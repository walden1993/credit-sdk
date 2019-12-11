/**
 * Project Name:credit-rest
 * File Name:V15.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月9日下午6:24:02
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V15 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年12月9日 下午6:24:02 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V15 extends BaseVO implements Serializable {

	private static final long serialVersionUID = -62271916681539488L;
	
	private String compensationDate;
	
	private String compensationAmount;
	
}

