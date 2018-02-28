package com.siyann.dao;

import com.siyann.entity.Goods;
import com.siyann.entity.GoodsCatalog;
import com.siyann.view.VGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao extends JpaRepository<Goods, Long> {
    @Query("select v from VGoods v where v.state in :state and v.type=:type")
    Page<VGoods> getAllByStateAndType(Integer[] state, Integer type, Pageable pageable) throws Exception;

    @Query("select v from VGoods v where v.state in :state and v.type=:type and v.name like :key")
    Page<VGoods> getAllByStateAndTypeAndName(String key, Integer[] state, Integer type, Pageable pageable) throws Exception;

    @Query("select v from VGoods v where v.state in :state and v.catalogId = :catalogId")
    Page<VGoods> getAllByStateAndCatalogId(Integer[] state, Long catalogId, Pageable pageable) throws Exception;

    @Query("select v from VGoods v where v.catalogId = :catalogId and v.state in :state")
    Page<VGoods> getAllByCatalogIdAndState(Long catalogId, Integer[] state, Pageable pageable) throws Exception;

    @Query("select count(v.id) from Goods v where v.catalogId = :catalogId and v.state in :state")
    Long countByCatalogIdAndState(Long catalogId, Integer[] state) throws Exception;

    @Query("select count(v.id) from Goods v where v.type = :type and v.state in :state")
    Long countByStateAndType(Integer[] state, Integer type) throws Exception;

    @Query("select count(v.id) from Goods v where v.type = :type and v.state in :state and v.name like :name ")
    Long countByStateAndTypeAndName(Integer[] state, Integer type, String name) throws Exception;

    @Modifying
    @Query("update Goods set state = :state where catalogId = :catalogId")
    int updateByCatalogIdAndState(Long catalogId, Integer state);

    @Modifying
    @Query("update Goods set state = :state where id = :id")
    int updateByIdAndState(Long id, Integer state);

}