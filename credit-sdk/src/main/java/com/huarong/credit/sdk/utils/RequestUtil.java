/**
 * Project Name:credit-sdk
 * File Name:DateUtil.java
 * Package Name:com.huarong.credit.sdk.utils
 * Date:2020年9月4日下午5:45:07
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:DateUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2020年9月4日 下午5:45:07 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
public class RequestUtil {
	
	public static String getRequestNo() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSSSSSSS");
		return df.format(date);
	}
}

