package library.dao.bookType;

import java.util.List;

import library.domain.bookType.BookType;

/**
* 图书类型 数据访问对象接口
* @author 0711103
* @version 1.0
*/
public interface BookTypeDAO {
   /**
    * <b>新增图书类型</b>
    * @param transientInstance  
    * @return 
    * @exception 任何未被捕捉的的异常
    */

	public void save(BookType transientInstance);
	/**
    * <b>删除图书类型</b>
    * @param persistentInstance  
    * @return 
    * @exception 任何未被捕捉的的异常
    */

	public void delete(BookType persistentInstance);
	/**
    * <b>根据id检索图书类型</b>
    * @param id  
    * @return BookType
    * @exception 任何未被捕捉的的异常
    */

	public BookType findById(java.lang.Integer id);
	/**
    * <b>检索图书类型</b>
    * @param  
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<BookType> findAll();
	/**
    * <b>更新图书类型</b>
    * @param  detachedInstance
    * @return BookType
    * @exception 任何未被捕捉的的异常
    */

	public BookType merge(BookType detachedInstance);

}