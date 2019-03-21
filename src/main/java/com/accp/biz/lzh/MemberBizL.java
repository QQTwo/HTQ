package com.accp.biz.lzh;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.lzh.IMemberDao;
import com.accp.vo.lzh.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.SUPPORTS,readOnly=true)
public class MemberBizL {
	@Resource
	private IMemberDao dao;
	
	/*
	 * 会员信息
	 */
	public List<UserVo> findMember(String nikeName){
		return dao.queryUser(nikeName);
	}
	
	public PageInfo<UserVo> findUserShop(String userName,String shopName,String merchantType,Integer pageNum){
		PageHelper.startPage(pageNum,20);
		return new PageInfo<UserVo>(dao.queryShop(userName, shopName, merchantType));
	}
	public UserVo findUserShopxq(int userID){
		return dao.queryShopxq(userID);
	}
}
