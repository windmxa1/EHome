package com.siyann.dao;

import com.siyann.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActivityDao extends JpaRepository<Activity,Integer> {
    @Query(value="select a from Activity a,ActivityGoods ag where a.id=ag.actId and ag.goodsId=?1")
    public List<Activity> getListByGoodsId(Long goodsId) throws Exception;
}
