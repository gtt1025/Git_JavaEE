package library.dao.reader;

import java.util.List;

import library.domain.reader.Reader;
/**
* ������Ϣ ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/


public interface ReaderDAO {
   /**
    * <b>��������</b>
    * @param transientInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void save(Reader transientInstance);
	/**
    * <b>ɾ������</b>
    * @param persistentInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void delete(Reader persistentInstance);
	/**
    * <b>����id����������Ϣ��¼</b>
    * @param id
    * @return  Reader
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Reader findById(java.lang.Integer id);
	/**
    * <b>���ݶ�������Լ���������Ϣ��¼</b>
    * @param propertyName value
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Reader> findByProperty(String propertyName, Object value);
	/**
    * <b>�������ж�����Ϣ��¼</b>
    * @param 
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Reader> findAll();
	/**
    * <b>����ҳ������������Ϣ��¼</b>
    * @param first max
    * @return  List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Reader> findAllPage(Integer first, Integer max);
	/**
    * <b>�õ�����ʵ��</b>
    * @param detachedInstance
    * @return  Reader
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Reader merge(Reader detachedInstance);

}