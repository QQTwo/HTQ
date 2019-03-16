/**
 * 
 * @ClassName:HuiyuanVo
 * @description:TODO
 * @author lenovo
 * @date 2019年3月13日
 * @version V1.0
 */
package com.accp.vo.cm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author 作者
* @version 创建时间：2019年3月13日 上午8:34:57
* 类说明
*/
/**
 * 
 * @ClassName:HuiyuanVo
 * @description:TODO
 * @author lenovo
 * @date 2019年3月13日
 * @version V1.0
 */
public class HuiyuanVo {
	private Integer userid;

	private String userimgpath;
	//用户昵称
	private String username;

	private String userrealname;

	private Integer usersex;

	private String userphone;

	private String contactmailbox;
	//用户金币
	private Float usermoney;
	//用户积分
	private Integer userintegral;

	private Integer country;

	private Integer provincialid;

	private Integer cityid;

	private Integer countyid;

	private String addetail;

	private Integer merchanttype;

	private Date merchantregistrationtime;

	private Integer firstserviceid;

	private Integer secondserviceid;

	private Float firstservicemoney;

	private Float secondservicemoney;

	private String hospitalname;

	private String shopname;

	private String signature;

	private Integer guaranteemoney;

	private String shopimg;

	private Integer identitytype;

	private String identitynumder;

	private String identityrealname;

	private String identitypositiveimg;

	private String identitynegativeimg;

	private String identityhandimg;

	private String languagenametext;

	private String majornametext;

	private Integer livecityid;

	private String merchantemail;

	private String merchantphone;

	private Float merchantlevel;

	private Integer merchantexp;

	private String qq;

	private String wechat;

	private String profession;

	private Float height;

	private String constellation;

	private Integer age;

	private Integer collectcount;

	private Integer ordercount;

	private Integer browsenumber;

	private Boolean trusteeship;

	private Date trusteeshipstarttime;

	private Integer trusteeshipmonth;

	private Integer businessstate;

	private Integer experience;

	private Boolean experiencestatus;
	//	审核状态(1待审核2已通过3拒绝)
	private Integer auditstatus;
	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss")
	private Date audittime;

	private Boolean authentication;

	private Boolean authenticationer;

	private Integer creditscore;

	private Boolean stateboolean;
	//邮箱验证/邮箱激活(0激活1未激活)
	private Boolean mailboxverification;

	private String registerip;

	private String lastentry;
	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss")
	private Date userregistrationtime;
	//用户最后登入时间
	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss")
	private Date recententry;

	private String selfintroduction;

	private String reason;
	
