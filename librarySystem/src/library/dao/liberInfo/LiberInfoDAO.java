package library.dao.liberInfo;

import library.domain.liberInfo.LiberInfo;
/**
* ͼ�����Ϣ ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/
public interface LiberInfoDAO {
   /**
    * <b>����ͼ��ݱ�ʶID������ͼ�����Ϣ</b>
    * @param id
    * @return LiberInfo 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public LiberInfo findById(java.lang.Integer id);

	/**
    * <b>����ͼ�����Ϣ</b>
    * @param liberInfo
    * @return boolean 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public boolean merge(LiberInfo liberInfo);
}