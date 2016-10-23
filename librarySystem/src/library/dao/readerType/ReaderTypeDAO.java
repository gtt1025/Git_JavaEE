package library.dao.readerType;

import java.util.List;

import library.domain.readerType.ReaderType;
/**
* �������� ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/

public interface ReaderTypeDAO {
   /**
    * <b>������������</b>
    * @param transientInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void save(ReaderType transientInstance);
	/**
    * <b>ɾ����������</b>
    * @param persistentInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void delete(ReaderType persistentInstance);
	/**
    * <b>����id������������</b>
    * @param id
    * @return  ReaderType
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public ReaderType findById(java.lang.Integer id);
	/**
    * <b>�������ж�������</b>
    * @param 
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<ReaderType> findAll();
	/**
    * <b>�޸Ķ���������Ϣ</b>
    * @param detachedInstance
    * @return  ReaderType
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public ReaderType merge(ReaderType detachedInstance);

}