/**
 * Project Name:credit-sdk
 * File Name:securityComputingVO.java
 * Package Name:com.huarong.credit.sdk.vo
 * Date:2020年9月29日下午4:52:21
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import lombok.Data;

/**
 * ClassName:securityComputingVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2020年9月29日 下午4:52:21 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
public class SecurityComputingVO {
	
	private String aesKey;//报文解密/加密密钥，密钥由RSA加密
	
	private String encData;//加密报文，AES加密
	
}

