package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.JSPBoardPostDAO;

public class EditUpdateProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String edited_title = request.getParameter("edited_title");
		String edited_content = request.getParameter("edited_content");
		Integer post_no = Integer.parseInt((String)request.getParameter("no"));
		
		JSPBoardPostDAO.editPost(edited_title, edited_content, post_no);
		
		
		return "redirect:/JspBoard1/post?no=" + post_no;
	}

}
