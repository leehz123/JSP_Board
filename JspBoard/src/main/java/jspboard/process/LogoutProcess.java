package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		//session.removeAttribute("id");
		//session.removeAttribute("longin_result");
		session.invalidate();
		return "redirect:/JspBoard1/login_form";
	}

}
