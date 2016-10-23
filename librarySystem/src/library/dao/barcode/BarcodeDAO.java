


package library.dao.barcode;

import java.util.List;

import library.domain.barcode.Barcode;

/**
* ͼ���� ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/

public interface BarcodeDAO {
   /**
    * <b>����ͼ����</b>
    * @param transientInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void save(Barcode transientInstance);
	
	/**
    * <b>ɾ��ͼ����</b>
    * @param persistentInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void delete(Barcode persistentInstance);
	
	/**
    * <b>����id����ͼ����</b>
    * @param id 
    * @return Barcode
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Barcode findById(java.lang.Integer id);
	
	/**
    * <b>���ݱ��ֵ���������Ϣ</b>
    * @param propertyName value 
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Barcode> findByProperty(String propertyName, Object value);
	/**
    * <b>��������ͼ����</b>
    * @param  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Barcode> findAll();
	/**
    * <b>����ҳ������ͼ����</b>
    * @param  first max
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Barcode> findAllPage(Integer first, Integer max);

}