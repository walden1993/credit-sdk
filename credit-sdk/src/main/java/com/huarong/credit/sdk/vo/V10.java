/**
 * Project Name:credit-rest
 * File Name:V10.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午5:01:57
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V10 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年12月9日 下午5:01:57 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V10 extends BaseVO implements Serializable {

	private static final long serialVersionUID = 9165846484426165768L;

	private String counterGuaranteeType;

	private String counterGuaranteeName;

	private String counterGuaranteeIdType;

	private String counterGuaranteeIdNo;

	private String counterGuaranteeAmount;

	private String counterGuaranteeStatus;

}
