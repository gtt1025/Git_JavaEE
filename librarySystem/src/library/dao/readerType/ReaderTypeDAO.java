package library.dao.readerType;

import java.util.List;

import library.domain.readerType.ReaderType;
/**
* 读者类型 数据访问对象接口
* @author 0711103
* @version 1.0
*/

public interface ReaderTypeDAO {
   /**
    * <b>新增读者类型</b>
    * @param transientInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */

	public void save(ReaderType transientInstance);
	/**
    * <b>删除读者类型</b>
    * @param persistentInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */

	public void delete(ReaderType persistentInstance);
	/**
    * <b>根据id检索读者类型</b>
    * @param id
    * @return  ReaderType
    * @exception 任何未被捕捉的的异常
    */

	public ReaderType findById(java.lang.Integer id);
	/**
    * <b>检索所有读者类型</b>
    * @param 
    * @return  List
    * @exception 任何未被捕捉的的异常
    */

	public List<ReaderType> findAll();
	/**
    * <b>修改读者类型信息</b>
    * @param detachedInstance
    * @return  ReaderType
    * @exception 任何未被捕捉的的异常
    */

	public ReaderType merge(ReaderType detachedInstance);

}