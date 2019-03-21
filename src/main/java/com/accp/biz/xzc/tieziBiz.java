package com.accp.biz.xzc;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.xzc.ItieziDao;
import com.accp.pojo.Forummanagement;
import com.accp.vo.xzc.postVo;
import com.accp.vo.xzc.postglVo;
import com.accp.vo.xzc.posttsVo;
import com.accp.vo.xzc.recordVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class tieziBiz {
	@Autowired
	private ItieziDao tz;
	public PageInfo<postVo> queryallpost(Integer PageNum,Integer PageSize,String title,String fmname){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<postVo>(tz.queryall(title,fmname));
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int deletechoose(int postid){
		return tz.deletechoose(postid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public List<Forummanagement> queryfmname(){
		return tz.queryfmname();
	}
	public PageInfo<postglVo> queryglpost(Integer PageNum,Integer PageSize){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<postglVo>(tz.queryglall());
	}
	public postglVo queryglpostxq(int fmid){
		return tz.queryglallxq(fmid);
	}
	public PageInfo<posttsVo> querytspost(Integer PageNum,Integer PageSize,String title){
		PageHelper.startPage(PageNum, PageSize);
		return new PageInfo<posttsVo>(tz.queryts(title));
	}
	public PageInfo<recordVo> queryAll(Integer pageNum, Integer pageSize,String userName) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<recordVo>(tz.queryAll(userName));
	}
	
}
