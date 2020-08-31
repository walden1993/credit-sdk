

package com.huarong.credit.sdk.vo.report;

import com.huarong.credit.sdk.vo.report.base.BaseVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组装9070请求报文
 * 
 * @return
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class R9070 extends BaseVO {
	
	private static final long serialVersionUID = -1034848247878240787L;

	private String serialNumber;
}
