/**
 * Project Name:credit-rest
 * File Name:V12.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午5:26:58
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V12 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月9日 下午5:26:58 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V12 extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 2026878448900712108L;
	
	private String relieveDate;
	
	private String onBalance;

	private String balanceChangeDate;

}

