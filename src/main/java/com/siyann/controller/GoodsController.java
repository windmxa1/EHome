package com.siyann.controller;

import com.siyann.entity.GoodsCatalog;
import com.siyann.service.GoodsService;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController("/back/GoodsController")
@RequestMapping("/back/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("getCataGoods")
    public Object getCataGoods(Integer start, Integer limit, Long catalogId)
            throws Exception {
        Integer[] state = {1, 0};
        return goodsService.getCataGoods(start, limit, catalogId, state, true);
    }

    @RequestMapping("searchGoods")
    public Object searchGoods(Integer start, Integer limit, String key, Integer type)
            throws Exception {
        Integer[] state = {1, 0};
        return goodsService.searchGoods(start, limit, key, type, state, true);
    }

    @RequestMapping("getGoodsList")
    public Object getGoodsList(Integer start, Integer limit, Integer type) throws Exception {
        Integer[] state = {1, 0};
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return goodsService.getGoodsList(start, limit, type, state, sort, true);
    }

    @RequestMapping("/addCatalog")
    public Object addCatalog(HttpServletRequest request, GoodsCatalog catalog,
                             @RequestParam(required = false) CommonsMultipartFile file)
            throws Exception {
        String path = request.getSession().getServletContext()
                .getRealPath("/");
        return goodsService.addCatalog(path, catalog, file);
    }

    @RequestMapping("/delCatalog")
    public Object delCatalog(HttpServletRequest request, @RequestParam Long id)
            throws Exception {

    }

    @RequestMapping("/updateGoodsState")
    public Object updateGoodsState(HttpServletRequest request, Long id,
                                   Short state) throws Exception {

    }

    @RequestMapping("/updateCatalog")
    public Object updateCatalog(HttpServletRequest request,
                                GoodsCatalog catalog,
                                @RequestParam(required = false) CommonsMultipartFile file)
            throws Exception {

    }

    @RequestMapping("/addGoods")
    public Object addGoods(HttpServletRequest request, String name,
                           Double price, @RequestParam CommonsMultipartFile file,
                           Long catalogId, String description, String origin, String unit,
                           Double originPrice, Integer type) throws Exception {
        String path = request.getSession().getServletContext()
                .getRealPath("/upload/goods/");


    }

    @RequestMapping("/deleteGoods")
    public Object deleteGoods(HttpServletRequest request, Long id)
            throws Exception {

    }

    @RequestMapping("/updateGoods")
    @ResponseBody
    public Object updateGoods(HttpServletRequest request, Long id, String name,
                              Double price,
                              @RequestParam(required = false) CommonsMultipartFile file,
                              Long catalogId, String description, String origin, String unit,
                              Short state, Long saleNum, Double originPrice, Integer type)
            throws Exception {

    }

    @RequestMapping("/getCataGoods")
    public Object getCataGoods(Integer start, Integer limit, Long catalogId)
            throws Exception {

    }

}
