package com.siyann.dao.imp;

import java.util.List;

import com.siyann.dao.UserAddressDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.siyann.model.User;
import com.siyann.model.UserAddress;
import com.siyann.util.HibernateSessionFactory;

public class UserAddressDaoImp implements UserAddressDao {

	public Long saveOrUpdate(UserAddress userAddress) {
		Long id = 0L;
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			if (userAddress.getId() != null) {
				session.update(userAddress);
			} else {
				id = (Long) session.save(userAddress);
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

	public boolean delete(Long userid, Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			String sql = "delete from UserAddress where userid=? and id=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, userid);
			query.setParameter(1, id);
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

	public List<UserAddress> getList(Long userid) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "from UserAddress where userid= ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, userid);
			List<UserAddress> list = (List<UserAddress>) query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateDefault(Long id, Boolean default_) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			if (default_) {
				String sql = "update from UserAddress set default_=0";
				Query query = session.createQuery(sql);
				query.executeUpdate();
				String sql2 = "update from UserAddress set default_=1 where id=?";
				Query query2 = session.createQuery(sql2);
				query2.setParameter(0, id);
				query2.executeUpdate();
			} else {
				String sql = "update from UserAddress set default_=0 where id=?";
				Query query = session.createQuery(sql);
				query.setParameter(0, id);
				query.executeUpdate();
			}
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
	public UserAddress getDefaultAddress(Long userid) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "from UserAddress where userid= ? and default_=1";
			Query query = session.createQuery(sql);
			query.setParameter(0, userid);
			query.setMaxResults(1);
			UserAddress userAddress = (UserAddress) query.uniqueResult();
			return userAddress;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public String getAddressById(Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "select concat(ua.receiver,' ',ua.sex,' ',ua.tel,' ',ua.address) as address from user_address ua where id= ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setParameter(0, id);
			query.setMaxResults(1);
			String userAddress = (String) query.uniqueResult();
			return userAddress;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}