package library.dao.liberInfo;

import library.domain.liberInfo.LiberInfo;
/**
* 图书馆信息 数据访问对象接口
* @author 0711103
* @version 1.0
*/
public interface LiberInfoDAO {
   /**
    * <b>根据图书馆标识ID，查找图书馆信息</b>
    * @param id
    * @return LiberInfo 
    * @exception 任何未被捕捉的的异常
    */
	public LiberInfo findById(java.lang.Integer id);

	/**
    * <b>更新图书馆信息</b>
    * @param liberInfo
    * @return boolean 
    * @exception 任何未被捕捉的的异常
    */
	public boolean merge(LiberInfo liberInfo);
}