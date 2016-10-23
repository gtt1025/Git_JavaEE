package library.dao.book;

import java.util.List;

import library.domain.book.Book;
/**
* 图书 数据访问对象接口
* @author 0711103
* @version 1.0
*/


public interface BookDAO {
   /**
    * <b>新增图书</b>
    * @param transientInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
    */
	public void save(Book transientInstance);
	/**
    * <b>删除图书</b>
    * @param persistentInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
    */

	public void delete(Book persistentInstance);
	/**
    * <b>根据id检索图书</b>
    * @param id 
    * @return Book
    * @exception 任何未被捕捉的的异常
    */

	public Book findById(java.lang.Integer id);
	/**
    * <b>根据属性检索图书</b>
    * @param propertyName value  
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Book> findByProperty(String propertyName, Object value);
	/**
    * <b>模糊查询</b>
    * @param propertyName value  
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Book> findByVagueProperty(String propertyName, Object value);
	/**
    * <b>根据入馆时间检索图书信息</b>
    * @param begin end  
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Book> findByIntime(String begin, String end);
	/**
    * <b>更新图书信息</b>
    * @param detachedInstance  
    * @return Book
    * @exception 任何未被捕捉的的异常
    */

	public Book merge(Book detachedInstance);

}