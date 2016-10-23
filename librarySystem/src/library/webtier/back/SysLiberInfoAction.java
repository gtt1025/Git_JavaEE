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

	// �õ�ͼ�����Ϣ
	public ActionForward showLiberInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LiberInfo li = sysLiberInfoFacade.showLiberInfo();
		request.setAttribute("liberInfo", li);//��ͼ�����Ϣ����request������
		return mapping.findForward("updateLiberinfo");//���ص��޸�ͼ�����Ϣҳ��

	}

	// �޸�ͼ�����Ϣ
	public ActionForward updateLiberInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;//����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");//ȡ��ͼ���id
		String liberName = (String) dyForm.get("liberName");//ȡ��ͼ�������
		String curator = (String) dyForm.get("curator");//ȡ��ͼ��ݹݳ�
		String tel = (String) dyForm.get("tel");//ȡ��ͼ��ݵ绰
		String address = (String) dyForm.get("address");//ȡ��ͼ��ݵ�ַ	
		String email = (String) dyForm.get("email");//ȡ��ͼ���Email
		String url = (String) dyForm.get("url");//ȡ��ͼ�����ַ		
		String buildDateemp = (String) dyForm.get("buildDate");//ȡ��ͼ��ݽ�������
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date buildDate = dateformat.parse(buildDateemp);//���ַ���ת��Ϊ���ڸ�ʽ
		String description = (String) dyForm.get("description");//ȡ��ͼ��ݼ��			
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
		return mapping.findForward("updateSuccess");//���ص���̨��ҳ
	}

}