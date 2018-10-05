package com.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall.pojo.Product;
import com.tmall.pojo.Property;
import com.tmall.pojo.PropertyValue;
import com.tmall.service.PropertyService;
import com.tmall.service.PropertyValueService;

@Service
public class PropertyValueServiceImpl extends BaseServiceImpl implements PropertyValueService{
	@Autowired
	PropertyService propertyService;
	/*
	 * 初始化PropertyValue
	 */
	@Override
	public void init(Product product) {
		/*
		 * 首先根据产品获得分类，然后获得这个分类下的所有属性集合
		 */
		List<Property> propertys=propertyService.listByParent(product.getCategory());
		/*
		 * 用属性和产品进行查询
		 */
		for(Property property:propertys) {
			PropertyValue propertyValue=get(property,product);
			//属性值不存在，就创建一个属性值，并设置产品和属性，接着将它插入数据库中
			if(propertyValue==null) {
				propertyValue=new PropertyValue();
				propertyValue.setProduct(product);
				propertyValue.setProperty(property);
				dao.save(propertyValue);
			}
		}
	}
	
	private PropertyValue get(Property property,Product product) {
		List<PropertyValue> result=list("product",product,"property",property);
		if(result.isEmpty())
			return null;
		return result.get(0);
	}

	public List<PropertyValue> list(String key_product,Product product,String key_property,Property property){
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(key_product, product));
		dc.add(Restrictions.eq(key_property, property));
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}

}
