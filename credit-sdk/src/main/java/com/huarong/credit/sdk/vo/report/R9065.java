/**
 * Project Name:credit-rest
 * File Name:R9060.java
 * Package Name:com.huarong.credit.vo.report
 * Date:2020年8月17日下午3:22:31
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report;

import com.huarong.credit.sdk.vo.report.base.AssureUpload;
import com.huarong.credit.sdk.vo.report.base.BaseVO;
import com.huarong.credit.sdk.vo.report.base.Compensatory;
import com.huarong.credit.sdk.vo.report.base.CompensatoryDetails;
import com.huarong.credit.sdk.vo.report.base.RealInBulgaria;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组装9060请求报文
 * 
 * 当担保合同发生代偿时，必须上报：基础段+实际在保责任信息段+代偿概况信息段+代偿明细信息段
 * 
 * @return
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class R9065 extends BaseVO {
	
	private static final long serialVersionUID = -1034848247878240787L;

	AssureUpload assureUpload;
	
	RealInBulgaria realInBulgaria;
	
	Compensatory compensatory;
	
	CompensatoryDetails compensatoryDetails;
}
