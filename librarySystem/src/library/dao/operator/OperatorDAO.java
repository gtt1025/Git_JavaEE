package library.dao.operator;

import java.util.List;

import library.domain.operator.Operator;
/**
* ��������Ϣ ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/

public interface OperatorDAO {
   /**
    * <b>�����ݿ�����һ������Ա</b>
    * @param transientInstance
    * @return  
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void save(Operator transientInstance);
	/**
    * <b>ʹ��id����һ������Ա����Ϣ</b>
    * @param id
    * @return Operator
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Operator findById(java.lang.Integer id);
	/**
    * <b>ʹ�ö�������Խ��м���</b>
    * @param propertyName value
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Operator> findByProperty(String propertyName, Object value);
	/**
    * <b>�������й���Ա��Ϣ</b>
    * @param 
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Operator> findAll();
	/**
    * <b>���¹���Ա��Ϣ</b>
    * @param detachedInstance
    * @return Operator
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Operator merge(Operator detachedInstance);

}