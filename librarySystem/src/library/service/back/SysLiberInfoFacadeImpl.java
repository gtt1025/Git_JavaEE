package library.service.back;

import library.dao.liberInfo.LiberInfoDAO;
import library.domain.liberInfo.LiberInfo;

public class SysLiberInfoFacadeImpl implements SysLiberInfoFacade {
	private LiberInfoDAO liberInfoDAO;

	public LiberInfoDAO getLiberInfoDAO() {
		return liberInfoDAO;
	}

	public void setLiberInfoDAO(LiberInfoDAO liberInfoDAO) {
		this.liberInfoDAO = liberInfoDAO;
	}
	// 单查图书馆信息
	public LiberInfo showLiberInfo() {
		return liberInfoDAO.findById(1);
	}
	//修改图书馆信息
	public boolean editLiberInfo(LiberInfo liberInfo) {

		try {
			liberInfoDAO.merge(liberInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
