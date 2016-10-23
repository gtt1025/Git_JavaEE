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

	// 查找图书
	public ActionForward searchBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象

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
		return mapping.findForward("faile");//将页面返回到前台主页
	}

	// 读者登录
	public ActionForward readerLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		String name = (String) dyForm.get("name");// 取得登录的帐号
		String password = (String) dyForm.get("password");// 取得登录的密码
		Reader reader = frontFacade.readerLogin(name, password);
		if (reader != null) {// 判断登录的用户名和密码是否正确
			HttpSession session = request.getSession();
			session.setAttribute("reader", reader);// 将用户信息放入Session对象中
			session.setAttribute("sessionData", "session");// 用于判断用户是否登录
			this.findBorrowedBooks(mapping, form, request, response);
			return mapping.findForward("success");//将页面返回到登录成功页面
		} else {
			this.showLiberInfo(mapping, form, request, response);//将页面返回到前台主页
		}
		request.setAttribute("flag", "ture");
		return mapping.findForward("faile");//将页面返回到前台主页
	}
	//退出登录
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			HttpSession session = request.getSession();
			session.setAttribute("reader", null);// 去除session
			session.setAttribute("sessionData", null);
			
			return mapping.findForward("faile");//将页面返回到前台主页
	}

	// 显示图书馆信息
	public ActionForward showLiberInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LiberInfo li = sysLiberInfoFacade.showLiberInfo();
		request.setAttribute("liberInfo", li);
		return mapping.findForward("faile");//将页面返回到前台主页
	}

	// 查看读者已借的图书
	public ActionForward findBorrowedBooks(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Reader reader = (Reader) request.getSession().getAttribute("reader");
		int readerId = reader.getId();
		List list = frontFacade.findBorrowedBooks(readerId);// 取得读者已借的图书列表
		request.setAttribute("borrowedBooksList", list);
		return mapping.findForward("showBorrowedBooks");//将页面返回到显示读者已借图书主页面
	}

	// 显示读者信息
	public ActionForward showReaderInformation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Reader reader = (Reader) request.getSession().getAttribute("reader");// 从Session中获得Reader对象
		int readerId = reader.getId();
		List list = (List) frontFacade.showReaderInformation(readerId);
		request.setAttribute("showReaderInfoList", list);
		return mapping.findForward("showReaderInfo");//将页面返回到修改读者信息页面
	}

	// 修改读者信息
	public ActionForward updateReaderInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得id
		String password = (String) dyForm.get("password");// 取得密码
		String tel = (String) dyForm.get("tel");// 取得联系电话
		String email = (String) dyForm.get("email");// 取得Email
		String description = (String) dyForm.get("description");// 取得备注
		Reader r = new Reader();
		r.setId(id);
		r.setPassword(password);
		r.setEmail(email);
		r.setTel(tel);
		r.setDescription(description);
		frontFacade.updateReaderInformation(r);// 更新读者信息
		ActionForward actForward = mapping.findForward("borrowedBooks");
		String path = actForward.getPath();
		path += "?method=findBorrowedBooks";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}

	// 续借
	public ActionForward renew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer borrowId = (Integer) dyForm.get("borrowId");// 取得id
		frontFacade.renew(borrowId);// 续借图书
		ActionForward actForward = mapping.findForward("borrowedBooks");
		String path = actForward.getPath();
		path += "?method=findBorrowedBooks";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交

	}

}
