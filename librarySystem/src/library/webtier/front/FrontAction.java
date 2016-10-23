package library.webtier.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.domain.liberInfo.LiberInfo;
import library.domain.reader.Reader;
import library.service.back.SysLiberInfoFacade;
import library.service.front.FrontFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class FrontAction extends DispatchAction {
	private FrontFacade frontFacade;
	private SysLiberInfoFacade sysLiberInfoFacade;

	public FrontFacade getFrontFacade() {
		return frontFacade;
	}

	public void setFrontFacade(FrontFacade frontFacade) {
		this.frontFacade = frontFacade;
	}

	public SysLiberInfoFacade getSysLiberInfoFacade() {
		return sysLiberInfoFacade;
	}

	public void setSysLiberInfoFacade(SysLiberInfoFacade sysLiberInfoFacade) {
		this.sysLiberInfoFacade = sysLiberInfoFacade;
	}

	// ����ͼ��
	public ActionForward searchBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����

		String typer = (String) dyForm.get("typer");//
		String begin = (String) dyForm.get("begin");//
		String end = (String) dyForm.get("end");//
		String bookTypes = (String) dyForm.get("bookTypes");//
		String theName = (String) dyForm.get("theName");//
		String messages[] = new String[5];
		if (typer.equals("author") || typer.equals("publisher")
				|| typer.equals("bookName")) {
			messages[0] = theName;
		} else if (typer.equals("booktypeT")) {
			messages[0] = bookTypes;
		} else if (typer.equals("inTime")) {
			messages[0] = begin;
			messages[1] = end;
		}
		Object lo = frontFacade.searchBook(typer, messages);
		List l = (List) lo;
		request.setAttribute("search", l);
		return mapping.findForward("faile");//��ҳ�淵�ص�ǰ̨��ҳ
	}

	// ���ߵ�¼
	public ActionForward readerLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		String name = (String) dyForm.get("name");// ȡ�õ�¼���ʺ�
		String password = (String) dyForm.get("password");// ȡ�õ�¼������
		Reader reader = frontFacade.readerLogin(name, password);
		if (reader != null) {// �жϵ�¼���û����������Ƿ���ȷ
			HttpSession session = request.getSession();
			session.setAttribute("reader", reader);// ���û���Ϣ����Session������
			session.setAttribute("sessionData", "session");// �����ж��û��Ƿ��¼
			this.findBorrowedBooks(mapping, form, request, response);
			return mapping.findForward("success");//��ҳ�淵�ص���¼�ɹ�ҳ��
		} else {
			this.showLiberInfo(mapping, form, request, response);//��ҳ�淵�ص�ǰ̨��ҳ
		}
		request.setAttribute("flag", "ture");
		return mapping.findForward("faile");//��ҳ�淵�ص�ǰ̨��ҳ
	}
	//�˳���¼
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			HttpSession session = request.getSession();
			session.setAttribute("reader", null);// ȥ��session
			session.setAttribute("sessionData", null);
			
			return mapping.findForward("faile");//��ҳ�淵�ص�ǰ̨��ҳ
	}

	// ��ʾͼ�����Ϣ
	public ActionForward showLiberInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LiberInfo li = sysLiberInfoFacade.showLiberInfo();
		request.setAttribute("liberInfo", li);
		return mapping.findForward("faile");//��ҳ�淵�ص�ǰ̨��ҳ
	}

	// �鿴�����ѽ��ͼ��
	public ActionForward findBorrowedBooks(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Reader reader = (Reader) request.getSession().getAttribute("reader");
		int readerId = reader.getId();
		List list = frontFacade.findBorrowedBooks(readerId);// ȡ�ö����ѽ��ͼ���б�
		request.setAttribute("borrowedBooksList", list);
		return mapping.findForward("showBorrowedBooks");//��ҳ�淵�ص���ʾ�����ѽ�ͼ����ҳ��
	}

	// ��ʾ������Ϣ
	public ActionForward showReaderInformation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Reader reader = (Reader) request.getSession().getAttribute("reader");// ��Session�л��Reader����
		int readerId = reader.getId();
		List list = (List) frontFacade.showReaderInformation(readerId);
		request.setAttribute("showReaderInfoList", list);
		return mapping.findForward("showReaderInfo");//��ҳ�淵�ص��޸Ķ�����Ϣҳ��
	}

	// �޸Ķ�����Ϣ
	public ActionForward updateReaderInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ��id
		String password = (String) dyForm.get("password");// ȡ������
		String tel = (String) dyForm.get("tel");// ȡ����ϵ�绰
		String email = (String) dyForm.get("email");// ȡ��Email
		String description = (String) dyForm.get("description");// ȡ�ñ�ע
		Reader r = new Reader();
		r.setId(id);
		r.setPassword(password);
		r.setEmail(email);
		r.setTel(tel);
		r.setDescription(description);
		frontFacade.updateReaderInformation(r);// ���¶�����Ϣ
		ActionForward actForward = mapping.findForward("borrowedBooks");
		String path = actForward.getPath();
		path += "?method=findBorrowedBooks";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}

	// ����
	public ActionForward renew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer borrowId = (Integer) dyForm.get("borrowId");// ȡ��id
		frontFacade.renew(borrowId);// ����ͼ��
		ActionForward actForward = mapping.findForward("borrowedBooks");
		String path = actForward.getPath();
		path += "?method=findBorrowedBooks";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ

	}

}