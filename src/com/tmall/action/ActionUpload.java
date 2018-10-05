package com.tmall.action;
import java.io.File;

public class ActionUpload {           //ActionUpload用于处理图片上传
	protected File img;
	protected String imgFileName;
	protected String imgContentType;
	
	public void setImg(File img) {
		this.img=img;
	}
	public File getImg() {
		return img;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName=imgFileName;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType=imgContentType;
	}
	public String getImgContentType() {
		return imgContentType;
	}

}
