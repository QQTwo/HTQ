package com.accp.action.xzc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.xzc.sjBiz;
import com.accp.vo.xzc.appVo;
import com.accp.vo.xzc.userVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/sj")
public class sjAction {
	@Autowired
	private sjBiz sj;
	
	@RequestMapping(value="/users/{num}/{size}/{auditstatus}/{merchanttype}/{username}",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<userVo> getuser(@PathVariable Integer num,@PathVariable Integer size,@PathVariable Integer auditstatus,@PathVariable Integer merchanttype,@PathVariable String username) {
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if(username==null||username.equals("@*")) {
			username=null;
		}
		if(auditstatus==null ||auditstatus==0) {
			auditstatus=0;
		}
		if(merchanttype==null ||merchanttype==0) {
			merchanttype=0;
		}
		
		System.out.println(auditstatus+"/"+merchanttype+"/"+username);
		PageInfo<userVo> pageinfo=sj.queryAllUser(num, size, auditstatus, merchanttype, username);
		return pageinfo;
	}
	@RequestMapping(value="/users/{userid}",method=RequestMethod.GET)
	public userVo getuser(@PathVariable int userid) {
		return sj.queryAllUser(userid);
	}
	@RequestMapping(value="/updatauser/{userid}/{auditstatus}",method=RequestMethod.GET)
	@ResponseBody
	public int updatauser(@PathVariable int userid,@PathVariable int auditstatus) {
		System.out.println(auditstatus);
		System.out.println(userid);
		if(auditstatus==0) {
			auditstatus=1;
		}
		return sj.updatauser(userid,auditstatus);
	}
	/*@RequestMapping(value="/updatausersc/{userid}/{auditstatus}",method=RequestMethod.GET)
	@ResponseBody
	public String updatausersc(@PathVariable int userid,@PathVariable int auditstatus) {
		sj.updateAppra(av);
		if(a==1) {
		return 1;
		}else {
			return 0;
		}
	}*/
	//鉴定申请
	@GetMapping("jianding")
	public Map<String,String> jianding(int userid,int auditstatus,String reason){
		System.out.println("xx"+userid);
		Map<String,String> message=new HashMap<String,String>();
		if(reason==""||reason=="@*") {
			reason="无";
		}
		
		sj.updateAppra(userid, auditstatus, reason);
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	@RequestMapping(value="/jd/{num}/{size}/{auditstatus}/{name}",method=RequestMethod.GET)
	public PageInfo<appVo> ajaxAla(@PathVariable Integer num,@PathVariable Integer size ,@PathVariable Integer auditstatus,@PathVariable String name) {
		
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=10;
		}
		if(auditstatus==null ||auditstatus==0) {
			auditstatus=0;
		}
		if(name==null ||name=="") {
			name=null;
		}
		PageHelper.startPage(num, size);
		
		return new PageInfo<appVo>(sj.queryAllAppraisalApply(name,auditstatus));
	}
	@RequestMapping(value="/jd/{userid}",method=RequestMethod.GET)
	public int updatash(@PathVariable Integer userid) {
		sj.updata(userid);
		return 1;
	}
	@RequestMapping(value="/jdc/{userid}",method=RequestMethod.GET)
	public appVo queryAppraisalApply(@PathVariable Integer userid) {
		return sj.queryAppraisalApply(userid);
	}
	
}
