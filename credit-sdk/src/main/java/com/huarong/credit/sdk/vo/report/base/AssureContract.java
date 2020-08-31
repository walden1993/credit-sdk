/**
 * Project Name:credit-rest
 * File Name:AssureContract.java
 * Package Name:com.huarong.credit.vo.report.base
 * Date:2020年8月17日下午3:52:02
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report.base;

import java.io.Serializable;

import lombok.Data;

/**
 * 担保合同段
 * 
 * @ClassName: AssureContract
 * @Description:TODO(描述这个类的作用)
 * @author: hejiahua
 * @date: 2020年8月17日 下午3:56:45
 * @Copyright:
 */
@Data
public class AssureContract implements Serializable {

	private static final long serialVersionUID = 3037832102856368466L;
	private String assureContractType;// 担保业务种类
	private String assureManner;// 担保方式
	private String assureContractMoney;// 担保金额
	private String assureBeginDate;// 担保起始日期
	private String assureFinishDate; // 担保到期日期
	private String depositsRatio;// 存出保证金比例
	private String beAssureManner; // 反担保方式
	private String compensationRatio;// 约定再担保补偿
	private String rates;// 费率
	private String annualizedRates;// 年化费率

	// 附件
	private String identPicPath;// 客户身份证图片
	private String assPicPath;// 委托担保书图片
	private String contractPicPath;// 服务合同图片
	private String proPicPath;// 其他附件图片
	private String agrPicPath;// 借款协议附件图片

	// 附件后缀
	private String identPicPathType;// 客户身份证图片后缀
	private String assPicPathType;
	private String contractPicPathType;
	private String proPicPathType;
	private String agrPicPathType;

	public String parseXml() {
		StringBuffer strb = new StringBuffer();
		strb.append("<assureContract>"); // 担保合同段
		strb.append("<assureContractType>").append(assureContractType).append("</assureContractType>"); // 担保业务种类
		strb.append("<assureManner>").append(assureManner).append("</assureManner>"); // 担保方式
		strb.append("<assureContractMoney>").append(assureContractMoney).append("</assureContractMoney>"); // 担保金额
		strb.append("<assureBeginDate>").append(assureBeginDate).append("</assureBeginDate>"); // 担保起始日期
		strb.append("<assureFinishDate>").append(assureFinishDate).append("</assureFinishDate>"); // 担保到期日期
		strb.append("<depositsRatio>").append(depositsRatio).append("</depositsRatio>"); // 存出保证金比例
		strb.append("<beAssureManner>").append(beAssureManner).append("</beAssureManner>"); // 反担保方式
		strb.append("<compensationRatio>").append(compensationRatio).append("</compensationRatio>"); // 约定再担保补偿
		strb.append("<rates>").append(rates).append("</rates>"); // 费率
		strb.append("<annualizedRates>").append(annualizedRates).append("</annualizedRates>"); // 年化费率

		// 附件
		strb.append("<identPicPath>").append(identPicPath).append("</identPicPath>");// 客户身份证图片
		strb.append("<assPicPath>").append(assPicPath).append("</assPicPath>");// 委托担保书图片
		strb.append("<contractPicPath>").append(contractPicPath).append("</contractPicPath>");// 服务合同图片
		strb.append("<proPicPath>").append(proPicPath).append("</proPicPath>");// 其他附件图片
		strb.append("<agrPicPath>").append(agrPicPath).append("</agrPicPath>");// 借款协议附件图片
//		//附件后缀
		strb.append("<identPicPathType>").append(identPicPathType).append("</identPicPathType>");// 客户身份证图片后缀
		strb.append("<assPicPathType>").append(assPicPathType).append("</assPicPathType>");// 委托担保书图片后缀
		strb.append("<contractPicPathType>").append(contractPicPathType).append("</contractPicPathType>");// 服务合同图片后缀
		strb.append("<proPicPathType>").append(proPicPathType).append("</proPicPathType>");// 其他附件图片后缀
		strb.append("<agrPicPathType>").append(agrPicPathType).append("</agrPicPathType>");// 借款协议图片后缀
		strb.append("</assureContract>");
		return strb.toString();
	}
}
