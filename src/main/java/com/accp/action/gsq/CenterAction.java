package com.accp.action.gsq;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.biz.gsq.OrderBiz;
import com.accp.pojo.User;
import com.accp.vo.gsq.Orders;

@Controller
@RequestMapping("/c/gsq")
public class CenterAction {
	@Autowired
	private OrderBiz orderBiz;

	/**
	 * 个人中心主页
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/center/home")
	public String centerHome(Model model, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		Orders order = new Orders();
		order.setUserid(user.getUserid());
		model.addAttribute("list", orderBiz.queryOrderList(order, 1, 10).getList());
		model.addAttribute("orderInfo", orderBiz.queryOrderInfo(user.getUserid()));
		model.addAttribute("user", user);
		return "grzx-index";
	}
	/**
	 * 积分抽奖
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/center/Luck")
	public String centerLuck(Model model, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		model.addAttribute("user", user);
		return "gsq-Luck";
	}
}