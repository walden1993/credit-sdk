/**
 * Project Name:credit-sdk
 * File Name:CreditQueryTest.java
 * Package Name:com.huarong.credit.sdk
 * Date:2020年8月26日下午6:16:36
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.huarong.credit.sdk.utils.RequestUtil;
import com.huarong.credit.sdk.vo.query.credit.C9002;
import com.huarong.credit.sdk.vo.query.credit.C9004;
import com.huarong.credit.sdk.vo.query.risk.C9003;
import com.huarong.credit.sdk.vo.query.rule.R9002;
import com.huarong.credit.sdk.vo.query.v1.RiskRptQueryVO;
import com.huarong.credit.sdk.vo.query.v1.RuleQueryVO;
import com.huarong.credit.sdk.vo.query.v1.SecurityComputingQueryVO;

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
 * ClassName:华融资信报告查询接口测试类 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月26日 下午6:16:36 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
public class CreditQueryTest {

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

	public static void main(String[] args) {
		//C9002();
		R9005();
	}

	/**
	 * 纸质授权查询
	 */
	public static void R9002() {

		R9002 r9002 = new R9002();

		r9002.setRequestNo(RequestUtil.getRequestNo());
		r9002.setMerchantId(merchantId);
		r9002.setRiskQueryType("R9002");
		r9002.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("张三"));
		r9002.setQueryIdNoType("01");
		r9002.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("110101199003076077"));
		r9002.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		r9002.setCertFile(Base64.encode(FileUtil.file("D:\\certs\\test\\face_1119121314124595221977.jpg")));
		r9002.setOtherFile("2222");
		r9002.setIncomeFile("3333");

		r9002.setAuthoFile(Base64.encode(FileUtil.file("D:\\certs\\test\\face_1119121314124595221977.jpg")));
		r9002.setWorkFile("");
		r9002.setAssetsFile("6666");
		r9002.setIdentFile("7777");
		r9002.setBackUrl("http://172.16.3.216:8383/notify");

		r9002.setRules("R0001=L");

		Map<String, Object> map = BeanUtil.beanToMap(r9002);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		r9002.setSignature(signBase64);

		String result = HttpUtil.post("http://127.0.0.1:83/api/v1.0/R9002", BeanUtil.beanToMap(r9002), 60000);

		System.out.println(result);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");

		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, false, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
		}
		System.out.println(String.format("请求流水号：%s", r9002.getRequestNo()));
	}

	/**
	 * 纸质授权查询
	 */
	public static void C9002() {

		C9002 c9002 = new C9002();

		c9002.setRequestNo(RequestUtil.getRequestNo());
		c9002.setMerchantId(merchantId);
		c9002.setRiskQueryType("C9002");
		c9002.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("李四"));
		c9002.setQueryIdNoType("01");
		c9002.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("110101199003076077"));
		c9002.setQueryPhone(SecureUtil.des(desKey.getBytes()).encryptBase64("13600000000"));
		c9002.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		c9002.setCertFile(Base64.encode(FileUtil.file("D:\\certs\\test\\face_1119121314124595221977.jpg")));
		c9002.setOtherFile("2222");
		c9002.setIncomeFile("3333");

		c9002.setAuthoFile(Base64.encode(FileUtil.file("D:\\certs\\test\\face_1119121314124595221977.jpg")));
		c9002.setWorkFile("");
		c9002.setAssetsFile("6666");
		c9002.setIdentFile("7777");
		c9002.setBackUrl("http://172.16.3.216:8383/notify");

		Map<String, Object> map = BeanUtil.beanToMap(c9002);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		c9002.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/C9002", post_url_base), BeanUtil.beanToMap(c9002), 60000);

		System.out.println(result);

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
		System.out.println(String.format("请求流水号：%s", c9002.getRequestNo()));
	}

	/**
	 * 银联五要素授权查询
	 */
	public static void C9003() {

		C9003 c9003 = new C9003();

		c9003.setRequestNo(RequestUtil.getRequestNo());
		c9003.setMerchantId(merchantId);
		c9003.setRiskQueryType("C9003");
		c9003.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("张三"));
		c9003.setQueryIdNoType("01");
		c9003.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("11010119900307715X"));
		c9003.setQueryPhone(SecureUtil.des(desKey.getBytes()).encryptBase64("18560580991"));
		c9003.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		c9003.setOtherFile("2222");
		c9003.setIncomeFile("3333");
		c9003.setBackUrl("3233");
		c9003.setWorkFile("5555");
		c9003.setAssetsFile("6666");
		c9003.setIdentFile("7777");

		Map<String, Object> map = BeanUtil.beanToMap(c9003);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		c9003.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/C9003", post_url_base), BeanUtil.beanToMap(c9003), 60000);

		System.out.println(result);

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
		System.out.println(String.format("请求流水号：%s", c9003.getRequestNo()));
	}

	/**
	 * 综合电子认证授权查询
	 */
	public static void C9004() {

		C9004 c9004 = new C9004();

		c9004.setRequestNo(RequestUtil.getRequestNo());
		c9004.setMerchantId(merchantId);
		c9004.setRiskQueryType("C9004");
		c9004.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("邓可"));
		c9004.setQueryIdNoType("01");
		c9004.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("430621198706162716"));
		c9004.setQueryPhone(SecureUtil.des(desKey.getBytes()).encryptBase64("13537679204"));
		c9004.setQueyCardNo(SecureUtil.des(desKey.getBytes()).encryptBase64("6222980021935954"));
		c9004.setAuthTime(DateUtil.now());
		c9004.setVeriFaceTime(DateUtil.now());
		c9004.setIdCardFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setOtherAuthFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setCaFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setIdentFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setWorkFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		c9004.setOtherFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setIncomeFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setBackUrl("3233");
		//c9004.setAssetsFile(Base64.encode(FileUtil.newFile("H:\\test\\demo-htmlfile.pdf")));
		c9004.setAuthIndexId("32434");

		Map<String, Object> map = BeanUtil.beanToMap(c9004);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		c9004.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/C9004", post_url_base), BeanUtil.beanToMap(c9004), 60000);

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
		System.out.println(String.format("请求流水号：%s", c9004.getRequestNo()));
	}

	/**
	 * R9002-R9003接口查询
	 */
	public static void R9003() {

		RuleQueryVO quleQueryVO = new RuleQueryVO();

		quleQueryVO.setRequestNo(RequestUtil.getRequestNo());
		quleQueryVO.setMerchantId(merchantId);
		quleQueryVO.setRiskQueryType("R9003");
		quleQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		// quleQueryVO.setRules("R0001=21");

		quleQueryVO.setSerialNumber("1598939170793");

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
		System.out.println(result);

	}

	/**
	 * R9002-R9003接口查询
	 */
	public static void R9004() {

		RiskRptQueryVO riskRptQueryVO = new RiskRptQueryVO();

		riskRptQueryVO.setRequestNo(RequestUtil.getRequestNo());
		riskRptQueryVO.setMerchantId(merchantId);
		riskRptQueryVO.setRiskQueryType("R9004");
		riskRptQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));

		riskRptQueryVO.setSerialNumber("2020090905333200000905");
		//riskRptQueryVO.setCompany(SecureUtil.des(desKey.getBytes()).encryptBase64("北京银行"));
		//riskRptQueryVO.setCompanyAddress(SecureUtil.des(desKey.getBytes()).encryptBase64("北京市西城区金融大街35号国际企业大厦A座305室"));
		//riskRptQueryVO.setHomeAddress(SecureUtil.des(desKey.getBytes()).encryptBase64("北京市朝阳区春晓园北区7号楼C555室"));
		
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
				FileUtil.writeBytes(htmlRpt.getBytes(), "H://test//test.html");
			}
		}
		System.out.println(result);

	}
	
	/**
	 * R9002-R9003接口查询
	 */
	public static void R9005() {

		SecurityComputingQueryVO securityComputingQueryVO = new SecurityComputingQueryVO();

		securityComputingQueryVO.setRequestNo(RequestUtil.getRequestNo());
		securityComputingQueryVO.setMerchantId(merchantId);
		securityComputingQueryVO.setRiskQueryType("R9005");
		securityComputingQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));

		securityComputingQueryVO.setSerialNumber("2020090905333200000905");
		
		Map<String, Object> map = BeanUtil.beanToMap(securityComputingQueryVO);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		securityComputingQueryVO.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/R9005", post_url_base), BeanUtil.beanToMap(securityComputingQueryVO),
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
				String securityComputingXml = SecureUtil.rsa(privateKeyBase64, publicKeyBase64).decryptStr(data.getStr("securityComputingXml"),
						KeyType.PrivateKey);
				FileUtil.writeBytes(securityComputingXml.getBytes(), "H://test//test.xml");
			}
		}
		System.out.println(result);

	}
}
