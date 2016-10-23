package library.dao.operator;

import java.util.List;

import library.domain.operator.Operator;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* 操作者信息 数据访问对象
* @author 0711103
* @version 1.0
*/
public class OperatorDAOImpl extends HibernateDaoSupport implements OperatorDAO {
   /**
    * <b>向数据库新增一个管理员</b>
    * @param transientInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */
	public void save(Operator transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>使用id检索一个管理员的信息</b>
    * @param id
    * @return Operator
    * @exception 任何未被捕捉的的异常
    */
	public Operator findById(java.lang.Integer id) {
		try {
			Operator instance = (Operator) getHibernateTemplate().get(
					Operator.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>使用对象的属性进行检索</b>
    * @param propertyName value
    * @return List
    * @exception 任何未被捕捉的的异常
    */
	public List<Operator> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Operator as model where model."
					+ propertyName + "= ?";
			List<Operator> result = getHibernateTemplate().find(queryString,
					value);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>检索所有管理员信息</b>
    * @param 
    * @return List
    * @exception 任何未被捕捉的的异常
    */
	public List<Operator> findAll() {
		try {
			String queryString = "from Operator";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>更新管理员信息</b>
    * @param detachedInstance
    * @return Operator
    * @exception 任何未被捕捉的的异常
    */
	public Operator merge(Operator detachedInstance) {
		try {
			Operator result = (Operator) getHibernateTemplate().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}