package com.siyann.dao.imp;


import com.siyann.dao.RepairDao;
import com.siyann.model.RepairComment;
import com.siyann.model.RepairOrder;
import com.siyann.util.HibernateSessionFactory;
import com.siyann.view.VRepairOrder;
import com.siyann.view.VRepairOrderId;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RepairDaoImp implements RepairDao {

	@Override
	public Long saveOrUpdate(RepairOrder repair) {
		Long id = 0L;
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			if (repair.getId() != null) {
				session.update(repair);
			} else {
				id = (Long) session.save(repair);
			}
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1L;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteRepairOrder(Long[] id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session
					.createQuery("delete from RepairOrder where id in (:idList)");
			query.setParameterList("idList", id);
			query.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public int getUnRead() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session
					.createQuery("update RepairOrder set isRead=1 where isRead = 0");
			int count = query.executeUpdate();
			ts.commit();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public int getUnRead(Integer staffId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session
					.createQuery("update RepairOrder set isStaffRead=1 where isStaffRead = 0 and staffId=?");
			query.setParameter(0, staffId);
			int count = query.executeUpdate();
			ts.commit();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Long saveOrUpdate(RepairComment repairComment) {
		Long id = 0L;
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			if (repairComment.getId() != null) {
				session.update(repairComment);
			} else {
				id = (Long) session.save(repairComment);
			}
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1L;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<VRepairOrderId> getList(Integer start, Integer limit,
										Long userid) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "from VRepairOrder where id.userid= ? order by id.id desc";
			Query query = session.createQuery(sql);
			if (start == null)
				start = 0;
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			} else if (limit == -1) {
			} else {
				query.setMaxResults(limit);
			}
			query.setFirstResult(start);
			query.setParameter(0, userid);
			List<VRepairOrder> repairOrders = query.list();
			List<VRepairOrderId> list = new ArrayList<>();

			for (VRepairOrder v : repairOrders) {
				list.add(v.getId());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<VRepairOrderId> getList(Integer start, Integer limit,
			Integer[] status) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "";
			Query query = null;
			if (status != null && status.length > 0) {
				sql = "from VRepairOrder where id.status in (:typeList) order by id.id desc";
				query = session.createQuery(sql);
				query.setParameterList("typeList", status);
			} else {
				sql = "from VRepairOrder order by id.id desc";
				query = session.createQuery(sql);
			}
			if (start == null) {
				start = 0;
			}
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			} else if (limit == -1) {
			} else {
				query.setMaxResults(limit);
			}
			List<VRepairOrder> repairOrders = query.list();
			List<VRepairOrderId> list = new ArrayList<>();

			for (VRepairOrder v : repairOrders) {
				list.add(v.getId());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Long getRepairListCount(Integer[] status) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "";
			Query query = null;
			if (status != null && status.length > 0) {
				sql = "select count(id.id) from VRepairOrder where id.status in (:typeList)";
				query = session.createQuery(sql);
				query.setParameterList("typeList", status);
			} else {
				sql = "select count(id.id) from VRepairOrder";
				query = session.createQuery(sql);
			}
			Long count = (Long) query.uniqueResult();

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<VRepairOrderId> getRepairListByStaffId(Integer staffId,
			Integer status, Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "";
			SQLQuery query = null;
			if (status != null) {
				sql = "select v.* from v_repair_order v where v.status=? and v.staff_id = ? order by id desc";
				query = session.createSQLQuery(sql);
				query.setParameter(0, status);
				query.setParameter(1, staffId);
			} else {
				sql = "select v.* from v_repair_order v where v.staff_id =? order by id desc";
				query = session.createSQLQuery(sql);
				query.setParameter(0, staffId);
			}
			if (start == null) {
				start = 0;
			}
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			} else if (limit == -1) {
			} else {
				query.setMaxResults(limit);
			}
			query.addEntity(VRepairOrder.class);
			List<VRepairOrder> repairOrders = query.list();
			List<VRepairOrderId> list = new ArrayList<>();

			for (VRepairOrder v : repairOrders) {
				list.add(v.getId());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateRepairOrder(Long id, Integer status,
			String handleResult,Integer staffId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			String sql = "update RepairOrder set status=?,handleResult=?,staffId=? where id=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, status);
			query.setParameter(1, handleResult);
			query.setParameter(2, staffId);
			query.setParameter(3, id);
			query.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	@Override
	public boolean updateRepairOrder(Long id, Integer status,
			String handleResult) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			String sql = "update RepairOrder set status=?,handleResult=? where id=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, status);
			query.setParameter(1, handleResult);
			query.setParameter(2, id);
			query.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateRepairOrder(Integer staffId, Long repairOrderId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			String sql = "update RepairOrder set staffId= ? where id =?";
			Query query = session.createQuery(sql);
			query.setParameter(0, staffId);
			query.setParameter(1, repairOrderId);
			query.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}