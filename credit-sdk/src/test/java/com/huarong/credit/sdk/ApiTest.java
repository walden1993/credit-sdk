/**
 * Project Name:credit-sdk
 * File Name:ApiTest.java
 * Package Name:com.huarong.credit.sdk
 * Date:2019年12月11日上午8:46:52
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk;
/**
 * ClassName:ApiTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月11日 上午8:46:52 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
import java.util.Map;

import org.junit.Test;

import com.huarong.credit.sdk.vo.V16;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;

/**
 * ClassName:ApiTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年12月10日 下午6:33:33 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
public class ApiTest {

	String signKey = "12345678";

	@Test
	public void test16() {

		V16 v16 = new V16();
		v16.setSpCode("10000001");
		v16.setTransId("16");
		v16.setRecoveryAmount("100");
		v16.setRecoveryDate("20191210");
		v16.setContractCode("100000000000001");

		// 如果需要加密
		//String encryptValue = SecureUtil.des(signKey.getBytes()).encryptHex(v16.getRecoveryAmount());
		//v16.setRecoveryAmount(encryptValue);
		

		// 获取加签参数
		Map<String, Object> map = BeanUtil.beanToMap(v16);
		String localSign = SecureUtil.signParamsMd5(map, signKey);
		v16.setSignature(localSign);

		String result = HttpUtil.post("http://127.0.0.1:82/api/v1.0/16", BeanUtil.beanToMap(v16));
		System.out.println(result);
	}

}

