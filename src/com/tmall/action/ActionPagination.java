package com.tmall.action;
import com.tmall.util.Page;

/**
 * ActionPagination用于处理分页，并且继承了ActionUpload，
 * 这样既可以处理分页，有可以上传图片
 * @author Tyella
 */
public class ActionPagination extends ActionUpload{   
	protected Page page;
	
	public void setPage(Page page) {
		this.page=page;
	}
	public Page getPage() {
		return page;
	}
}
