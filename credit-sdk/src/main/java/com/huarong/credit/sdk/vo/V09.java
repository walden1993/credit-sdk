/**
 * Project Name:credit-rest
 * File Name:V09.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午4:50:26
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V09 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年12月9日 下午4:50:26 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V09 extends BaseVO implements Serializable {

	private static final long serialVersionUID = -5198843482785184215L;

	private String creditorType;

	private String creditorName;

	private String creditorIdType;

	private String creditorIdNo;

	private String mainContractId;

	private String mainContractCode;

	private String investIn;

	private String creditorStatus;
}
