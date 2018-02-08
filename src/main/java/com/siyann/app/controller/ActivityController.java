package com.siyann.app.controller;

import com.siyann.dao.ActivityDao;
import com.siyann.entity.Activity;
import com.siyann.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("/app/ActivityController")
@RequestMapping("/app/activity")
public class ActivityController {
    Map<String, Object> data;
    @Autowired
    ActivityDao aDao;

    @RequestMapping("getActivityById")
    public Object getActivityById(Long goodsId) {
        List<Activity> list = aDao.getListByGoodsId(goodsId);
        return ResultUtils.toJson(100, "", list);
    }
}
