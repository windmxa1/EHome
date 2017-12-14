package com.siyann.dao.imp;

import com.siyann.dao.ScrollNewsDao;
import org.hibernate.Query;
import org.hibernate.Session;
import com.siyann.model.ScrollNews;
import com.siyann.util.HibernateSessionFactory;

public class ScrollNewsDaoImp implements ScrollNewsDao {

	@Override
	public ScrollNews getLastNews() {
		try {
			Session session = HibernateSessionFactory.getSession();
			String sql = "from ScrollNews order by id desc ";
			Query query = session.createQuery(sql);
			query.setMaxResults(1);
			return (ScrollNews) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
