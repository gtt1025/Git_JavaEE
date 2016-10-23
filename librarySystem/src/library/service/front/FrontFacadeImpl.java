package library.service.front;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import library.dao.barcode.BarcodeDAO;
import library.dao.book.BookDAO;
import library.dao.bookType.BookTypeDAO;
import library.dao.borrow.BorrowDAO;
import library.dao.reader.ReaderDAO;
import library.dao.readerType.ReaderTypeDAO;
import library.domain.barcode.Barcode;
import library.domain.book.Book;
import library.domain.bookType.BookType;
import library.domain.borrow.Borrow;
import library.domain.reader.Reader;
import library.util.Calculate;


public class FrontFacadeImpl implements FrontFacade {
	private BookDAO bookDAO;
	private ReaderDAO readerDAO;
	private BorrowDAO borrowDAO;
	private BarcodeDAO barcodeDAO;
	private BookTypeDAO bookTypeDAO;
	private ReaderTypeDAO readerTypeDAO;

	public ReaderTypeDAO getReaderTypeDAO() {
		return readerTypeDAO;
	}

	public void setReaderTypeDAO(ReaderTypeDAO readerTypeDAO) {
		this.readerTypeDAO = readerTypeDAO;
	}

	public BookTypeDAO getBookTypeDAO() {
		return bookTypeDAO;
	}

	public void setBookTypeDAO(BookTypeDAO bookTypeDAO) {
		this.bookTypeDAO = bookTypeDAO;
	}

	public BarcodeDAO getBarcodeDAO() {
		return barcodeDAO;
	}

