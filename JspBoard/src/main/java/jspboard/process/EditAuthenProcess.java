package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspboard.dao.BoardUserDAO;

public class EditAuthenProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		String nickName = request.getParameter("nick");
		Integer post_no = Integer.parseInt(request.getParameter("no"));
		String writer_id = BoardUserDAO.getId(nickName);
		
//		System.out.println("글넘버 : "+post_no);
//		System.out.println("글쓴 닉넴 : " + nickName);
//		System.out.println("글쓴 아디 : " + writer_id);
		
		String input_pwd = request.getParameter("input_pwd");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pwd = BoardUserDAO.getPwd(id);
		
//		System.out.println("입력된 비번 : " + input_pwd);
//		System.out.println("접속중인 아디 : " + id);
//		System.out.println("접속중인 아디의 비번 : " + pwd);
		
		
		if(writer_id.equals(id)) {

			if(input_pwd.equals(pwd)) {				
				return "redirect:/JspBoard1/edit_form?no=" + post_no;
			} else {
				//비번 불일치
				return "redirect:/JspBoard1/post?no=" + post_no + "&authen_failed=0";
			}
		} else {
			////아이디 불일치	
			return "redirect:/JspBoard1/post?no=" + post_no + "&authen_failed=1";
		}

	}

}
