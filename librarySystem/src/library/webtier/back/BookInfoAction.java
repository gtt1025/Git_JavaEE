package library.webtier.back;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.barcode.Barcode;
import library.domain.book.Book;
import library.domain.bookType.BookType;
import library.domain.operator.Operator;
import library.service.back.BookInfoFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class BookInfoAction extends DispatchAction {
	private BookInfoFacade bookInfoFacade;

	public BookInfoFacade getBookInfoFacade() {
		return bookInfoFacade;
	}

	public void setBookInfoFacade(BookInfoFacade bookInfoFacade) {
		this.bookInfoFacade = bookInfoFacade;
	}

	// ����ͼ��
	public ActionForward newBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		String bookname = (String) dyForm.get("bookname");// ȡ��ͼ������
		String author = (String) dyForm.get("author");// ȡ��ͼ������
		String publisher = (String) dyForm.get("publisher");// ȡ��ͼ�������
		float price = (Float) dyForm.get("price");// ȡ��ͼ��۸�
		int type = (Integer) dyForm.get("type");// ȡ������
		int num = (Integer) dyForm.get("num");// ȡ������ͼ������
		int operator = (Integer) dyForm.get("operator");// ȡ�ò���Ա�ʺ�
		Book book = new Book();
		book.setBookName(bookname);
		book.setAuthor(author);
		BookType bt = new BookType();
		bt.setId(type);
		book.setBooktypeT(bt);
		book.setInTime(new Date());
		Operator o = new Operator();
		o.setId(operator);
		book.setOperatorT(o);
		book.setPrice(price);
		book.setPublisher(publisher);
		bookInfoFacade.newBook(book, num);// ����BookTypeFacade����newBook()����

		ActionForward actForward = mapping.findForward("showALLBookInfo");
		String path = actForward.getPath();
		path += "?method=findAllBook";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ

	}

	// ����ͼ�����
	public ActionForward addNum(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ����Ҫ���ӵ�ͼ��id
		Integer num = (Integer) dyForm.get("num");// ȡ����Ҫ���ӵ�ͼ������
		Book book = new Book();
		book.setId(id);
		bookInfoFacade.addNum(book, num);
		ActionForward actForward = mapping.findForward("showALLBookInfo");
		String path = actForward.getPath();
		path += "?method=findAllBook";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}

	// ɾ��ͼ��
	public ActionForward removeBookBarcode(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");
		Barcode b = new Barcode();
		b.setId(id);
		String s = bookInfoFacade.removeBookBarcode(b);
		String error = "";
		if (s.equals("notexist")) {
			error = "ͼ���Ų�����";
		} else if (s.equals("deletebook")) {
			error = "�ѽ�������ɾ��";
		} else if (s.equals("deletebarcode")) {
			error = "��ɾ�������е�һ��";
		} else if (s.equals("borrowed")) {
			error = "ɾ��ʧ��";
		} else if (s.equals("error")) {
			error = "ɾ��ʧ��";
		}
		request.setAttribute("error", error);
		return mapping.findForward("error");// ������Ϣ��ʾҳ��
	}

	// ȫ��ͼ��
	public ActionForward findAllBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer page = (Integer) dyForm.get("page");// ȡ��ҳ��
		if (page == null) {
			page = 1;
		}
		Object[] o = bookInfoFacade.findBook(page, 20);
		Integer pageNum = (Integer) o[0];// ��ҳ��
		List<Barcode> lb = (List<Barcode>) o[1];
		request.setAttribute("pageNum", pageNum);// ��pageNum����Request������
		request.setAttribute("allBookList", lb);// ��lb����Request������
		// ����bookTypeFacade��findBook()����
		return mapping.findForward("showAllBook");// ����ά��ͼ����Ϣҳ��
	}

	// ����ͼ��
	public ActionForward showBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ��ͼ��id
		Barcode bc = new Barcode();
		bc.setId(id);
		bc = bookInfoFacade.showBook(bc);
		request.setAttribute("bc", bc);
		return mapping.findForward("updateBook");// ���ص�����ͼ����Ϣҳ��
	}

	// �޸�ͼ��
	public ActionForward editBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("bid");
		String bookname = (String) dyForm.get("bookname");// ȡ��ͼ������
		String author = (String) dyForm.get("author");// ȡ��ͼ������
		String publisher = (String) dyForm.get("publisher");// ȡ��ͼ�������
		float price = (Float) dyForm.get("price");// ȡ��ͼ��۸�
		int type = (Integer) dyForm.get("type");// ȡ������
		Book book = new Book();
		book.setAuthor(author);
		book.setBookName(bookname);
		book.setId(id);
		BookType bt = new BookType();
		bt.setId(type);
		book.setBooktypeT(bt);
		book.setPublisher(publisher);
		book.setPrice(price);
		bookInfoFacade.editBook(book);
		ActionForward actForward = mapping.findForward("showALLBookInfo");
		String path = actForward.getPath();
		path += "?method=findAllBook";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}

}