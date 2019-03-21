package com.accp.biz.xzc;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.xzc.ISjDao;
import com.accp.vo.xzc.appVo;
import com.accp.vo.xzc.userVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)

public class sjBiz {
	@Autowired
	private ISjDao sj;
	
	public PageInfo<userVo> queryAllUser(Integer PageNum,Integer PageSize,int auditstatus,int merchanttype,String username){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<userVo>(sj.queryAllUser(auditstatus,merchanttype,username));
	}
	public userVo queryAllUser(int userid){
		return sj.queryUser(userid);
	}
	/*鉴定审核*/
	public List<appVo> queryAllAppraisalApply(String name,int auditstatus){
		return sj.queryAllAppraisalApply(name,auditstatus);
	}
	public appVo queryAppraisalApply(int userid){
		return sj.queryAppraisalApply(userid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updata(int userid){
		sj.updatash(userid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int updatauser(int userid,int auditstatus){
		return sj.updatauser(userid,auditstatus);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updateAppra( int userid,int auditstatus,String reason) {
		sj.updataAppra(userid, auditstatus, reason);
	}
}
