package library.dao.bookType;

import java.util.List;

import library.domain.bookType.BookType;

/**
* ͼ������ ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/
public interface BookTypeDAO {
   /**
    * <b>����ͼ������</b>
    * @param transientInstance  
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void save(BookType transientInstance);
	/**
    * <b>ɾ��ͼ������</b>
    * @param persistentInstance  
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void delete(BookType persistentInstance);
	/**
    * <b>����id����ͼ������</b>
    * @param id  
    * @return BookType
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public BookType findById(java.lang.Integer id);
	/**
    * <b>����ͼ������</b>
    * @param  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<BookType> findAll();
	/**
    * <b>����ͼ������</b>
    * @param  detachedInstance
    * @return BookType
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public BookType merge(BookType detachedInstance);

}