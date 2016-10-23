package library.service.back;

import java.util.List;

import library.dao.book.BookDAO;
import library.dao.bookType.BookTypeDAO;
import library.domain.bookType.BookType;


public class BookTypeFacadeImpl implements BookTypeFacade {

	private BookTypeDAO bookTypeDAO;// 图书类型Dao类
	private BookDAO bookDAO;//图书信息Dao类

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

	// 更新图书类型
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

	// 检索所有图书类型
	public List<BookType> findBookType() {
		return bookTypeDAO.findAll();
	}

	// 添加图书类型
	public boolean newBookType(BookType bookType) {
		try {
			bookTypeDAO.save(bookType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 删除图书类型
	public boolean removeBookType(BookType bookType) {
		if (bookDAO.findByProperty("booktypeT", bookType).size() > 0) {
			return false;
		} else {
			bookTypeDAO.delete(bookType);
			return true;
		}
	}

	// 检索单个图书类型
	public BookType showBookType(BookType bookType) {
		return bookTypeDAO.findById(bookType.getId());
	}

}
