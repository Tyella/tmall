package com.tmall.util;

public class Page {
	int start;       //当前页中的开始序号
	int count;       //每页显示个数 
	int total;       //总个数
	String param;    //参数
	private static final int defaultCount=5;   //默认每页显示5条
	
	public Page() {
		count=defaultCount;
	}
	public Page(int start,int count) {
		super();
		this.start=start;
		this.count=count;
	}
	
	public void setStart(int start) {
		this.start=start;
	}
	public int getStart() {
		return start;
	}
	public void setCount(int count) {
		this.count=count;
	}
	public int getCount() {
		return count;
	}
	public void setTotal(int total) {
		this.total=total;
	}
	public int getTotal() {
		return total;
	}
	public void setParam(String param) {
		this.param=param;
	}
	public String getParam() {
		return param;
	}
	public boolean isHasPrevious() {
		if(start==0)
			return false;
		return true;
	}
	public boolean isHasNext() {
		if(start==getLast())
			return false;
		return true;
	}
	public int getLast() {
		int last;
		if(total%count==0)
			last=total-count;                   //总数为50，每页存5个，最后一页开始为45（下标从0起算）
		else
			last=total=total%count;             //总数为51，每页存5个，最后一页开始为50
		last=last<0?0:last;
		return last;
	}
	public int getTotalPage() {
		int totalPage=0;
		if(total%count==0)
			totalPage=total/count;
		else
			totalPage=total/count+1;
		return totalPage;
		
	}
	public String toString() {
		return "Page[start="+getStart()+"count="+getCount()+"total="+getTotal()+"param="+getParam()+"]";
	}
}
