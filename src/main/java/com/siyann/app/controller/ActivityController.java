package com.siyann.app.controller;

import com.siyann.entity.Activity;
import com.siyann.service.ActivityService;
import com.siyann.util.Utils;
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
    ActivityService aService;

    @RequestMapping("getActivityById")
    public Object getActivityById(Long goodsId) throws Exception{
        return aService.getListByGoodsId(goodsId);
    }

}
