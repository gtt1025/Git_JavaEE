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

	// ����
	public ActionForward borrowBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("operatorid");//ȡ�ù���Աid
		String barcode = (String) dyForm.get("barcode");//ͼ����
		String identiCode = (String) dyForm.get("identiCode");//����֤��
		Operator o = new Operator();
		o.setId(id);
		String s = borrowFacade.borrowBook(barcode, identiCode, o);
		String error = "";
		if (s.equals("readerOrBarcodeError")) {
			error = "ͼ���Ż�ͼ��֤���д�";
		} else if (s.equals("tooMany")) {
			error = "�ö��߽������Ѵ�����";
		} else if (s.equals("notIn")) {
			error = "��ǰͼ���ѱ����";
		} else if (s.equals("success")) {
			error = "���ĳɹ�";
		}
		request.setAttribute("error", error);
		return mapping.findForward("borrowBook");//ת�����ͼ��ҳ��	
	}

	// ����
	public ActionForward giveBackBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("operatorid");//ȡ�ù���Աid
		String barcode = (String) dyForm.get("barcode");//ͼ����
		Operator o = new Operator();
		o.setId(id);
		String s = borrowFacade.giveBackBook(barcode, o);

		String error = "";
		if (s.equals("barcodeError")) {
			error = "ͼ��Ŵ���";
		} else if (s.equals("notBorrow")) {
			error = "��ǰͼ�鲢û�б����";
		} else if (s.equals("success")) {
			error = "����ɹ�";
		}
		request.setAttribute("error", error);
		return mapping.findForward("giveBack");//ת�����ͼ��ҳ��
	}

	// ��������
	public ActionForward warningBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Borrow> lb = borrowFacade.warningBack();
		request.setAttribute("lb", lb);

		return mapping.findForward("warningBack");//ת��������ҳ��
	}

	// ��ʷ��¼,��ʾ�ѽ����ͼ��ͽ�������Ϣ��
	public ActionForward historyBorrowed(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		Integer page = (Integer) dyForm.get("page");//ȡ��ҳ��
		if (page == null) {
			page = 1;
		}
		Object[] o = borrowFacade.historyBorrowed(page, 20);
		Integer pageNum = (Integer) o[0];
		//;//��ҳ��   	
		List<Borrow> lbr = (List<Borrow>) o[1];
		request.setAttribute("pageNum", pageNum);//��pageNum����Request������
		request.setAttribute("borrwed", lbr);//��lbr����Request������															
		return mapping.findForward("showBorrowedBook");//��ҳ��ת����ʷ��¼ҳ��
	}

}