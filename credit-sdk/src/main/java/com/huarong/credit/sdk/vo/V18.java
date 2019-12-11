/**
 * Project Name:credit-rest
 * File Name:V18.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午6:39:08
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V18 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月9日 下午6:39:08 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V18 extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = -989562559526821396L;
	
	private String payableDate;
	
	private String payableAmount;
	
	private String paidinDate;
	
	private String arrearsAmount;
	
	private String premiumPaymentStatus;
	
}

