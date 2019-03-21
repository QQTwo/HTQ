/**
 * 
 * @ClassName:IAreaDao
 * @description:TODO
 * @author lenovo
 * @date 2019年3月15日
 * @version V1.0
 */
package com.accp.dao.cm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Sharea;

/**
* @author 作者
* @version 创建时间：2019年3月15日 上午10:02:01
* 类说明
*/
/**
 * 
 * @ClassName:IAreaDao
 * @description:TODO
 * @author lenovo
 * @date 2019年3月15日
 * @version V1.0
 */
public interface IAreaDao {
			//国家地区管理
			/**
			 * 按父类编号查询地区
			 * @param pid
			 * @return
			 */
			public List<Sharea> queryAllArea(Integer pid);
			
			
			
}
