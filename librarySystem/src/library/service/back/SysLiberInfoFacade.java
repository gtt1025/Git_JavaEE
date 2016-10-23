package library.service.back;

import library.domain.liberInfo.LiberInfo;

public interface SysLiberInfoFacade {
	// 单查图书馆信息
	public LiberInfo showLiberInfo();

	// 修改图书馆信息
	public boolean editLiberInfo(LiberInfo liberInfo);
}
