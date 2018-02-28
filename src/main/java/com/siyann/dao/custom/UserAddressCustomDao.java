package com.siyann.dao.custom;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserAddressCustomDao {
    void update(Long id, Long userid) throws Exception;
}
