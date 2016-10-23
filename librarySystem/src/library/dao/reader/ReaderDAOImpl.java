package library.dao.reader;

import java.util.List;


import library.domain.reader.Reader;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* ������Ϣ ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/
public class ReaderDAOImpl extends HibernateDaoSupport implements ReaderDAO {

   /**
    * <b>��������</b>
    * @param transientInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void save(Reader transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>ɾ������</b>
    * @param persistentInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����id����������Ϣ��¼</b>
    * @param id
    * @return  Reader
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>���ݶ�������Լ���������Ϣ��¼</b>
    * @param propertyName value
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>�������ж�����Ϣ��¼</b>
    * @param 
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����ҳ������������Ϣ��¼</b>
    * @param first max
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>�õ�����ʵ��</b>
    * @param detachedInstance
    * @return  Reader
    * @exception �κ�δ����׽�ĵ��쳣
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