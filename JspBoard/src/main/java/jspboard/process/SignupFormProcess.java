package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupFormProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
	
		
		
		
		//return "/WEB-INF/views/employee/addForm.jsp";
		//return "redirect:/chap04/employee/list";
		return "/WEB-INF/views/signup.jsp";
	}
}
