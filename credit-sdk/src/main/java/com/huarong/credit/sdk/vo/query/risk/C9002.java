/**
 * Project Name:credit-rest
 * File Name:C9005.java
 * Package Name:com.huarong.credit.vo.risk
 * Date:2020年7月6日上午9:49:39
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.query.risk;

import com.huarong.credit.sdk.vo.query.base.BaseC9000VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:C9005 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年7月6日 上午9:49:39 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class C9002 extends BaseC9000VO {

	private static final long serialVersionUID = -3661378951551226418L;

	
	private String queryName;// 查询姓名

	private String queryIdNoType;// 查询证件号码类型

	private String queryIdNo;// 查询证件号码
	
	private String authoFile; 
	
	private String certFile;
	
	private String identFile;
	
	private String workFile;
	
	private String incomeFile;
	
	private String assetsFile;
	
	private String otherFile;
	
	private String backUrl;

}
