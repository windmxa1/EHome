package com.siyann.controller;

import com.siyann.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/back/ActivityController")
@RequestMapping("/back/activity")
public class ActivityController {
    Map<String, Object> data;
    @Autowired
    ActivityService aService;

    @RequestMapping("getActivityById")
    public Object getActivityById(Long goodsId) throws Exception{
        return aService.getListByGoodsId(goodsId);
    }

}
