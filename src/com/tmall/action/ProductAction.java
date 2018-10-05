package com.tmall.action;

import org.apache.struts2.convention.annotation.Action;
import com.tmall.pojo.Product;
import com.tmall.pojo.Category;
import com.tmall.util.Page;
import java.util.Date;

public class ProductAction extends ActionResult{
	@Action("admin_product_list")
	public String list() {
		if(page==null)
			page=new Page();
		int total=productService.total(category);
		page.setTotal(total);
		page.setParam("&category.id="+category.getId());
		products=productService.list(page, product);
		/*
		 * 让category引用从指向瞬时对象，变为指向持久对象
		 */
		int id=category.getId();
		category=(Category)categoryService.get(id);
		/*
		 * 为每个产品设置缩略图
		 */
		for (Product product : products) {
			productImageService.setFirstProductImage(product);
		}
		return "listProduct";
	}
	
	@Action("admin_product_add")
	public String add() {
		product.setCreateDate(new Date());      //为产品设置创建时间
		productService.save(product);           //通过productService将product对象插入到数据库
		return "listProductPage";
	}
	
	@Action("admin_product_delete")
	public String delete() {
		int id=product.getId();
		product=(Product)productService.get(id);
		productService.delete(product);
		return "listProductPage";
	}
	
	@Action("admin_product_edit")
	public String edit() {
		int id=product.getId();
		product=(Product)productService.get(id);
		return "listProductPage";
	}
	
	@Action("admin_product_update")
	public String update() {
		/*
		 * 首先根据浏览器传过来的id，把对象从数据库里查询出来
		 */
		Product productFromDB=(Product)productService.get(product.getId());
		//设置创建日期
		product.setCreateDate(productFromDB.getCreateDate());
		//通过productService更新product对象
		productService.update(product);
		return "listProductPage";
	}

}
