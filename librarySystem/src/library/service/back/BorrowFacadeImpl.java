package library.service.back;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import library.dao.barcode.BarcodeDAO;
import library.dao.book.BookDAO;
import library.dao.borrow.BorrowDAO;
import library.dao.operator.OperatorDAO;
import library.dao.reader.ReaderDAO;
import library.domain.barcode.Barcode;
import library.domain.borrow.Borrow;
import library.domain.operator.Operator;
import library.domain.reader.Reader;


public class BorrowFacadeImpl implements BorrowFacade {

	private ReaderDAO readerDAO;
	private BorrowDAO borrowDAO;
	private BarcodeDAO barcodeDAO;
	private BookDAO bookDAO;
	private OperatorDAO operatorDAO;

	public BookDAO getBookDAO() {
		return bookDAO;
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

	public BorrowDAO getBorrowDAO() {
		return borrowDAO;
	}

	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}

	public BarcodeDAO getBarcodeDAO() {
		return barcodeDAO;
	}

	public void setBarcodeDAO(BarcodeDAO barcodeDAO) {
		this.barcodeDAO = barcodeDAO;
	}

	public OperatorDAO getOperatorDAO() {
		return operatorDAO;
	}

	public void setOperatorDAO(OperatorDAO operatorDAO) {
		this.operatorDAO = operatorDAO;
	}

	// 借书
	public String borrowBook(String barcode, String identiCode,
			Operator operator) {
		// 读者号和书号是否正确
		if (readerDAO.findByProperty("identiCode", identiCode).size() > 0
				&& barcodeDAO.findByProperty("barcode", barcode).size() > 0) {
			Reader reader = readerDAO.findByProperty("identiCode", identiCode)
					.get(0);
			Barcode bc = barcodeDAO.findByProperty("barcode", barcode).get(0);
			// 当前读者借书量是否已经达到其最大借书量
			if (borrowDAO.findByTwoProperties("readerT", reader.getId(),
					"giveback", 0).size() >= reader.getReaderTypeT()
					.getQuantity()) {
				return "tooMany";
			}
			// 当前图书是否已经被借出
			if (borrowDAO.findByTwoProperties("barcodeT", bc.getId(),
					"giveback", 0).size() > 0) {
				return "notIn";
			}
			Borrow borrow = new Borrow();
			borrow.setBarcodeT(bc);
			borrow.setBorrowTime(new Date());
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.DAY_OF_MONTH, 30);
			borrow.setForceBackTime(c.getTime());
			Short s = 0;
			borrow.setGiveback(s);
			borrow.setGivebackTime(null);
			borrow.setOperatorTByBorrowOperator(operator);
			borrow.setOperatorTByGivebackOperator(null);
			borrow.setReaderT(reader);
			borrow.setRenew(s);
			borrowDAO.save(borrow);
			return "success";
		}

		return "readerOrBarcodeError";
	}

	// 还书
	public String giveBackBook(String barcode, Operator operator) {
		// 书号是否正确
		if (barcodeDAO.findByProperty("barcode", barcode).size() > 0) {
			Barcode bc = barcodeDAO.findByProperty("barcode", barcode).get(0);
			if (borrowDAO.findByTwoProperties("barcodeT", bc.getId(),
					"giveback", 0).size() > 0) {
				Borrow br = borrowDAO.findByTwoProperties("barcodeT",
						bc.getId(), "giveback", 0).get(0);
				// 当前书是否未被借出
				Short s = 1;
				br.setGiveback(s);
				br.setGivebackTime(new Date());
				br.setOperatorTByGivebackOperator(operator);
				br.setRenew(s);
				borrowDAO.merge(br);
				return "success";
			} else {
				return "notBorrow";
			}
		}
		return "barcodeError";
	}

	// 检索当前时间五天之内到期的图书
	public List<Borrow> warningBack() {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, 5);
		Short s = 0;

		return borrowDAO.findWarnings(s, c.getTime());
	}

	// 借书历史
	public Object[] historyBorrowed(Integer page, Integer max) {
		Integer pageNum = 0;
		if (borrowDAO.findAll().size() % max == 0) {
			pageNum = borrowDAO.findAll().size() / max;
		} else
			pageNum = borrowDAO.findAll().size() / max + 1;
		Object[] o = new Object[2];
		o[0] = pageNum;
		o[1] = borrowDAO.findAllPage(max * (page - 1), max);
		return o;
	}
}
