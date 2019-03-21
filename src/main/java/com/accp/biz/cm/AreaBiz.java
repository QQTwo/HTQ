/**
 * 
 * @ClassName:AreaBiz
 * @description:TODO
 * @author lenovo
 * @date 2019年3月15日
 * @version V1.0
 */
package com.accp.biz.cm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.cm.IAreaDao;
import com.accp.pojo.Sharea;

/**
* @author 作者
* @version 创建时间：2019年3月15日 上午10:04:13
* 类说明
*/
/**
 * 
 * @ClassName:AreaBiz
 * @description:TODO
 * @author lenovo
 * @date 2019年3月15日
 * @version V1.0
 */
@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class AreaBiz {
	@Autowired
	private IAreaDao dao;
	//按父类编号查询地区
	public List<Sharea> queryAllArea(Integer pid){
		return dao.queryAllArea(pid);
	}
	
	
}
