/**
 * Project Name:credit-rest
 * File Name:compensatoryDetails.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午4:20:42
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:代偿明细信息段 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年8月17日 下午4:20:42 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class CompensatoryDetails implements Serializable {

	private static final long serialVersionUID = 6415926246294937174L;
	private String compensatoryDate;//// 代偿日期
	private String compensatoryMoney;// 代偿金额

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<compensatoryDetails>"); // 代偿明细信息段
		strb.append("<compensatoryDate>").append(compensatoryDate).append("</compensatoryDate>"); // 代偿日期
		strb.append("<compensatoryMoney>").append(compensatoryMoney).append("</compensatoryMoney>"); // 代偿金额
		strb.append("</compensatoryDetails>");
		return strb.toString();
	}

}
