package library.dao.reader;

import java.util.List;

import library.domain.reader.Reader;
/**
* 读者信息 数据访问对象接口
* @author 0711103
* @version 1.0
*/


public interface ReaderDAO {
   /**
    * <b>新增读者</b>
    * @param transientInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */

	public void save(Reader transientInstance);
	/**
    * <b>删除读者</b>
    * @param persistentInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */

	public void delete(Reader persistentInstance);
	/**
    * <b>根据id检索读者信息记录</b>
    * @param id
    * @return  Reader
    * @exception 任何未被捕捉的的异常
    */

	public Reader findById(java.lang.Integer id);
	/**
    * <b>根据对象的属性检索读者信息记录</b>
    * @param propertyName value
    * @return  List
    * @exception 任何未被捕捉的的异常
    */

	public List<Reader> findByProperty(String propertyName, Object value);
	/**
    * <b>检索所有读者信息记录</b>
    * @param 
    * @return  List
    * @exception 任何未被捕捉的的异常
    */

	public List<Reader> findAll();
	/**
    * <b>根据页数检索读者信息记录</b>
    * @param first max
    * @return  List
    * @exception 任何未被捕捉的的异常
    */

	public List<Reader> findAllPage(Integer first, Integer max);
	/**
    * <b>得到读者实例</b>
    * @param detachedInstance
    * @return  Reader
    * @exception 任何未被捕捉的的异常
    */

	public Reader merge(Reader detachedInstance);

}