package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.JSPBoardPostDAO;
import jspboard.model.Post;

public class EditFormProcess implements Process {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		Integer post_no = Integer.parseInt(request.getParameter("no"));
		
		Post post = JSPBoardPostDAO.getPost(post_no);
		
		request.setAttribute("post", post);
		
		return "/WEB-INF/views/edit.jsp";
	}

}