	//总金币数
	private float jinbi;
	//总积分数
	private int jifen;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUserimgpath() {
		return userimgpath;
	}
	public void setUserimgpath(String userimgpath) {
		this.userimgpath = userimgpath;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserrealname() {
		return userrealname;
	}
	public void setUserrealname(String userrealname) {
		this.userrealname = userrealname;
	}
	public Integer getUsersex() {
		return usersex;
	}
	public void setUsersex(Integer usersex) {
		this.usersex = usersex;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getContactmailbox() {
		return contactmailbox;
	}
	public void setContactmailbox(String contactmailbox) {
		this.contactmailbox = contactmailbox;
	}
	public Float getUsermoney() {
		return usermoney;
	}
	public void setUsermoney(Float usermoney) {
		this.usermoney = usermoney;
	}
	public Integer getUserintegral() {
		return userintegral;
	}
	public void setUserintegral(Integer userintegral) {
		this.userintegral = userintegral;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	public Integer getProvincialid() {
		return provincialid;
	}
	public void setProvincialid(Integer provincialid) {
		this.provincialid = provincialid;
	}
	public Integer getCityid() {
		return cityid;
	}
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	public Integer getCountyid() {
		return countyid;
	}
	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}
	public String getAddetail() {
		return addetail;
	}
	public void setAddetail(String addetail) {
		this.addetail = addetail;
	}
	public Integer getMerchanttype() {
		return merchanttype;
	}
	public void setMerchanttype(Integer merchanttype) {
		this.merchanttype = merchanttype;
	}
	public Date getMerchantregistrationtime() {
		return merchantregistrationtime;
	}
	public void setMerchantregistrationtime(Date merchantregistrationtime) {
		this.merchantregistrationtime = merchantregistrationtime;
	}
	public Integer getFirstserviceid() {
		return firstserviceid;
	}
	public void setFirstserviceid(Integer firstserviceid) {
		this.firstserviceid = firstserviceid;
	}
	public Integer getSecondserviceid() {
		return secondserviceid;
	}
	public void setSecondserviceid(Integer secondserviceid) {
		this.secondserviceid = secondserviceid;
	}
	public Float getFirstservicemoney() {
		return firstservicemoney;
	}
	public void setFirstservicemoney(Float firstservicemoney) {
		this.firstservicemoney = firstservicemoney;
	}
	public Float getSecondservicemoney() {
		return secondservicemoney;
	}
	public void setSecondservicemoney(Float secondservicemoney) {
		this.secondservicemoney = secondservicemoney;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Integer getGuaranteemoney() {
		return guaranteemoney;
	}
	public void setGuaranteemoney(Integer guaranteemoney) {
		this.guaranteemoney = guaranteemoney;
	}
	public String getShopimg() {
		return shopimg;
	}
	public void setShopimg(String shopimg) {
		this.shopimg = shopimg;
	}
	public Integer getIdentitytype() {
		return identitytype;
	}
	public void setIdentitytype(Integer identitytype) {
		this.identitytype = identitytype;
	}
	public String getIdentitynumder() {
		return identitynumder;
	}
	public void setIdentitynumder(String identitynumder) {
		this.identitynumder = identitynumder;
	}
	public String getIdentityrealname() {
		return identityrealname;
	}
	public void setIdentityrealname(String identityrealname) {
		this.identityrealname = identityrealname;
	}
	public String getIdentitypositiveimg() {
		return identitypositiveimg;
	}
	public void setIdentitypositiveimg(String identitypositiveimg) {
		this.identitypositiveimg = identitypositiveimg;
	}
	public String getIdentitynegativeimg() {
		return identitynegativeimg;
	}
	public void setIdentitynegativeimg(String identitynegativeimg) {
		this.identitynegativeimg = identitynegativeimg;
	}
	public String getIdentityhandimg() {
		return identityhandimg;
	}
	public void setIdentityhandimg(String identityhandimg) {
		this.identityhandimg = identityhandimg;
	}
	public String getLanguagenametext() {
		return languagenametext;
	}
	public void setLanguagenametext(String languagenametext) {
		this.languagenametext = languagenametext;
	}
	public String getMajornametext() {
		return majornametext;
	}
	public void setMajornametext(String majornametext) {
		this.majornametext = majornametext;
	}
	public Integer getLivecityid() {
		return livecityid;
	}
	public void setLivecityid(Integer livecityid) {
		this.livecityid = livecityid;
	}
	public String getMerchantemail() {
		return merchantemail;
	}
	public void setMerchantemail(String merchantemail) {
		this.merchantemail = merchantemail;
	}
	public String getMerchantphone() {
		return merchantphone;
	}
	public void setMerchantphone(String merchantphone) {
		this.merchantphone = merchantphone;
	}
	public Float getMerchantlevel() {
		return merchantlevel;
	}
	public void setMerchantlevel(Float merchantlevel) {
		this.merchantlevel = merchantlevel;
	}
	public Integer getMerchantexp() {
		return merchantexp;
	}
	public void setMerchantexp(Integer merchantexp) {
		this.merchantexp = merchantexp;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCollectcount() {
		return collectcount;
	}
	public void setCollectcount(Integer collectcount) {
		this.collectcount = collectcount;
	}
	public Integer getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(Integer ordercount) {
		this.ordercount = ordercount;
	}
	public Integer getBrowsenumber() {
		return browsenumber;
	}
	public void setBrowsenumber(Integer browsenumber) {
		this.browsenumber = browsenumber;
	}
	public Boolean getTrusteeship() {
		return trusteeship;
	}
	public void setTrusteeship(Boolean trusteeship) {
		this.trusteeship = trusteeship;
	}
	public Date getTrusteeshipstarttime() {
		return trusteeshipstarttime;
	}
	public void setTrusteeshipstarttime(Date trusteeshipstarttime) {
		this.trusteeshipstarttime = trusteeshipstarttime;
	}
	public Integer getTrusteeshipmonth() {
		return trusteeshipmonth;
	}
	public void setTrusteeshipmonth(Integer trusteeshipmonth) {
		this.trusteeshipmonth = trusteeshipmonth;
	}
	public Integer getBusinessstate() {
		return businessstate;
	}
	public void setBusinessstate(Integer businessstate) {
		this.businessstate = businessstate;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Boolean getExperiencestatus() {
		return experiencestatus;
	}
	public void setExperiencestatus(Boolean experiencestatus) {
		this.experiencestatus = experiencestatus;
	}
	public Integer getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(Integer auditstatus) {
		this.auditstatus = auditstatus;
	}
	public Date getAudittime() {
		return audittime;
	}
	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}
	public Boolean getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Boolean authentication) {
		this.authentication = authentication;
	}
	public Boolean getAuthenticationer() {
		return authenticationer;
	}
	public void setAuthenticationer(Boolean authenticationer) {
		this.authenticationer = authenticationer;
	}
	public Integer getCreditscore() {
		return creditscore;
	}
	public void setCreditscore(Integer creditscore) {
		this.creditscore = creditscore;
	}
	public Boolean getStateboolean() {
		return stateboolean;
	}
	public void setStateboolean(Boolean stateboolean) {
		this.stateboolean = stateboolean;
	}
	public Boolean getMailboxverification() {
		return mailboxverification;
	}
	public void setMailboxverification(Boolean mailboxverification) {
		this.mailboxverification = mailboxverification;
	}
	public String getRegisterip() {
		return registerip;
	}
	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}
	public String getLastentry() {
		return lastentry;
	}
	public void setLastentry(String lastentry) {
		this.lastentry = lastentry;
	}
	public Date getUserregistrationtime() {
		return userregistrationtime;
	}
	public void setUserregistrationtime(Date userregistrationtime) {
		this.userregistrationtime = userregistrationtime;
	}
	public Date getRecententry() {
		return recententry;
	}
	public void setRecententry(Date recententry) {
		this.recententry = recententry;
	}
	public String getSelfintroduction() {
		return selfintroduction;
	}
	public void setSelfintroduction(String selfintroduction) {
		this.selfintroduction = selfintroduction;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public float getJinbi() {
		return jinbi;
	}
	public void setJinbi(int jinbi) {
		this.jinbi = jinbi;
	}
	public int getJifen() {
		return jifen;
	}
	public void setJifen(int jifen) {
		this.jifen = jifen;
	}
	public HuiyuanVo(String userimgpath, String username, String userrealname, Integer usersex, String userphone,
			String contactmailbox, Float usermoney, Integer userintegral, Integer country, Integer provincialid,
			Integer cityid, Integer countyid, String addetail, Integer merchanttype, Date merchantregistrationtime,
			Integer firstserviceid, Integer secondserviceid, Float firstservicemoney, Float secondservicemoney,
			String hospitalname, String shopname, String signature, Integer guaranteemoney, String shopimg,
			Integer identitytype, String identitynumder, String identityrealname, String identitypositiveimg,
			String identitynegativeimg, String identityhandimg, String languagenametext, String majornametext,
			Integer livecityid, String merchantemail, String merchantphone, Float merchantlevel, Integer merchantexp,
			String qq, String wechat, String profession, Float height, String constellation, Integer age,
			Integer collectcount, Integer ordercount, Integer browsenumber, Boolean trusteeship,
			Date trusteeshipstarttime, Integer trusteeshipmonth, Integer businessstate, Integer experience,
			Boolean experiencestatus, Integer auditstatus, Date audittime, Boolean authentication,
			Boolean authenticationer, Integer creditscore, Boolean stateboolean, Boolean mailboxverification,
			String registerip, String lastentry, Date userregistrationtime, Date recententry, String selfintroduction,
			String reason, float jinbi, int jifen) {
		super();
		this.userimgpath = userimgpath;
		this.username = username;
		this.userrealname = userrealname;
		this.usersex = usersex;
		this.userphone = userphone;
		this.contactmailbox = contactmailbox;
		this.usermoney = usermoney;
		this.userintegral = userintegral;
		this.country = country;
		this.provincialid = provincialid;
		this.cityid = cityid;
		this.countyid = countyid;
		this.addetail = addetail;
		this.merchanttype = merchanttype;
		this.merchantregistrationtime = merchantregistrationtime;
		this.firstserviceid = firstserviceid;
		this.secondserviceid = secondserviceid;
		this.firstservicemoney = firstservicemoney;
		this.secondservicemoney = secondservicemoney;
		this.hospitalname = hospitalname;
		this.shopname = shopname;
		this.signature = signature;
		this.guaranteemoney = guaranteemoney;
		this.shopimg = shopimg;
		this.identitytype = identitytype;
		this.identitynumder = identitynumder;
		this.identityrealname = identityrealname;
		this.identitypositiveimg = identitypositiveimg;
		this.identitynegativeimg = identitynegativeimg;
		this.identityhandimg = identityhandimg;
		this.languagenametext = languagenametext;
		this.majornametext = majornametext;
		this.livecityid = livecityid;
		this.merchantemail = merchantemail;
		this.merchantphone = merchantphone;
		this.merchantlevel = merchantlevel;
		this.merchantexp = merchantexp;
		this.qq = qq;
		this.wechat = wechat;
		this.profession = profession;
		this.height = height;
		this.constellation = constellation;
		this.age = age;
		this.collectcount = collectcount;
		this.ordercount = ordercount;
		this.browsenumber = browsenumber;
		this.trusteeship = trusteeship;
		this.trusteeshipstarttime = trusteeshipstarttime;
		this.trusteeshipmonth = trusteeshipmonth;
		this.businessstate = businessstate;
		this.experience = experience;
		this.experiencestatus = experiencestatus;
		this.auditstatus = auditstatus;
		this.audittime = audittime;
		this.authentication = authentication;
		this.authenticationer = authenticationer;
		this.creditscore = creditscore;
		this.stateboolean = stateboolean;
		this.mailboxverification = mailboxverification;
		this.registerip = registerip;
		this.lastentry = lastentry;
		this.userregistrationtime = userregistrationtime;
		this.recententry = recententry;
		this.selfintroduction = selfintroduction;
		this.reason = reason;
		this.jinbi = jinbi;
		this.jifen = jifen;
	}
	public HuiyuanVo() {
		super();
	}
	@Override
	public String toString() {
		return "HuiyuanVo [userid=" + userid + ", userimgpath=" + userimgpath + ", username=" + username
				+ ", userrealname=" + userrealname + ", usersex=" + usersex + ", userphone=" + userphone
				+ ", contactmailbox=" + contactmailbox + ", usermoney=" + usermoney + ", userintegral=" + userintegral
				+ ", country=" + country + ", provincialid=" + provincialid + ", cityid=" + cityid + ", countyid="
				+ countyid + ", addetail=" + addetail + ", merchanttype=" + merchanttype + ", merchantregistrationtime="
				+ merchantregistrationtime + ", firstserviceid=" + firstserviceid + ", secondserviceid="
				+ secondserviceid + ", firstservicemoney=" + firstservicemoney + ", secondservicemoney="
				+ secondservicemoney + ", hospitalname=" + hospitalname + ", shopname=" + shopname + ", signature="
				+ signature + ", guaranteemoney=" + guaranteemoney + ", shopimg=" + shopimg + ", identitytype="
				+ identitytype + ", identitynumder=" + identitynumder + ", identityrealname=" + identityrealname
				+ ", identitypositiveimg=" + identitypositiveimg + ", identitynegativeimg=" + identitynegativeimg
				+ ", identityhandimg=" + identityhandimg + ", languagenametext=" + languagenametext + ", majornametext="
				+ majornametext + ", livecityid=" + livecityid + ", merchantemail=" + merchantemail + ", merchantphone="
				+ merchantphone + ", merchantlevel=" + merchantlevel + ", merchantexp=" + merchantexp + ", qq=" + qq
				+ ", wechat=" + wechat + ", profession=" + profession + ", height=" + height + ", constellation="
				+ constellation + ", age=" + age + ", collectcount=" + collectcount + ", ordercount=" + ordercount
				+ ", browsenumber=" + browsenumber + ", trusteeship=" + trusteeship + ", trusteeshipstarttime="
				+ trusteeshipstarttime + ", trusteeshipmonth=" + trusteeshipmonth + ", businessstate=" + businessstate
				+ ", experience=" + experience + ", experiencestatus=" + experiencestatus + ", auditstatus="
				+ auditstatus + ", audittime=" + audittime + ", authentication=" + authentication
				+ ", authenticationer=" + authenticationer + ", creditscore=" + creditscore + ", stateboolean="
				+ stateboolean + ", mailboxverification=" + mailboxverification + ", registerip=" + registerip
				+ ", lastentry=" + lastentry + ", userregistrationtime=" + userregistrationtime + ", recententry="
				+ recententry + ", selfintroduction=" + selfintroduction + ", reason=" + reason + ", jinbi=" + jinbi
				+ ", jifen=" + jifen + "]";
	}
	
	
}
