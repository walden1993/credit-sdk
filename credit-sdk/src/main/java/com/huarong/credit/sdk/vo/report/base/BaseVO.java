package com.huarong.credit.sdk.vo.report.base;

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
	private String merchantId;

	// 业务类型
	private String businessType;

	// 请求流水
	private String requestNo;

	// 加签字段
	private String signature;

}
