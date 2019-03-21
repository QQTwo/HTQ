package com.accp.biz.gsq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.cn.IMerchantEnterDao;
import com.accp.dao.gsq.IUserDao;
import com.accp.dao.ylh.GoldnotesDao;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.News;
import com.accp.pojo.Services;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.pojo.UserHabit;
import com.accp.util.RandomNoReiteration;
import com.accp.vo.cn.ServiceSelect;
import com.accp.vo.cn.ServicesVO;
import com.accp.vo.gsq.NewsVo;
import com.accp.vo.gsq.TimeOutEmailDateVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class UserBiz {
	@Autowired
	private IUserDao dao;
	@Autowired
    private GoldnotesDao Gdao;
	@Autowired
	private IMerchantEnterDao Mdao;
	
	public boolean queryEmail(String email) {
		/**
		 * 查询的数字返回0代表可新增
		 */
		return dao.queryEmail(email)==0;
	}
	/**
	 * 邮箱用户注册
	 * @param emailDate
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean saveEmailUser(TimeOutEmailDateVo emailDate) {
		return dao.saveEmailUser(emailDate)>=0;
	}
	/**
	 * 邮箱登陆
	 * @param emailDate
	 * @return
	 */
	public User login(String email,String password) {
		return dao.login(email, password);
		
	}
	/**
	 * 修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean updatePwd(String email,String password){
		return dao.updatePwd(email, password)>0;
	}
	/**
	 * 查询地址
	 * @param pid
	 * @param flag
	 * @return
	 */
	public List<Sharea> querySharea(){
		return dao.querySharea();
	}
	/**
	 * 修改个人信息
	 * @param u
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean updateUserInfo(User u) {
		return dao.updateUserInfo(u)>0;
	}
	/**
	 * 查询当前用户
	 * @param userID
	 * @return
	 */
	public User queryUser(Integer userID){
		return dao.queryUser(userID);
	}
	/**
	 * 修改用户头像
	 * @param userImgPath
	 * @param userID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean updateUserImg(String userImgPath,Integer  userID) {
		return dao.updateUserImg(userImgPath, userID)>0;
	}
	/**
	 * 查询服务类别
	 * @param id
	 * @return
	 */
	public String querySerType(Integer id) {
		return dao.querySerType(id);
	}
	/**
	 * 修改店铺信息
	 * @param u
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean updateUserDpxx(User u) {
		return dao.updateUserDpxx(u)>0;
	}
	/**
	 * 系统分页查询
	 * @param userID
	 * @param newsType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<News>  queryNewPageInfo(Integer userID,Integer newsType,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<>(dao.queryXtNews(userID, newsType));
	}
	/**
	 * 修改已读
	 * @param newsID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateXtNews(String newsID) {
		return dao.updateXtNews(newsID);
	}
	/**
	 * 删除系统信息
	 * @param newsID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int deleteNews(String newsID) {
		return dao.deleteNews(newsID);
	}
	
	/**
	 * 站内信分页查询
	 * @param userID
	 * @param newsType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<NewsVo>  queryZnxNewsPageInfo(Integer userID,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<>(dao.queryZnxNews(userID));
	}
	/**
	 * 修改站内信信息
	 * @param groupID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateZnxNews(String groupID) {
		return dao.updateZnxNews(groupID);
	}
	/**
	 * 删除站内信
	 * @param newsID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int deleteZnxNews(String groupID) {
		return dao.deleteZnxNews(groupID);
	}
	/**
	 * 查询站内信详情
	 * @param userID
	 * @return
	 */
	public List<NewsVo> queryZnxXq(String groupID){
		return dao.queryZnxXq(groupID);
	}
	/**
	 * 新增站内信
	 * @param news
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean saveZnx(News news) {
		return dao.saveZnx(news)>0;
	}
	/**
	 * 查询所有信息
	 * @param userID
	 * @return
	 */
	public List<News> queryAllNews(Integer userID){
		return dao.queryAllNews(userID);
	}
	/**
	 * 新增系统消息
	 * @param userID 用户ID
	 * @param content 内容
	 * @return
	 */
	public boolean saveXtxx(Integer userID,String content) {
		return dao.saveXtxx(userID, content)>0;
	}
	
	/**
	 * 新增系统消息
	 * @param userID 用户ID
	 */
	public void updateUserRecentEntry(Integer userID) {
		dao.updateUserRecentEntry(userID);
	}
	/**
	 * 根据编号获取用户
	 * 
	 * @param userid
	 *            用户编号
	 * @return
	 */
	public User queryUserById(int userid) {
		return dao.queryUserById(userid);
	}
	/**
	 * 
	    * @Title: updateUsersign
	    * @Description: 用户签到
	    * @param @param userid
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateUserSign(int userid) {
		//添加积分流记录表
		Integralrecord Integralrecord=new Integralrecord();
		Integralrecord.setUserid(userid);
		Integralrecord.setIrdate(new Date());
		Integralrecord.setIrdescribe("签到送积分");
		Integralrecord.setAuditstatus(4);
		Integralrecord.setRecordinandout(+20);
	    Gdao.addIntegralRecord(Integralrecord);
		return dao.updateUserSign(userid, 20,0);
	}
	/**
	 * 
	    * @Title: saveUserHabit
	    * @Description: 记录用户习惯
	    * @param @param habit    参数
	    * @return void    返回类型
	    * @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void saveUserHabit(UserHabit habit) {
		dao.saveUserHabit(habit);
	}
	
	/**
	 * 
	    * @Title: queryUserHabit
	    * @Description: 根据用户习惯，返回猜你喜欢（主要参考 阅读了什么 与 主要阅读的服务价格）
	    * @param @param userID
	    * @param @return    参数
	    * @return List<UserHabit>    返回类型
	    * @throws
	 */
	public List<ServicesVO> queryUserHabit(Integer userID) {
		List<UserHabit> habit = new ArrayList<UserHabit>();
		List<ServicesVO> tj = new ArrayList<ServicesVO>();
		
		//是否有用户登陆
		if(userID != null) {
			System.err.println("用户");
			habit = dao.queryUserHabit(userID);
			Object[] randoms;
			for (int i = 0; i < 3; i++) {
				ServiceSelect obj = new ServiceSelect();
				obj.setOrderByPop(2);//人气排序
				int j = i;
				//如果用户未能点击三种以上的服务时
				if(habit.size() == 1) {
					if(j >= 1) {
						j = 0;
					}
				} else if(habit.size() == 2){
					if(j >= 2) {
						j = 1;
					}
				}
				if(habit.size()>0) {
					if(habit.get(j).getStPid() != null) {
						obj.setStidChild(habit.get(j).getStPid());//子类别编号
					}else {
						obj.setStid(habit.get(j).getStid());//类别编号
					}
				}
//				obj.setTransactionValueMax((int)(habit.get(j).getsPrice()*1.3));//最大金额
//				obj.setTransactionValueMin((int)(habit.get(j).getsPrice()*0.7));//最小金额
				List<ServicesVO> zx = Mdao.queryServices(obj);
				randoms = RandomNoReiteration.getRandomInfo(3, zx.size());
				int su = 0;
				if(randoms.length > 1){
					Random random=new Random();
					su = random.nextInt(randoms.length-1);
				}
				tj.add(zx.get((int)randoms[su]));//随机获取该条件中的商品
			}
		}else {
			System.err.println("游客");
			ServiceSelect obj = new ServiceSelect();
			obj.setOrderByPop(2);//人气排序
			List<ServicesVO> zx = Mdao.queryServices(obj);
			Object[] randoms = RandomNoReiteration.getRandomInfo(3, zx.size());
			for (int i = 0; i < 3; i++) {
				tj.add(zx.get((int)randoms[i]));//随机获取该条件中的商品
			}
		}
		return tj;
	}
}
