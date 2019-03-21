package com.accp.dao.xzc;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.accp.vo.xzc.appVo;
import com.accp.vo.xzc.userVo;

public interface ISjDao {
	/**
	 * 商家入驻
	 * @return
	 */
	public List<userVo> queryAllUser(@Param("auditstatus") int auditstatus,@Param("merchanttype") int merchanttype,@Param("username") String username);
	/**
	 * 商家入驻详情
	 * @return
	 */
	public userVo queryUser(@Param("userid") int userid);
	
	/**
	 * 查询鉴定审核
	 * @return
	 */
	public List<appVo> queryAllAppraisalApply(@Param("name")String name,@Param("auditstatus")int auditstatus);
	
	public appVo queryAppraisalApply(@Param("userid")int userid);
	/**
	 * 修改
	 * @param userid
	 * @return
	 */
	public void updatash(@Param("userid")int userid);
	
	public void updataAppra(@Param("userid") int userid,@Param("auditstatus") int auditstatus,@Param("reason") String reason);
	
	public int updatauser(@Param("userid") int userid,@Param("auditstatus") int auditstatus);
}
