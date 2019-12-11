package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 基础类型
 * 
 * @author hejiahua
 *
 */
@Data
public class BaseVO implements Serializable {

	private static final long serialVersionUID = 1120194754102572570L;
	// 商户编号
	private String spCode;

	// 请求类型
	private String transId;

	// 担保合同号码
	private String contractCode;

	// 加签字段
	private String signature;

}
