package com.siyann.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.siyann.dao.GarouselDao;
import com.siyann.dao.imp.GarouselDaoImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.siyann.util.ResultUtils;
import com.siyann.view.VGarouselId;
import org.springframework.web.bind.annotation.RestController;

@RestController("/app/GarouselController")
@RequestMapping("/app/garousel")
public class GarouselController {
	GarouselDao gDao;
	Map<String, Object> data;

	@RequestMapping("/getGarousels")

	public Object getGarousels(Integer catalogId) throws Exception {
		gDao = new GarouselDaoImp();
		data = new HashMap<String, Object>();
		if (catalogId == null) {
			catalogId = 1;
		}
		List<VGarouselId> list = gDao.getListByCatalog(catalogId);
		if (list == null || list.size() == 0) {
			data.put("list", new ArrayList<>());
		} else {
			data.put("list", list);
		}
		return ResultUtils.toJson(100, "", data);
	}
}
