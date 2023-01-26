package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.JSPBoardPostDAO;
import jspboard.database.DBConnector;

public class BoardProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("posts", JSPBoardPostDAO.getPostList());
		return "/WEB-INF/views/board.jsp";
	}
}
