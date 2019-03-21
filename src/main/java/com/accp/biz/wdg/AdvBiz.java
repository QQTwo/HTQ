package com.accp.biz.wdg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.wdg.AdvDao;
import com.accp.dao.ylh.GoldnotesDao;
import com.accp.pojo.Advertisement;
import com.accp.pojo.Advertisementtype;
import com.accp.pojo.Goldnotes;
import com.accp.vo.wdg.AdvertisementVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AdvBiz {
		@Autowired
		private AdvDao dao;
		@Autowired
		private GoldnotesDao gdao;
		public List<Advertisementtype> queryAllAdv(){
			return dao.queryAllAdv();
		}
		
		public List<AdvertisementVo> queryAllAdvVo(Integer atid){
			return dao.queryAllAdvVo(atid);
		}
		public boolean addAdv(Advertisement a) {
			return dao.addAdv(a)>0;
		}
		public boolean moAdv(Advertisement a) {
			return dao.updateAdv(a)>0;
		}
		public Advertisement queryObjAdv(Integer aid) {
			return dao.queryObjAdv(aid);
		}
		public boolean removeAdv(String[] ids) {
			return dao.deleteAdv(ids)>0;
		}
		public int addGold(Goldnotes goldnotes) {
			return gdao.addGoldnotes(goldnotes);
		}
}
