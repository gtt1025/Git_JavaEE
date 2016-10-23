package library.dao.readerType;

import java.util.List;

import library.domain.readerType.ReaderType;


import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* �������� ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/
public class ReaderTypeDAOImpl extends HibernateDaoSupport implements
		ReaderTypeDAO {
   /**
    * <b>������������</b>
    * @param transientInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void save(ReaderType transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>ɾ����������</b>
    * @param persistentInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void delete(ReaderType persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
    * <b>����id������������</b>
    * @param id
    * @return  ReaderType
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>�������ж�������</b>
    * @param 
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>�޸Ķ���������Ϣ</b>
    * @param detachedInstance
    * @return  ReaderType
    * @exception �κ�δ����׽�ĵ��쳣
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