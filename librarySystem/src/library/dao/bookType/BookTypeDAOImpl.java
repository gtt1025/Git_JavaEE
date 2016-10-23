
package library.dao.bookType;

import java.util.List;


import library.domain.bookType.BookType;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* 图书类型 数据访问对象
* @author 0711103
* @version 1.0
*/
public class BookTypeDAOImpl extends HibernateDaoSupport implements BookTypeDAO {

   /**
    * <b>新增图书类型</b>
    * @param transientInstance  
    * @return 
    * @exception 任何未被捕捉的的异常
    */
	public void save(BookType transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	
	/**
    * <b>删除图书类型</b>
    * @param persistentInstance  
    * @return 
    * @exception 任何未被捕捉的的异常
    */
	public void delete(BookType persistentInstance) {
		try {
			BookType b = (BookType) getHibernateTemplate().load(BookType.class,
					persistentInstance.getId());
			getHibernateTemplate().delete(b);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据id检索图书类型</b>
    * @param id  
    * @return BookType
    * @exception 任何未被捕捉的的异常
    */
	public BookType findById(java.lang.Integer id) {
		try {
			BookType instance = (BookType) getHibernateTemplate().get(
					BookType.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>检索图书类型</b>
    * @param  
    * @return List
    * @exception 任何未被捕捉的的异常
    */
	public List<BookType> findAll() {
		try {
			String queryString = "from BookType";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>更新图书类型</b>
    * @param  detachedInstance
    * @return BookType
    * @exception 任何未被捕捉的的异常
    */
	public BookType merge(BookType detachedInstance) {
		try {
			BookType result = (BookType) getHibernateTemplate().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}