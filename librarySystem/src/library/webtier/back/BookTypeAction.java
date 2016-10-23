package library.webtier.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.bookType.BookType;
import library.service.back.BookTypeFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class BookTypeAction extends DispatchAction {
	private BookTypeFacade bookTypeFacade;

	public BookTypeFacade getBookTypeFacade() {
		return bookTypeFacade;
	}

	public void setBookTypeFacade(BookTypeFacade bookTypeFacade) {
		this.bookTypeFacade = bookTypeFacade;
	}

	// ����ͼ������
	public ActionForward addBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		String name = (String) dyForm.get("name");//ȡ��ͼ����������
		BookType bookType = new BookType();
		bookType.setName(name);
		bookTypeFacade.newBookType(bookType);

		ActionForward actForward = mapping.findForward("showType");
		String path = actForward.getPath();
		path += "?method=findBookType";//��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);//��ֹˢ���ύ		

	}

	// ɾ��ͼ������
	public ActionForward removeBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");//ȡ��ͼ������id
		BookType bt = new BookType();
		bt.setId(id);
		bookTypeFacade.removeBookType(bt);
		ActionForward actForward = mapping.findForward("showType");
		String path = actForward.getPath();
		path += "?method=findBookType";//��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);//��ֹˢ���ύ		

	}

	// ȫ��ͼ������
	public ActionForward findBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<BookType> list = bookTypeFacade.findBookType();
		request.setAttribute("bookTypeList", list);
		return mapping.findForward("showBookType");//���ص���ʾ����ͼ������ҳ��
	}

	// ����ͼ������
	public ActionForward showBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");//ȡ��ͼ������id
		BookType bookType = new BookType();
		bookType.setId(id);
		bookType = bookTypeFacade.showBookType(bookType);
		request.setAttribute("bookType", bookType);
		return mapping.findForward("updateBookType");
	}

	// �޸�ͼ������
	public ActionForward updateBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");//ȡ��ͼ������id
		String name = (String) dyForm.get("name");//ȡ��ͼ����������
		BookType bookType = new BookType();
		bookType.setId(id);
		bookType.setName(name);
		bookTypeFacade.editBookType(bookType);
		ActionForward actForward = mapping.findForward("showType");
		String path = actForward.getPath();
		path += "?method=findBookType";//��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);//��ֹˢ���ύ		

	}

}