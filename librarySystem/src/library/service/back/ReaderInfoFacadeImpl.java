package library.service.back;

import java.util.List;

import library.dao.borrow.BorrowDAO;
import library.dao.operator.OperatorDAO;
import library.dao.reader.ReaderDAO;
import library.dao.readerType.ReaderTypeDAO;
import library.domain.reader.Reader;
import library.util.Calculate;


public class ReaderInfoFacadeImpl implements ReaderInfoFacade {

	private ReaderDAO readerDAO;
	private ReaderTypeDAO readerTypeDAO;
	private BorrowDAO borrowDAO;
	private OperatorDAO operatorDAO;

	public OperatorDAO getOperatorDAO() {
		return operatorDAO;
	}

	public void setOperatorDAO(OperatorDAO operatorDAO) {
		this.operatorDAO = operatorDAO;
	}

	public ReaderDAO getReaderDAO() {
		return readerDAO;
	}

	public void setReaderDAO(ReaderDAO readerDAO) {
		this.readerDAO = readerDAO;
	}

	public ReaderTypeDAO getReaderTypeDAO() {
		return readerTypeDAO;
	}

	public void setReaderTypeDAO(ReaderTypeDAO readerTypeDAO) {
		this.readerTypeDAO = readerTypeDAO;
	}

	public BorrowDAO getBorrowDAO() {
		return borrowDAO;
	}

	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}

	// 修改读者
	public boolean editReader(Reader reader) {

		Reader r = readerDAO.findById(reader.getId());
		r.setPaperNo(reader.getPaperNo());
		r.setPapertype(reader.getPapertype());
		r.setReaderTypeT(reader.getReaderTypeT());
		r.setRealName(reader.getRealName());
		r.setSex(reader.getSex());
		try {
			readerDAO.merge(r);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 全查读者
	public Object[] findReader(Integer page, Integer max) {
		// 总页数
		Integer pageNum = 0;
		if (readerDAO.findAll().size() % max == 0) {
			pageNum = readerDAO.findAll().size() / max;
		} else
			pageNum = readerDAO.findAll().size() / max + 1;
		List<Reader> list = readerDAO.findAllPage(max * (page - 1), max);
		Object[] o = new Object[2];
		o[0] = pageNum;
		o[1] = list;
		return o;
	}

	// 新增读者
	public boolean newReader(Reader reader) {

		Calculate cc = new Calculate();
		try {
			reader.setPassword("000000");// 设置读者的初始密码为000000
			readerDAO.save(reader);
			reader.setIdentiCode(cc.createReaderIdentiCode(reader.getId()));
			readerDAO.merge(reader);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// 删除读者
	public String removeReader(Reader reader) {

		Reader r = readerDAO.findById(reader.getId());
		if (r == null) {// 当前读者是否存在
			return "notexist";
		} else if (borrowDAO.findByProperty("readerT", r).size() == 0) {
			// 当前读者是否借过书
			readerDAO.delete(r);// 删除
			return "deletereader";
		} else {
			return "borrowed";
		}
	}

	// 使用id单查读者
	public Reader showReader(Reader reader) {

		return readerDAO.findById(reader.getId());
	}

}
