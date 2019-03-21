package com.accp.action.lzh;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.lzh.MemberBizL;
import com.accp.vo.lzh.UserVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/c/lzh/member")
public class MemberActionL {
	@Resource
	private MemberBizL biz;
	
	/*
	 * 会员信息
	 */
	@GetMapping("/memberInfo/{nikeName}")
	public List<UserVo> findUsersInfo(@PathVariable String nikeName){
		return biz.findMember(nikeName);
	}
	
	@GetMapping("/userShop/{userName}/{shopName}/{merchantType}/{pageNum}")
	public PageInfo<UserVo> findUserShop(@PathVariable String userName,@PathVariable String shopName,@PathVariable String merchantType,@PathVariable Integer pageNum){
		if ("@*".equals(userName)||"".equals(userName)) {
			userName = null;
		}
		if ("@*".equals(shopName)||"".equals(shopName)) {
			shopName = null;
		}
		if ("@*".equals(merchantType)||"".equals(merchantType)) {
			merchantType = null;
		}
		return biz.findUserShop(userName, shopName, merchantType, pageNum);
	}
	@GetMapping("/userShopxq/{userID}")
	public UserVo findUserShopxq(@PathVariable int userID){
		return biz.findUserShopxq(userID);
	}
}
