package jspboard.process;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.BoardUserDAO;
import jspboard.database.DBConnector;

public class SignupProcess implements Process {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String btn = request.getParameter("button");
		System.out.println(btn);
		if(btn.equals("가입하기")) {
			try {
				request.setCharacterEncoding("EUC-KR");
				System.out.println("char인코딩 성공");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
				System.out.println("char인코딩 실패");
			}
			
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			String nick_name = request.getParameter("nick_name");
			String user_name = request.getParameter("user_name");
			String user_mail = request.getParameter("user_mail");
			String user_phone = request.getParameter("user_phone1") + "-" 
								+ request.getParameter("user_phone2") + "-" 
								+ request.getParameter("user_phone3"); 

			return BoardUserDAO.insertNewUser(user_id, user_pw, nick_name, user_name, user_mail, user_phone);			

		} if(btn.equals("중복확인")) {		
			String user_id = request.getParameter("user_id");
			request.setAttribute("dup_result", BoardUserDAO.duplicateChk(user_id));
			return "/WEB-INF/views/signup.jsp";
		}
		
		return null;
	}
}
