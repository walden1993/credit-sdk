/**
 * Project Name:credit-rest
 * File Name:CreditorAndContract.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:09:49
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:债权人及主合同信息段 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:09:49 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class CreditorAndContract implements Serializable {

	private static final long serialVersionUID = -937527628167941026L;
	private String creditorType;// 债权人类型 1-放贷机构 2-非放贷机构 3-自然人
	private String creditorName;// 债权人名称
	private String creditorPaperType;// 债权人证件类型
	private String creditorPaperCode;// 债权人证件号码
	private String masterContractNumber;// 主合同编号
	private String masterContractCode;// 主合同号码
	private String invest; // 投向
	private String status;// 状态位 1-有效 2-无效

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<creditorAndContract>"); // 债权人及主合同信息段
		strb.append("<creditorType>").append(creditorType).append("</creditorType>"); // 债权人类型 1-放贷机构 2-非放贷机构 3-自然人
		strb.append("<creditorName>").append(creditorName).append("</creditorName>"); // 债权人名称
		strb.append("<creditorPaperType>").append(creditorPaperType).append("</creditorPaperType>"); // 债权人证件类型
		strb.append("<creditorPaperCode>").append(creditorPaperCode).append("</creditorPaperCode>"); // 债权人证件号码
		strb.append("<masterContractNumber>").append(masterContractNumber).append("</masterContractNumber>"); // 主合同编号
		strb.append("<masterContractCode>").append(masterContractCode).append("</masterContractCode>"); // 主合同号码
		strb.append("<invest>").append(invest).append("</invest>"); // 投向
		strb.append("<status>").append(status).append("</status>"); // 状态位 1-有效 2-无效
		strb.append("</creditorAndContract>");
		return strb.toString();
	}
}
