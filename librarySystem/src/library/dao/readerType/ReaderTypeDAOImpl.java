package library.dao.readerType;

import java.util.List;

import library.domain.readerType.ReaderType;


import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* 读者类型 数据访问对象
* @author 0711103
* @version 1.0
*/
public class ReaderTypeDAOImpl extends HibernateDaoSupport implements
		ReaderTypeDAO {
   /**
    * <b>新增读者类型</b>
    * @param transientInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */
	public void save(ReaderType transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>删除读者类型</b>
    * @param persistentInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */
	public void delete(ReaderType persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>根据id检索读者类型</b>
    * @param id
    * @return  ReaderType
    * @exception 任何未被捕捉的的异常
    */
	public ReaderType findById(java.lang.Integer id) {
		try {
			ReaderType instance = (ReaderType) getHibernateTemplate().get(
					ReaderType.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>检索所有读者类型</b>
    * @param 
    * @return  List
    * @exception 任何未被捕捉的的异常
    */
	public List<ReaderType> findAll() {
		try {
			String queryString = "from ReaderType";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>修改读者类型信息</b>
    * @param detachedInstance
    * @return  ReaderType
    * @exception 任何未被捕捉的的异常
    */
	public ReaderType merge(ReaderType detachedInstance) {
		try {
			ReaderType result = (ReaderType) getHibernateTemplate().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}