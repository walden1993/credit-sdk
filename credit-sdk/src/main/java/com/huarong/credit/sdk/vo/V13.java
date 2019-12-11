/**
 * Project Name:credit-rest
 * File Name:V13.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午5:29:41
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V13 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年12月9日 下午5:29:41 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V13 extends BaseVO implements Serializable {

	private static final long serialVersionUID = 3349704861678854277L;

	private String bookkeepingDate;

	private String recoveryFlag;

	private String compensationLastDate;

	private String compensationTotalAmount;

	private String thisInstCompensationAmount;

	private String recoveryLastDate;

	private String compensationBalance;

	private String thisInstCompensationBalance;

	private String recoveryTotalAmount;

	private String lossToalAmount;
}
