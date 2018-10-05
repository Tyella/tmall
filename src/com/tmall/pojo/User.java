package com.tmall.pojo;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public String getAnonymousName() {        //获得用户的匿名名称，在评价时显示用户名用
		if(name==null)
			return null;
		if(name.length()==1)
			return "*";
		if(name.length()==2)
			return name.substring(0, 1)+"*";
		char[] cs=name.toCharArray();
		for(int i=1;i<cs.length;i++)
			cs[i]='*';
		return new String(cs);
	}
}
