package jspboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jspboard.database.DBConnector;

public class BoardUserDAO {

	public static String getId(String nickName) {
		
		String sql = "SELECT board_user_id FROM board_user WHERE board_nickname=?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);	
		){
			pstmt.setString(1, nickName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();			
			return rs.getString("board_user_id");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getPwd(String input_id) {
		
		//System.out.println(id);
		String sql = "SELECT board_user_password FROM board_user WHERE board_user_id =?";
		
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			//System.out.println(id);
			pstmt.setString(1, input_id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("board_user_password");

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static String getNickname(String id) {
		
		String sql = "SELECT board_nickname FROM board_user WHERE board_user_id=?";
				
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);	
		){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();			
			return rs.getString("board_nickname");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean duplicateChk(String id) {
		String sql = "SELECT * FROM board_user WHERE board_user_id=?";
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);	
		){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
	
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;	 //애매하네
	}

	public static String insertNewUser(String user_id, String user_pw, String nick_name, String user_name, String user_mail, String user_phone) {
		
		String sql = "INSERT INTO board_user VALUES(?, ?, ?, ?, ?, ?)";
		try (	
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			conn.setAutoCommit(false);
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			pstmt.setString(3, nick_name);
			pstmt.setString(4, user_name);
			pstmt.setString(5, user_mail);
			pstmt.setString(6, user_phone);
			
			System.out.println("user " + pstmt.executeUpdate() + " 명 회원가입 성공");
			
			conn.commit();

			return "redirect:/JspBoard1/login_form";
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user 회원가입 실패");
			return "redirect:/JspBoard1/signup_form";
		}
	}
	
}
