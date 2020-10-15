/**
 * Project Name:credit-sdk
 * File Name:ConfigUtil.java
 * Package Name:com.huarong.credit.sdk.utils
 * Date:2020年9月29日下午4:56:26
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.setting.dialect.Props;

/**
 * ClassName:ConfigUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年9月29日 下午4:56:26 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
public class ConfigUtil {
	public static String privateKeyBase64 = "";// rsa私钥
	public static String publicKeyBase64 = "";// rsa公钥
	public static String desKey = "";// des盐key
	public static String post_url_base = "";// 征信查询请求地址
	public static String merchantId = "";// 机构编号

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
}
