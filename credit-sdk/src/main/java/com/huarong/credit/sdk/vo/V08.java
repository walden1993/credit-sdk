package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName:V08 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年12月9日 下午4:15:04 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V08 extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 7872079612851341410L;
	
	private String warranteeType;
	
	private String warranteeName;
	
	private String warranteeIdType;
	
	private String warranteeIdNo;
	
	private String guaranteeStatus;
	
}
