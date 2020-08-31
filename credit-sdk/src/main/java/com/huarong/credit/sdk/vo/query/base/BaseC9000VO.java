/**
 * Project Name:credit-rest
 * File Name:BaseC9000VO.java
 * Package Name:com.huarong.credit.vo.risk
 * Date:2020年7月6日下午2:44:15
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.query.base;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:BaseC9000VO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年7月6日 下午2:44:15 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
public class BaseC9000VO implements Serializable {

	private static final long serialVersionUID = -9041408723213400287L;

	private String requestNo;// 查询流水
	
	private String merchantId;// 商户号

	private String riskQueryType;// 查询交易类型

	private String queryDate;// 查询日期yyyyMMdd

	// 加签字段
	private String signature;

}
