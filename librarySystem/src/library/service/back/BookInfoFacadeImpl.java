package library.service.back;

import java.util.List;

import library.dao.barcode.BarcodeDAO;
import library.dao.book.BookDAO;
import library.dao.bookType.BookTypeDAO;
import library.dao.borrow.BorrowDAO;
import library.dao.operator.OperatorDAO;
import library.domain.barcode.Barcode;
import library.domain.book.Book;
import library.util.Calculate;


public class BookInfoFacadeImpl implements BookInfoFacade {

	private BookDAO bookDAO;
	private BookTypeDAO bookTypeDAO;
	private BorrowDAO borrowDAO;
	private BarcodeDAO barcodeDAO;
	private OperatorDAO operatorDAO;

	public OperatorDAO getOperatorDAO() {
		return operatorDAO;
	}

	public void setOperatorDAO(OperatorDAO operatorDAO) {
		this.operatorDAO = operatorDAO;
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

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public BookTypeDAO getBookTypeDAO() {
		return bookTypeDAO;
	}

	public void setBookTypeDAO(BookTypeDAO bookTypeDAO) {
		this.bookTypeDAO = bookTypeDAO;
	}

	public BorrowDAO getBorrowDAO() {
		return borrowDAO;
	}

	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}

	// ����ͼ����Ϣ
	public boolean editBook(Book book) {
		Book b = bookDAO.findById(book.getId());
		b.setAuthor(book.getAuthor());
		b.setBookName(book.getBookName());
		b.setPublisher(book.getPublisher());
		b.setPrice(book.getPrice());
		b.setBooktypeT(book.getBooktypeT());
		try {
			bookDAO.merge(b);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ����ȫ��ͼ��
	public Object[] findBook(Integer page, Integer max) {
		// ������ҳ��
		Integer pageNum = 0;
		if (barcodeDAO.findAll().size() % max == 0) {
			pageNum = barcodeDAO.findAll().size() / max;
		} else
			pageNum = barcodeDAO.findAll().size() / max + 1;
		List<Barcode> list = barcodeDAO.findAllPage(max * (page - 1), max);
		// ����ҳ���Ͳ����List�ŵ�O��
		Object[] o = new Object[2];
		o[0] = pageNum;
		o[1] = list;
		return o;
	}

	// ����ͼ��
	public boolean newBook(Book book, Integer num) {
		bookDAO.save(book);
		for (int i = 1; i <= num; i++) {
			Calculate cc = new Calculate();
			Barcode b = new Barcode();
			b.setBookT(book);
			b.setBarcode(cc.createBarcode(book.getBooktypeT().getId(), book
					.getId(), i));
			barcodeDAO.save(b);
		}

		return true;
	}

	// ����ͼ������
	public boolean addNum(Book book, Integer num) {
		// �õ���ǰ�Ѿ����ڵ�ͼ������
		int existNum = Integer.parseInt(barcodeDAO
				.findByProperty("bookT", book).get(
						barcodeDAO.findByProperty("bookT", book).size() - 1)
				.getBarcode().substring(6));
		Book b = bookDAO.findById(book.getId());
		// ����
		for (int i = existNum + 1; i <= existNum + num; i++) {
			Calculate cc = new Calculate();
			Barcode barcode = new Barcode();
			barcode.setBookT(book);
			barcode.setBarcode(cc.createBarcode(b.getBooktypeT().getId(), book
					.getId(), i));
			barcodeDAO.save(barcode);
		}
		return false;
	}

	// ɾ��һ��ͼ��
	public String removeBookBarcode(Barcode barcode) {

		Barcode b = barcodeDAO.findById(barcode.getId());
		List<Barcode> lb = barcodeDAO.findByProperty("bookT", b.getBookT());
		// �ж�Barcode�Ƿ����
		if (lb.size() == 0) {
			return "notexist";
		} else if (borrowDAO.findByProperty("barcodeT", b).size() == 0) {
			if (lb.size() == 1) {
				barcodeDAO.delete(b);
				bookDAO.delete(lb.get(0).getBookT());
				// ��ǰBarcode�Ƿ�Ϊ���������е�Ψһһ��
				return "deletebook";
			} else if (lb.size() > 1) {
				barcodeDAO.delete(b);
				return "deletebarcode";
			}
		} else {
			return "borrowed";
		}
		return "error";
	}

	// ʹ��id����ͼ��
	public Barcode showBook(Barcode barcode) {
		return barcodeDAO.findById(barcode.getId());
	}

}