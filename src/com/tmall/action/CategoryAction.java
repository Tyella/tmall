package com.tmall.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.tmall.pojo.Category;
import com.tmall.util.ImageUtil;

public class CategoryAction extends ActionResult{       //CategoryAction专注于充当控制器
	@Action("admin_category_list")
	public String list() {
		categorys=categoryService.list();
		System.out.println(categorys);
		return "listCategory";
	}
	@Action("admin_category_add")
	public String add() {
		categoryService.save(category);
		File imageFolder=new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		File file=new File(imageFolder,category.getId()+".jpg");
		try {
			FileUtils.copyFile(img,file);
			BufferedImage img=ImageUtil.change2jpg(file);
			ImageIO.write(img, "jpg", file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "listCategoryPage";
	}
	@Action("admin_category_delete")
	public String delete(Category category) {
		categoryService.delete(category);
		return "listCategoryPage";
	}
	@Action("admin_category_edit")
	public String edit() {
		 int id=category.getId();
	    category=(Category)categoryService.get(id);
	    return "editCategory";
	}
	public String update() {
		categoryService.update(category);
		if(img!=null) {
			File imageFolder=new File(ServletActionContext.getServletContext().getRealPath("img/category"));
			File file=new File(imageFolder,category.getId()+".jpg");
			try {
				FileUtils.copyFile(img,file);
				BufferedImage img=ImageUtil.change2jpg(file);
				ImageIO.write(img, "jpg", file);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		return "listCategoryPage";
	}
}
