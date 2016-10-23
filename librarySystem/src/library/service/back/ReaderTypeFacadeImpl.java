package library.service.back;

import java.util.List;

import library.dao.reader.ReaderDAO;
import library.dao.readerType.ReaderTypeDAO;
import library.domain.readerType.ReaderType;


public class ReaderTypeFacadeImpl implements ReaderTypeFacade {

	private ReaderTypeDAO readerTypeDAO;
	private ReaderDAO readerDAO;

	public ReaderTypeDAO getReaderTypeDAO() {
		return readerTypeDAO;
	}

	public void setReaderTypeDAO(ReaderTypeDAO readerTypeDAO) {
		this.readerTypeDAO = readerTypeDAO;
	}

	public ReaderDAO getReaderDAO() {
		return readerDAO;
	}

	public void setReaderDAO(ReaderDAO readerDAO) {
		this.readerDAO = readerDAO;
	}

	// �޸Ķ�������
	public boolean editReaderType(ReaderType readerType) {

		try {
			readerTypeDAO.findById(readerType.getId());
			readerTypeDAO.merge(readerType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// �������ж�������
	public List<ReaderType> findReaderType() {

		return readerTypeDAO.findAll();
	}

	// ������������
	public boolean newReaderType(ReaderType readerType) {

		try {
			readerTypeDAO.save(readerType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ɾ����������
	public boolean removeReaderType(ReaderType readerType) {

		if (readerDAO.findByProperty("readerTypeT", readerType).size() > 0) {
			return false;
		} else {
			readerTypeDAO.delete(readerType);
			return true;
		}
	}

	// ����ָ���Ķ�������
	public ReaderType showReaderType(ReaderType readerType) {

		return readerTypeDAO.findById(readerType.getId());
	}

}
