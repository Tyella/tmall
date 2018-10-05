package com.tmall.service;
import java.util.List;
import com.tmall.util.Page;

public interface BaseService {
	public void save(Object object);
	public void delete(Object object);
	public void update(Object object);
	public Object get(Class clazz,int id);
	public Object get(int id);
	public List list();                    //查询
	public List listByPage(Page page);     //分页查询
	public int total();
	
	/*
	 * 根据父类查询所有子类对象，比如查询某个分类下的所有属性
	 */
	public List listByParent(Object parent);          
	/*
	 * 根据父类分页查询子类对象，比如查询某个分类下的前5个属性
	 */
	public List list(Page page,Object object);      
	/*
	 * 根据父类查询子类对象数量，比如查询分类下属性数量
	 */
	public int total(Object parentObject);              
}
