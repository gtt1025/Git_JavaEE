package library.webtier.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.readerType.ReaderType;
import library.service.back.ReaderTypeFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class ReaderTypeAction extends DispatchAction {
	private ReaderTypeFacade readerTypeFacade;

	public ReaderTypeFacade getReaderTypeFacade() {
		return readerTypeFacade;
	}

	public void setReaderTypeFacade(ReaderTypeFacade readerTypeFacade) {
		this.readerTypeFacade = readerTypeFacade;
	}

	// ������������
	public ActionForward addReaderType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		String name = (String) dyForm.get("name");// ȡ�ö�����������
		Integer quantity = (Integer) dyForm.get("quantity");// ȡ�ÿɽ�ͼ������
		ReaderType rt = new ReaderType();
		rt.setName(name);
		rt.setQuantity(quantity);
		readerTypeFacade.newReaderType(rt);
		ActionForward actForward = mapping.findForward("showReaderTypes");
		String path = actForward.getPath();
		path += "?method=findReaderType";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}

	// ɾ����������
	public ActionForward removeReaderType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ��ͼ������
		ReaderType rt = new ReaderType();
		rt.setId(id);
		readerTypeFacade.removeReaderType(rt);
		ActionForward actForward = mapping.findForward("showReaderTypes");
		String path = actForward.getPath();
		path += "?method=findReaderType";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}

	// ȫ���������
	public ActionForward findReaderType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<ReaderType> lr = readerTypeFacade.findReaderType();
		request.setAttribute("allReaderType", lr);
		return mapping.findForward("showAllReaderType");
	}

	// �����������
	public ActionForward showReaderType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ��ͼ������
		ReaderType readerType = new ReaderType();
		readerType.setId(id);
		ReaderType rt = readerTypeFacade.showReaderType(readerType);
		request.setAttribute("readerType", rt);
		return mapping.findForward("updateReaderType");
	}

	// �޸Ķ�������
	public ActionForward updateReaderType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ��ͼ������
		String name = (String) dyForm.get("name");// ȡ�ö�����������
		Integer quantity = (Integer) dyForm.get("quantity");// ȡ�ÿɽ�ͼ������
		ReaderType rt = new ReaderType();
		rt.setId(id);
		rt.setName(name);
		rt.setQuantity(quantity);
		readerTypeFacade.editReaderType(rt);// ����readerTypeFacade��editReaderType()����
		ActionForward actForward = mapping.findForward("showReaderTypes");
		String path = actForward.getPath();
		path += "?method=findReaderType";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}
}