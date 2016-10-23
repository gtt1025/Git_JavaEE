package library.dao.reader;

import java.util.List;


import library.domain.reader.Reader;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* 读者信息 数据访问对象
* @author 0711103
* @version 1.0
*/
public class ReaderDAOImpl extends HibernateDaoSupport implements ReaderDAO {

   /**
    * <b>新增读者</b>
    * @param transientInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */
	public void save(Reader transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>删除读者</b>
    * @param persistentInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */
	public void delete(Reader persistentInstance) {
		try {

			getHibernateTemplate().delete(persistentInstance);
			// getSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据id检索读者信息记录</b>
    * @param id
    * @return  Reader
    * @exception 任何未被捕捉的的异常
    */
	public Reader findById(java.lang.Integer id) {
		try {
			Reader instance = (Reader) getHibernateTemplate().get(Reader.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据对象的属性检索读者信息记录</b>
    * @param propertyName value
    * @return  List
    * @exception 任何未被捕捉的的异常
    */
	public List<Reader> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Reader as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>检索所有读者信息记录</b>
    * @param 
    * @return  List
    * @exception 任何未被捕捉的的异常
    */
	public List<Reader> findAll() {
		try {
			String queryString = "from Reader";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据页数检索读者信息记录</b>
    * @param first max
    * @return  List
    * @exception 任何未被捕捉的的异常
    */
	public List<Reader> findAllPage(Integer first, Integer max) {
		try {
			String queryString = "from Reader order by registTime desc";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			queryObject.setFirstResult(first);
			queryObject.setMaxResults(max);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	/**
    * <b>得到读者实例</b>
    * @param detachedInstance
    * @return  Reader
    * @exception 任何未被捕捉的的异常
    */
	public Reader merge(Reader detachedInstance) {
		try {
			Reader result = (Reader) getHibernateTemplate().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}