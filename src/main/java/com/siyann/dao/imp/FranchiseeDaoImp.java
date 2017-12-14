package com.siyann.dao.imp;

import com.siyann.dao.FranchiseeDao;
import com.siyann.model.Franchisee;
import com.siyann.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class FranchiseeDaoImp implements FranchiseeDao {

	@Override
	public Long saveOrUpdate(Franchisee franchisee) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Long id = 0L;
			if (franchisee.getId() == null) {
				id = (Long) session.save(franchisee);
			} else {
				session.update(franchisee);
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
	public Franchisee getFranchisee(String nickName, Integer catalogId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "from Franchisee where catalogId= ? and nickname=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, catalogId);
			query.setParameter(1, nickName);
			query.setMaxResults(1);
			Franchisee franchisee = (Franchisee) query.uniqueResult();
			return franchisee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<String> getNicknameList(Integer catalogId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "select nickname from Franchisee where catalogId= ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, catalogId);
			List<String> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<Franchisee> getList(Integer catalogId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = " from Franchisee where catalogId= ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, catalogId);
			List<Franchisee> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<Franchisee> getList(Integer start, Integer limit,
			Integer catalogId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "";
			Query query = null;
			if (catalogId == null) {
				sql = " from Franchisee ";
				query = session.createQuery(sql);
			} else {
				sql = " from Franchisee where catalogId= ?";
				query = session.createQuery(sql);
				query.setParameter(0, catalogId);
			}
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
			List<Franchisee> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<Franchisee> getList(List<Long> ids) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = " from Franchisee where id in (:ids) ?";
			Query query = session.createQuery(sql);
			query.setParameterList("ids", ids);
			List<Franchisee> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<Object[]> getLatLonList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "select lat,lon,id from Franchisee";
			Query query = session.createQuery(sql);
			List<Object[]> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