	public void setBarcodeDAO(BarcodeDAO barcodeDAO) {
		this.barcodeDAO = barcodeDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public BorrowDAO getBorrowDAO() {
		return borrowDAO;
	}

	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public ReaderDAO getReaderDAO() {
		return readerDAO;
	}

	public void setReaderDAO(ReaderDAO readerDAO) {
		this.readerDAO = readerDAO;
	}

	// 查书
	public Object searchBook(String searchType, String[] bookProperties) {
		List<Object> l = new ArrayList<Object>();
		// 使用书名或出版社进行查询
		if (searchType.equals("bookName") || searchType.equals("publisher")) {
			// 先使用精确查询
			for (Book book : bookDAO.findByProperty(searchType,
					bookProperties[0])) {
				Iterator<Barcode> barcode = book.getBarcodeTs().iterator();
				BookType bookType = book.getBooktypeT();
				while (barcode.hasNext()) {
					int may = 1;
					Barcode b = barcode.next();
					Iterator<Borrow> borrow = b.getBorrowTs().iterator();
					while (borrow.hasNext()) {
						may = borrow.next().getGiveback();
					}
					List<Object> books = new ArrayList<Object>();
					// 将图书书信息，图书编号，是否可借，图书类型放入List中
					books.add(book);
					books.add(b);
					books.add(may);
					books.add(bookType);
					l.add(books);
				}
			}
			// 然后使用模糊查寻
			for (Book book : bookDAO.findByVagueProperty(searchType,
					bookProperties[0])) {
				Iterator<Barcode> barcode = book.getBarcodeTs().iterator();
				BookType bookType = book.getBooktypeT();
				while (barcode.hasNext()) {
					int may = 1;
					Barcode b = barcode.next();
					Iterator<Borrow> borrow = b.getBorrowTs().iterator();
					while (borrow.hasNext()) {
						may = borrow.next().getGiveback();
					}
					List<Object> books = new ArrayList<Object>();
					books.add(book);
					books.add(b);
					books.add(may);
					books.add(bookType);
					l.add(books);
				}
			}
			return l;
			// 使用作者名查
		} else if (searchType.equals("author")) {
			for (Book book : bookDAO.findByProperty(searchType,
					bookProperties[0])) {
				Iterator<Barcode> barcode = book.getBarcodeTs().iterator();
				BookType bookType = book.getBooktypeT();
				while (barcode.hasNext()) {
					int may = 1;
					Barcode b = barcode.next();
					Iterator<Borrow> borrow = b.getBorrowTs().iterator();
					while (borrow.hasNext()) {
						may = borrow.next().getGiveback();
					}
					List<Object> books = new ArrayList<Object>();
					books.add(book);
					books.add(b);
					books.add(may);
					books.add(bookType);
					l.add(books);
				}
			}
			return l;
			// 使用图书类型查
		} else if (searchType.equals("booktypeT")) {
			bookTypeDAO.findById(Integer.parseInt(bookProperties[0]));
			for (Book book : bookDAO.findByProperty(searchType, bookTypeDAO
					.findById(Integer.parseInt(bookProperties[0])))) {
				Iterator<Barcode> barcode = book.getBarcodeTs().iterator();
				BookType bookType = book.getBooktypeT();
				while (barcode.hasNext()) {
					int may = 1;
					Barcode b = barcode.next();
					Iterator<Borrow> borrow = b.getBorrowTs().iterator();
					while (borrow.hasNext()) {
						may = borrow.next().getGiveback();
					}
					List<Object> books = new ArrayList<Object>();
					books.add(book);
					books.add(b);
					books.add(may);
					books.add(bookType);
					l.add(books);
				}
			}
			return l;
			// 使用上架日期查
		} else if (searchType.equals("inTime")) {
			String stringDate1 = bookProperties[0];
			String stringDate2 = bookProperties[1];
			Calculate cc = new Calculate();
			// 日期参数的排序
			switch (cc.compare_date(bookProperties[0], bookProperties[1])) {
			case 1:
				break;
			case 0:
				Calendar c = Calendar.getInstance();

				try {

					c.setTime(new SimpleDateFormat("yyyy-MM-dd")
							.parse(stringDate2));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.add(Calendar.DAY_OF_MONTH, 1);
				// 设置日期格式
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
				stringDate2 = sdf.format(c.getTime()).toString().substring(0,
						10);
				break;
			case -1:
				stringDate2 = bookProperties[0];
				stringDate1 = bookProperties[1];
			}
			for (Book book : bookDAO.findByIntime(stringDate1, stringDate2)) {
				Iterator<Barcode> barcode = book.getBarcodeTs().iterator();
				BookType bookType = book.getBooktypeT();
				while (barcode.hasNext()) {
					int may = 1;
					Barcode b = barcode.next();
					Iterator<Borrow> borrow = b.getBorrowTs().iterator();
					while (borrow.hasNext()) {
						may = borrow.next().getGiveback();
					}
					List<Object> books = new ArrayList<Object>();
					books.add(book);
					books.add(b);
					books.add(may);
					books.add(bookType);
					l.add(books);
				}
			}
			return l;
		}
		return null;
	}

	// 读者登录
	public Reader readerLogin(String name, String password) {
		if (readerDAO.findByProperty("name", name).size() != 0
				&& readerDAO.findByProperty("name", name).get(0).getPassword()
						.equals(password)) {
			return readerDAO.findByProperty("name", name).get(0);
		}
		return null;
	}

	// 查看读者借且未还的书
	public List<Object> findBorrowedBooks(Integer readerId) {

		List<Object> list = new ArrayList<Object>();
		for (Borrow borrow : borrowDAO.findByTwoProperties("readerT", readerId,
				"giveback", "0")) {
			List<Object> l = new ArrayList<Object>();
			l.add(borrow);
			Date date1 = new Date();
			Date date2 = borrow.getForceBackTime();

			l
					.add(((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24)) + 1);

			list.add(l);
		}
		return list;
	}

	// 单查读者信息
	public Object showReaderInformation(Integer readerId) {
		Reader reader = readerDAO.findById(readerId);
		String type = reader.getReaderTypeT().getName();
		List<Object> list = new ArrayList<Object>();
		// 将读者类型和信息放入List中
		list.add(reader);
		list.add(type);
		return list;
	}

	// 修改读者信息
	public boolean updateReaderInformation(Reader reader) {

		try {
			Reader r = readerDAO.findById(reader.getId());
			r.setDescription(reader.getDescription());
			r.setEmail(reader.getEmail());
			r.setTel(reader.getTel());
			r.setPassword(reader.getPassword());
			readerDAO.merge(r);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// 续借
	public boolean renew(Integer borrowId) {
		try {
			Borrow borrow = borrowDAO.findById(borrowId);
			Calendar c = Calendar.getInstance();
			c.setTime(borrow.getForceBackTime());
			// 将还书日期延后30天
			c.add(Calendar.DAY_OF_MONTH, 30);
			Short s = 1;
			// 将续借字段renew设置为1，表示已经续借过
			borrow.setForceBackTime(c.getTime());
			borrow.setRenew(s);
			borrowDAO.merge(borrow);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
