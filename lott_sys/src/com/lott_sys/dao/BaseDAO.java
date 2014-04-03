/**
 * 
 */
package com.lott_sys.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author caozx10172
 *
 */
public class BaseDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		
		return sessionFactory.openSession();
	}
}
