/**
 * Project Name:credit-rest
 * File Name:RuleQueryVo.java
 * Package Name:com.huarong.credit.vo.credit.v1
 * Date:2020年8月25日上午11:36:43
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo.query.v1;

import java.io.Serializable;

import com.huarong.credit.sdk.vo.query.base.BaseC9000VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: 安全计算<br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2020年8月25日 上午11:36:43 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SecurityComputingQueryVO extends BaseC9000VO implements Serializable {

	private static final long serialVersionUID = 3690200657405657208L;
	
	private String serialNumber; 
	

	private String params;
}
