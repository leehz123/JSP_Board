package jspboard.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.JSPBoardPostDAO;
import jspboard.database.DBConnector;
import jspboard.model.Post;

public class PostProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		Integer no = Integer.parseInt((String)request.getParameter("no"));
		//System.out.println("글번호 : " + no);
		//System.out.println("여기로 온 원인 : " + request.getParameter("delete_failed"));
		
		//이렇게 해줄 필요 없는게 같은 요청을 처리하는 페이지끼리는 같은 request, response객체를 를 공유함
		//request.setAttribute("delete_failed", request.getParameter("delete_failed"));/
		
		JSPBoardPostDAO.postViewIncre(no);
		
		String sql = "SELECT * FROM jspboard_posts WHERE post_no = ?";
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			request.setAttribute("post", new Post(rs));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/post.jsp";
	}

}
