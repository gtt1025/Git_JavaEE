package library.dao.operator;

import java.util.List;

import library.domain.operator.Operator;
/**
* 操作者信息 数据访问对象接口
* @author 0711103
* @version 1.0
*/

public interface OperatorDAO {
   /**
    * <b>向数据库新增一个管理员</b>
    * @param transientInstance
    * @return  
    * @exception 任何未被捕捉的的异常
    */

	public void save(Operator transientInstance);
	/**
    * <b>使用id检索一个管理员的信息</b>
    * @param id
    * @return Operator
    * @exception 任何未被捕捉的的异常
    */

	public Operator findById(java.lang.Integer id);
	/**
    * <b>使用对象的属性进行检索</b>
    * @param propertyName value
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Operator> findByProperty(String propertyName, Object value);
	/**
    * <b>检索所有管理员信息</b>
    * @param 
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Operator> findAll();
	/**
    * <b>更新管理员信息</b>
    * @param detachedInstance
    * @return Operator
    * @exception 任何未被捕捉的的异常
    */

	public Operator merge(Operator detachedInstance);

}