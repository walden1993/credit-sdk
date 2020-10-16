/**
 * Project Name:credit-sdk
 * File Name:SecurityComputingConteller.java
 * Package Name:com.huarong.credit.sdk.controller
 * Date:2020年9月29日下午4:49:37
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huarong.credit.sdk.utils.ConfigUtil;
import com.huarong.credit.sdk.vo.SecurityComputingVO;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * ClassName:安全计算模拟交互 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年9月29日 下午4:49:37 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Controller
public class SecurityComputingConteller {

	@PostMapping("/test/securityComputing")
	@ResponseBody
	public SecurityComputingVO securityComputing(@RequestBody SecurityComputingVO securityComputingVO) {

		String aesKey = securityComputingVO.getAesKey();
		String encData = securityComputingVO.getEncData();

		// 解密公钥
		String decryptAesKey = SecureUtil.rsa(ConfigUtil.privateKeyBase64, ConfigUtil.publicKeyBase64)
				.decryptStr(aesKey, KeyType.PrivateKey);
		// 解密报文
		String decryptEncData = SecureUtil.aes(decryptAesKey.getBytes()).decryptStr(encData);

		JSONObject object = JSONUtil.parseObj(decryptEncData);

		String params = Base64.decodeStr(object.getStr("params"));//自定义参数
		System.out.println("自定义参数params:"+params);
		String fieldRptContent = Base64.decodeStr(object.getStr("fieldRptContent"));//征信报文
		
		if(JSONUtil.isJson(fieldRptContent)) {
			//JSON格式报文内容
		}else {
			//XML格式报文
		}
		
		System.out.println("征信报文:"+fieldRptContent);
		String serialNumber = object.getStr("serialNumber");

		// 处理安全计算逻辑
		String result = "处理安全计算逻辑";

		// 返回报文
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("result", result);
		paramMap.put("serialNumber", serialNumber);

		// 随机生成AES密钥
		String _aesKey = RandomUtil.randomString(32);

		// 加密报文
		String _encData = SecureUtil.aes(_aesKey.getBytes()).encryptBase64(JSONUtil.toJsonStr(paramMap));
		// 加密密钥
		String _AESKey = SecureUtil.rsa(ConfigUtil.privateKeyBase64, ConfigUtil.publicKeyBase64)
				.encryptBase64(_aesKey.getBytes(), KeyType.PublicKey);
		
		//返回报文
		SecurityComputingVO resultVo = new SecurityComputingVO();
		resultVo.setAesKey(_AESKey);
		resultVo.setEncData(_encData);
		return resultVo;
	}

}
