package library.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

public class CharacterTrans extends RequestProcessor {

	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		 request.setCharacterEncoding("UTF-8");  //在这加一行设置编码的的代吗。
		 super.process(request, response);
	}

}
