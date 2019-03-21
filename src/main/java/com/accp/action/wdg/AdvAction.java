package com.accp.action.wdg;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.wdg.AdvBiz;
import com.accp.pojo.Advertisement;
import com.accp.pojo.Advertisementtype;
import com.accp.pojo.Goldnotes;
import com.accp.util.Base64ConvertImageUtil;
import com.accp.vo.wdg.AdvertisementVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("wdg")
public class AdvAction {
	@Autowired
	private AdvBiz biz;
	
	// 查询所有广告
	@GetMapping("advs/{atid}")
	public List<AdvertisementVo> queryAllAdvVo(@PathVariable Integer atid){
		return biz.queryAllAdvVo(atid);
	}
	
	//删除广告
	@DeleteMapping("adv/{ids}")
	public boolean removeAdv(@PathVariable  String ids) {
		String [] temp = {ids};
		return biz.removeAdv(temp);
	}
	//新增广告
	@PostMapping("adv")
	public boolean addAdv(@RequestBody Advertisement adv,HttpSession session) {
		String hName = "."+adv.getAimgpath().substring(adv.getAimgpath().indexOf("/")+1, adv.getAimgpath().indexOf(";"));
		//重命名文件
		String name = UUID.randomUUID().toString().replaceAll("-", "")+hName;
		String base64 = adv.getAimgpath().substring(adv.getAimgpath().indexOf(";")+8);
		String path = "d:/hantingImg"+File.separator+ name;
		//保存图片至服务器
		Base64ConvertImageUtil.generateImageFromBase64(base64,path);
		
		adv.setAimgpath("/"+name);
		 
		Goldnotes g = new Goldnotes();
		g.setAcquisitionmode(6);
		g.setRecorddate(new Date());
		g.setRecorddescribe("站外广告收费");
		g.setRecordinandout(adv.getPrice());
		g.setAuditstatus(4);
		biz.addGold(g);
		return biz.addAdv(adv);
	}
	//查询所有广告分类
	@GetMapping("adv/types")
	public List<Advertisementtype> queryAllType(){
		return biz.queryAllAdv();
	}
	//加载单个广告
	@GetMapping("adv/{aid}")
	public Advertisement  queryObjAdv(@PathVariable Integer aid) {
		return biz.queryObjAdv(aid);
	}
	@PutMapping("adv/xufei")
	public boolean moAdv(@RequestBody Advertisement adv) {
		String str = adv.getAappurl();
		float price =Float.parseFloat(str.substring(str.indexOf("↓")+1));
		adv.setAappurl(str.substring(0, str.indexOf("↓")));
		Goldnotes g = new Goldnotes();
		g.setAcquisitionmode(6);
		g.setRecorddate(new Date());
		g.setRecorddescribe("站外广告收费");
		g.setRecordinandout(price);
		g.setAuditstatus(4);
		biz.addGold(g);
		return biz.moAdv(adv);
	}
}
