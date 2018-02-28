package com.siyann.dao;

import com.siyann.entity.GoodsCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsCatalogDao extends JpaRepository<GoodsCatalog, Long> {
    @Query("select gc.id from GoodsCatalog gc where gc.type = ?1")
    List<Long> getCatalogIdByType(Integer type) throws Exception;

    List<GoodsCatalog> findAllByType(Integer type) throws Exception;

    GoodsCatalog findOneByCatalog(String catalog);

    @Modifying
    @Query("update GoodsCatalog gc set gc.catalog=?2, gc.url=?3,gc.description = ?4,gc.type=?5 where gc.id = ?1")
    int update(long id, String catalog, String url, String description, Integer type);
}
