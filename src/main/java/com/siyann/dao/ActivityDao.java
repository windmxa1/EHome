package com.siyann.dao;

import com.siyann.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActivityDao extends JpaRepository<Activity,Integer> {
    @Query(value="select a.* from activity a,activity_goods ag where a.id=ag.act_id and ag.goods_id=?1")
    public List<Activity> getListByGoodsId(Long goodsId);
}
