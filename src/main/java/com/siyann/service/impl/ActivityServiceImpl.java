package com.siyann.service.impl;

import com.siyann.dao.ActivityDao;
import com.siyann.service.ActivityService;
import com.siyann.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao aDao;

    @Override
    public Object getListByGoodsId(Long goodsId) throws Exception {
        return Utils.toJson(100, "", aDao.getListByGoodsId(goodsId));
    }
}
