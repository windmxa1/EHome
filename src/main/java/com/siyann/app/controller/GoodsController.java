package com.siyann.app.controller;

import com.siyann.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/app/GoodsController")
@RequestMapping("/app/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("getGoodsList")
    public Object getGoodsList(Integer start, Integer limit, Integer type) throws Exception {
        Short[] state = {(short) 1};
        Sort sort = new Sort(Sort.Direction.DESC, "count");
        return goodsService.getGoodsList(start, limit, type, state, sort,false);
    }

    @RequestMapping("getBestSell")
    public Object getBestSell(Integer type) throws Exception {
        Short[] state = {(short) 1};
        Sort sort = new Sort(Sort.Direction.DESC, "count");
        return goodsService.getGoodsList(0, 10, type, state, sort,false);
    }

    // 搜索商品
    @RequestMapping("searchGoods")
    public Object searchGoods(Integer start, Integer limit, String key, Integer type)
            throws Exception {
        Short[] state = {(short) 1};
        return goodsService.searchGoods(start, limit, key, type, state,false);
    }

    // 最新上架
    @RequestMapping("getNewArrival")
    public Object getNewArrival(Integer type) throws Exception {
        Short[] state = {(short) 1};
        Sort sort = new Sort(Sort.Direction.DESC, "time");
        return goodsService.getGoodsList(0, 10, type, state, sort,false);
    }

    // 最新上架，按分类返回
    @RequestMapping("getNewArrival1")
    public Object getNewArrival1(Integer type) throws Exception {
        return goodsService.getNewArrival1(type);
    }

    // 获取目录列表
    @RequestMapping("getCatalog")
    public Object getCatalog(Integer type) throws Exception {
        return goodsService.getCatalog(type);
    }

    // 获取目录对应的商品列表
    @RequestMapping("getCataGoods")
    public Object getCataGoods(Integer start, Integer limit, Long catalogId)
            throws Exception {
        Short[] state = {1};
        return goodsService.getCataGoods(start, limit, catalogId, state, false);
    }
}
