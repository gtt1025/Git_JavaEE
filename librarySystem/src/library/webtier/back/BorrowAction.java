package library.webtier.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.borrow.Borrow;
import library.domain.operator.Operator;
import library.service.back.BorrowFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class BorrowAction extends DispatchAction {
	private BorrowFacade borrowFacade;

	public BorrowFacade getBorrowFacade() {
		return borrowFacade;
	}

	public void setBorrowFacade(BorrowFacade borrowFacade) {
		this.borrowFacade = borrowFacade;
	}

	// 借书
	public ActionForward borrowBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("operatorid");//取得管理员id
		String barcode = (String) dyForm.get("barcode");//图书编号
		String identiCode = (String) dyForm.get("identiCode");//借书证号
		Operator o = new Operator();
		o.setId(id);
		String s = borrowFacade.borrowBook(barcode, identiCode, o);
		String error = "";
		if (s.equals("readerOrBarcodeError")) {
			error = "图书编号或图书证号有错";
		} else if (s.equals("tooMany")) {
			error = "该读者借书量已达上限";
		} else if (s.equals("notIn")) {
			error = "当前图书已被借出";
		} else if (s.equals("success")) {
			error = "借阅成功";
		}
		request.setAttribute("error", error);
		return mapping.findForward("borrowBook");//转向借阅图书页面	
	}

	// 还书
	public ActionForward giveBackBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("operatorid");//取得管理员id
		String barcode = (String) dyForm.get("barcode");//图书编号
		Operator o = new Operator();
		o.setId(id);
		String s = borrowFacade.giveBackBook(barcode, o);

		String error = "";
		if (s.equals("barcodeError")) {
			error = "图书号错误";
		} else if (s.equals("notBorrow")) {
			error = "当前图书并没有被借出";
		} else if (s.equals("success")) {
			error = "还书成功";
		}
		request.setAttribute("error", error);
		return mapping.findForward("giveBack");//转向借阅图书页面
	}

	// 到期提醒
	public ActionForward warningBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Borrow> lb = borrowFacade.warningBack();
		request.setAttribute("lb", lb);

		return mapping.findForward("warningBack");//转向到期提醒页面
	}

	// 历史记录,显示已借出的图书和借书人信息等
	public ActionForward historyBorrowed(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		Integer page = (Integer) dyForm.get("page");//取得页数
		if (page == null) {
			page = 1;
		}
		Object[] o = borrowFacade.historyBorrowed(page, 20);
		Integer pageNum = (Integer) o[0];
		//;//总页数   	
		List<Borrow> lbr = (List<Borrow>) o[1];
		request.setAttribute("pageNum", pageNum);//将pageNum放入Request对象中
		request.setAttribute("borrwed", lbr);//将lbr放入Request对象中															
		return mapping.findForward("showBorrowedBook");//将页面转向历史记录页面
	}

}
