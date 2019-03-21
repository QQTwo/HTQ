package com.accp.dao.wdg;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Advertisement;
import com.accp.pojo.Advertisementtype;
import com.accp.vo.wdg.AdvertisementVo;

public interface AdvDao {
	//广告位管理
			/**
			 * 获取所有广告位分类
			 * @return
			 */
			public List<Advertisementtype> queryAllAdv();
			
			/**
			 * 获取所有广告位
			 * @return
			 */
			public List<AdvertisementVo> queryAllAdvVo(@Param("atid") Integer atid);
			
			/**
			 * 修改广告位
			 * @param a
			 * @return
			 */
			public int updateAdv(@Param("a")Advertisement a);
			
			/**
			 * 新增广告位
			 * @param a
			 * @return
			 */
			public int addAdv(@Param("a")Advertisement a);
			
			/**
			 * 得到某一个列
			 * @param atid
			 * @return
			 */
			public Advertisement queryObjAdv(@Param("aid") Integer atid);
			
			/**
			 * 广告批量删除
			 * @param ids
			 * @return
			 */
			public int deleteAdv(String[] ids);
			/**
			 * 根据ID加载广告信息
			 * @return
			 */
			public Advertisement findByaid(@Param("aid") Integer aid);
}
