package com.siyann.dao;

import com.siyann.model.AppVersion;

public interface VersionDao {
	/**
	 * 获取最新的版本号
	 */
	public AppVersion getLastVersion();	
}
