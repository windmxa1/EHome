package com.siyann.app.controller;

import java.util.HashMap;
import java.util.Map;

import com.siyann.dao.ScrollNewsDao;
import com.siyann.dao.imp.ScrollNewsDaoImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siyann.util.ResultUtils;

@RestController("/app/ScrollNewsController")
@RequestMapping("/app/scrollNews")
public class ScrollNewsController {
	Map<String, Object> data;
	ScrollNewsDao sDao;

	@RequestMapping("/getLastNews")
	public Object getLastNews() {
		sDao = new ScrollNewsDaoImp();
		data = new HashMap<String, Object>();
		data.put("news", sDao.getLastNews());
		return ResultUtils.toJson(100, "", data);
	}
}
