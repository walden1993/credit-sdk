/**
 * Project Name:credit-rest
 * File Name:RealInBulgaria.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午3:57:50
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:实际在保责任信息段 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午3:57:50 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class RealInBulgaria implements Serializable {
	private static final long serialVersionUID = 1145732270935332431L;
	private String assureContractStatus;// 担保合同状态
	private String dutyRelieveDate; // 担保责任解除日期
	private String balanceInBulgaria; // 在保金额
	private String balanceChangeDate; // 余额变化日期

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<realInBulgaria>"); // 实际在保责任信息段
		strb.append("<assureContractStatus>").append(assureContractStatus).append("</assureContractStatus>"); // 担保合同状态
		strb.append("<dutyRelieveDate>").append(dutyRelieveDate).append("</dutyRelieveDate>"); // 担保责任解除日期
		strb.append("<balanceInBulgaria>").append(balanceInBulgaria).append("</balanceInBulgaria>"); // 在保余额
		strb.append("<balanceChangeDate>").append(balanceChangeDate).append("</balanceChangeDate>"); // 余额变化日期
		strb.append("</realInBulgaria>");
		return strb.toString();
	}
}
