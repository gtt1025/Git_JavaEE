package library.dao.borrow;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import library.domain.borrow.Borrow;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
* 借书情况 数据访问对象
* @author 0711103
* @version 1.0
*/

public class BorrowDAOImpl extends HibernateDaoSupport implements BorrowDAO {


   /**
    * <b>新增借阅历史记录</b>
    * @param transientInstance  
    * @return 
    * @exception 任何未被捕捉的的异常
    */
	public void save(Borrow transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据id检索借书记录</b>
    * @param id  
    * @return Borrow
    * @exception 任何未被捕捉的的异常
    */
	public Borrow findById(java.lang.Integer id) {
		try {
			Borrow instance = (Borrow) getHibernateTemplate().get(Borrow.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>检索读者是否有借阅图书历史记录</b>
    * @param propertyName value
    * @return List 
    * @exception 任何未被捕捉的的异常
    */
	public List<Borrow> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Borrow as model where model."
					+ propertyName + "= ?";
			List<Borrow> result = getHibernateTemplate().find(queryString,
					value);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>检索指定读者的借书量是否已经达到其最大借书量</b>
    * @param propertyName1 value1 propertyName2 value2
    * @return List 
    * @exception 任何未被捕捉的的异常
    */
	public List<Borrow> findByTwoProperties(String propertyName1,
			Object value1, String propertyName2, Object value2) {
		try {
			String queryString = "from Borrow as model where model."
					+ propertyName1 + "= " + value1 + " and " + "model."
					+ propertyName2 + "= " + value2;

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>检索那些借书日期已到期但尚未归还的记录</b>
    * @param s date
    * @return List 
    * @exception 任何未被捕捉的的异常
    */
	public List<Borrow> findWarnings(Short s, Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String queryString = "from Borrow as model where model.giveback = "
					+ s + " and model.forceBackTime < '"
					+ sdf.format(date).toString()
					+ "' order by model.forceBackTime";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>检索所有的借书和还书记录</b>
    * @param 
    * @return List 
    * @exception 任何未被捕捉的的异常
    */
	public List<Borrow> findAll() {
		try {
			String queryString = "from Borrow";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>根据页数检索借书和还书记录</b>
    * @param first max
    * @return List 
    * @exception 任何未被捕捉的的异常
    */
	public List<Borrow> findAllPage(Integer first, Integer max) {
		try {
			String queryString = "from Borrow order by borrowTime desc";
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
    * <b>图书续借</b>
    * @param detachedInstance
    * @return Borrow 
    * @exception 任何未被捕捉的的异常
    */
	public Borrow merge(Borrow detachedInstance) {
		try {
			Borrow result = (Borrow) getHibernateTemplate().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}