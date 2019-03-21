package com.accp.dao.xzc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Forummanagement;
import com.accp.vo.xzc.postVo;
import com.accp.vo.xzc.postglVo;
import com.accp.vo.xzc.posttsVo;
import com.accp.vo.xzc.recordVo;

public interface ItieziDao {
	//查询帖子
	public List<postVo> queryall(@Param("title") String title,@Param("fmname") String fmname);
	//批量删除帖子
	public int deletechoose(@Param("postid") int postid);
	//动态下拉框,查询帖子板块
	public List<Forummanagement> queryfmname();
	//修改帖子
	public int updatepost(@Param("postvo")postVo postvo);
	//查询修改帖子
	public postVo querypost(@Param("postid") int postid);
	//删除帖子版块
	public int deletefor(@Param("fmid")int fmid);
	//新增栏目
	public int insertfor(@Param("foru") Forummanagement foru);
	//查询管理帖子
	public List<postglVo> queryglall();
	
	public postglVo queryglallxq(@Param("fmid")int fmid);
	//查询投诉帖子
		public List<posttsVo> queryts(@Param("title")String title);
		
		public List<recordVo> queryAll(@Param("userName")String userName);
}
