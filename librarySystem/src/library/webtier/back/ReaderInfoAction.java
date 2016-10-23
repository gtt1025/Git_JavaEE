package library.webtier.back;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.operator.Operator;
import library.domain.reader.Reader;
import library.domain.readerType.ReaderType;
import library.service.back.ReaderInfoFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class ReaderInfoAction extends DispatchAction {
	private ReaderInfoFacade readerInfoFacade;

	public ReaderInfoFacade getReaderInfoFacade() {
		return readerInfoFacade;
	}

	public void setReaderInfoFacade(ReaderInfoFacade readerInfoFacade) {
		this.readerInfoFacade = readerInfoFacade;
	}

	// 新增读者
	public ActionForward addReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		String name = (String) dyForm.get("name");// 取得读者帐号
		String realName = (String) dyForm.get("realName");// 取得真实姓名
		Short sex = (Short) dyForm.get("sex");// 取得性别
		String papertype = (String) dyForm.get("papertype");// 取得证件类型
		String paperNo = (String) dyForm.get("paperNo");// 取得证件号码
		String tel = (String) dyForm.get("tel");// 取得联系电话
		String email = (String) dyForm.get("email");// 取得email地址
		Integer type = (Integer) dyForm.get("type");// 取得读者类型
		String description = (String) dyForm.get("description");// 取得描述信息
		Integer operatorid = (Integer) dyForm.get("operator");// 取得管理员id
		Reader r = new Reader();
		r.setName(name);
		r.setRealName(realName);
		r.setSex(sex);
		r.setPaperNo(paperNo);
		r.setPapertype(papertype);
		r.setTel(tel);
		r.setEmail(email);
		ReaderType rt = new ReaderType();
		rt.setId(type);
		r.setReaderTypeT(rt);
		r.setDescription(description);
		Operator o = new Operator();
		o.setId(operatorid);
		r.setOperatorT(o);
		r.setRegistTime(new Date());
		readerInfoFacade.newReader(r);
		ActionForward actForward = mapping.findForward("showReaders");
		String path = actForward.getPath();
		path += "?method=findReader";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交

	}

	// 删除读者
	public ActionForward removeReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得读者id
		Reader r = new Reader();
		r.setId(id);
		String s = readerInfoFacade.removeReader(r);

		String error = "";
		if (s.equals("notexist")) {
			error = "该读者不存在";
		} else if (s.equals("deletereader")) {
			error = "删除成功";
		} else if (s.equals("borrowed")) {
			error = "该读者有过借阅历史，不能删除";
		}
		request.setAttribute("error", error);
		return mapping.findForward("error");
	}

	// 全查读者
	public ActionForward findReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer page = (Integer) dyForm.get("page");// 取得页数
		if (page == null) {
			page = 1;
		}
		Object[] o = readerInfoFacade.findReader(page, 20);
		Integer pageNum = (Integer) o[0];
		List<Reader> lr = (List<Reader>) o[1];
		request.setAttribute("pageNum", pageNum);// 将pageNum放入Request对象中
		request.setAttribute("allReaderList", lr);// 将lr放入Request对象中
		return mapping.findForward("showAllReader");

	}

	// 单查读者
	public ActionForward showReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Reader r = new Reader();
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");// 取得读者id
		r.setId(id);
		r = readerInfoFacade.showReader(r);
		request.setAttribute("reader", r);

		return mapping.findForward("updateReaderInfo");// 返回到修改读者信息页面
	}

	// 修改读者
	public ActionForward updateReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// 定义一个动态ActionForm对象
		String realName = (String) dyForm.get("realName");// 取得真实姓名
		Short sex = (Short) dyForm.get("sex");// 取得性别
		String papertype = (String) dyForm.get("papertype");// 取得证件类型
		String paperNo = (String) dyForm.get("paperNo");// 取得证件号码
		Integer id = (Integer) dyForm.get("id");// 取得读者id
		Reader r = new Reader();
		r.setPapertype(papertype);// 证件类型
		r.setPaperNo(paperNo);// 证件号
		r.setRealName(realName);// 真实姓名
		r.setSex(sex);// 性别
		r.setId(id);
		ReaderType rt = new ReaderType();
		Integer type = (Integer) dyForm.get("type");// 取得读者类型
		rt.setId(type);// 此处需要从页面上传值
		r.setReaderTypeT(rt);
		readerInfoFacade.editReader(r);
		ActionForward actForward = mapping.findForward("showReaders");
		String path = actForward.getPath();
		path += "?method=findReader";// 需要传递的参数
		return new ActionForward(actForward.getName(), path, true);// 防止刷新提交
	}

}
