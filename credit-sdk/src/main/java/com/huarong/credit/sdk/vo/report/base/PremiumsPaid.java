/**
 * Project Name:credit-rest
 * File Name:PremiumsPaid.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:25:00
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:保费缴纳概况信息段 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:25:00 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class PremiumsPaid implements Serializable {

	private static final long serialVersionUID = 6202913928533829275L;
	private String paymentType;// 缴费类别 1-担保费 2-保险保费
	private String billingDate;// 记账日期
	private String premiumsPaidMoney;// 金额
	private String premiumsPaidMethod;// 缴纳方式:1-一次性（趸交）2-分期（期交 ）
	private String premiumsPaidRate;// 缴纳频率
	private String billingStartDate;// 计费起始日期
	private String premiumPaystatus;// 保费缴纳状态 1-正常 2-欠缴 3-缴清
	private String billingEndDate;// 缴纳结束日期
	private String premiumsPaidBalance;// 余额
	private String accumulatedArrears; // 累计欠缴金额

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<premiumsPaid>"); // 保费缴纳概况信息段数据项
		strb.append("<paymentType>").append(paymentType).append("</paymentType>"); // 缴费类别 1-担保费 2-保险保费
		strb.append("<billingDate>").append(billingDate).append("</billingDate>"); // 记账日期
		strb.append("<premiumsPaidMoney>").append(premiumsPaidMoney).append("</premiumsPaidMoney>"); // 金额
		strb.append("<premiumsPaidMethod>").append(premiumsPaidMethod).append("</premiumsPaidMethod>"); // 缴纳方式:1-一次性（趸交）2-分期（期交
																										// ）
		strb.append("<premiumsPaidRate>").append(premiumsPaidRate).append("</premiumsPaidRate>"); // 缴纳频率
		strb.append("<billingStartDate>").append(billingStartDate).append("</billingStartDate>"); // 计费起始日期
		strb.append("<premiumPaystatus>").append(premiumPaystatus).append("</premiumPaystatus>"); // 保费缴纳状态 1-正常 2-欠缴
																									// 3-缴清
		strb.append("<billingEndDate>").append(billingEndDate).append("</billingEndDate>"); // 缴纳结束日期
		strb.append("<premiumsPaidBalance>").append(premiumsPaidBalance).append("</premiumsPaidBalance>"); // 余额
		strb.append("<accumulatedArrears>").append(accumulatedArrears).append("</accumulatedArrears>"); // 累计欠缴金额
		strb.append("</premiumsPaid>");
		return strb.toString();
	}
}
