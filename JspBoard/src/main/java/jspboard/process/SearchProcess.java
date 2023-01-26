package jspboard.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.JSPBoardPostDAO;

public class SearchProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		String sort = request.getParameter("sort");
		String search = request.getParameter("search");
		
		if(sort.equals("글제목")) {
			request.setAttribute("posts", JSPBoardPostDAO.searchTitle(search));
		} else if(sort.equals("글쓴이")) {
			request.setAttribute("posts", JSPBoardPostDAO.searchWriter(search));
		}
		
		return "/WEB-INF/views/board.jsp";
	}

}
