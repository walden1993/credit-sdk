/**
 * Project Name:credit-rest
 * File Name:Compensatory.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:16:36
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:代偿概况信息段 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:16:36 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class Compensatory implements Serializable {
	private static final long serialVersionUID = 2957624430873051064L;
	private String accounttingDate;// 记账日期
	private String continuedRecovery; // 继续追偿标志：1-是，2-否
	private String lastOnceDate;// 最近一次代偿日期：YYYY-MM-DD
	private String compensatoryAmounts;// 累计代偿金额
	private String agencyBearCompensatory;// 本机构承担代偿金额
	private String lastOnceRecoveryDate;// 最近一次追偿日期
	private String compensatoryBalance;// 代偿余额
	private String agencyBearBalance;// 本机构承担代偿余额
	private String recoveryAmounts;// 累计追偿金额
	private String lossAmounts;// 累计损失金额
	private String losePath;// 逾期扣款失败截图附件
	private String noticePath;// 逾期上报通知截图附件
	private String collectionPath;// 催收记录附件
	private String otherPath;// 其他资料附件
	private String losePathType;// 其他资料附件后缀
	private String noticePathType;
	private String collectionPathType;
	private String otherPathType;

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<compensatory>"); // 代偿概况信息段
		strb.append("<accounttingDate>").append(accounttingDate).append("</accounttingDate>"); // 记账日期
		strb.append("<continuedRecovery>").append(continuedRecovery).append("</continuedRecovery>"); // 继续追偿标志：1-是，2-否
		strb.append("<lastOnceDate>").append(lastOnceDate).append("</lastOnceDate>"); // 最近一次代偿日期：YYYY-MM-DD
		strb.append("<compensatoryAmounts>").append(compensatoryAmounts).append("</compensatoryAmounts>"); // 累计代偿金额
		strb.append("<agencyBearCompensatory>").append(agencyBearCompensatory).append("</agencyBearCompensatory>"); // 本机构承担代偿金额
		strb.append("<lastOnceRecoveryDate>").append(lastOnceRecoveryDate).append("</lastOnceRecoveryDate>"); // 最近一次追偿日期
		strb.append("<compensatoryBalance>").append(compensatoryBalance).append("</compensatoryBalance>"); // 代偿余额
		strb.append("<agencyBearBalance>").append(agencyBearBalance).append("</agencyBearBalance>"); // 本机构承担代偿余额
		strb.append("<recoveryAmounts>").append(recoveryAmounts).append("</recoveryAmounts>"); // 累计追偿金额
		strb.append("<lossAmounts>").append(lossAmounts).append("</lossAmounts>"); // 累计损失金额
		strb.append("<losePath>").append(losePath).append("</losePath>");// 逾期扣款失败截图附件
		strb.append("<noticePath>").append(noticePath).append("</noticePath>");// 逾期上报通知截图附件
		strb.append("<collectionPath>").append(collectionPath).append("</collectionPath>");// 催收记录附件
		strb.append("<otherPath>").append(otherPath).append("</otherPath>");// 其他资料附件
		strb.append("<losePathType>").append(losePathType).append("</losePathType>");// 其他资料附件后缀
		strb.append("<noticePathType>").append(noticePathType).append("</noticePathType>");// 其他资料附件后缀
		strb.append("<collectionPathType>").append(collectionPathType).append("</collectionPathType>");// 其他资料附件后缀
		strb.append("<otherPathType>").append(otherPathType).append("</otherPathType>");// 其他资料附件后缀
		strb.append("</compensatory>");
		return strb.toString();
	}
}
