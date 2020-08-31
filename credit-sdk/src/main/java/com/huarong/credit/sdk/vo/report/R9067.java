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

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组装9067请求报文
 * 
 * 当确认代偿款项损失时，必须上报：基础段+代偿概况信息段
 * 
 * @return
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class R9067 extends BaseVO {
	
	private static final long serialVersionUID = -1034848247878240787L;

	AssureUpload assureUpload;
	
	Compensatory compensatory;
}
