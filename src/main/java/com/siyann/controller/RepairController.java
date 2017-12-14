package com.siyann.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.siyann.dao.RepairDao;
import com.siyann.dao.imp.RepairDaoImp;
import com.siyann.model.RepairOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.siyann.util.Constants;
import com.siyann.util.Coordinate;
import com.siyann.util.JsonUtils;
import com.siyann.util.PDFUtil;
import com.siyann.util.RedisUtil;
import com.siyann.util.ResultUtils;
import com.siyann.view.VRepairOrderId;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("/back/RepairController")
@RequestMapping("/back/repair")
public class RepairController {
	Map<String, Object> data;
	RepairDao rDao;

	/**
	 * 查看所有报修单
	 */
	@RequestMapping("/getRepairOrderList1")
	@ResponseBody
	public Object getRepairOrderList1(HttpServletRequest request,
			Integer start, Integer limit, Integer type[]) throws Exception {
		rDao = new RepairDaoImp();
		List<VRepairOrderId> list = rDao.getList(start, limit, type);
		if (list == null) {
			return ResultUtils.toJson(101, "后台错误，请重试", "");
		}
		data = new HashMap<>();
		data.put("total", rDao.getRepairListCount(type));
		data.put("list", list);
		return ResultUtils.toJson(100, "", data);
	}

	/**
	 * 维修单通知
	 */
	@RequestMapping("/repairNotice")
	@ResponseBody
	public Object notice() {
		rDao = new RepairDaoImp();
		if (rDao.getUnRead() > 0) {
			return ResultUtils.toJson(100, "有新的维修单提交", "");
		} else {
			return ResultUtils.toJson(101, "", "");
		}
	}

	/**
	 * 查看所有报修单
	 */
	@RequestMapping("/getRepairOrderList")
	@ResponseBody
	public Object getRepairOrderList(HttpServletRequest request, Integer start,
			Integer limit, Integer type[]) throws Exception {
		rDao = new RepairDaoImp();
		List<VRepairOrderId> list = rDao.getList(start, limit, type);

		if (list == null) {
			return ResultUtils.toJson(101, "后台错误，请重试", "");
		}
		data = new HashMap<>();
		data.put("total", rDao.getRepairListCount(type));
		data.put("list", list);
		return ResultUtils.toJson(100, "", data);
	}

	/**
	 * 修改报修单状态（负责人APP专用）
	 */
	@RequestMapping("/updateRepairOrder")
	@ResponseBody
	public Object updateRepairOrder(HttpServletRequest request,
			@RequestBody RepairOrder repair) throws Exception {
		rDao = new RepairDaoImp();
		if (rDao.updateRepairOrder(repair.getId(), repair.getStatus(),
				repair.getHandleResult(), repair.getStaffId())) {
			return ResultUtils.toJson(100, "修改成功", "");
		}
		return ResultUtils.toJson(101, "修改失败", "");
	}

	/**
	 * 修改报修单状态(后台维护使用)
	 */
	@RequestMapping("/updateRepairOrder1")
	@ResponseBody
	public Object updateRepairOrder1(HttpServletRequest request,
			RepairOrder repair) throws Exception {
		rDao = new RepairDaoImp();
		if (rDao.saveOrUpdate(repair) == 0L) {
			return ResultUtils.toJson(100, "修改成功", "");
		}
		return ResultUtils.toJson(101, "修改失败", "");
	}

	/**
	 * 导出报修单
	 */
	@RequestMapping("/getRepairOrderPDF")
	@ResponseBody
	public Object getRepairOrderPDF(HttpServletRequest request, Integer start,
			Integer limit, Integer type[]) throws Exception {
		rDao = new RepairDaoImp();
		List<VRepairOrderId> list = rDao.getList(start, limit, type);
		if (list == null || list.size() == 0) {
			return ResultUtils.toJson(101, "暂无报修单或后台错误，请重试", "");
		}
		PDFUtil.buidPDF(Constants.watermark, list, 1);
		return ResultUtils.toJson(100, "", "");
	}

	/**
	 * 删除报修单
	 */
	@RequestMapping("/deleteRepairOrder")
	@ResponseBody
	public Object deleteRepairOrder(HttpServletRequest request, Long[] id)
			throws Exception {
		rDao = new RepairDaoImp();
		if (id == null || id.length == 0) {
			return ResultUtils.toJson(101, "参数错误", "");
		}
		if (rDao.deleteRepairOrder(id)) {
			return ResultUtils.toJson(100, "删除成功", "");
		}
		return ResultUtils.toJson(101, "删除失败", "");

	}
}