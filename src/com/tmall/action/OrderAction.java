package com.tmall.action;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import com.tmall.pojo.Order;
import com.tmall.service.OrderService;
import com.tmall.util.Page;

public class OrderAction extends ActionResult {

	@Action("admin_order_list")
	public String list() {
		if (page == null)
			page = new Page();
		int total = orderService.total();
		page.setTotal(total);
		orders = orderService.listByPage(page);
		orderItemService.fill(orders);
		return "listOrder";
	}

	@Action("admin_order_delivery")
	public String delivery() {
		int id=order.getId();
		order=(Order)orderService.get(id);
		order.setDeliveryDate(new Date());
		order.setStatus(OrderService.waitConfirm);
		orderService.update(order);
		return "listOrderPage";
	}

}