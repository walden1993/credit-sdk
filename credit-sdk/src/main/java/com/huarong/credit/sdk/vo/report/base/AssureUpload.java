/**
 * Project Name:credit-rest
 * File Name:AssureUpload.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午3:41:09
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * 合同开立基础段
 * 
 * @ClassName: AssureUpload
 * @author: hejiahua
 * @date: 2020年8月17日 下午3:50:02
 * @Copyright:
 */

@Data
public class AssureUpload implements Serializable {
	private static final long serialVersionUID = 7827375774519151642L;
	private String businessNumber;// 担保业务编号
	private String contractNumber;// 担保合同号码
	private String isAssureType;// 被担保人类型
	private String isAssureName;// 被担保人名称
	private String isAssureCreditType; // 被担保人证件类型
	private String isAssureCreditCode; // 被担保人证件号码
	private String businessYearMonth;// 业务发生年月

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<assureUpload>"); // 基础段
		strb.append("<businessNumber>").append(businessNumber).append("</businessNumber>"); // 担保业务编号
		strb.append("<contractNumber>").append(businessNumber).append("</contractNumber>"); // 担保合同号码
		strb.append("<isAssureType>").append(businessNumber).append("</isAssureType>"); // 被担保人类型
		strb.append("<isAssureName>").append(businessNumber).append("</isAssureName>"); // 被担保人名称
		strb.append("<isAssureCreditType>").append(businessNumber).append("</isAssureCreditType>"); // 被担保人证件类型
		strb.append("<isAssureCreditCode>").append(businessNumber).append("</isAssureCreditCode>"); // 被担保人证件号码
		strb.append("<businessYearMonth>").append(businessNumber).append("</businessYearMonth>"); // 业务发生年月
		strb.append("</assureUpload>");
		return strb.toString();
	}

}
