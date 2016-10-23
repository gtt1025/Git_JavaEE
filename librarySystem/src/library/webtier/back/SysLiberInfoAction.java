package library.webtier.back;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.liberInfo.LiberInfo;
import library.service.back.SysLiberInfoFacade;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;


public class SysLiberInfoAction extends DispatchAction {
	private SysLiberInfoFacade sysLiberInfoFacade;

	public SysLiberInfoFacade getSysLiberInfoFacade() {
		return sysLiberInfoFacade;
	}

	public void setSysLiberInfoFacade(SysLiberInfoFacade sysLiberInfoFacade) {
		this.sysLiberInfoFacade = sysLiberInfoFacade;
	}

	// 得到图书馆信息
	public ActionForward showLiberInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LiberInfo li = sysLiberInfoFacade.showLiberInfo();
		request.setAttribute("liberInfo", li);//将图书馆信息放入request对象中
		return mapping.findForward("updateLiberinfo");//返回到修改图书馆信息页面

	}

	// 修改图书馆信息
	public ActionForward updateLiberInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//定义一个动态ActionForm对象
		Integer id = (Integer) dyForm.get("id");//取得图书馆id
		String liberName = (String) dyForm.get("liberName");//取得图书馆名称
		String curator = (String) dyForm.get("curator");//取得图书馆馆长
		String tel = (String) dyForm.get("tel");//取得图书馆电话
		String address = (String) dyForm.get("address");//取得图书馆地址	
		String email = (String) dyForm.get("email");//取得图书馆Email
		String url = (String) dyForm.get("url");//取得图书馆网址		
		String buildDateemp = (String) dyForm.get("buildDate");//取得图书馆建馆日期
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date buildDate = dateformat.parse(buildDateemp);//将字符串转换为日期格式
		String description = (String) dyForm.get("description");//取得图书馆简介			
		LiberInfo li = new LiberInfo();
		li.setId(id);
		li.setLiberName(liberName);
		li.setCurator(curator);
		li.setTel(tel);
		li.setAddress(address);
		li.setEmail(email);
		li.setUrl(url);
		li.setBuildDate(buildDate);
		li.setIntroduce(description);
		sysLiberInfoFacade.editLiberInfo(li);
		return mapping.findForward("updateSuccess");//返回到后台主页
	}

}
