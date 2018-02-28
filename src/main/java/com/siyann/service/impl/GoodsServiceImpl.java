package com.siyann.service.impl;

import com.siyann.dao.GoodsCatalogDao;
import com.siyann.dao.GoodsDao;
import com.siyann.entity.GoodsCatalog;
import com.siyann.service.GoodsService;
import com.siyann.util.Utils;
import com.siyann.view.VGoods;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao gDao;
    @Autowired
    GoodsCatalogDao goodsCatalogDao;
    Map<String, Object> data;

    // 获取商品信息
    @Override
    public Object getGoodsList(Integer start, Integer limit, Integer type, Integer[] state, Sort sort, boolean isWeb) throws Exception {
        data = new HashMap<String, Object>();
        if (type == null) type = 0;
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<VGoods> vGoodsPage = gDao.getAllByStateAndType(state, type, pageable);
        List<VGoods> list = vGoodsPage.getContent();
        data.put("list", list);
        if (isWeb) {
            data.put("total", gDao.countByStateAndType(state, type));
        }
        return Utils.toJson(100, "", data);
    }

//	@RequestMapping("/checkGoods")
//	@ResponseBody
//	public Object checkGoods(@RequestBody OrderModel o) throws Exception {
//		StringBuffer list = new StringBuffer();
//		gDao = new GoodsDaoImp();
//		for (OrdersDetail od : o.getDetails()) {
//			if (gDao.getGoods(od.getGoodsId(), od.getTime(), (Integer) 1) == null) {
//				if (list.length() == 0) {
//					list.append(od.getName());
//				} else {
//					list.append("、" + od.getName());
//				}
//			}
//		}
//		if (list.length() > 0) {
//			return ResultUtils.toJson(101,
//					"您的购物车中如下商品信息已过期，请重新选购:" + list.toString(), "");
//		}
//		return ResultUtils.toJson(100, "", "");
//	}

    // 获取销量最高的10个商品
