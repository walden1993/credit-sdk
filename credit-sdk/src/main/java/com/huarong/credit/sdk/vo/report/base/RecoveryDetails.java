/**
 * Project Name:credit-rest
 * File Name:RecoveryDetails.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:21:56
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:追偿明细 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:21:56 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class RecoveryDetails implements Serializable {
	private static final long serialVersionUID = -3597799490951973023L;
	private String recoveryDate;// 追偿日期
	private String recoveryMoney; // 追偿金额

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<recoveryDetails>"); // 追偿明细信息段
		strb.append("<recoveryDate>").append(recoveryDate).append("</recoveryDate>"); // 追偿日期
		strb.append("<recoveryMoney>").append(recoveryMoney).append("</recoveryMoney>"); // 追偿金额
		strb.append("</recoveryDetails>");
		return strb.toString();
	}
}
