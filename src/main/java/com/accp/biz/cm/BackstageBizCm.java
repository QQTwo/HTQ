/**
 * 
 * @ClassName:BackstageBizCm
 * @description:TODO
 * @author lenovo
 * @date 2019年3月21日
 * @version V1.0
 */
package com.accp.biz.cm;
/**
* @author 作者
* @version 创建时间：2019年3月21日 上午8:39:55
* 类说明
*/
/**
 * 
 * @ClassName:BackstageBizCm
 * @description:TODO
 * @author lenovo
 * @date 2019年3月21日
 * @version V1.0
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.cm.IBackstageDaoCm;
import com.accp.pojo.Appraisalapply;
import com.accp.pojo.Bond;
import com.accp.pojo.Logistics;
import com.accp.pojo.Post;
import com.accp.pojo.Putforward;
import com.accp.pojo.Refund;
import com.accp.pojo.Services;
import com.accp.pojo.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class BackstageBizCm {
	@Autowired
	private IBackstageDaoCm dao;
	public List<Services> queryAllServices(){
		return dao.queryAllServices();
	}
	public List<Appraisalapply> queryAllAppraisalApply(){
		return dao.queryAllAppraisalApply();
	}
	public List<User> queryAllUser(){
		return dao.queryAllUser();
	}
	public List<Putforward> queryAllPut(){
		return dao.queryAllPut();
	}
	
	public List<Bond> queryAllBond(){
		return dao.queryAllBond();
	}
	public List<Post> queryAllPost(){
		return dao.queryAllPost();
	}
	public List<Refund> queryAllRefund(){
		return dao.queryAllRefund();
	}
}
