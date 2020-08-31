/**
 * Project Name:credit-rest
 * File Name:BeAssurePeople.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:00:18
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:被担保人信息段 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:00:18 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class BeAssurePeople implements Serializable {

	private static final long serialVersionUID = -496716115943961080L;
	private String beAssurePeopleType;// 被担保人类型
	private String beAssurePeopleName;// 被担保人名称
	private String beAssureCreditName;// 被担保人证件类型
	private String beAssureCreditCode;// 被担保人证件号码
	private String beAssureStatus;// 状态位 1-有效 2-无效

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<beAssurePeople>"); // 被担保人信息段
		strb.append("<beAssurePeopleType>").append(beAssurePeopleType).append("</beAssurePeopleType>"); // 被担保人类型
		strb.append("<beAssurePeopleName>").append(beAssurePeopleName).append("</beAssurePeopleName>"); // 被担保人名称
		strb.append("<beAssureCreditName>").append(beAssureCreditName).append("</beAssureCreditName>"); // 被担保人证件类型
		strb.append("<beAssureCreditCode>").append(beAssureCreditCode).append("</beAssureCreditCode>"); // 被担保人证件号码
		strb.append("<beAssureStatus>").append(beAssureStatus).append("</beAssureStatus>"); // 状态位 1-有效 2-无效
		strb.append("</beAssurePeople>");
		return strb.toString();
	}
}
