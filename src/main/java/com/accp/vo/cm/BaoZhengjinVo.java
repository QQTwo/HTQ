/**
 * 
 * @ClassName:BaoZhengjinVo
 * @description:TODO
 * @author lenovo
 * @date 2019年3月19日
 * @version V1.0
 */
package com.accp.vo.cm;
/**
* @author 作者
* @version 创建时间：2019年3月19日 下午8:46:44
* 类说明
*/
/**
 * 
 * @ClassName:BaoZhengjinVo
 * @description:保证金vo实体
 * @author lenovo
 * @date 2019年3月19日
 * @version V1.0
 */

import java.util.Date;

public class BaoZhengjinVo {
	private Integer bID;
	private Integer userID;
	private Integer bondType;
	private double goldCoin;
	private String reviewNotes;
	private String submitTime;//提交申请时间
	private String completeTime;//完成审核时间
	private Integer auditStatus;//审核状态(1待审核2审核成功3未通过)
	private String userName;//用户名
	private String shopName;//商家名
	public Integer getbID() {
		return bID;
	}
	public void setbID(Integer bID) {
		this.bID = bID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getBondType() {
		return bondType;
	}
	public void setBondType(Integer bondType) {
		this.bondType = bondType;
	}
	public double getGoldCoin() {
		return goldCoin;
	}
	public void setGoldCoin(double goldCoin) {
		this.goldCoin = goldCoin;
	}
	public String getReviewNotes() {
		return reviewNotes;
	}
	public void setReviewNotes(String reviewNotes) {
		this.reviewNotes = reviewNotes;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
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
	public BaoZhengjinVo(Integer bID, Integer userID, Integer bondType, double goldCoin, String reviewNotes,
			String submitTime, String completeTime, Integer auditStatus, String userName, String shopName) {
		super();
		this.bID = bID;
		this.userID = userID;
		this.bondType = bondType;
		this.goldCoin = goldCoin;
		this.reviewNotes = reviewNotes;
		this.submitTime = submitTime;
		this.completeTime = completeTime;
		this.auditStatus = auditStatus;
		this.userName = userName;
		this.shopName = shopName;
	}
	public BaoZhengjinVo() {
		super();
	}
	
}
