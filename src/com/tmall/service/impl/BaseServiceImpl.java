package com.tmall.service.impl;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall.dao.impl.DAOImpl;
import com.tmall.pojo.Category;
import com.tmall.service.BaseService;
import com.tmall.util.Page;

@Service
public class BaseServiceImpl implements BaseService{
	@Autowired
	DAOImpl dao;
	protected Class clazz;
	
	//利用了反射和异常
	//那个类BaseServiceImpl，clazz就指向哪个类对象
	//比如categoryServiceImpl继承了BaseServiceImpl,clazz就指向Category.class
	public BaseServiceImpl() {
		try {
			throw new Exception();           //故意抛出一个异常，然后捕捉它，利用反射机制
		}
		catch(Exception e) {
			StackTraceElement stes[]=e.getStackTrace();
			String serviceImplClassName=stes[1].getClassName();
			try {
				Class serviceImplClazz=Class.forName(serviceImplClassName);
				String serviceImplClassSimpleName=serviceImplClazz.getSimpleName();
				String pojoSimpleName=serviceImplClassSimpleName.replaceAll("ServiceImpl","");
				String pojoPackageName=serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
				String pojoFullName=pojoPackageName+"."+pojoSimpleName;
				clazz=Class.forName(pojoFullName);
			}catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public List list() {
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}
	@Override
	public int total() {
		String hql="select count(*) from"+clazz.getName();
		List<Long> l=dao.find(hql);
		if(l.isEmpty())
			return 0;
		Long result=l.get(0);
		return result.intValue();
	}
	@Override
	public List<Object> listByPage(Page page){
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc, page.getStart(), page.getCount());
	}
	@Override
	public void save(Object object) {
		dao.save(object);
	}
	@Override
	public void delete(Object object) {
		dao.delete(object);
	}
	@Override
	public Object get(Class clazz,int id) {
		return dao.get(clazz, id);
	}
	@Override
	public Object get(int id) {
		return get(clazz,id);
	}
	@Override
	public void update(Object object) {
		dao.update(object);
	}
	
	/*
	 * 查询父类下的所有子类对象
	 * 以分类和属性为例，就是查询某个分类下的所有属性
	 */
	@Override
	public List listByParent(Object parent) {
		String parentName=parent.getClass().getSimpleName();       //借助反射获取父类的类型名称
		String parentNameWithFirstLetterLower=StringUtils.uncapitalize(parentName);
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}
	
	/*
	 * 以分页的方式查询父类下的子类对象集合
	 * 以分类和属性为例，就是查询某个分类下的前5个属性，或第5到10个属性
	 */
	@Override
	public List list(Page page,Object parent) {
		String parentName=parent.getClass().getSimpleName();     //借助反射获取父类的类型名称
		String parentNameWithFirstLetterLower=StringUtils.uncapitalize(parentName);
		DetachedCriteria dc=DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc, page.getStart(), page.getCount());
	}
	
	/*
	 * 根据父类查询子类对象数量
	 */
	@Override
	public int total(Object parentObject) {
		String parentName=parentObject.getClass().getSimpleName();
		String parentNameWithFirstLetterLower=StringUtils.uncapitalize(parentName);
		
		String sqlFormat="select count(*) from %s bean where bean.%s=?";
		String hql=String.format(sqlFormat, clazz.getName());
		
		List<Long> l=dao.find(hql, parentObject);
		if(l.isEmpty())
			return 0;
		Long result=l.get(0);
		return result.intValue();
	}

}
