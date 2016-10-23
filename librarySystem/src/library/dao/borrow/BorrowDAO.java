package library.dao.borrow;

import java.util.Date;
import java.util.List;

import library.domain.borrow.Borrow;
/**
* 借书情况 数据访问对象接口
* @author 0711103
* @version 1.0
*/

public interface BorrowDAO {
   /**
    * <b>新增借阅历史记录</b>
    * @param transientInstance  
    * @return 
    * @exception 任何未被捕捉的的异常
    */
	public void save(Borrow transientInstance);
	/**
    * <b>根据id检索借书记录</b>
    * @param id  
    * @return Borrow
    * @exception 任何未被捕捉的的异常
    */

	public Borrow findById(java.lang.Integer id);
	/**
    * <b>检索读者是否有借阅图书历史记录</b>
    * @param propertyName value
    * @return List 
    * @exception 任何未被捕捉的的异常
    */

	public List<Borrow> findByProperty(String propertyName, Object value);
	/**
    * <b>检索指定读者的借书量是否已经达到其最大借书量</b>
    * @param propertyName1 value1 propertyName2 value2
    * @return List 
    * @exception 任何未被捕捉的的异常
    */

	public List<Borrow> findByTwoProperties(String propertyName1,
			Object value1, String propertyName2, Object value2);
	/**
    * <b>检索那些借书日期已到期但尚未归还的记录</b>
    * @param s date
    * @return List 
    * @exception 任何未被捕捉的的异常
    */

	public List<Borrow> findWarnings(Short s, Date date);
	/**
    * <b>检索所有的借书和还书记录</b>
    * @param 
    * @return List 
    * @exception 任何未被捕捉的的异常
    */

	public List<Borrow> findAll();
	/**
    * <b>根据页数检索借书和还书记录</b>
    * @param first max
    * @return List 
    * @exception 任何未被捕捉的的异常
    */

	public List<Borrow> findAllPage(Integer first, Integer max);
	/**
    * <b>图书续借</b>
    * @param detachedInstance
    * @return Borrow 
    * @exception 任何未被捕捉的的异常
    */

	public Borrow merge(Borrow detachedInstance);

}