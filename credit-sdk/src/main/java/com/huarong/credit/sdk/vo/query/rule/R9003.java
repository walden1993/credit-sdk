/**
 * Project Name:credit-rest
 * File Name:CreditRuleVo.java
 * Package Name:com.huarong.credit.vo.credit
 * Date:2020年7月7日下午6:25:17
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.query.rule;

import java.io.Serializable;

import com.huarong.credit.sdk.vo.query.risk.C9003;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:征信查询比对结果VO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年7月7日 下午6:25:17 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class R9003 extends C9003 implements Serializable {

	private static final long serialVersionUID = 3364635163218338800L;
	private String rules;

}