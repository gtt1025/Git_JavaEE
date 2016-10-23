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

	// �޸Ķ���
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

	// ȫ�����
	public Object[] findReader(Integer page, Integer max) {
		// ��ҳ��
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

	// ��������
	public boolean newReader(Reader reader) {

		Calculate cc = new Calculate();
		try {
			reader.setPassword("000000");// ���ö��ߵĳ�ʼ����Ϊ000000
			readerDAO.save(reader);
			reader.setIdentiCode(cc.createReaderIdentiCode(reader.getId()));
			readerDAO.merge(reader);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// ɾ������
	public String removeReader(Reader reader) {

		Reader r = readerDAO.findById(reader.getId());
		if (r == null) {// ��ǰ�����Ƿ����
			return "notexist";
		} else if (borrowDAO.findByProperty("readerT", r).size() == 0) {
			// ��ǰ�����Ƿ�����
			readerDAO.delete(r);// ɾ��
			return "deletereader";
		} else {
			return "borrowed";
		}
	}

	// ʹ��id�������
	public Reader showReader(Reader reader) {

		return readerDAO.findById(reader.getId());
	}

}