package com.tmall.action;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmall.service.CategoryService;
import com.tmall.service.PropertyService;
import com.tmall.service.ProductService;
import com.tmall.service.ProductImageService;
import com.tmall.service.PropertyValueService;
import com.tmall.service.UserService;
import com.tmall.service.OrderItemService;
import com.tmall.service.OrderService;
/**
 * ActionService提供服务的注入
 * @author Tyella
 */
public class ActionService extends ActionPojo{
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected PropertyService propertyService;
	@Autowired
	protected ProductService productService;
	@Autowired
	protected ProductImageService productImageService;
	@Autowired
	protected PropertyValueService propertyValueService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected OrderService orderService;
	@Autowired
	protected OrderItemService orderItemService;
}
