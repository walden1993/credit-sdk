/**
 * Project Name:credit-rest
 * File Name:V16.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午6:27:49
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V16 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月9日 下午6:27:49 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V16 extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1554694751644059074L;
	
	private String recoveryDate;
	
	private String recoveryAmount;
	
}

