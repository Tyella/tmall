package com.tmall.action;
import org.apache.struts2.convention.annotation.Action;

import com.tmall.pojo.Product;
import com.tmall.pojo.PropertyValue;
public class PropertyValueAction extends ActionResult{
	@Action("admin_propertyValue")
	public String edit() {
		int id=product.getId();
		product=(Product)productService.get(id);
		propertyValueService.init(product);
		propertyValues=propertyValueService.listByParent(product);
		return "editPropertyValue";
	}
	@Action("admin_propertyValue_update")
	public String update() {
		String value=propertyValue.getVaule();
		int id=propertyValue.getId();
		propertyValue=(PropertyValue)propertyValueService.get(id);
		propertyValue.setVaule(value);
		propertyValueService.update(propertyValue);
		return "updatePropertyValue";
		
	}

}
