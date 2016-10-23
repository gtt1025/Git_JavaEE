
package library.dao.bookType;

import java.util.List;


import library.domain.bookType.BookType;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* ͼ������ ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/
public class BookTypeDAOImpl extends HibernateDaoSupport implements BookTypeDAO {

   /**
    * <b>����ͼ������</b>
    * @param transientInstance  
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void save(BookType transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	
	/**
    * <b>ɾ��ͼ������</b>
    * @param persistentInstance  
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����id����ͼ������</b>
    * @param id  
    * @return BookType
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����ͼ������</b>
    * @param  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����ͼ������</b>
    * @param  detachedInstance
    * @return BookType
    * @exception �κ�δ����׽�ĵ��쳣
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