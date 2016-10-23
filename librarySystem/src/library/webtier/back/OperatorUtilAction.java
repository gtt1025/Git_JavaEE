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

	// 管理员登录
	public ActionForward operatorLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		String name = (String) dyForm.get("name");// 取得管理员登录帐号
		String password = (String) dyForm.get("password");// 取得管理员登录密码
		Operator o = new Operator();
		o.setName(name);
		o.setPassword(password);
		Operator operator = operatorUtilFacade.operatorLogin(o);
		if (operator != null) {// 判断输入的帐号和密码是否正确
			HttpSession session = request.getSession();
			session.setAttribute("operator", operator);
			session.setAttribute("sessionData", "session");// 用于判断用户是否登录
			return mapping.findForward("loginSuccess");// 返回到后台主页
		}
		request.setAttribute("flag", "true");
		return mapping.findForward("operatorlogin");// 返回到登录页面
	}

	// 管理员退出登录
	public ActionForward loginout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.isNew() != true) {
			session.invalidate();
		}
		return mapping.findForward("operatorlogin");// 返回到登录页面
	}

	// 管理员修改密码
	public ActionForward editPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得当前登录管理员的id
		String password = (String) dyForm.get("password");// 取得管理员输入的新密码
		Operator o = new Operator();
		o.setId(id);
		o.setPassword(password);
		operatorUtilFacade.editPassword(o);
		ActionForward actForward = mapping.findForward("updateSuccess");
		String path = actForward.getPath();
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}

}
