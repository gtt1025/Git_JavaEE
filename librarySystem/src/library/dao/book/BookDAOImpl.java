package library.dao.book;

import java.util.List;

import library.domain.book.Book;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* ͼ�� ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/


public class BookDAOImpl extends HibernateDaoSupport implements BookDAO {
   /**
    * <b>����ͼ��</b>
    * @param transientInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */
   
   public void save(Book transientInstance) {
      try {
         getHibernateTemplate().save(transientInstance);
      } catch (RuntimeException re) {
         throw re;
      }
   }


   /**
    * <b>ɾ��ͼ��</b>
    * @param persistentInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */
   public void delete(Book persistentInstance) {
      try {
         Book b = (Book) this.getHibernateTemplate().load(Book.class,
               persistentInstance.getId());
         getHibernateTemplate().delete(b);
      } catch (RuntimeException re) {
         throw re;
      }
   }


   /**
    * <b>����id����ͼ��</b>
    * @param id 
    * @return Book
    * @exception �κ�δ����׽�ĵ��쳣
    */
   public Book findById(java.lang.Integer id) {
      try {
         Book instance = (Book) getHibernateTemplate().get(Book.class, id);
         return instance;
      } catch (RuntimeException re) {
         throw re;
      }
   }

   /**
    * <b>�������Լ���ͼ��</b>
    * @param propertyName value  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */
   public List<Book> findByProperty(String propertyName, Object value) {
      try {
         String queryString = "from Book as model where model."
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
    * <b>ģ����ѯ</b>
    * @param propertyName value  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */
   public List<Book> findByVagueProperty(String propertyName, Object value) {
      try {
         String queryString = "from Book as model where model."
               + propertyName + " like '%" + value + "%' and model."
               + propertyName + " !='" + value + "'";
         Query queryObject = getHibernateTemplate().getSessionFactory()
               .openSession().createQuery(queryString);
         return queryObject.list();
      } catch (RuntimeException re) {
         throw re;
      }

   }

   /**
    * <b>�������ʱ�����ͼ����Ϣ</b>
    * @param begin end  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */
   public List<Book> findByIntime(String begin, String end) {
      try {

         String queryString = "from Book as model where model.inTime between '"
               + begin + "' and '" + end + "'";
         Query queryObject = getHibernateTemplate().getSessionFactory()
               .openSession().createQuery(queryString);
         return queryObject.list();
      } catch (RuntimeException re) {
         throw re;
      }
   }


   /**
    * <b>����ͼ����Ϣ</b>
    * @param detachedInstance  
    * @return Book
    * @exception �κ�δ����׽�ĵ��쳣
    */
   public Book merge(Book detachedInstance) {
      try {
         Book result = (Book) getHibernateTemplate().merge(detachedInstance);
         return result;
      } catch (RuntimeException re) {
         throw re;
      }
   }
}