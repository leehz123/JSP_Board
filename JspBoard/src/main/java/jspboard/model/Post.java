package jspboard.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Post {
	Integer no;
	String title;
	String content;
	String nickname;
	Integer view_num;
	Date date;

	public Post(ResultSet rs) throws SQLException {
		no = rs.getInt("post_no");
		title = rs.getString("post_title");
		content = rs.getString("post_content");
		nickname = rs.getString("post_writer");
		view_num = rs.getInt("post_view_num");
		date = rs.getDate("post_date");
	}


	public Integer getNo() {
		return no;
	}


	public void setNo(Integer no) {
		this.no = no;
	}


	public Integer getView_num() {
		return view_num;
	}


	public void setView_num(Integer view_num) {
		this.view_num = view_num;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	

}
