package com.siyann.dao.imp;

import com.siyann.dao.UserFeedbackDao;
import com.siyann.model.UserFeedback;
import com.siyann.util.HibernateSessionFactory;
import com.siyann.view.VUserFeedback;
import com.siyann.view.VUserFeedbackId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserFeedbackDaoImp implements UserFeedbackDao {

	@Override
	public Integer saveOrUpdate(UserFeedback userFeedback) {
		Integer id = 0;
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			if (userFeedback.getId() == null) {
				id = (Integer) session.save(userFeedback);
			}
			session.update(userFeedback);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateRead(Integer id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			String sql = "update UserFeedback set read=1 where id = ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, id);
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
	public boolean delete(Integer id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "delete from UserFeedback where id = ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, id);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<VUserFeedbackId> getList(Integer read, Integer start,
			Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Query query = null;
			if (read == null) {
				query = session
						.createQuery("from VUserFeedback v order by v.id.read");
			} else {
				query = session
						.createQuery("from VUserFeedback where v.id.read= ? order by v.id.read");
				query.setParameter(0, read);
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
			query.setFirstResult(start);
			List<VUserFeedback> vlist = query.list();
			List<VUserFeedbackId> list = new ArrayList<>();
			for (VUserFeedback feedbackId : vlist) {
				list.add(feedbackId.getId());
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
	public Long getFeedbackCount() {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "select count(id) from UserFeedback";
			Query query = session.createQuery(sql);
			query.setMaxResults(1);
			Long count = (Long) query.uniqueResult();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}