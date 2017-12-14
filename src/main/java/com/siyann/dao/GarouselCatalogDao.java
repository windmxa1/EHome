package com.siyann.dao;

import java.util.List;

import com.siyann.model.GarouselCatalog;

public interface GarouselCatalogDao {
	/**
	 * 获取轮播图目录
	 */
	public List<GarouselCatalog> getCatalog(Integer start, Integer limit);

	/**
	 * 维护轮播图目录
	 */
	public Integer saveOrUpdate(GarouselCatalog gCatalog);
	
	/**
	 * 删除轮播图目录
	 */
	public boolean delete(Integer id);
	
	
}
