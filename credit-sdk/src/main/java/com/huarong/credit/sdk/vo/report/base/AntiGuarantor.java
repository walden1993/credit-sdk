/**
 * Project Name:credit-rest
 * File Name:AntiGuarantor.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:04:22
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:反担保人信息段 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:04:22 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class AntiGuarantor implements Serializable {

	private static final long serialVersionUID = 1052951904793023361L;
	private String antiGuarantorType; // 反担保人类型 1-企业或其他组织 2-自然人
	private String antiGuarantorName;// 反担保人名称
	private String antiGuarantorCreditType;// 反担保人证件类型
	private String isAssureCreditCode;// 反担保人证件号码
	private String pledgeValueCurrency;// 反担保责任金额
	private String statusBit;// 状态位 1-有效 2-无效

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<antiGuarantor>"); // 反担保人信息段
		strb.append("<antiGuarantorType>").append(antiGuarantorType).append("</antiGuarantorType>"); // 反担保人类型 1-企业或其他组织
																										// 2-自然人
		strb.append("<antiGuarantorName>").append(antiGuarantorName).append("</antiGuarantorName>"); // 反担保人名称
		strb.append("<antiGuarantorCreditType>").append(antiGuarantorCreditType).append("</antiGuarantorCreditType>"); // 反担保人证件类型
		strb.append("<isAssureCreditCode>").append(isAssureCreditCode).append("</isAssureCreditCode>"); // 反担保人证件号码
		strb.append("<pledgeValueCurrency>").append(pledgeValueCurrency).append("</pledgeValueCurrency>"); // 反担保责任金额
		strb.append("<statusBit>").append(statusBit).append("</statusBit>"); // 状态位 1-有效 2-无效
		strb.append("</antiGuarantor>");
		return strb.toString();
	}
}
