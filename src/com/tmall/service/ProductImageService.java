package com.tmall.service;

import java.util.List;
import com.tmall.pojo.Product;
import com.tmall.pojo.ProductImage;

public interface ProductImageService extends BaseService {
	/*
	 * 两常量表示图片类型
	 */
	public static final String type_single="type_single";
	public static final String type_detail="type_detail";
	/*
	 * 查询某个产品下的，某种类型的图片
	 */
	public List<ProductImage> list(String key_product,Product product,String key_type,String type);
	/*
	 * 查询某个产品下类型是type_single的图片集合
	 * 如果集合不为空，取出第一张图片，作为这个产品的图片
	 */
	public void setFirstProductImage(Product product);

}
