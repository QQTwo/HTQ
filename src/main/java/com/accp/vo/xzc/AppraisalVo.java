package com.accp.vo.xzc;

import java.util.Date;

public class AppraisalVo {
	private int userID;
	private String userName;
	private String stName; 
	private String userRealName;
	private int userSex;
	private String userPhone;
	private Date submitTime;
	private int auditStatus;
	private Date auditTime;
	private int identityType;
	private String identityNumder;
	private String merchantPhone;
	private String merchantEmail;
	private String reason;
	private String contactMailbox;
	private String adminOpinion;
	private int merchantType;
	
	public int getMerchantType() {
		return merchantType;
	}
	public void setMerchantType(int merchantType) {
		this.merchantType = merchantType;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public int getUserSex() {
		return userSex;
	}
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public int getIdentityType() {
		return identityType;
	}
	public void setIdentityType(int identityType) {
		this.identityType = identityType;
	}
	public String getIdentityNumder() {
		return identityNumder;
	}
	public void setIdentityNumder(String identityNumder) {
		this.identityNumder = identityNumder;
	}
	public String getMerchantPhone() {
		return merchantPhone;
	}
	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}
	public String getMerchantEmail() {
		return merchantEmail;
	}
	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getContactMailbox() {
		return contactMailbox;
	}
	public void setContactMailbox(String contactMailbox) {
		this.contactMailbox = contactMailbox;
	}
	public String getAdminOpinion() {
		return adminOpinion;
	}
	public void setAdminOpinion(String adminOpinion) {
		this.adminOpinion = adminOpinion;
	}
	
	
}
