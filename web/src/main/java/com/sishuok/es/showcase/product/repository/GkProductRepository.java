/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.es.showcase.product.repository;

import java.util.List;

import com.sishuok.es.common.repository.BaseRepository;
import com.sishuok.es.showcase.product.entity.GkProduct;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface GkProductRepository extends BaseRepository<GkProduct, Long> {
	GkProduct findByCategoryId(Long categoryId);
	List<GkProduct> findAllByName(String name);
}


