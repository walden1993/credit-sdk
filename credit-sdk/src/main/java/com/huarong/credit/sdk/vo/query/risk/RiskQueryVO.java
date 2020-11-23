/**
 * Project Name:credit-sdk
 * File Name:E0001.java
 * Package Name:com.huarong.credit.sdk.vo.query.risk
 * Date:2020年11月23日上午11:35:54
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.query.risk;

import java.io.Serializable;

import com.huarong.credit.sdk.vo.query.base.BaseC9000VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:风控查询入参 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年11月23日 上午11:35:54 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RiskQueryVO extends BaseC9000VO implements Serializable {
	private static final long serialVersionUID = 4280206372834266036L;
	
	private String queryName;// 查询姓名

	private String queryIdNoType;// 查询证件号码类型

	private String queryIdNo;// 查询证件号码
	
	private String queryPhone;// 查询手机号
	
	private String riskQueryData;//风控选填参数信息，json格式base64
}
