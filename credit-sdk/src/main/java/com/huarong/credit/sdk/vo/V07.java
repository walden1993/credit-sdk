package com.huarong.credit.sdk.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 对应交易类型
 * 
 * @author hejiahua
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class V07 extends BaseVO implements Serializable {

	private static final long serialVersionUID = -4794423145224925183L;

	private String warranteeType;

	private String warranteeName;

	private String warranteeIdType;

	private String warranteeIdNo;

	private String area;

	private String homeAddress;

	private String mobilePhone;

	private String industryCategory;

	private String deviceId;

	private String mobilePhoneAccess;

	private String nightCalls30Days;

	private String deviceType;

	private String businessType;

	private String guaranteeMode;

	private String debtUse;

	private String guaranteeAmount;

	private String loanAmount;

	private String warranteePeriod;

	private String guaranteeSdate;

	private String interestDate;

	private String expireDate;

	private String guaranteeEdate;

	private String repayMethod;

	private String repaSign;

	private String gracePeriod;

	private String marginLevel;

	private String counterGuaranteeBcbl;

	private String rate;

	private String rateYear;

	private String paymentOrder;

	private String guaranteeRelieveDate;

	private String onBalance;

	private String balanceChangeDate;

	private String zbalanceChangeDate;

	private String meetAmount;

	private String meetInt;

	private String meetTotal;

	private String returnAmount;

	private String returnInt;

	private String returnTotal;
}
