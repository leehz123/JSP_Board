package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspboard.dao.BoardUserDAO;

public class LoginProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		
		String input_id = request.getParameter("input_id");
		String input_pw = request.getParameter("input_pwd");
		
		HttpSession session = request.getSession();
		
		String user_pwd = BoardUserDAO.getPwd(input_id);
	
		if(user_pwd != null) {
			//System.out.println("일단 null은 아님");
			if(input_pw.equals(user_pwd)) {
				//System.out.println("로그인 성공");
				session.setAttribute("id", input_id);
				session.setAttribute("longin_result", 0);
				return "redirect:/JspBoard1/board";				
			} else {
				//System.out.println("비번 불일치");
				session.setAttribute("longin_result", 1);
				return "redirect:/JspBoard1/login_form";				
			}
		} else {
			//System.out.println("아디 없음");
			session.setAttribute("longin_result", 2);
			return "redirect:/JspBoard1/login_form";
		}
		
	}
}
