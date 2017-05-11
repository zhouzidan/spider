package com.zhouguobao.pachong.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhouguobao.pachong.model.ImgTag;
import com.zhouguobao.pachong.model.ImgTagPage;

public class ImgTagPageDbUtil {
	private static ImgTagPageDbUtil instance ;
	private ImgTagPageDbUtil() {
	}
	public static ImgTagPageDbUtil get(){
		if (instance == null) {
			instance = new ImgTagPageDbUtil();
		}
		return instance;
	}
	
	public void insetTag(ArrayList<ImgTagPage> pages){
		Connection connection = PaChongDbUtil.get().getOpenConn();
		// 2.创建statement类对象，用来执行SQL语句！！
		try {
			String sql = "INSERT INTO tag_page (tag_id,url) VALUES (?,?);";
			PreparedStatement psql = connection.prepareStatement(sql);
			for (ImgTagPage page : pages) {
				psql.setInt(1, page.getTagId());
				psql.setString(2, page.getUrl());
				psql.executeUpdate();
			}
			psql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ImgTagPage> geImgTagPages(){
		ArrayList<ImgTagPage> imgTagPages = new ArrayList<>();
		Connection connection = PaChongDbUtil.get().getOpenConn();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from tag_page");
			 while(resultSet.next()){
				 int id = resultSet.getInt("id");
				 String url = resultSet.getString("url");
				 int tagId = resultSet.getInt("tag_id");
				 ImgTagPage imgTagPage = new ImgTagPage(id, tagId, url);
				 imgTagPages.add(imgTagPage);
			 }
			 resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imgTagPages;
	}
	
}
