


package library.dao.barcode;

import java.util.List;

import library.domain.barcode.Barcode;

/**
* 图书编号 数据访问对象接口
* @author 0711103
* @version 1.0
*/

public interface BarcodeDAO {
   /**
    * <b>保存图书编号</b>
    * @param transientInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
    */

	public void save(Barcode transientInstance);
	
	/**
    * <b>删除图书编号</b>
    * @param persistentInstance 
    * @return 
    * @exception 任何未被捕捉的的异常
    */

	public void delete(Barcode persistentInstance);
	
	/**
    * <b>根据id检索图书编号</b>
    * @param id 
    * @return Barcode
    * @exception 任何未被捕捉的的异常
    */

	public Barcode findById(java.lang.Integer id);
	
	/**
    * <b>根据编号值检索编号信息</b>
    * @param propertyName value 
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Barcode> findByProperty(String propertyName, Object value);
	/**
    * <b>检索所有图书编号</b>
    * @param  
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Barcode> findAll();
	/**
    * <b>根据页数检索图书编号</b>
    * @param  first max
    * @return List
    * @exception 任何未被捕捉的的异常
    */

	public List<Barcode> findAllPage(Integer first, Integer max);

}