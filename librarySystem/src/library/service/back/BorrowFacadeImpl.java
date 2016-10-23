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

	// ����
	public String borrowBook(String barcode, String identiCode,
			Operator operator) {
		// ���ߺź�����Ƿ���ȷ
		if (readerDAO.findByProperty("identiCode", identiCode).size() > 0
				&& barcodeDAO.findByProperty("barcode", barcode).size() > 0) {
			Reader reader = readerDAO.findByProperty("identiCode", identiCode)
					.get(0);
			Barcode bc = barcodeDAO.findByProperty("barcode", barcode).get(0);
			// ��ǰ���߽������Ƿ��Ѿ��ﵽ����������
			if (borrowDAO.findByTwoProperties("readerT", reader.getId(),
					"giveback", 0).size() >= reader.getReaderTypeT()
					.getQuantity()) {
				return "tooMany";
			}
			// ��ǰͼ���Ƿ��Ѿ������
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

	// ����
	public String giveBackBook(String barcode, Operator operator) {
		// ����Ƿ���ȷ
		if (barcodeDAO.findByProperty("barcode", barcode).size() > 0) {
			Barcode bc = barcodeDAO.findByProperty("barcode", barcode).get(0);
			if (borrowDAO.findByTwoProperties("barcodeT", bc.getId(),
					"giveback", 0).size() > 0) {
				Borrow br = borrowDAO.findByTwoProperties("barcodeT",
						bc.getId(), "giveback", 0).get(0);
				// ��ǰ���Ƿ�δ�����
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

	// ������ǰʱ������֮�ڵ��ڵ�ͼ��
	public List<Borrow> warningBack() {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, 5);
		Short s = 0;

		return borrowDAO.findWarnings(s, c.getTime());
	}

	// ������ʷ
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