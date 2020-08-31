/**
 * Project Name:credit-sdk
 * File Name:CreditReportTest.java
 * Package Name:com.huarong.credit.sdk
 * Date:2020年8月26日下午6:16:50
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk;

import java.util.HashMap;
import java.util.Map;

import com.huarong.credit.sdk.vo.report.R9060;
import com.huarong.credit.sdk.vo.report.R9069;
import com.huarong.credit.sdk.vo.report.R9070;
import com.huarong.credit.sdk.vo.report.base.AssureContract;
import com.huarong.credit.sdk.vo.report.base.AssureUpload;
import com.huarong.credit.sdk.vo.report.base.CreditorAndContract;
import com.huarong.credit.sdk.vo.report.base.RealInBulgaria;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.dialect.Props;

/**
 * ClassName:华融担保上报接口测试类 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月26日 下午6:16:50 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
public class CreditReportTest {

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
		post_url_base = props.getProperty("config.url.credit.reportbase", "http://127.0.0.1:83/api/v1.0/");
		merchantId = props.getProperty("config.merchantId", "10000001");
	}

	public static void main(String[] args) {
		//R9060_69();

		//R9069();
		
		R9070();
	}

	/**
	 * 9060-9069接口上报
	 * 
	 * @Title: R9060_69
	 * @Description: TODO(描述这个方法的作用)
	 * @param:
	 */
	public static void R9060_69() {

		R9060 r9060 = new R9060();

		String requestNo = "202008228171805000001";
		r9060.setMerchantId(merchantId);
		r9060.setBusinessType("9060");
		r9060.setRequestNo(requestNo);

		AssureUpload assureUpload = new AssureUpload();
		assureUpload.setBusinessNumber(requestNo);
		assureUpload.setContractNumber(requestNo);
		assureUpload.setIsAssureType("2");
		assureUpload.setIsAssureName(SecureUtil.des(desKey.getBytes()).encryptBase64("李四"));
		assureUpload.setIsAssureCreditType("0");
		assureUpload.setIsAssureCreditCode(SecureUtil.des(desKey.getBytes()).encryptBase64("220124195907280419"));
		assureUpload.setBusinessYearMonth("2020-08-20");
		r9060.setAssureUpload(assureUpload);

		AssureContract assureContract = new AssureContract();
		assureContract.setAssureContractType("01");
		assureContract.setAssureManner("1");
		assureContract.setAssureContractMoney("1000");
		assureContract.setAssureBeginDate("2018-12-01");
		assureContract.setAssureFinishDate("2019-12-01");
		assureContract.setRates("20");
		r9060.setAssureContract(assureContract);

		RealInBulgaria realInBulgaria = new RealInBulgaria();
		realInBulgaria.setAssureContractStatus("1");
		realInBulgaria.setDutyRelieveDate("");
		realInBulgaria.setBalanceChangeDate("2020-09-19");
		realInBulgaria.setBalanceInBulgaria("1000");
		r9060.setRealInBulgaria(realInBulgaria);

		/*
		 * BeAssurePeople beAssurePeople = new BeAssurePeople();
		 * beAssurePeople.setBeAssurePeopleName(SecureUtil.des(desKey.getBytes()).
		 * encryptBase64("李四"));
		 * beAssurePeople.setBeAssureCreditCode(SecureUtil.des(desKey.getBytes()).
		 * encryptBase64("220124195907280419"));
		 * beAssurePeople.setBeAssurePeopleType("2");
		 * beAssurePeople.setBeAssureCreditName("0");
		 * beAssurePeople.setBeAssureStatus("1");
		 * r9060.setBeAssurePeople(beAssurePeople);
		 */

		/*
		 * AntiGuarantor antiGuarantor = new AntiGuarantor();
		 * antiGuarantor.setAntiGuarantorType("2");
		 * antiGuarantor.setAntiGuarantorName(SecureUtil.des(desKey.getBytes()).
		 * encryptBase64("李四")); antiGuarantor.setAntiGuarantorCreditType("0");
		 * antiGuarantor.setIsAssureCreditCode(SecureUtil.des(desKey.getBytes()).
		 * encryptBase64("220124195907280419"));
		 * antiGuarantor.setPledgeValueCurrency("1000");
		 * antiGuarantor.setStatusBit("1"); r9060.setAntiGuarantor(antiGuarantor);
		 */

		CreditorAndContract creditorAndContract = new CreditorAndContract();
		creditorAndContract.setCreditorType("2");
		creditorAndContract.setStatus("1");
		r9060.setCreditorAndContract(creditorAndContract);

		Map<String, Object> map = BeanUtil.beanToMap(r9060);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, false, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		r9060.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/07", post_url_base), JSONUtil.parseObj(r9060, true).toString(),
				60000);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");
		System.out.println(result);
		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, false, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
		}
	}
	
	/**
	 * 9060-9069接口解除担保
	 * 
	 * @Title: R9060_69
	 * @Description: TODO(描述这个方法的作用)
	 * @param:
	 */
	public static void R9069() {

		R9069 r9069 = new R9069();

		String requestNo = "20200820171805000013";
		String businessNumber="20200820171805000010";
		r9069.setMerchantId(merchantId);
		r9069.setBusinessType("9060");
		r9069.setRequestNo(requestNo);

		AssureUpload assureUpload = new AssureUpload();
		assureUpload.setBusinessNumber(businessNumber);
		assureUpload.setContractNumber(businessNumber);
		assureUpload.setIsAssureType("2");
		assureUpload.setIsAssureName(SecureUtil.des(desKey.getBytes()).encryptBase64("李四"));
		assureUpload.setIsAssureCreditType("0");
		assureUpload.setIsAssureCreditCode(SecureUtil.des(desKey.getBytes()).encryptBase64("220124195907280419"));
		assureUpload.setBusinessYearMonth("2020-08-20");
		r9069.setAssureUpload(assureUpload);
		

		RealInBulgaria realInBulgaria = new RealInBulgaria();
		realInBulgaria.setAssureContractStatus("2");
		realInBulgaria.setDutyRelieveDate("2020-08-27");
		realInBulgaria.setBalanceChangeDate("2020-08-27");
		realInBulgaria.setBalanceInBulgaria("0");
		r9069.setRealInBulgaria(realInBulgaria);

		

		Map<String, Object> map = BeanUtil.beanToMap(r9069);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, false, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		r9069.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/09", post_url_base), JSONUtil.parseObj(r9069, true).toString(),
				60000);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");
		System.out.println(result);
		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, false, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
		}
	}

	/**
	 * 上报反馈查询
	 * 
	 * @Title: R9070
	 * @Description: TODO(描述这个方法的作用)
	 * @param:
	 */
	public static void R9070() {

		R9070 r9070 = new R9070();

		String requestNo = IdUtil.objectId();
		r9070.setMerchantId(merchantId);
		r9070.setBusinessType("9070");
		r9070.setRequestNo(requestNo);
		r9070.setSerialNumber("HR2020082806410200000097");

		Map<String, Object> map = BeanUtil.beanToMap(r9070);

		map.remove("signature");

		String joinStr = MapUtil.sortJoin(map, StrUtil.EMPTY, StrUtil.EMPTY, false, "");

		System.out.println(joinStr);

		Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

		byte[] signByte = sign.sign(joinStr.getBytes());
		String signBase64 = Base64.encode(signByte);
		System.out.println(signBase64);

		r9070.setSignature(signBase64);

		String result = HttpUtil.post(String.format("%s/14", post_url_base), BeanUtil.beanToMap(r9070), 60000);

		JSONObject jsonObject = JSONUtil.parseObj(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", jsonObject.getStr("code"));
		resultMap.put("message", jsonObject.getStr("message"));
		resultMap.put("data", jsonObject.getStr("data"));
		String signature = jsonObject.getStr("signature");
		System.out.println(result);
		if ("0000".equals(jsonObject.getStr("code"))) {
			String resultStr = MapUtil.sortJoin(resultMap, StrUtil.EMPTY, StrUtil.EMPTY, false, "");
			boolean verify = sign.verify(resultStr.getBytes(), Base64.decode(signature));
			System.out.println(verify ? "验签通过" : "验签不通过");
		}
	}
}
