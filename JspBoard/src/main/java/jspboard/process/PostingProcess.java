package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspboard.dao.BoardUserDAO;
import jspboard.dao.JSPBoardPostDAO;

public class PostingProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String nickname = BoardUserDAO.getNickname(id);
		
		JSPBoardPostDAO.posting(title, content, nickname);
		
		return "redirect:/JspBoard1/board";
	}
}
