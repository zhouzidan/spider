package com.zhouguobao.pachong.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhouguobao.pachong.model.ImgTag;

public class ImgTagDbUtil {
	private static ImgTagDbUtil instance ;
	private ImgTagDbUtil() {
	}
	public static ImgTagDbUtil get(){
		if (instance == null) {
			instance = new ImgTagDbUtil();
		}
		return instance;
	}
	
	public void insetTag(ArrayList<ImgTag> tags){
		Connection connection = PaChongDbUtil.get().getOpenConn();
		// 2.创建statement类对象，用来执行SQL语句！！
		try {
			String sql = "INSERT INTO tag (tag,url) VALUES (?,?);";
			PreparedStatement psql = connection.prepareStatement(sql);
			for (ImgTag imgTag : tags) {
				psql.setString(1, imgTag.getTag());
				psql.setString(2, imgTag.getUrl());
				psql.executeUpdate();
			}
			psql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ImgTag> geImgTags(){
		ArrayList<ImgTag> imgTags = new ArrayList<>();
		Connection connection = PaChongDbUtil.get().getOpenConn();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from tag");
			 while(resultSet.next()){
				 int id = resultSet.getInt("id");
				 String url = resultSet.getString("url");
				 String tag = resultSet.getString("tag");
				 ImgTag imgTag = new ImgTag(id,tag, url);
				 imgTags.add(imgTag);
			 }
			 resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imgTags;
	}
	
}
