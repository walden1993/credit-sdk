/**
 * Project Name:credit-rest
 * File Name:V11.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午5:09:41
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V11 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月9日 下午5:09:41 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V11 extends BaseVO implements Serializable {

	private static final long serialVersionUID = 4933552954245116167L;
	
	private String onBalance;
	
	private String balanceChangeDate;
	
	private String repayMethod;
	
	private String repayPeriods;
	
	private String repayAmount;
	
	private String debtStatus;
	
	private String otherFees;
	
	private String actualInterest;
	
	private String actualPrincipal;
	
	private String actualTotal;
	
	private String contractStatus;
	
	private String loadaidResiduePrincipal;
	
	private String bankResiduePrincipal;
}

