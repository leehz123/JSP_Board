package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditAuthenFormProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/editAuthen.jsp";
	}

}
