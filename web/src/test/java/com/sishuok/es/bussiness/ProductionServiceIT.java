package com.sishuok.es.bussiness;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sishuok.es.test.BaseIT;
import com.sishuok.es.common.entity.search.SearchOperator;
import com.sishuok.es.common.entity.search.Searchable;
import com.sishuok.es.common.repository.RepositoryHelper;
import com.sishuok.es.showcase.product.entity.Category;
import com.sishuok.es.showcase.product.entity.GkProduct;
import com.sishuok.es.showcase.product.entity.Product;
import com.sishuok.es.showcase.product.service.CategoryService;
import com.sishuok.es.showcase.product.service.GkProductService;
import com.sishuok.es.showcase.product.service.ProductService;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class ProductionServiceIT extends BaseIT {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	GkProductService gkProductService;
	@PersistenceContext
	EntityManager em;
	RepositoryHelper repository;
	
	
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
	
	@Test
	public void testGkProductionSave(){
		GkProduct p =  new GkProduct();
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
		
		gkProductService.save(p);
		//em.flush();
		clear();	//@remark: 若不clear，又会怎样-不清除，则会因缓存机制，便不会从数据库重新查询
		gkProductService.findOne(p.getId());
		
		//gkProductService.findByCategoryId(c.getId());
	}
	
	@Test
	public void testDelete(){
		String name = "天天向上";
		List<GkProduct> plst = gkProductService.findAllByName(name);
		Assert.assertEquals(4, plst.size());
		
		gkProductService.deleteByParams(name);
	}
	
	@Test
	public void testFind(){
		Searchable searchable = Searchable.newSearchable().addSearchFilter("category.name", SearchOperator.eq, "1");
		productService.findAllWithSort(searchable);
		
	}
}
