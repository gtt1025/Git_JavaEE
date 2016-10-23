package library.webtier.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.readerType.ReaderType;
import library.service.back.ReaderTypeFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class ReaderTypeAction extends DispatchAction {
	private ReaderTypeFacade readerTypeFacade;

	public ReaderTypeFacade getReaderTypeFacade() {
		return readerTypeFacade;
	}

	public void setReaderTypeFacade(ReaderTypeFacade readerTypeFacade) {
		this.readerTypeFacade = readerTypeFacade;
	}

	// 新增读者类型
	public ActionForward addReaderType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		String name = (String) dyForm.get("name");// 取得读者类型名称
		Integer quantity = (Integer) dyForm.get("quantity");// 取得可借图书数量
		ReaderType rt = new ReaderType();
		rt.setName(name);
		rt.setQuantity(quantity);
		readerTypeFacade.newReaderType(rt);
		ActionForward actForward = mapping.findForward("showReaderTypes");
		String path = actForward.getPath();
		path += "?method=findReaderType";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}

	// 删除读者类型
	public ActionForward removeReaderType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得图书名称
		ReaderType rt = new ReaderType();
		rt.setId(id);
		readerTypeFacade.removeReaderType(rt);
		ActionForward actForward = mapping.findForward("showReaderTypes");
		String path = actForward.getPath();
		path += "?method=findReaderType";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}

	// 全查读者类型
	public ActionForward findReaderType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<ReaderType> lr = readerTypeFacade.findReaderType();
		request.setAttribute("allReaderType", lr);
		return mapping.findForward("showAllReaderType");
	}

	// 单查读者类型
	public ActionForward showReaderType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得图书名称
		ReaderType readerType = new ReaderType();
		readerType.setId(id);
		ReaderType rt = readerTypeFacade.showReaderType(readerType);
		request.setAttribute("readerType", rt);
		return mapping.findForward("updateReaderType");
	}

	// 修改读者类型
	public ActionForward updateReaderType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得图书名称
		String name = (String) dyForm.get("name");// 取得读者类型名称
		Integer quantity = (Integer) dyForm.get("quantity");// 取得可借图书数量
		ReaderType rt = new ReaderType();
		rt.setId(id);
		rt.setName(name);
		rt.setQuantity(quantity);
		readerTypeFacade.editReaderType(rt);// 调用readerTypeFacade中editReaderType()方法
		ActionForward actForward = mapping.findForward("showReaderTypes");
		String path = actForward.getPath();
		path += "?method=findReaderType";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}
}
