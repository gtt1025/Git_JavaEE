package library.service.back;

import library.domain.liberInfo.LiberInfo;

public interface SysLiberInfoFacade {
	// ����ͼ�����Ϣ
	public LiberInfo showLiberInfo();

	// �޸�ͼ�����Ϣ
	public boolean editLiberInfo(LiberInfo liberInfo);
}
