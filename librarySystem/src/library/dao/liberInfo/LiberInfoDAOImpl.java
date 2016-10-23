package library.dao.liberInfo;


import library.domain.liberInfo.LiberInfo;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
* ͼ�����Ϣ ���ݷ��ʶ���
* @author 0711103
* @version 1.0
*/

public class LiberInfoDAOImpl extends HibernateDaoSupport implements
		LiberInfoDAO {

   /**
    * <b>����ͼ��ݱ�ʶID������ͼ�����Ϣ</b>
    * @param id
    * @return LiberInfo 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public LiberInfo findById(Integer id) {
		return (LiberInfo) getHibernateTemplate().find(
				"from LiberInfo where id=" + id).get(0);
	}


	/**
    * <b>����ͼ�����Ϣ</b>
    * @param liberInfo
    * @return boolean 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public boolean merge(LiberInfo liberInfo) {
		getHibernateTemplate().merge(liberInfo);
		return true;
	}

}