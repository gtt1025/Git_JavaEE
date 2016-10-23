package library.dao.liberInfo;


import library.domain.liberInfo.LiberInfo;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
* 图书馆信息 数据访问对象
* @author 0711103
* @version 1.0
*/

public class LiberInfoDAOImpl extends HibernateDaoSupport implements
		LiberInfoDAO {

   /**
    * <b>根据图书馆标识ID，查找图书馆信息</b>
    * @param id
    * @return LiberInfo 
    * @exception 任何未被捕捉的的异常
    */
	public LiberInfo findById(Integer id) {
		return (LiberInfo) getHibernateTemplate().find(
				"from LiberInfo where id=" + id).get(0);
	}


	/**
    * <b>更新图书馆信息</b>
    * @param liberInfo
    * @return boolean 
    * @exception 任何未被捕捉的的异常
    */
	public boolean merge(LiberInfo liberInfo) {
		getHibernateTemplate().merge(liberInfo);
		return true;
	}

}