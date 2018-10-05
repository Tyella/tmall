package com.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.DetachedCriteria;

import org.springframework.stereotype.Service;
import com.tmall.pojo.Product;
import com.tmall.pojo.ProductImage;
import com.tmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl implements ProductImageService{
	/*
	 * 查询某个产品下的，某种类型的图片
	 */
	@Override
	public List<ProductImage> list(String key_product,Product product,String key_type,String type){
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(key_product, product));
		dc.add(Restrictions.eq(key_type, type));
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}
	/*
	 * 取出某个产品下类型是type_single的产品图片集合
	 * 如果集合不为空，取出第一张图片，作为这个产品的图片
	 */
	@Override
	public void setFirstProductImage(Product product) {
		if(product.getProductImage()==null)
			return ;
		List<ProductImage> pil=list("product",product,"type",ProductImageService.type_single);
		if(!pil.isEmpty())
			product.setProductImage(pil.get(0));
	}
}
