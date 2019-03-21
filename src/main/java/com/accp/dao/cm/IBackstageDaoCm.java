/**
 * 
 * @ClassName:IBackstageDaoCm
 * @description:TODO
 * @author lenovo
 * @date 2019年3月21日
 * @version V1.0
 */
package com.accp.dao.cm;

import java.util.List;

import com.accp.pojo.Appraisalapply;
import com.accp.pojo.Bond;
import com.accp.pojo.Logistics;
import com.accp.pojo.Post;
import com.accp.pojo.Putforward;
import com.accp.pojo.Refund;
import com.accp.pojo.Services;
import com.accp.pojo.User;

/**
* @author 作者
* @version 创建时间：2019年3月21日 上午8:36:07
* 类说明
*/
/**
 * 
 * @ClassName:IBackstageDaoCm
 * @description:TODO
 * @author lenovo
 * @date 2019年3月21日
 * @version V1.0
 */
public interface IBackstageDaoCm {
	// 后台处理获取为审核条数
	/**
	 * 服务审核
	 * 
	 * @return
	 */
	public List<Services> queryAllServices();

	/**
	 * 申请鉴定
	 * 
	 * @return
	 */
	public List<Appraisalapply> queryAllAppraisalApply();

	/**
	 * 商家入驻
	 * 
	 * @return
	 */
	public List<User> queryAllUser();

	/**
	 * 提现
	 * 
	 * @return
	 */
	public List<Putforward> queryAllPut();

	

	/**
	 * 保证金
	 * 
	 * @return
	 */
	public List<Bond> queryAllBond();

	/**
	 * 帖子鉴定
	 * 
	 * @return
	 */
	public List<Post> queryAllPost();

	/**
	 * 申请管理员介入
	 * 
	 * @return
	 */
	public List<Refund> queryAllRefund();
}
