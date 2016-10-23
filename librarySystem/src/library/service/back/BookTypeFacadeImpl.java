package library.service.back;

import java.util.List;

import library.dao.book.BookDAO;
import library.dao.bookType.BookTypeDAO;
import library.domain.bookType.BookType;


public class BookTypeFacadeImpl implements BookTypeFacade {

	private BookTypeDAO bookTypeDAO;// ͼ������Dao��
	private BookDAO bookDAO;//ͼ����ϢDao��

	public BookTypeDAO getBookTypeDAO() {
		return bookTypeDAO;
	}

	public void setBookTypeDAO(BookTypeDAO bookTypeDAO) {
		this.bookTypeDAO = bookTypeDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	// ����ͼ������
	public boolean editBookType(BookType bookType) {
		try {
			bookTypeDAO.findById(bookType.getId());
			bookTypeDAO.merge(bookType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ��������ͼ������
	public List<BookType> findBookType() {
		return bookTypeDAO.findAll();
	}

	// ����ͼ������
	public boolean newBookType(BookType bookType) {
		try {
			bookTypeDAO.save(bookType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ɾ��ͼ������
	public boolean removeBookType(BookType bookType) {
		if (bookDAO.findByProperty("booktypeT", bookType).size() > 0) {
			return false;
		} else {
			bookTypeDAO.delete(bookType);
			return true;
		}
	}

	// ��������ͼ������
	public BookType showBookType(BookType bookType) {
		return bookTypeDAO.findById(bookType.getId());
	}

}