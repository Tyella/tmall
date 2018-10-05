package com.tmall.action;
import java.util.List;
import com.tmall.pojo.Category;
import com.tmall.pojo.Property;
import com.tmall.pojo.Product;
import com.tmall.pojo.ProductImage;
import com.tmall.pojo.PropertyValue;
import com.tmall.pojo.User;
import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;
/**
 * ActionPojo用于提供实体对象和实体对象集合的getter和setter方法
 * setter用于接受注入
 * getter用于向view(jsp)提供数据
 * @author Tyella
 */
public class ActionPojo extends ActionPagination{
	protected Category category;
	protected Property property;
	protected Product product;
	protected ProductImage productImage;
	protected PropertyValue propertyValue;
	protected User user;
	protected Order order;
	protected OrderItem orderItem;
	
	protected List<Category> categorys;
	protected List<Property> propertys;
	protected List<Product> products;
	protected List<ProductImage> productSingleImages;          //单个图片的集合
	protected List<ProductImage> productDetailImages;          //详细图片的集合
	protected List<PropertyValue> propertyValues;
	protected List<User> users;
	protected List<Order> orders;
	protected List<OrderItem> orderItems;
	
	public void setCategory(Category category) {
		this.category=category;
	}
	public Category getCategory() {
		return category;
	}
	public void setProperty(Property property) {
		this.property=property;
	}
	public Property getProperty() {
		return property;
	}
	public void setProduct(Product product) {
		this.product=product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProductImage(ProductImage productImage) {
		this.productImage=productImage;
	}
	public ProductImage getProductImage() {
		return productImage;
	}
	public void setPropertyValue(PropertyValue propertyValue) {
		this.propertyValue=propertyValue;
	}
	public PropertyValue getPropertyValue() {
		return propertyValue;
	}
	public void setUser(User user) {
		this.user=user;
	}
	public User getUser() {
		return user;
	}
	public void setOrder(Order order) {
		this.order=order;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem=orderItem;
	}
	
	
	public void setCategorys(List<Category> categorys) {
		this.categorys=categorys;
	}
	public List<Category> getCategorys(){
		return categorys;
	}
	public void setPropertys(List<Property> propertys) {
		this.propertys=propertys;
	}
	public List<Property> getPropertys(){
		return propertys;
	}
	public void setProducts(List<Product> products) {
		this.products=products;
	}
	public List<Product> getProducts(){
		return products;
	}
	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages=productSingleImages;
	}
	public List<ProductImage> getProductSingleImages(){
		return productSingleImages;
	}
	public void setProductDetailImages(List<ProductImage> productDetailImages) {
		this.productDetailImages=productDetailImages;
	}
	public List<ProductImage> getProductDetailImages(){
		return productDetailImages;
	}
	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues=propertyValues;
	}
	public List<PropertyValue> getPropertyValues(){
		return propertyValues;
	}
	public void setUsers(List<User> users) {
		this.users=users;
	}
	public List<User> getUsers(){
		return users;
	}
	public void setOrders(List<Order> orders) {
		this.orders=orders;
	}
	public List<Order> getOrders(){
		return orders;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems=orderItems;
	}
	public List<OrderItem> getOrderItems(){
		return orderItems;
	}
	
	
}
