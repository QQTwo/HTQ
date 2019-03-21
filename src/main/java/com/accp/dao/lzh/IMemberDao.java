package com.accp.dao.lzh;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.vo.lzh.UserVo;

public interface IMemberDao {
	/**
	 * 
	 * @Name queryUser
	 * @description 查询会员信息
	 * @param userNickName
	 * @return
	 */
	public List<UserVo> queryUser(@Param("userName")String userNickName);
	
	public List<UserVo> queryShop(@Param("userName")String userName,@Param("shopName")String shopName,@Param("merchantType")String merchantType);
	
	public UserVo queryShopxq(@Param("userID")int userID);
}
