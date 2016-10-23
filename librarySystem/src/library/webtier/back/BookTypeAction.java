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

	// 新增图书类型
	public ActionForward addBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		String name = (String) dyForm.get("name");//取得图书类型名称
		BookType bookType = new BookType();
		bookType.setName(name);
		bookTypeFacade.newBookType(bookType);

		ActionForward actForward = mapping.findForward("showType");
		String path = actForward.getPath();
		path += "?method=findBookType";//需要传递的参数
		return new ActionForward(actForward.getName(), path, true);//防止刷新提交		

	}

	// 删除图书类型
	public ActionForward removeBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");//取得图书类型id
		BookType bt = new BookType();
		bt.setId(id);
		bookTypeFacade.removeBookType(bt);
		ActionForward actForward = mapping.findForward("showType");
		String path = actForward.getPath();
		path += "?method=findBookType";//需要传递的参数
		return new ActionForward(actForward.getName(), path, true);//防止刷新提交		

	}

	// 全查图书类型
	public ActionForward findBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<BookType> list = bookTypeFacade.findBookType();
		request.setAttribute("bookTypeList", list);
		return mapping.findForward("showBookType");//返回到显示所有图书类型页面
	}

	// 单查图书类型
	public ActionForward showBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");//取得图书类型id
		BookType bookType = new BookType();
		bookType.setId(id);
		bookType = bookTypeFacade.showBookType(bookType);
		request.setAttribute("bookType", bookType);
		return mapping.findForward("updateBookType");
	}

	// 修改图书类型
	public ActionForward updateBookType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");//取得图书类型id
		String name = (String) dyForm.get("name");//取得图书类型名称
		BookType bookType = new BookType();
		bookType.setId(id);
		bookType.setName(name);
		bookTypeFacade.editBookType(bookType);
		ActionForward actForward = mapping.findForward("showType");
		String path = actForward.getPath();
		path += "?method=findBookType";//需要传递的参数
		return new ActionForward(actForward.getName(), path, true);//防止刷新提交		

	}

}
