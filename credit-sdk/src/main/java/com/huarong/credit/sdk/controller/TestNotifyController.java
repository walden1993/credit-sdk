/**
 * Project Name:credit-sdk
 * File Name:Test9001Controller.java
 * Package Name:com.huarong.credit.sdk.controller
 * Date:2020年7月30日下午6:09:04
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huarong.credit.sdk.vo.ResultVO;
import com.huarong.credit.sdk.vo.query.rule.R9002;
import com.huarong.credit.sdk.vo.query.v1.CreditScoreQueryVO;
import com.huarong.credit.sdk.vo.query.v1.RiskRptQueryVO;
import com.huarong.credit.sdk.vo.query.v1.RuleQueryVO;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.dialect.Props;

/**
 * ClassName:Test9001Controller <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年7月30日 下午6:09:04 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Controller
public class TestNotifyController {

	private static String privateKeyBase64 = "";// rsa私钥
	private static String publicKeyBase64 = "";// rsa公钥
	private static String desKey = "";// des盐key
	private static String post_url_base = "";// 征信查询请求地址
	private static String merchantId = "";// 机构编号

	static {
		Props props = new Props("config.properties");
		privateKeyBase64 = FileUtil.readString(
				props.getProperty("config.rsa.privatekey", "classpath:certs/privateKey.txt"), CharsetUtil.UTF_8);
		publicKeyBase64 = FileUtil.readString(
				props.getProperty("config.rsa.publickey", "classpath:certs/publicKey.txt"), CharsetUtil.UTF_8);
		desKey = props.getProperty("config.deskey", "12345678");
		post_url_base = props.getProperty("config.url.credit.querybase", "http://127.0.0.1:83/api/v1.0/");
		merchantId = props.getProperty("config.merchantId", "10000001");
	}

	@RequestMapping("/notify")
	@ResponseBody
	public ResultVO notify(HttpServletRequest httpServletRequest) throws IOException {
		String result = getRequestPostStr(httpServletRequest);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");

		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, true, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
			if (verify) {
//				String xmlRpt = SecureUtil.rsa(privateKeyBase64, publicKeyBase64)
//						.decryptStr(jsonObject.getJSONObject("data").getStr("xmlRpt"), KeyType.PrivateKey);
//				System.out.println(xmlRpt);
			}
		}
		System.out.println(result);

		System.out.println(jsonObject.toStringPretty());
		return new ResultVO();

	}

	/**
	 * 描述:获取 post 请求的 byte[] 数组
	 * 
	 * <pre>
	 * 举例：
	 * </pre>
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
		int contentLength = request.getContentLength();
		if (contentLength < 0) {
			return null;
		}
		byte buffer[] = new byte[contentLength];
		for (int i = 0; i < contentLength;) {

			int readlen = request.getInputStream().read(buffer, i, contentLength - i);
			if (readlen == -1) {
				break;
			}
			i += readlen;
		}
		return buffer;
	}

	/**
	 * 描述:获取 post 请求内容
	 * 
	 * <pre>
	 * 举例：
	 * </pre>
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getRequestPostStr(HttpServletRequest request) throws IOException {
		byte buffer[] = getRequestPostBytes(request);
		String charEncoding = request.getCharacterEncoding();
		if (charEncoding == null) {
			charEncoding = "UTF-8";
		}
		return new String(buffer, charEncoding);
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test(String ruleName, String ruleValue) {

		R9002 r9002 = new R9002();

		r9002.setRequestNo(String.valueOf(System.currentTimeMillis()));
		r9002.setMerchantId("10000001");
		r9002.setRiskQueryType("R9002");
		r9002.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("张三"));
		r9002.setQueryIdNoType("01");
		r9002.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("11010119900307715X"));
		r9002.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		r9002.setCertFile("111");
		r9002.setOtherFile("2222");
		r9002.setRules(ruleName + "=" + ruleValue);
		r9002.setIncomeFile("3333");
		r9002.setAuthoFile("4444");
		r9002.setBackUrl("3233");
		r9002.setWorkFile("5555");
		r9002.setAssetsFile("6666");
		r9002.setIdentFile("7777");

		Map<String, Object> map = BeanUtil.beanToMap(r9002);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		r9002.setSignature(signBase64);

		String result = HttpUtil.post("http://127.0.0.1:8080/credit-rest/api/v1.0/R9002", BeanUtil.beanToMap(r9002),
				60000);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");

		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, true, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
		}
		System.out.println(result);

		System.out.println(jsonObject.toStringPretty());
		return jsonObject.toStringPretty();
	}

	@RequestMapping("/R9002")
	@ResponseBody
	public String _R9002(String serialNumber, String jsonParams) throws IOException {

		CreditScoreQueryVO creditScoreQueryVO = new CreditScoreQueryVO();

		creditScoreQueryVO.setRequestNo(String.valueOf(System.currentTimeMillis()));
		creditScoreQueryVO.setMerchantId(merchantId);
		creditScoreQueryVO.setRiskQueryType("R9003");
		creditScoreQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));

		creditScoreQueryVO.setSerialNumber("1598939170793");
		if (StrUtil.isNotEmpty(serialNumber)) {
			creditScoreQueryVO.setSerialNumber(serialNumber);
		}
		creditScoreQueryVO.setJsonParams(jsonParams);

		Map<String, Object> map = BeanUtil.beanToMap(creditScoreQueryVO);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		creditScoreQueryVO.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/R9002", post_url_base), BeanUtil.beanToMap(creditScoreQueryVO),
				60000);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");

		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, true, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
		}
		return JSONUtil.toJsonPrettyStr(result);
	}

	@RequestMapping("/R9003")
	@ResponseBody
	public String _R9003(String ruleName, String ruleValue, String serialNumber) {

		RuleQueryVO quleQueryVO = new RuleQueryVO();

		quleQueryVO.setRequestNo(String.valueOf(System.currentTimeMillis()));
		quleQueryVO.setMerchantId(merchantId);
		quleQueryVO.setRiskQueryType("R9003");
		quleQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		quleQueryVO.setRules(ruleName + "=" + ruleValue);

		quleQueryVO.setSerialNumber("1598939170793");
		if (StrUtil.isNotEmpty(serialNumber)) {
			quleQueryVO.setSerialNumber(serialNumber);
		}

		Map<String, Object> map = BeanUtil.beanToMap(quleQueryVO);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		quleQueryVO.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/R9003", post_url_base), BeanUtil.beanToMap(quleQueryVO), 60000);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");

		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, true, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
		}
		return JSONUtil.toJsonPrettyStr(result);
	}

	@RequestMapping("/R9004")
	@ResponseBody
	public String _R9004(String serialNumber) {

		RiskRptQueryVO riskRptQueryVO = new RiskRptQueryVO();

		riskRptQueryVO.setRequestNo(String.valueOf(System.currentTimeMillis()));
		riskRptQueryVO.setMerchantId(merchantId);
		riskRptQueryVO.setRiskQueryType("R9004");
		riskRptQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));

		riskRptQueryVO.setSerialNumber("1598939170793");
		if (StrUtil.isNotEmpty(serialNumber)) {
			riskRptQueryVO.setSerialNumber(serialNumber);
		}

		Map<String, Object> map = BeanUtil.beanToMap(riskRptQueryVO);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		riskRptQueryVO.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/R9004", post_url_base), BeanUtil.beanToMap(riskRptQueryVO),
				60000);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");

		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, true, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
			if (verify) {
				JSONObject data = jsonObject.getJSONObject("data");
				String htmlRpt = SecureUtil.rsa(privateKeyBase64, publicKeyBase64).decryptStr(data.getStr("htmlRpt"),
						KeyType.PrivateKey);
				// FileUtil.writeBytes(htmlRpt.getBytes(), "H://test//test.html");
				data.put("htmlRpt", htmlRpt);
				resultMap.put("data", data);
			}
		}
		return JSONUtil.toJsonPrettyStr(resultMap);
	}

}
