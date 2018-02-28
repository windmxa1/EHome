package com.siyann.dao;

import com.siyann.entity.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppVersionDao extends JpaRepository<AppVersion, Integer> {
    public AppVersion findFirstByOrderByIdDesc() throws Exception;
}
