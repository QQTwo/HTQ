/**
 * 
 * @ClassName:memberAction
 * @description:TODO
 * @author lenovo
 * @date 2019年3月12日
 * @version V1.0
 */
package com.accp.action.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.cm.AreaBiz;
import com.accp.biz.cm.BackstageBizCm;
import com.accp.biz.cm.memberBiz;
import com.accp.pojo.Services;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.vo.cm.BaoZhengjinVo;
import com.accp.vo.cm.ForwardVo;
import com.accp.vo.cm.HuiyuanVo;
import com.accp.vo.cm.IntegralVo;
import com.accp.vo.cm.PutforwardrecordVo;
import com.accp.vo.cm.RecordVo;
import com.accp.vo.cm.ServiceCollectVo;
import com.accp.vo.cm.ShopRecomment;
import com.accp.vo.cm.UserVo;
import com.accp.vo.cm.VipVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* @author 作者
* @version 创建时间：2019年3月12日 下午6:46:59
* 类说明
*/
/**
 * 
 * @ClassName:memberAction
 * @description:TODO
 * @author lenovo
 * @date 2019年3月12日
 * @version V1.0
 */
//会员管理
@RestController
@RequestMapping("/c/cmmember")
public class memberAction {
	@Autowired
	private memberBiz biz;
	@Autowired
	private AreaBiz abiz;
	//后台首页
	@Autowired
	private BackstageBizCm bbiz;
	//查询所有会员即会员审核
	@RequestMapping(value="/users/{num}/{size}/{userNickName}",method=RequestMethod.GET)
	public PageInfo<HuiyuanVo> getUserList(@PathVariable Integer num,@PathVariable Integer size, @PathVariable String userNickName) {
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=13;
		}
		if (userNickName.equals("0")) {
			userNickName = null;
		}
		return biz.findUserListByPage(num, size, userNickName);
	}
	//统计总金币数和积分数
	@RequestMapping(value="/users/sum/{userNickName}",method=RequestMethod.GET)
	public Map<String,Object> summmoney(@PathVariable String userNickName) {
		Map<String, Object> message = new HashMap<String, Object>();
		if (userNickName.equals("0")) {
			userNickName = null;
		}
		float jinbi=biz.summmoney(userNickName);
		float jifen=biz.sumjifen(userNickName);
		message.put("jinbi", jinbi);
		message.put("jifen", jifen);
		return message;
	}
	//根据编号找到会员对象
	@RequestMapping(value="/users/user/{userID}",method=RequestMethod.GET)
	public VipVo queryVipById(@PathVariable int userID) {
		return biz.queryVipById(userID);
	}
	//修改
	@PutMapping("updateuser")
	public Map<String, String> updateUserinfo(@RequestBody VipVo vo) {
		Map<String, String> message = new HashMap<String, String>();
		biz.updatememberInfo(vo);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//服务收藏
	@GetMapping("serviceCollect")
	public PageInfo<ServiceCollectVo> serviceCollect(String userName,String serviceTitle,String stname,Integer num, Integer size){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=13;
		}
		if(userName=="") {
			userName=null;
		}
		if(serviceTitle=="") {
			serviceTitle=null;
		}
		PageHelper.startPage(num, size);
		return biz.serviceCollect(userName,serviceTitle,stname,num,size);
	}
	//提现申请
	@GetMapping("querytixian")
	public PageInfo<PutforwardrecordVo> querytixian(String userName, Integer auditStatus,Integer num, Integer size){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if(userName=="") {
			userName=null;
		}
		PageHelper.startPage(num, size);
		return biz.findtixian(userName,auditStatus, num, size);
	}
	//找到提现对象
	@GetMapping("loadforward")
	public ForwardVo queryForward(int userID,String Time) {
		return biz.queryForward(userID,Time);
	}
	//提现审核
	@PutMapping("updateForward")
	public Map<String, String> updateForward(@RequestBody ForwardVo vo) {
		Map<String, String> message = new HashMap<String, String>();
		biz.updateForward(vo);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//地区联动
	@GetMapping("queryArea")
	public List<Sharea> queryArea(Integer id){
		List<Sharea> area=abiz.queryAllArea(id);
		return area;
	}
	//积分记录
	@GetMapping("queryIntegral")
	public PageInfo<IntegralVo> queryIntegral(Integer num, Integer size,String userName) {
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		PageHelper.startPage(num, size);
		return biz.queryIntegral(num, size, userName);
	}
	//充值记录
	@GetMapping("queryRecharge")
	public PageInfo<RecordVo> queryRecharge(Integer num, Integer size,String userName,Integer acquisitionMode,Integer auditStatus){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		PageHelper.startPage(num, size);
		return biz.queryRecharge(num, size, userName, acquisitionMode,auditStatus);
	}
	//商家推荐
	@GetMapping("shopRecomment")
	public PageInfo<ShopRecomment> shopRecomment(String userName,Integer merchantType,String shopName,Integer recommendbool,Integer num,Integer size){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if (userName.equals("")) {
			userName = null;
		}
		if(shopName.equals("")) {
			shopName=null;
		}
		PageHelper.startPage(num, size);
		return biz.shopRecomment(userName, merchantType, shopName, recommendbool, num, size);
	}
	//商家推荐修改
	@GetMapping("loadshopRe")
	public ShopRecomment loadshopRe(Integer serviceID) {
		return biz.loadshopRe(serviceID);
	}
	@PutMapping("updateRecomment")
	public Map<String, String> updateRecomment(@RequestBody Services services) {
		Map<String, String> message = new HashMap<String, String>();
		biz.updateRecomment(services);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//保证金
	@GetMapping("baozhengjinList")
	public PageInfo<BaoZhengjinVo> baozhengjinList(String userName,Integer auditStatus,Integer num, Integer size){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if(userName=="") {
			userName=null;
		}
		PageHelper.startPage(num, size);
		return biz.baozhengjinList(userName, auditStatus, num, size);
	}
	//保证金审核
	@GetMapping("loadbaozhengjin")
	public BaoZhengjinVo loadbaozhengjin(int userID,String Time,Integer bID) {
		return biz.loadbaozhengjin(userID, Time, bID);
	}
	@PutMapping("updateBaozhengjin")
	public Map<String, String> updateBaozhengjin(@RequestBody BaoZhengjinVo vo) {
		Map<String, String> message = new HashMap<String, String>();
		biz.updateBaozhengjin(vo);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	//商家管理
	@GetMapping("queryShop")
	public PageInfo<UserVo> queryShop(String userName,String shopName,String merchantType,Integer num, Integer size) {
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		if (shopName.equals("0")||shopName.equals("")) {
			shopName = null;
		}
		if (merchantType.equals("-1")||merchantType.equals("")) {
			merchantType = null;
		}
		PageHelper.startPage(num, size);
		return biz.queryShop(userName, shopName, merchantType,num,size);
	}
	//商家管理金币和积分记录
	@GetMapping("sumShopmoney")
	public Map<String,Object> sumShopmoney(String userName,String shopName,String merchantType) {
		Map<String, Object> message = new HashMap<String, Object>();
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		if (shopName.equals("0")||shopName.equals("")) {
			shopName = null;
		}
		if (merchantType.equals("-1")||merchantType.equals("")) {
			merchantType = null;
		}
		float jinbi=biz.summShopmoney(userName, shopName, merchantType);
		float jifen=biz.sumShopjifen(userName, shopName, merchantType);
		message.put("sjinbi", jinbi);
		message.put("sjifen", jifen);
		return message;
	}
	//加载商家管理对象
	@GetMapping("loadShopVo")
	public UserVo loadShopVo(Integer userID) {
		return biz.loadShopVo(userID);
	}
	//修改商家管理审核
	@PutMapping("updateShopVip")
	public Map<String, String> updateShopVip(@RequestBody User u) {
		Map<String, String> message = new HashMap<String, String>();
		biz.updateShopVip(u);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	/**
	 * 后台首页
	 */
	@GetMapping("getQuery")
	public Map<String,Object> getQuery(){
		Map<String,Object> message=new HashMap<String,Object>();
		//服务审核
		message.put("services", bbiz.queryAllServices());
		//申请鉴定
		message.put("ala", bbiz.queryAllAppraisalApply());
		//商家入驻
		message.put("user", bbiz.queryAllUser());
		//提现
		message.put("put", bbiz.queryAllPut());
		//保证金退还申请
		message.put("bond", bbiz.queryAllBond());
		//申请管理员介入
		message.put("refg",bbiz.queryAllRefund());
		//帖子鉴定
		message.put("post", bbiz.queryAllPost());
		return message;
	}
	
}