//    public Object getGoodsList(Integer type) throws Exception {
//        data = new HashMap<String, Object>();
//        Integer[] state = {(Integer) 1};
//        if (type == null) type = 0;
//        List<VGoodsId> list = gDao.getList(0, 10, state, type);
//        if (list != null) {
//            data.put("list", list);
//        } else {
//            data.put("list", new ArrayList<>());
//        }
//        return ResultUtils.toJson(100, "", data);
//    }


    // 搜索商品
    @Override
    public Object searchGoods(Integer start, Integer limit, String key, Integer type, Integer[] state, boolean isWeb)
            throws Exception {
        data = new HashMap<String, Object>();
        if (type == null) type = 0;
        Sort sort = new Sort(Sort.Direction.DESC, "count");
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<VGoods> page = gDao.getAllByStateAndTypeAndName(key, state, type, pageable);
        List<VGoods> list = page.getContent();
        data.put("list", list);
        if (isWeb) {
            data.put("total", gDao.countByStateAndTypeAndName(state, type, key));
        }
        return Utils.toJson(100, "", data);
    }


    // 最新上架，按分类返回
    @Override
    public Object getNewArrival1(Integer type) throws Exception {
        data = new HashMap<String, Object>();
        if (type == null) type = 0;
        Sort sort = new Sort(Sort.Direction.DESC, "time");
        Pageable pageable = new PageRequest(0, 10, sort);
        List<Long> gCatalogIds = goodsCatalogDao.getCatalogIdByType(type);
        if (gCatalogIds == null) {
            return Utils.toJson(101, "服务器繁忙，请重试", "");
        }
        Integer state[] = {1};
        for (Long catalog : gCatalogIds) {
            Page<VGoods> page = gDao.getAllByStateAndCatalogId(state, catalog, pageable);
            List<VGoods> list = page.getContent();
            data.put("" + catalog, list);
        }
        return Utils.toJson(100, "", data);
    }

    // 获取目录列表
    @Override
    public Object getCatalog(Integer type) throws Exception {
        data = new HashMap<String, Object>();
        if (type == null) type = 0;
        List<GoodsCatalog> list = goodsCatalogDao.findAllByType(type);
        if (list != null) {
            data.put("list", list);
        } else {
            data.put("list", new ArrayList<>());
        }
        return Utils.toJson(100, "", data);
    }

    // 获取目录对应的商品列表
    @Override
    public Object getCataGoods(Integer start, Integer limit, Long catalogId, Integer[] state, boolean isWeb)
            throws Exception {
        data = new HashMap<String, Object>();
        Sort sort = new Sort(Sort.Direction.DESC, "count");
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<VGoods> page = gDao.getAllByCatalogIdAndState(catalogId, state, pageable);
        List<VGoods> list = page.getContent();
        data.put("list", list);
        if (isWeb) {
            data.put("total", gDao.countByCatalogIdAndState(catalogId, state));
        }
        return Utils.toJson(100, "", data);
    }

    /**
     * 获取目录列表
     */
    @Override
    public Object getCatalog() throws Exception {
        data = new HashMap<String, Object>();
        List<GoodsCatalog> list = goodsCatalogDao.findAll();
        data.put("list", list);
        data.put("total", goodsCatalogDao.count());
        return Utils.toJson(100, "", data);
    }

    /**
     * 添加目录
     */
    @Override
    public Object addCatalog(String path, GoodsCatalog catalog,
                             CommonsMultipartFile file)
            throws Exception {
        if (goodsCatalogDao.findOneByCatalog(catalog.getCatalog()) != null) {
            return Utils.toJson(101, "添加失败,该目录已存在", "");
        }
        String url = Utils.getFileUrl(path, file, System.currentTimeMillis() / 1000,
                "upload/catalog");
        GoodsCatalog goodsCatalog = new GoodsCatalog(catalog.getCatalog(), url,
                catalog.getDescription(), catalog.getType());
        goodsCatalogDao.saveAndFlush(goodsCatalog);
        return Utils.toJson(100, "添加成功", "");
//        return ResultUtils.toJson(101, "添加失败", "");
    }

    /**
     * 删除商品目录，商品伪删除，不删除图片
     */
    @Override
    public Object delCatalog(String path, Long id)
            throws Exception {
        goodsCatalogDao.deleteById(id);
        gDao.updateByCatalogIdAndState(id, -1);
//        File file = new File(path + "/upload/goods/"
//                + File.separator + id + File.separator);
//        System.out.println(file.getAbsolutePath());
//        FileUtils.deleteDirectory(file);
        return Utils.toJson(100, "删除成功", "");
    }

    /**
     * 上下架商品
     */
    @Override
    public Object updateGoodsState(Long id,
                                   Integer state) throws Exception {
        gDao.updateByIdAndState(id, Math.abs(state - 1));
        return Utils.toJson(100, "操作成功", "");
//        return ResultUtils.toJson(101, "操作失败", "");
    }

    public Object updateCatalog(String path, GoodsCatalog catalog, CommonsMultipartFile file)
            throws Exception {
        String url = Utils.getFileUrl(path, file, System.currentTimeMillis() / 1000,
                "upload/catalog");
        if (url == null) {
            url = catalog.getUrl();
        }
        goodsCatalogDao.update(catalog.getId(),
                catalog.getCatalog(), url, catalog.getDescription(),
                catalog.getType());
        return Utils.toJson(100, "修改成功", "");
//        return ResultUtils.toJson(101,"修改失败","");
    }

    /**
     * 添加商品
     */
    @Override
    public Object addGoods(String path, String name,
                           Double price, CommonsMultipartFile file,
                           Long catalogId, String description, String origin, String unit,
                           Double originPrice, Integer type) throws Exception {
        Long time = System.currentTimeMillis() / 1000;

        String filename = time + "_" + file.getOriginalFilename();
        String filePath = path + File.separator + catalogId + File.separator
                + filename;
        // System.out.println(filePath);
        File newFile = new File(filePath);
        // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);

        String url = Utils.getFileUrl();

        Goods goods = new Goods(name, price, url, catalogId, description, time,
                origin, (Integer) 1, "g", 500, 0L, originPrice, type);
        if (description != null) {
            goods.setDescription(description);
        }
        if (origin != null) {
            goods.setOrigin(origin);
        }
        if (unit != null) {
            try {
                goods.setUnitName(unit.replaceAll("\\d+", ""));
                goods.setUnitNum(Integer.parseInt(unit.replaceAll("\\D+", "")));
            } catch (Exception e) {
                return ResultUtils.toJson(101, "添加失败，单位格式错误", "");
            }
        }
        gDao = new GoodsDaoImp();
        if (gDao.saveOrUpdate(goods) > 0) {
            return ResultUtils.toJson(100, "添加成功", "");
        }
        return ResultUtils.toJson(101, "添加失败", "");
    }

    // 删除商品，伪删除
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public Object deleteGoods(HttpServletRequest request, Long id)
            throws Exception {
        gDao = new GoodsDaoImp();
        // 删除之前上传的商品图片
        Goods g = gDao.getGoods(id);
        if (g != null) {
            File f = new File(request.getSession().getServletContext()
                    .getRealPath("/")
                    + g.getUrl());
            if (f.exists()) {
                f.delete();
            }
        }
        if (gDao.delete(id)) {
            return ResultUtils.toJson(100, "删除成功", "");
        }
        return ResultUtils.toJson(101, "删除失败", "");
    }

    @RequestMapping("/updateGoods")
    @ResponseBody
    public Object updateGoods(HttpServletRequest request, Long id, String name,
                              Double price,
                              @RequestParam(required = false) CommonsMultipartFile file,
                              Long catalogId, String description, String origin, String unit,
                              Integer state, Long saleNum, Double originPrice, Integer type)
            throws Exception {
        Long time = System.currentTimeMillis() / 1000;
        gDao = new GoodsDaoImp();
        String url = "";
        if (file.getOriginalFilename().equals("")) {
            Goods g = gDao.getGoods(id);
            if (g != null) {
                url = g.getUrl();
            } else {
                return ResultUtils.toJson(101, "修改失败", "原纪录不存在");
            }
        } else {
            String path = request.getSession().getServletContext()
                    .getRealPath("/upload/goods/");
            String filename = time + "_" + file.getOriginalFilename();

            String filePath = path + File.separator + catalogId
                    + File.separator + filename;
            File newFile = new File(filePath);
            if (!newFile.getParentFile().exists()) {
                System.out.println("目标文件的目录不存在，准备创建目录...");
                if (!newFile.getParentFile().mkdirs()) {
                    System.out.println("创建目录失败");
                    return ResultUtils.toJson(101, "服务器繁忙请重试", "");
                }
            }
            // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            url = "upload/goods/" + catalogId + "/" + filename;
            // 删除之前上传的商品图片
            Goods g = gDao.getGoods(id);
            if (g != null) {
                File f = new File(request.getSession().getServletContext()
                        .getRealPath("/")
                        + g.getUrl());
                if (f.exists()) {
                    f.delete();
                }
            }
        }
        Goods goods = new Goods(name, price, url, catalogId, description, time,
                origin, state, "g", 500, saleNum, originPrice, type);
        if (unit != null) {
            try {
                goods.setUnitName(unit.replaceAll("\\d+", ""));
                goods.setUnitNum(Integer.parseInt(unit.replaceAll("\\D+", "")));
            } catch (Exception e) {
                return ResultUtils.toJson(101, "修改失败，单位格式错误", "");
            }
        }
        goods.setId(id);
        if (gDao.saveOrUpdate(goods) == 0) {
            return ResultUtils.toJson(100, "修改成功", "");
        }
        return ResultUtils.toJson(101, "修改失败", "");
    }

//    // 获取目录对应的商品列表
//    @RequestMapping("/getCataGoods")
//    @ResponseBody
//    public Object getCataGoods(Integer start, Integer limit, Long catalogId)
//            throws Exception {
//        gDao = new GoodsDaoImp();
//        Integer[] state = {(Integer) 1, (Integer) 0};
//        data = new HashMap<String, Object>();
//        List<VGoodsId> list = gDao.getCataGoods(start, limit, catalogId, state);
//        if (list != null) {
//            data.put("list", list);
//            data.put("total", gDao.getCountByCatalog(catalogId, state));
//        } else {
//            data.put("list", new ArrayList<>());
//        }
//        return ResultUtils.toJson(100, "", data);
//    }
}
