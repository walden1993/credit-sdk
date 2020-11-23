/**
 * Project Name:credit-sdk
 * File Name:RiskQueryTest.java
 * Package Name:com.huarong.credit.sdk
 * Date:2020年11月23日上午11:31:49
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.huarong.credit.sdk.utils.RequestUtil;
import com.huarong.credit.sdk.vo.query.risk.RiskQueryVO;
import com.huarong.credit.sdk.vo.query.v1.CreditScoreQueryVO;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.dialect.Props;

/**
 * ClassName:华融资信-风控接口测试类 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2020年11月23日 上午11:31:49 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
public class RiskQueryTest {
	private static String privateKeyBase64 = "";// rsa私钥
	private static String publicKeyBase64 = "";// rsa公钥
	private static String desKey = "";// des盐key
	private static String post_url_base = "";// 担保上报请求地址
	private static String merchantId = "";// 机构编号

	static {
		Props props = new Props("config.properties");
		privateKeyBase64 = FileUtil.readString(
				props.getProperty("config.rsa.privatekey", "classpath:certs/privateKey.txt"), CharsetUtil.UTF_8);
		publicKeyBase64 = FileUtil.readString(
				props.getProperty("config.rsa.publickey", "classpath:certs/publicKey.txt"), CharsetUtil.UTF_8);
		desKey = props.getProperty("config.deskey", "12345678");
		post_url_base = props.getProperty("config.url.credit.riskbase", "http://127.0.0.1:83/api/v1.1/risk");
		merchantId = props.getProperty("config.merchantId", "10000001");
	}
	
	@Test
	public void E0001() {
		RiskQueryVO riskQueryVO = new RiskQueryVO();

		riskQueryVO.setRequestNo(RequestUtil.getRequestNo());
		riskQueryVO.setMerchantId(merchantId);
		riskQueryVO.setRiskQueryType("E0001");
		riskQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		riskQueryVO.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("李四"));
		riskQueryVO.setQueryIdNoType("01");
		riskQueryVO.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("110101199003076077"));
		riskQueryVO.setQueryPhone(SecureUtil.des(desKey.getBytes()).encryptBase64("13600000000"));
		
		// 技术沟通后自定义的参数
		JSONObject riskQueryData = new JSONObject();
		riskQueryData.put("queryName", "王华融");// 姓名
		riskQueryData.put("queryIdNo", "140502198811102243");// 身份证
		riskQueryData.put("queyCardNo", "6202002294573115115");// 卡号
		riskQueryData.put("queryPhone", "13986671325");// 手机号
		//json格式base64
		riskQueryVO.setRiskQueryData(Base64.encode(JSONUtil.toJsonStr(riskQueryData)));

		Map<String, Object> map = BeanUtil.beanToMap(riskQueryVO);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		riskQueryVO.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/E0001", post_url_base), BeanUtil.beanToMap(riskQueryVO), 60000);

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
	
	@Test
	public void E0002() {
		RiskQueryVO riskQueryVO = new RiskQueryVO();

		riskQueryVO.setRequestNo(RequestUtil.getRequestNo());
		riskQueryVO.setMerchantId(merchantId);
		riskQueryVO.setRiskQueryType("E0002");
		riskQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		riskQueryVO.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("李四"));
		riskQueryVO.setQueryIdNoType("01");
		riskQueryVO.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("110101199003076077"));
		riskQueryVO.setQueryPhone(SecureUtil.des(desKey.getBytes()).encryptBase64("13600000000"));
		
		// 技术沟通后自定义的参数
		JSONObject riskQueryData = new JSONObject();
		riskQueryData.put("queryName", "王华融");// 姓名
		riskQueryData.put("queryIdNo", "140502198811102243");// 身份证
		riskQueryData.put("queyCardNo", "6202002294573115115");// 卡号
		riskQueryData.put("queryPhone", "13986671325");// 手机号
		//json格式base64
		riskQueryVO.setRiskQueryData(Base64.encode(JSONUtil.toJsonStr(riskQueryData)));

		Map<String, Object> map = BeanUtil.beanToMap(riskQueryVO);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		riskQueryVO.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/E0002", post_url_base), BeanUtil.beanToMap(riskQueryVO), 60000);

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
	
	@Test
	public void E0003() {
		RiskQueryVO riskQueryVO = new RiskQueryVO();

		riskQueryVO.setRequestNo(RequestUtil.getRequestNo());
		riskQueryVO.setMerchantId(merchantId);
		riskQueryVO.setRiskQueryType("E0003");
		riskQueryVO.setQueryDate(DateUtil.format(new Date(), "yyyyMMdd"));
		riskQueryVO.setQueryName(SecureUtil.des(desKey.getBytes()).encryptBase64("李四"));
		riskQueryVO.setQueryIdNoType("01");
		riskQueryVO.setQueryIdNo(SecureUtil.des(desKey.getBytes()).encryptBase64("110101199003076077"));
		riskQueryVO.setQueryPhone(SecureUtil.des(desKey.getBytes()).encryptBase64("13600000000"));
		
		// 技术沟通后自定义的参数
		JSONObject riskQueryData = new JSONObject();
		riskQueryData.put("queryName", "王华融");// 姓名
		riskQueryData.put("queryIdNo", "140502198811102243");// 身份证
		riskQueryData.put("queyCardNo", "6202002294573115115");// 卡号
		riskQueryData.put("queryPhone", "13986671325");// 手机号
		//json格式base64
		riskQueryVO.setRiskQueryData(Base64.encode(JSONUtil.toJsonStr(riskQueryData)));

		Map<String, Object> map = BeanUtil.beanToMap(riskQueryVO);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, true, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		riskQueryVO.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/E0003", post_url_base), BeanUtil.beanToMap(riskQueryVO), 60000);

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
}

