package library.webtier.back;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.domain.operator.Operator;
import library.service.back.OperatorUtilFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class OperatorUtilAction extends DispatchAction {
	private OperatorUtilFacade operatorUtilFacade;

	public OperatorUtilFacade getOperatorUtilFacade() {
		return operatorUtilFacade;
	}

	public void setOperatorUtilFacade(OperatorUtilFacade operatorUtilFacade) {
		this.operatorUtilFacade = operatorUtilFacade;
	}

	// ����Ա��¼
	public ActionForward operatorLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		String name = (String) dyForm.get("name");// ȡ�ù���Ա��¼�ʺ�
		String password = (String) dyForm.get("password");// ȡ�ù���Ա��¼����
		Operator o = new Operator();
		o.setName(name);
		o.setPassword(password);
		Operator operator = operatorUtilFacade.operatorLogin(o);
		if (operator != null) {// �ж�������ʺź������Ƿ���ȷ
			HttpSession session = request.getSession();
			session.setAttribute("operator", operator);
			session.setAttribute("sessionData", "session");// �����ж��û��Ƿ��¼
			return mapping.findForward("loginSuccess");// ���ص���̨��ҳ
		}
		request.setAttribute("flag", "true");
		return mapping.findForward("operatorlogin");// ���ص���¼ҳ��
	}

	// ����Ա�˳���¼
	public ActionForward loginout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.isNew() != true) {
			session.invalidate();
		}
		return mapping.findForward("operatorlogin");// ���ص���¼ҳ��
	}

	// ����Ա�޸�����
	public ActionForward editPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ�õ�ǰ��¼����Ա��id
		String password = (String) dyForm.get("password");// ȡ�ù���Ա�����������
		Operator o = new Operator();
		o.setId(id);
		o.setPassword(password);
		operatorUtilFacade.editPassword(o);
		ActionForward actForward = mapping.findForward("updateSuccess");
		String path = actForward.getPath();
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}

}