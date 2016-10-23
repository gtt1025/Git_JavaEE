package library.webtier.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.operator.Operator;
import library.service.back.SysOperatorFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class SysOperatorAction extends DispatchAction {
	private SysOperatorFacade sysOperatorFacade;

	public SysOperatorFacade getSysOperatorFacade() {
		return sysOperatorFacade;
	}

	public void setSysOperatorFacade(SysOperatorFacade sysOperatorFacade) {
		this.sysOperatorFacade = sysOperatorFacade;
	}

	// ��������Ա
	public ActionForward addOperator(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		String name = (String) dyForm.get("name");// ȡ�ù���Ա�ʺ�
		String password = (String) dyForm.get("password");// ȡ�ù���Ա����
		Short bookOper = (Short) dyForm.get("bookOper");// ȡ��ͼ�����Ȩ��
		if (bookOper == null)
			bookOper = 0;
		Short borrowOper = (Short) dyForm.get("borrowOper");// ȡ�ý軹����Ȩ��
		if (borrowOper == null)
			borrowOper = 0;
		Short queryOper = (Short) dyForm.get("queryOper");// ȡ�ò�ѯ����Ȩ��
		if (queryOper == null)
			queryOper = 0;
		Short readerOper = (Short) dyForm.get("readerOper");// ȡ�ö��߲���Ȩ��
		if (readerOper == null)
			readerOper = 0;
		Short sysOper = (Short) dyForm.get("sysOper");// ȡ��ϵͳ����Ȩ��
		if (sysOper == null)
			sysOper = 0;
		Operator o = new Operator();
		o.setName(name);
		o.setPassword(password);
		o.setBook(bookOper);
		o.setBorrow(borrowOper);
		o.setQuery(queryOper);
		o.setReader(readerOper);
		o.setSystem(sysOper);
		sysOperatorFacade.newOperator(o);
		return mapping.findForward("showOperators");// ���ص�ά������Ա��Ϣҳ��
	}

	// ��ʾ���й���Ա
	public ActionForward findOperatorInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Operator> lof = sysOperatorFacade.findOperatorInfo();
		request.setAttribute("lof", lof);
		return mapping.findForward("showAllOperator");// ���ص�ά������Ա��Ϣҳ��
	}

	// ɾ������Ա
	public ActionForward removeOperator(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ�ù���Աid
		sysOperatorFacade.removeOperator(id);
		return mapping.findForward("showOperators");// ���ص�ά������Ա��Ϣҳ��
	}

	// �������ԱȨ��
	public ActionForward showAuthority(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ�ù���Աid
		Operator o = sysOperatorFacade.showAuthority(id);
		request.setAttribute("operator", o);
		return mapping.findForward("update");// ���ص����¹���Ա��Ϣ��ҳ��
	}

	// �޸Ĺ���Ա��Ϣ
	public ActionForward updateAuthority(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ�ù���Աid
		Short bookOper = (Short) dyForm.get("bookOper");// ȡ��ͼ�����Ȩ��
		if (bookOper == null)
			bookOper = 0;
		Short borrowOper = (Short) dyForm.get("borrowOper");// ȡ�ý軹����Ȩ��
		if (borrowOper == null)
			borrowOper = 0;
		Short queryOper = (Short) dyForm.get("queryOper");// ȡ�ò�ѯ����Ȩ��
		if (queryOper == null)
			queryOper = 0;
		Short readerOper = (Short) dyForm.get("readerOper");// ȡ�ö��߲���Ȩ��
		if (readerOper == null)
			readerOper = 0;
		Short sysOper = (Short) dyForm.get("sysOper");// ȡ��ϵͳ����Ȩ��
		if (sysOper == null)
			sysOper = 0;
		Operator o = new Operator();
		o.setId(id);
		o.setBook(bookOper);
		o.setBorrow(borrowOper);
		o.setQuery(queryOper);
		o.setReader(readerOper);
		o.setSystem(sysOper);
		sysOperatorFacade.updateAuthority(o);
		return mapping.findForward("showOperators");//���ص�ά������Ա��Ϣҳ��
	}
}