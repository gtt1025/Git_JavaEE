package library.dao.operator;

import java.util.List;

import library.domain.operator.Operator;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* ��������Ϣ ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/
public class OperatorDAOImpl extends HibernateDaoSupport implements OperatorDAO {
   /**
    * <b>�����ݿ�����һ������Ա</b>
    * @param transientInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void save(Operator transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>ʹ��id����һ������Ա����Ϣ</b>
    * @param id
    * @return Operator
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>ʹ�ö�������Խ��м���</b>
    * @param propertyName value
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>�������й���Ա��Ϣ</b>
    * @param 
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>���¹���Ա��Ϣ</b>
    * @param detachedInstance
    * @return Operator
    * @exception �κ�δ����׽�ĵ��쳣
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