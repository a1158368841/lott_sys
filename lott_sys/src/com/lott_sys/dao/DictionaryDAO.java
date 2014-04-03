package com.lott_sys.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lott_sys.vo.Dictionary;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dictionary entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lott_sys.vo.Dictionary
 * @author MyEclipse Persistence Tools
 */

public class DictionaryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(DictionaryDAO.class);
	// property constants
	public static final String DICT_ENTRY = "dictEntry";
	public static final String STRENTRY = "strentry";
	public static final String DICT_PROMPT = "dictPrompt";
	public static final String DICT_CODE = "dictCode";
	public static final String ENTRY_NAME = "entryName";

	protected void initDao() {
		// do nothing
	}
	
	public int getDictcode(String num,int dict_entry){
		int dictcode = -1;
		Session se = getSession();
		String hql = "select dictCode from Dictionary where instr(strentry,'" + num + "') > 0 and dict_entry= " + dict_entry;		
		List<Integer> list =getHibernateTemplate().find(hql);		
		if(list.isEmpty()){
			dictcode = -1;
		}else{
			dictcode = list.get(0);
		}
		//System.out.println(dictcode);
		return dictcode;
	}

	public void save(Dictionary transientInstance) {
		log.debug("saving Dictionary instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dictionary persistentInstance) {
		log.debug("deleting Dictionary instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dictionary findById(java.lang.Integer id) {
		log.debug("getting Dictionary instance with id: " + id);
		try {
			Dictionary instance = (Dictionary) getHibernateTemplate().get(
					"com.lott_sys.vo.Dictionary", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dictionary instance) {
		log.debug("finding Dictionary instance by example");
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
		log.debug("finding Dictionary instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dictionary as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDictEntry(Object dictEntry) {
		return findByProperty(DICT_ENTRY, dictEntry);
	}

	public List findByStrentry(Object strentry) {
		return findByProperty(STRENTRY, strentry);
	}

	public List findByDictPrompt(Object dictPrompt) {
		return findByProperty(DICT_PROMPT, dictPrompt);
	}

	public List findByDictCode(Object dictCode) {
		return findByProperty(DICT_CODE, dictCode);
	}

	public List findByEntryName(Object entryName) {
		return findByProperty(ENTRY_NAME, entryName);
	}

	public List findAll() {
		log.debug("finding all Dictionary instances");
		try {
			String queryString = "from Dictionary";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dictionary merge(Dictionary detachedInstance) {
		log.debug("merging Dictionary instance");
		try {
			Dictionary result = (Dictionary) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dictionary instance) {
		log.debug("attaching dirty Dictionary instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dictionary instance) {
		log.debug("attaching clean Dictionary instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DictionaryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DictionaryDAO) ctx.getBean("DictionaryDAO");
	}
}