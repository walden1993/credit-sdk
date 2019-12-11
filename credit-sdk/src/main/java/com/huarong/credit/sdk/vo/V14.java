/**
 * Project Name:credit-rest
 * File Name:V14.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午6:13:10
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V14 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月9日 下午6:13:10 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V14 extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 3977588347399152818L;
	
	private String dueAmount;
	
	private String dueInt;
	
	private String penaltyBalance;
	
	private String compoundBalance;
	
	private String addPenaltyBalance;
	
	private String addCompoundBalance;
	
	private String dueDays;
	
	private String curPeriods;
	
	private String higPeriods;
	
	private String tolPeriods;
	
	private String verFlag;
	
	private String verDate;
	
}

