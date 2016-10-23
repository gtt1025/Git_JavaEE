

package library.dao.barcode;

import java.util.List;

import library.domain.barcode.Barcode;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
* ͼ���� ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/

public class BarcodeDAOImpl extends HibernateDaoSupport implements BarcodeDAO {

   /**
    * <b>����ͼ����</b>
    * @param transientInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void save(Barcode transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	/**
    * <b>ɾ��ͼ����</b>
    * @param persistentInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����id����ͼ����</b>
    * @param id 
    * @return Barcode
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>���ݱ��ֵ���������Ϣ</b>
    * @param propertyName value 
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>��������ͼ����</b>
    * @param  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
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
    * <b>����ҳ������ͼ����</b>
    * @param  first max
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
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