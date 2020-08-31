/**
 * Project Name:credit-rest
 * File Name:R9060.java
 * Package Name:com.huarong.credit.vo.report
 * Date:2020年8月17日下午3:22:31
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.report;

import com.huarong.credit.sdk.vo.report.base.AntiGuarantor;
import com.huarong.credit.sdk.vo.report.base.AssureContract;
import com.huarong.credit.sdk.vo.report.base.AssureUpload;
import com.huarong.credit.sdk.vo.report.base.BaseVO;
import com.huarong.credit.sdk.vo.report.base.BeAssurePeople;
import com.huarong.credit.sdk.vo.report.base.CreditorAndContract;
import com.huarong.credit.sdk.vo.report.base.RealInBulgaria;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组装9060请求报文
 * 
 * 当签订担保信息合同时，必须上报：基础段+担保合同信息段+实际在保责任信息段 +反担保人信息段+债权人及主合同信息段
 * 当担保合同有被担保人时，必须上报被担保人信息段
 * 
 * @return
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class R9060 extends BaseVO {
	
	private static final long serialVersionUID = -1034848247878240787L;

	AssureUpload assureUpload;
	
	AssureContract assureContract;
	
	RealInBulgaria realInBulgaria;
	
	BeAssurePeople beAssurePeople;
	
	AntiGuarantor antiGuarantor;
	
	CreditorAndContract creditorAndContract;
}
