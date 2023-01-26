package jspboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspboard.database.DBConnector;
import jspboard.model.Post;

public class JSPBoardPostDAO {

	public static List<Post> getPostList() {
		List<Post> list = new ArrayList<>();
		String sql = "SELECT * FROM jspboard_posts";
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			
			while(rs.next()) {
//				System.out.println(rs.getInt("post_no"));
//				System.out.println(rs.getString("post_title"));
//				System.out.println(rs.getString("post_content"));
//				System.out.println(rs.getString("post_writer"));
//				System.out.println(rs.getInt("post_view_num"));
//				System.out.println(rs.getDate("post_date"));
				list.add(new Post(rs));
			}
			return list;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	public static Post getPost(Integer post_no) {
		
		String sql = "SELECT * FROM jspboard_posts WHERE post_no = ?";
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);				
		){
			
			pstmt.setInt(1, post_no);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();			
		
			Post post= new Post(rs);
			
			return post;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	
	
	public static void deletePost(Integer post_no) {
		String sql = "DELETE FROM jspboard_posts WHERE post_no = ?";

		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);					
		){
			pstmt.setInt(1, post_no);
			
			conn.setAutoCommit(false);
			
			System.out.println(pstmt.executeUpdate() + "포스트 삭제 완료");
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("포스트 삭제 실패");
		}
	
	}
	
	
	public static void editPost(String edited_title, String edited_content, Integer post_no) {
		String sql = "UPDATE jspboard_posts SET post_title = ?, post_content=? WHERE post_no =?";

		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, edited_title);
			pstmt.setString(2, edited_content);
			pstmt.setInt(3, post_no);
			
			conn.setAutoCommit(false);

			System.out.println(pstmt.executeUpdate()+"포스트 수정 완료");
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("포스트 수정 실패");
		}
	
	}
	
	

	public static void posting(String title, String content, String nickname) {
	
		String sql = "INSERT INTO jspboard_posts(post_no, post_title, post_content, post_writer) "
						+ "VALUES(jspboard_postno_seq.nextval, ?, ?, ?)";
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);		
		) {
			
			conn.setAutoCommit(false);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, nickname);
			
			System.out.println(pstmt.executeUpdate() + "post DB에 저장 성공");
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("post DB에 저장 실패");
		}
	}
	
	
	public static void postViewIncre(Integer post_no) {
		String sql = "UPDATE jspboard_posts SET post_view_num = post_view_num + 1 WHERE post_no =?";
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);				
		) {
			
			pstmt.setInt(1, post_no);
			conn.setAutoCommit(false);
			System.out.println(pstmt.executeUpdate()+ "조회수 증가");
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public static List<Post> searchTitle(String title) {
		String sql = "SELECT * FROM jspboard_posts WHERE post_title = ?";
		List<Post> list = new ArrayList<>();
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, title);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {

				list.add(new Post(rs));
			}
			return list;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	public static List<Post> searchWriter(String writer) {
		String sql = "SELECT * FROM jspboard_posts WHERE post_writer = ?";
		List<Post> list = new ArrayList<>();
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			pstmt.setString(1, writer);
			
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {

				list.add(new Post(rs));
			}
			return list;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
