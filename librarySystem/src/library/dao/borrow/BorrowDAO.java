package library.dao.borrow;

import java.util.Date;
import java.util.List;

import library.domain.borrow.Borrow;
/**
* ������� ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/

public interface BorrowDAO {
   /**
    * <b>����������ʷ��¼</b>
    * @param transientInstance  
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void save(Borrow transientInstance);
	/**
    * <b>����id���������¼</b>
    * @param id  
    * @return Borrow
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Borrow findById(java.lang.Integer id);
	/**
    * <b>���������Ƿ��н���ͼ����ʷ��¼</b>
    * @param propertyName value
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Borrow> findByProperty(String propertyName, Object value);
	/**
    * <b>����ָ�����ߵĽ������Ƿ��Ѿ��ﵽ����������</b>
    * @param propertyName1 value1 propertyName2 value2
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Borrow> findByTwoProperties(String propertyName1,
			Object value1, String propertyName2, Object value2);
	/**
    * <b>������Щ���������ѵ��ڵ���δ�黹�ļ�¼</b>
    * @param s date
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Borrow> findWarnings(Short s, Date date);
	/**
    * <b>�������еĽ���ͻ����¼</b>
    * @param 
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Borrow> findAll();
	/**
    * <b>����ҳ����������ͻ����¼</b>
    * @param first max
    * @return List 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Borrow> findAllPage(Integer first, Integer max);
	/**
    * <b>ͼ������</b>
    * @param detachedInstance
    * @return Borrow 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Borrow merge(Borrow detachedInstance);

}