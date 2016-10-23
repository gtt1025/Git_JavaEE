package library.dao.book;

import java.util.List;

import library.domain.book.Book;
/**
* ͼ�� ���ݷ��ʶ���ӿ�
* @author 0711103
* @version 1.0
*/


public interface BookDAO {
   /**
    * <b>����ͼ��</b>
    * @param transientInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */
	public void save(Book transientInstance);
	/**
    * <b>ɾ��ͼ��</b>
    * @param persistentInstance 
    * @return 
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public void delete(Book persistentInstance);
	/**
    * <b>����id����ͼ��</b>
    * @param id 
    * @return Book
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Book findById(java.lang.Integer id);
	/**
    * <b>�������Լ���ͼ��</b>
    * @param propertyName value  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Book> findByProperty(String propertyName, Object value);
	/**
    * <b>ģ����ѯ</b>
    * @param propertyName value  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Book> findByVagueProperty(String propertyName, Object value);
	/**
    * <b>�������ʱ�����ͼ����Ϣ</b>
    * @param begin end  
    * @return List
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public List<Book> findByIntime(String begin, String end);
	/**
    * <b>����ͼ����Ϣ</b>
    * @param detachedInstance  
    * @return Book
    * @exception �κ�δ����׽�ĵ��쳣
    */

	public Book merge(Book detachedInstance);

}