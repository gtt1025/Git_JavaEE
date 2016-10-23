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

	// ��������
	public ActionForward addReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		String name = (String) dyForm.get("name");// ȡ�ö����ʺ�
		String realName = (String) dyForm.get("realName");// ȡ����ʵ����
		Short sex = (Short) dyForm.get("sex");// ȡ���Ա�
		String papertype = (String) dyForm.get("papertype");// ȡ��֤������
		String paperNo = (String) dyForm.get("paperNo");// ȡ��֤������
		String tel = (String) dyForm.get("tel");// ȡ����ϵ�绰
		String email = (String) dyForm.get("email");// ȡ��email��ַ
		Integer type = (Integer) dyForm.get("type");// ȡ�ö�������
		String description = (String) dyForm.get("description");// ȡ��������Ϣ
		Integer operatorid = (Integer) dyForm.get("operator");// ȡ�ù���Աid
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
		path += "?method=findReader";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ

	}

	// ɾ������
	public ActionForward removeReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ�ö���id
		Reader r = new Reader();
		r.setId(id);
		String s = readerInfoFacade.removeReader(r);

		String error = "";
		if (s.equals("notexist")) {
			error = "�ö��߲�����";
		} else if (s.equals("deletereader")) {
			error = "ɾ���ɹ�";
		} else if (s.equals("borrowed")) {
			error = "�ö����й�������ʷ������ɾ��";
		}
		request.setAttribute("error", error);
		return mapping.findForward("error");
	}

	// ȫ�����
	public ActionForward findReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer page = (Integer) dyForm.get("page");// ȡ��ҳ��
		if (page == null) {
			page = 1;
		}
		Object[] o = readerInfoFacade.findReader(page, 20);
		Integer pageNum = (Integer) o[0];
		List<Reader> lr = (List<Reader>) o[1];
		request.setAttribute("pageNum", pageNum);// ��pageNum����Request������
		request.setAttribute("allReaderList", lr);// ��lr����Request������
		return mapping.findForward("showAllReader");

	}

	// �������
	public ActionForward showReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Reader r = new Reader();
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		Integer id = (Integer) dyForm.get("id");// ȡ�ö���id
		r.setId(id);
		r = readerInfoFacade.showReader(r);
		request.setAttribute("reader", r);

		return mapping.findForward("updateReaderInfo");// ���ص��޸Ķ�����Ϣҳ��
	}

	// �޸Ķ���
	public ActionForward updateReader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dyForm = (DynaActionForm) form;// ����һ����̬ActionForm����
		String realName = (String) dyForm.get("realName");// ȡ����ʵ����
		Short sex = (Short) dyForm.get("sex");// ȡ���Ա�
		String papertype = (String) dyForm.get("papertype");// ȡ��֤������
		String paperNo = (String) dyForm.get("paperNo");// ȡ��֤������
		Integer id = (Integer) dyForm.get("id");// ȡ�ö���id
		Reader r = new Reader();
		r.setPapertype(papertype);// ֤������
		r.setPaperNo(paperNo);// ֤����
		r.setRealName(realName);// ��ʵ����
		r.setSex(sex);// �Ա�
		r.setId(id);
		ReaderType rt = new ReaderType();
		Integer type = (Integer) dyForm.get("type");// ȡ�ö�������
		rt.setId(type);// �˴���Ҫ��ҳ���ϴ�ֵ
		r.setReaderTypeT(rt);
		readerInfoFacade.editReader(r);
		ActionForward actForward = mapping.findForward("showReaders");
		String path = actForward.getPath();
		path += "?method=findReader";// ��Ҫ���ݵĲ���
		return new ActionForward(actForward.getName(), path, true);// ��ֹˢ���ύ
	}

}