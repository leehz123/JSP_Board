package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAuthenFormProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/deleteAuthen.jsp";
	}
	
}
