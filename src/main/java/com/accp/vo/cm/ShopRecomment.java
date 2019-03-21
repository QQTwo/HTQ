/**
 * 
 * @ClassName:ShopRecomment
 * @description:TODO
 * @author lenovo
 * @date 2019年3月19日
 * @version V1.0
 */
package com.accp.vo.cm;
/**
* @author 作者
* @version 创建时间：2019年3月19日 上午11:20:30
* 类说明
*/
/**
 * 
 * @ClassName:ShopRecomment
 * @description:TODO
 * @author lenovo
 * @date 2019年3月19日
 * @version V1.0
 */

import java.util.Date;

public class ShopRecomment {
	private Integer stid;
	private Integer serviceID;
	private Integer userID;
	private String userName;
	private String shopName;
	private String stName;
	private Integer merchantType;
	private Integer auditStatus;
	private Integer userSex;
	private String merchantPhone;
	private Integer recommendBool;
	private double guaranteeMoney;
	private String qq;
	private String weChat;
	private String registerIP;
	private String lastEntry;
	private Date userRegistrationTime;
	private Date recentEntry;
	private Integer businessState;
	private String serviceCoverImg;
	private String adDetail;
	
	public String getAdDetail() {
		return adDetail;
	}
	public void setAdDetail(String adDetail) {
		this.adDetail = adDetail;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public Integer getMerchantType() {
		return merchantType;
	}
	public void setMerchantType(Integer merchantType) {
		this.merchantType = merchantType;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getMerchantPhone() {
		return merchantPhone;
	}
	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}
	public Integer getRecommendBool() {
		return recommendBool;
	}
	public void setRecommendBool(Integer recommendBool) {
		this.recommendBool = recommendBool;
	}
	public double getGuaranteeMoney() {
		return guaranteeMoney;
	}
	public void setGuaranteeMoney(double guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	public String getRegisterIP() {
		return registerIP;
	}
	public void setRegisterIP(String registerIP) {
		this.registerIP = registerIP;
	}
	public String getLastEntry() {
		return lastEntry;
	}
	public void setLastEntry(String lastEntry) {
		this.lastEntry = lastEntry;
	}
	public Date getUserRegistrationTime() {
		return userRegistrationTime;
	}
	public void setUserRegistrationTime(Date userRegistrationTime) {
		this.userRegistrationTime = userRegistrationTime;
	}
	public Date getRecentEntry() {
		return recentEntry;
	}
	public void setRecentEntry(Date recentEntry) {
		this.recentEntry = recentEntry;
	}
	public Integer getBusinessState() {
		return businessState;
	}
	public void setBusinessState(Integer businessState) {
		this.businessState = businessState;
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public ShopRecomment(Integer stid, Integer serviceID, Integer userID, String userName, String shopName,
			String stName, Integer merchantType, Integer auditStatus, Integer userSex, String merchantPhone,
			Integer recommendBool, double guaranteeMoney, String qq, String weChat, String registerIP, String lastEntry,
			Date userRegistrationTime, Date recentEntry, Integer businessState, String serviceCoverImg) {
		super();
		this.stid = stid;
		this.serviceID = serviceID;
		this.userID = userID;
		this.userName = userName;
		this.shopName = shopName;
		this.stName = stName;
		this.merchantType = merchantType;
		this.auditStatus = auditStatus;
		this.userSex = userSex;
		this.merchantPhone = merchantPhone;
		this.recommendBool = recommendBool;
		this.guaranteeMoney = guaranteeMoney;
		this.qq = qq;
		this.weChat = weChat;
		this.registerIP = registerIP;
		this.lastEntry = lastEntry;
		this.userRegistrationTime = userRegistrationTime;
		this.recentEntry = recentEntry;
		this.businessState = businessState;
		this.serviceCoverImg = serviceCoverImg;
	}
	public ShopRecomment() {
		super();
	}
	
}
