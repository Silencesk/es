/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.es.showcase.product.service;

import com.sishuok.es.common.repository.RepositoryHelper;
import com.sishuok.es.common.service.BaseService;
import com.sishuok.es.showcase.product.entity.GkProduct;
import com.sishuok.es.showcase.product.repository.GkProductRepository;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>User: geke
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class GkProductService extends BaseService<GkProduct, Long> {
	 private GkProductRepository getGkProductRepository() {
	        return (GkProductRepository) baseRepository;
	 }
	
	public GkProduct findByCategoryId(Long categoryId){
		return getGkProductRepository().findByCategoryId(categoryId);
	}
	
	public int deleteByParams(String name){
		RepositoryHelper rh = new RepositoryHelper(GkProduct.class);
		String ql = "delete from GkProduct where name=?1";
		return rh.batchUpdate(ql, name);
	}
	
	public List<GkProduct> findAllByName(String name){
		return getGkProductRepository().findAllByName(name);
	}
}
