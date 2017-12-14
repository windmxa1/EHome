package com.siyann.dao;

import com.siyann.model.ScrollNews;

public interface ScrollNewsDao {
	/**
	 * 获取最新消息
	 */
	public ScrollNews getLastNews();
}
