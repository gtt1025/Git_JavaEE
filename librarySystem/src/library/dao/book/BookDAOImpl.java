package library.dao.book;

import java.util.List;

import library.domain.book.Book;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* 图书 数据访问对象
* @author 0711103
* @version 1.0
*/


public class BookDAOImpl extends HibernateDaoSupport implements BookDAO {
   /**
    * <b>新增图书</b>
    * @param transientInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
    */
   
   public void save(Book transientInstance) {
      try {
         getHibernateTemplate().save(transientInstance);
      } catch (RuntimeException re) {
         throw re;
      }
   }


   /**
    * <b>删除图书</b>
    * @param persistentInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
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
    * <b>根据id检索图书</b>
    * @param id 
    * @return Book
    * @exception 任何未被捕捉的的异常
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
    * <b>根据属性检索图书</b>
    * @param propertyName value  
    * @return List
    * @exception 任何未被捕捉的的异常
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
    * <b>模糊查询</b>
    * @param propertyName value  
    * @return List
    * @exception 任何未被捕捉的的异常
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
    * <b>根据入馆时间检索图书信息</b>
    * @param begin end  
    * @return List
    * @exception 任何未被捕捉的的异常
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
    * <b>更新图书信息</b>
    * @param detachedInstance  
    * @return Book
    * @exception 任何未被捕捉的的异常
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