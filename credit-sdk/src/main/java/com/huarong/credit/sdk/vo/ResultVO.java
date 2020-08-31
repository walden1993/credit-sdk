/**
 * Project Name:credit-rest
 * File Name:ResultVO.java
 * Package Name:com.huarong.credit.vo
 * Date:2019年12月10日上午11:44:09
 * Copyright (c) 2019, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.vo;
/**
 * ClassName:ResultVO <br/>
 * Reason:	 响应结果VO. <br/>
 * Date:     2019年12月10日 上午11:44:09 <br/>
 * @author   hejiahua
 * @version  
 * @see 	 
 */

/**
 * Controller 统一定义返回类
 * 
 * @author 单红宇
 * @date 2019年6月26日
 *
 */
public class ResultVO {

	/**
	 * 返回信息
	 */
	private String message;

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ResultVO [message=" + message + ", code=" + code + ", data=" + data + "]";
	}

	/**
	 * 返回数据
	 */
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 默认构造，返回操作正确的返回代码和信息
	 */
	public ResultVO() {
		this.message = "操作成功";
		this.code = "0000";
	}

	public ResultVO(String code, String message) {
		super();
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
