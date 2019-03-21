package com.accp.vo.lzh;

import java.util.Date;

public class UserVo {
	private int userID;
	private String userName;
	private String userEmail;
	private int merchantType;
	private int userIntegral;
	private int userMoney;
	private int loginType;
	private int auditStatus;
	private String userPhone;
	private Date recentEntry;
	private String shopName;
	private Boolean mailboxVerification;
	private String contactMailbox;
	private String merchantEmail;
	private int businessState;
	private int documenttype;
	
	public int getDocumenttype() {
		return documenttype;
	}
	public void setDocumenttype(int documenttype) {
		this.documenttype = documenttype;
	}
	public int getBusinessState() {
		return businessState;
	}
	public void setBusinessState(int businessState) {
		this.businessState = businessState;
	}
	public String getMerchantEmail() {
		return merchantEmail;
	}
	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}
	public String getContactMailbox() {
		return contactMailbox;
	}
	public void setContactMailbox(String contactMailbox) {
		this.contactMailbox = contactMailbox;
	}
	public Boolean getMailboxVerification() {
		return mailboxVerification;
	}
	public void setMailboxVerification(Boolean mailboxVerification) {
		this.mailboxVerification = mailboxVerification;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Date getRecentEntry() {
		return recentEntry;
	}
	public void setRecentEntry(Date recentEntry) {
		this.recentEntry = recentEntry;
	}
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
	public int getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
