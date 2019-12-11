/**
 * Project Name:credit-rest
 * File Name:V17.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午6:30:27
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V17 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月9日 下午6:30:27 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V17 extends BaseVO implements Serializable {

	private static final long serialVersionUID = 7698573876004688666L;
	
	private String paymentCategory;
	
	private String bookkeepingDate;
	
	private String amount;
	
	private String paymentMethod;
	
	private String paymentFrequency;
	
	private String chargingSdate;
	
	private String premiumPaymentStatus;
	
	private String paymentEdate;
	
	private String balance;
	
	private String arrearsTotalAmount;

}

