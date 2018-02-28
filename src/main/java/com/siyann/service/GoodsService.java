package com.siyann.service;

import com.siyann.entity.GoodsCatalog;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface GoodsService {
    /**
     * 按类型及状态（删除、显示、隐藏）获取分页商品数据
     */
    public Object getGoodsList(Integer start, Integer limit, Integer type, Integer[] state, Sort sort, boolean isWeb) throws Exception;

    // 搜索商品
    Object searchGoods(Integer start, Integer limit, String key, Integer type, Integer[] state, boolean isWeb)
            throws Exception;

    // 最新上架，按分类返回
    Object getNewArrival1(Integer type) throws Exception;

    // 获取目录列表
    Object getCatalog(Integer type) throws Exception;

    // 获取目录对应的商品列表
    Object getCataGoods(Integer start, Integer limit, Long catalogId, Integer[] state, boolean isWeb)
            throws Exception;

    Object getCatalog() throws Exception;

    Object addCatalog(String path, GoodsCatalog catalog,
                      CommonsMultipartFile file)
            throws Exception;

    Object delCatalog(String path, Long id)
            throws Exception;

    Object updateGoodsState(Long id,
                            Integer state) throws Exception;
}
