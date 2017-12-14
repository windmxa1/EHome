package com.siyann.dao;

import java.util.List;

import com.siyann.model.UserAddress;

public interface UserAddressDao {
	/**
	 * 维护用户地址信息
	 */
	public Long saveOrUpdate(UserAddress userAddress);

	/**
	 * 删除用户地址
	 */
	public boolean delete(Long userid, Long id);
	
	/**
	 * 根据Id获取地址
	 */
	public String getAddressById(Long id);
	/**
	 * 查出用户对应的地址信息
	 */
	public List<UserAddress> getList(Long userid);
	/**
	 * 修改默认地址
	 */
	public boolean updateDefault(Long id, Boolean default_);

	public UserAddress getDefaultAddress(Long userid);
}