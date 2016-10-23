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

	// 新增管理员
	public ActionForward addOperator(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		String name = (String) dyForm.get("name");// 取得管理员帐号
		String password = (String) dyForm.get("password");// 取得管理员密码
		Short bookOper = (Short) dyForm.get("bookOper");// 取得图书操作权限
		if (bookOper == null)
			bookOper = 0;
		Short borrowOper = (Short) dyForm.get("borrowOper");// 取得借还操作权限
		if (borrowOper == null)
			borrowOper = 0;
		Short queryOper = (Short) dyForm.get("queryOper");// 取得查询操作权限
		if (queryOper == null)
			queryOper = 0;
		Short readerOper = (Short) dyForm.get("readerOper");// 取得读者操作权限
		if (readerOper == null)
			readerOper = 0;
		Short sysOper = (Short) dyForm.get("sysOper");// 取得系统操作权限
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
		return mapping.findForward("showOperators");// 返回到维护管理员信息页面
	}

	// 显示所有管理员
	public ActionForward findOperatorInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Operator> lof = sysOperatorFacade.findOperatorInfo();
		request.setAttribute("lof", lof);
		return mapping.findForward("showAllOperator");// 返回到维护管理员信息页面
	}

	// 删除管理员
	public ActionForward removeOperator(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得管理员id
		sysOperatorFacade.removeOperator(id);
		return mapping.findForward("showOperators");// 返回到维护管理员信息页面
	}

	// 单查管理员权限
	public ActionForward showAuthority(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得管理员id
		Operator o = sysOperatorFacade.showAuthority(id);
		request.setAttribute("operator", o);
		return mapping.findForward("update");// 返回到更新管理员信息的页面
	}

	// 修改管理员信息
	public ActionForward updateAuthority(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得管理员id
		Short bookOper = (Short) dyForm.get("bookOper");// 取得图书操作权限
		if (bookOper == null)
			bookOper = 0;
		Short borrowOper = (Short) dyForm.get("borrowOper");// 取得借还操作权限
		if (borrowOper == null)
			borrowOper = 0;
		Short queryOper = (Short) dyForm.get("queryOper");// 取得查询操作权限
		if (queryOper == null)
			queryOper = 0;
		Short readerOper = (Short) dyForm.get("readerOper");// 取得读者操作权限
		if (readerOper == null)
			readerOper = 0;
		Short sysOper = (Short) dyForm.get("sysOper");// 取得系统操作权限
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
		return mapping.findForward("showOperators");//返回到维护管理员信息页面
	}
}
