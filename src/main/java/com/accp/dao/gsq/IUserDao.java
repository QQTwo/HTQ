package com.accp.dao.gsq;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.News;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.pojo.UserHabit;
import com.accp.vo.gsq.NewsVo;
import com.accp.vo.gsq.TimeOutEmailDateVo;

public interface IUserDao {
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return
	 */
	public Integer queryEmail(@Param("email")String email);
	/**
	 * 使用邮箱注册
	 * @return
	 */
	public int saveEmailUser(@Param("emailDate")TimeOutEmailDateVo emailDate);
	/**
	 * 使用邮箱登陆
	 * @param emailDate
	 * @return
	 */
	public User login(@Param("email")String email,@Param("password")String password);
	/**
	 * 修改邮件登陆密码
	 * @param email
	 * @param password
	 * @return
	 */
	public int updatePwd(@Param("email")String email,@Param("password")String password);
	/**
	 * 查看中韩行政地区
	 * @return
	 */
	public List<Sharea> querySharea();
	/**
	 * 修改个人资料
	 * @param u
	 * @return
	 */
	public int updateUserInfo(@Param("u")User u);
	/**
	 * 查询当前用户
	 * @param userID
	 * @return
	 */
	public User queryUser(@Param("userID")Integer  userID);
	/**
	 * 修改用户图片
	 * @param userImgPath
	 * @param userID
	 * @return
	 */
	public int updateUserImg(@Param("userImg")String userImgPath,@Param("userID")Integer  userID);
	/**
	 * 查询服务类别
	 * @param id
	 * @return
	 */
	public String querySerType(@Param("id")Integer id);
	/**
	 * 修改用户店铺信息
	 * @param u
	 * @return
	 */
	public int updateUserDpxx(@Param("u")User u);
	/**
	 * 查询用户系统信息
	 * @param userID
	 * @return
	 */
	public List<News> queryXtNews(@Param("userid")Integer userID,@Param("newsType")Integer newsType);
	/**
	 * 修改系统信息已读状态
	 * @param newsID
	 * @return
	 */
	public int updateXtNews(@Param("newsID")String newsID);
	/**
	 * 删除系统信息
	 * @param newsID
	 * @return
	 */
	public int deleteNews(@Param("newsID")String newsID);
	/**
	 * 查询站内信
	 * @param userID
	 * @return
	 */
	public List<NewsVo> queryZnxNews(@Param("userid")Integer userID);
	/**
	 * 修改站内信已读状态
	 * @param groupID
	 * @return
	 */
	public int updateZnxNews(@Param("theSender")String theSender,@Param("addressee")String addressee);
	/**
	 * 删除站内信
	 * @param newsID
	 * @return
	 */
	public int deleteZnxNews(@Param("theSender")String theSender,@Param("addressee")String addressee);
	/**
	 * 查询站内信详情
	 * @param groupID
	 * @return
	 */
	public List<NewsVo> queryZnxXq(@Param("groupID")String groupID,@Param("thesender")Integer thesender,@Param("addressee")Integer addressee);
	/**
	 * 新增站内信
	 * @param news
	 * @return
	 */
	public int saveZnx(@Param("news")News news);
	/**
	 * 查询所有信息
	 * @param userID
	 * @return
	 */
	public List<News> queryAllNews(@Param("userid")Integer userID);
	/**
	 * 新增系统信息
	 * @param userID
	 * @param content
	 * @return
	 */
	public int saveXtxx(@Param("userid")Integer userID,@Param("content")String content);
	/**
	 * 修改最后登入时间
	 * @param userID
	 * @return
	 */
	public int updateUserRecentEntry(@Param("userid")Integer userID);
	/**
	 * 根据编号获取用户
	 * 
	 * @param userid
	 *            编号
	 * @return
	 */
	User queryUserById(int userid);
	/**
	 * 相对修改用余额
	 * 
	 * @param usermoney
	 *            相对余额
	 * @param userid
	 *            用户编号
	 * @return
	 */
	boolean updateUserMoney(@Param("usermoney") Float usermoney, @Param("userid") int userid);
	/**
	 * 
	    * @Title: updateUsersign
	    * @Description: 用户签到 获取积分
	    * @param @param userID
	    * @param @return    参数
	    * @return int  返回类型
	    * @throws
	 */
	public int updateUserSign(@Param("userid")Integer userID,@Param("signNum")Integer signNum);
	
	//查询未读信息（全部为0 系统1 站内信2）
	public int selectNoReader(@Param("newstype") Integer newstype,@Param("userid")Integer userid);
	/**
	 * 
	    * @Title: updateUserSign
	    * @Description: 修改签到状态
	    * @param @param userID
	    * @param @param signNum
	    * @param @param signType
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int updateUserSign(@Param("userid")Integer userID,@Param("signNum")Integer signNum,@Param("signType")Integer signType);
	/**
	 * 
	    * @Title: saveUserHabit
	    * @Description: 用户习惯查看服务
	    * @param @param habit    参数
	    * @return void    返回类型
	    * @throws
	 */
	void saveUserHabit(@Param("habit")UserHabit habit);
	/**
	 * 
	    * @Title: queryUserHabit
	    * @Description: 查看用户习惯
	    * @param @param userID
	    * @param @return    参数
	    * @return List<UserHabit>    返回类型
	    * @throws
	 */
	List<UserHabit> queryUserHabit(@Param("userid")Integer userID);
	
}
