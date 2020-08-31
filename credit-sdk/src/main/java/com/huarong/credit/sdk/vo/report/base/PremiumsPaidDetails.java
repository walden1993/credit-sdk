/**
 * Project Name:credit-rest
 * File Name:PremiumsPaidDetails.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:31:14
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:保费缴纳明细信息段数据项 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:31:14 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class PremiumsPaidDetails implements Serializable {

	private static final long serialVersionUID = -4633377799974698672L;
	private String payableDate;// 应缴日期
	private String payableMoney;// 应缴金额
	private String paidDate;// 实缴日期
	private String outstandingMoney;// 欠缴金额
	private String premiumsStatus; // 本期保费缴纳状态 00-正常；01-欠缴；02-欠缴2期后缴清；99-缴清

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<premiumsPaidDetails>"); // 保费缴纳明细信息段数据项
		strb.append("<payableDate>").append(payableDate).append("</payableDate>"); // 应缴日期
		strb.append("<payableMoney>").append(payableMoney).append("</payableMoney>"); // 应缴金额
		strb.append("<paidDate>").append(paidDate).append("</paidDate>"); // 实缴日期
		strb.append("<outstandingMoney>").append(outstandingMoney).append("</outstandingMoney>"); // 欠缴金额
		strb.append("<premiumsStatus>").append(premiumsStatus).append("</premiumsStatus>"); // 本期保费缴纳状态
																							// 00-正常；01-欠缴；02-欠缴2期后缴清；99-缴清
		strb.append("</premiumsPaidDetails>");
		return strb.toString();
	}
}
