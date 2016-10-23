

package library.dao.barcode;

import java.util.List;

import library.domain.barcode.Barcode;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
* 图书编号 数据访问对象
* @author 0711103
* @version 1.0
*/

public class BarcodeDAOImpl extends HibernateDaoSupport implements BarcodeDAO {

   /**
    * <b>保存图书编号</b>
    * @param transientInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
    */

	public void save(Barcode transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>删除图书编号</b>
    * @param persistentInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
    */
	public void delete(Barcode persistentInstance) {
		try {
			Barcode b = (Barcode) this.getHibernateTemplate().load(
					Barcode.class, persistentInstance.getId());
			getHibernateTemplate().delete(b);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	
	/**
    * <b>根据id检索图书编号</b>
    * @param id 
    * @return Barcode
    * @exception 任何未被捕捉的的异常
    */
	public Barcode findById(java.lang.Integer id) {
		try {
			Barcode instance = (Barcode) getHibernateTemplate().get(
					Barcode.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据编号值检索编号信息</b>
    * @param propertyName value 
    * @return List
    * @exception 任何未被捕捉的的异常
    */
	public List<Barcode> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Barcode as model where model."
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
    * <b>检索所有图书编号</b>
    * @param  
    * @return List
    * @exception 任何未被捕捉的的异常
    */
	public List<Barcode> findAll() {
		try {
			String queryString = "from Barcode";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据页数检索图书编号</b>
    * @param  first max
    * @return List
    * @exception 任何未被捕捉的的异常
    */
	public List<Barcode> findAllPage(Integer first, Integer max) {
		try {
			String queryString = "from Barcode order By bookT desc";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			queryObject.setFirstResult(first);
			queryObject.setMaxResults(max);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

}