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

	// 新增图书
	public ActionForward newBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		String bookname = (String) dyForm.get("bookname");// 取得图书名称
		String author = (String) dyForm.get("author");// 取得图书作者
		String publisher = (String) dyForm.get("publisher");// 取得图书出版社
		float price = (Float) dyForm.get("price");// 取得图书价格
		int type = (Integer) dyForm.get("type");// 取得类型
		int num = (Integer) dyForm.get("num");// 取得增加图书数量
		int operator = (Integer) dyForm.get("operator");// 取得操作员帐号
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
		bookInfoFacade.newBook(book, num);// 调用BookTypeFacade类中newBook()方法

		ActionForward actForward = mapping.findForward("showALLBookInfo");
		String path = actForward.getPath();
		path += "?method=findAllBook";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交

	}

	// 增加图书册数
	public ActionForward addNum(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得需要添加的图书id
		Integer num = (Integer) dyForm.get("num");// 取得需要添加的图书数量
		Book book = new Book();
		book.setId(id);
		bookInfoFacade.addNum(book, num);
		ActionForward actForward = mapping.findForward("showALLBookInfo");
		String path = actForward.getPath();
		path += "?method=findAllBook";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}

	// 删除图书
	public ActionForward removeBookBarcode(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");
		Barcode b = new Barcode();
		b.setId(id);
		String s = bookInfoFacade.removeBookBarcode(b);
		String error = "";
		if (s.equals("notexist")) {
			error = "图书编号不存在";
		} else if (s.equals("deletebook")) {
			error = "已将整本书删除";
		} else if (s.equals("deletebarcode")) {
			error = "已删除此书中的一册";
		} else if (s.equals("borrowed")) {
			error = "删除失败";
		} else if (s.equals("error")) {
			error = "删除失败";
		}
		request.setAttribute("error", error);
		return mapping.findForward("error");// 返回信息提示页面
	}

	// 全查图书
	public ActionForward findAllBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer page = (Integer) dyForm.get("page");// 取得页数
		if (page == null) {
			page = 1;
		}
		Object[] o = bookInfoFacade.findBook(page, 20);
		Integer pageNum = (Integer) o[0];// 总页数
		List<Barcode> lb = (List<Barcode>) o[1];
		request.setAttribute("pageNum", pageNum);// 将pageNum放入Request对象中
		request.setAttribute("allBookList", lb);// 将lb放入Request对象中
		// 调用bookTypeFacade中findBook()方法
		return mapping.findForward("showAllBook");// 返回维护图书信息页面
	}

	// 单查图书
	public ActionForward showBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得图书id
		Barcode bc = new Barcode();
		bc.setId(id);
		bc = bookInfoFacade.showBook(bc);
		request.setAttribute("bc", bc);
		return mapping.findForward("updateBook");// 返回到更新图书信息页面
	}

	// 修改图书
	public ActionForward editBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("bid");
		String bookname = (String) dyForm.get("bookname");// 取得图书名称
		String author = (String) dyForm.get("author");// 取得图书作者
		String publisher = (String) dyForm.get("publisher");// 取得图书出版社
		float price = (Float) dyForm.get("price");// 取得图书价格
		int type = (Integer) dyForm.get("type");// 取得类型
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
		path += "?method=findAllBook";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}

}
