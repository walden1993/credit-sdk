/**
 * Project Name:credit-rest
 * File Name:C9001.java
 * Package Name:com.huarong.credit.vo
 * Date:2020年7月3日上午11:33:37
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.query.risk;

import com.huarong.credit.sdk.vo.query.base.BaseC9000VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:信用评分入参 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年7月3日 上午11:33:37 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class C9001 extends BaseC9000VO {

	private static final long serialVersionUID = 2313440489581801131L;

	private String queryName;// 查询姓名

	private String queryIdNoType;// 查询证件号码类型

	private String queryIdNo;// 查询证件号码

	private String queryPhone;// 查询手机号

}
