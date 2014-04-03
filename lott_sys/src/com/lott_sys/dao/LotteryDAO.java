package com.lott_sys.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lott_sys.vo.Lottery;

/**
 * A data access object (DAO) providing persistence and search support for
 * Lottery entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lott_sys.vo.Lottery
 * @author MyEclipse Persistence Tools
 */

public class LotteryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(LotteryDAO.class);
	// property constants
	public static final String LOTT_NUMS = "lottNums";
	public static final String NUM1 = "num1";
	public static final String NUM2 = "num2";
	public static final String NUM3 = "num3";
	public static final String NUM4 = "num4";
	public static final String NUM5 = "num5";
	public static final String SALE_PRICE = "salePrice";

	protected void initDao() {
		// do nothing
	}
	
	public List<Lottery> query(int begin,int end){
		List<Lottery> list = new ArrayList<Lottery>();
		String hql ="select * from Lottery where lottId between "+begin+" and "+end;
		list = getHibernateTemplate().find(hql);
		return list;
	}
	
	public List<Lottery> query(int nums){
		List<Lottery> list = new ArrayList<Lottery>();
		String hql ="from Lottery order by lottId desc ";//limit 0,"+nums;
		list = (List<Lottery>)getHibernateTemplate().find(hql);
		return list;
	}

	public void save(Lottery transientInstance) {
		log.debug("saving Lottery instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Lottery persistentInstance) {
		log.debug("deleting Lottery instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Lottery findById(java.lang.Integer id) {
		log.debug("getting Lottery instance with id: " + id);
		try {
			Lottery instance = (Lottery) getHibernateTemplate().get(
					"com.lott_sys.vo.Lottery", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Lottery instance) {
		log.debug("finding Lottery instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Lottery instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Lottery as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLottNums(Object lottNums) {
		return findByProperty(LOTT_NUMS, lottNums);
	}

	public List findByNum1(Object num1) {
		return findByProperty(NUM1, num1);
	}

	public List findByNum2(Object num2) {
		return findByProperty(NUM2, num2);
	}

	public List findByNum3(Object num3) {
		return findByProperty(NUM3, num3);
	}

	public List findByNum4(Object num4) {
		return findByProperty(NUM4, num4);
	}

	public List findByNum5(Object num5) {
		return findByProperty(NUM5, num5);
	}

	public List findBySalePrice(Object salePrice) {
		return findByProperty(SALE_PRICE, salePrice);
	}

	public List findAll() {
		log.debug("finding all Lottery instances");
		try {
			String queryString = "from Lottery";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Lottery merge(Lottery detachedInstance) {
		log.debug("merging Lottery instance");
		try {
			Lottery result = (Lottery) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Lottery instance) {
		log.debug("attaching dirty Lottery instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Lottery instance) {
		log.debug("attaching clean Lottery instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LotteryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LotteryDAO) ctx.getBean("LotteryDAO");
	}
}