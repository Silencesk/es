package com.sishuok.es.bussiness;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sishuok.es.test.BaseIT;
import com.sishuok.es.showcase.product.entity.Category;
import com.sishuok.es.showcase.product.entity.Product;
import com.sishuok.es.showcase.product.service.CategoryService;
import com.sishuok.es.showcase.product.service.ProductService;

public class ProductionServiceIT extends BaseIT {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@Test
	public void testSave(){
		Product p =  new Product();
		Category c = new Category();
		c.setName("综艺");
		c.setShow(true);
		c.setWeight(200);
		categoryService.save(c);
		p.setCategory(c);
		p.setBeginDate(new Date());
		p.setEndDate(DateUtils.addDays(new Date(), 3));
		p.setName("天天向上");
		p.setNumber(new Long(1));
		p.setPrice(new Long(800));
		p.setShow(true);
		
		productService.save(p);
		
		//clear();	//@remark: 若不clear，又会怎样-不清除，则会因缓存机制，便不会从数据库重新查询
		productService.findOne(p.getId());
		
		productService.findByCategoryId(c.getId());
	}
}
