package library.dao.borrow;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import library.domain.borrow.Borrow;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
* ������� ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/

public class BorrowDAOImpl extends HibernateDaoSupport implements BorrowDAO {


   /**
    * <b>����������ʷ��¼</b>
    * @param transientInstance  
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void save(Borrow transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>����id���������¼</b>
    * @param id  
    * @return Borrow
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>���������Ƿ��н���ͼ����ʷ��¼</b>
    * @param propertyName value
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����ָ�����ߵĽ������Ƿ��Ѿ��ﵽ����������</b>
    * @param propertyName1 value1 propertyName2 value2
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>������Щ���������ѵ��ڵ���δ�黹�ļ�¼</b>
    * @param s date
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public List<Borrow> findWarnings(Short s, Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
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
    * <b>�������еĽ���ͻ����¼</b>
    * @param 
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����ҳ����������ͻ����¼</b>
    * @param first max
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>ͼ������</b>
    * @param detachedInstance
    * @return Borrow 
    * @exception �κ�δ����׽�ĵ��쳣
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