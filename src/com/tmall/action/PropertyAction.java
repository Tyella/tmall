package com.tmall.action;
import org.apache.struts2.convention.annotation.Action;
import com.tmall.util.Page;
import com.tmall.pojo.Category;
import com.tmall.pojo.Property;

public class PropertyAction extends ActionResult{
	@Action("admin_property_list")
	public String list() {
		if(page==null)
			page=new Page();
		int total=propertyService.total(category);
		page.setTotal(total);
		page.setParam("&category.id="+category.getId());
		propertys=propertyService.list(page, category);           //根据分页对象和分类对象获取属性集合
		int id=category.getId();
		category=(Category)categoryService.get(id);
		return "listProperty";
	}
	
	@Action("admin_property_add")
	public String add() {
		propertyService.save(property);                      //通过propertyService将property对象插入到数据库
		return "listPropertyPage";
	}
	
	@Action("admin_property_delete")
	public String delete() {
		int id=property.getId();
		property=(Property)propertyService.get(id);
		propertyService.delete(property);
		return "listPropertyPage";
	}
	
	@Action("admin_property_edit")
	public String edit() {
		/*
		 * 让property引用从指向瞬时对象，改为指向持久化对象
		 * 瞬时对象是由struts注入进来的，只有id，没有name
		 * 持久化对象就和数据库中的同步了，不仅有id，还有name
		 */
		int id=property.getId();
		property=(Property)propertyService.get(id);
		return "editProperty";
	}
	
	@Action("admin_property_update")
	public String update() {
		propertyService.update(property);
		return "listPropertyPage";
	}

}
