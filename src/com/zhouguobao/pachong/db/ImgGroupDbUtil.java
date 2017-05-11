package com.zhouguobao.pachong.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhouguobao.pachong.model.ImgGroup;
import com.zhouguobao.pachong.model.ImgTag;

public class ImgGroupDbUtil {
	private static ImgGroupDbUtil instance ;
	private ImgGroupDbUtil() {
	}
	public static ImgGroupDbUtil get(){
		if (instance == null) {
			instance = new ImgGroupDbUtil();
		}
		return instance;
	}
	
	public void insetTag(ArrayList<ImgGroup> imgGroups){
		Connection connection = PaChongDbUtil.get().getOpenConn();
		// 2.创建statement类对象，用来执行SQL语句！！
		try {
			String sql = "INSERT INTO img_group (url,alt,tag_id,star,failure_num) VALUES (?,?,?,?,?);";
			PreparedStatement psql = connection.prepareStatement(sql);
			for (ImgGroup imgGroup : imgGroups) {
				psql.setString(1, imgGroup.getUrl());
				psql.setString(2, imgGroup.getAlt());
				psql.setInt(3, imgGroup.getTagId());
				psql.setInt(4, imgGroup.getStar());
				psql.setInt(5, imgGroup.getFailureNum());
				psql.executeUpdate();
			}
			psql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ImgGroup> getImgGroups(){
		ArrayList<ImgGroup> imgGroups = new ArrayList<>();
		Connection connection = PaChongDbUtil.get().getOpenConn();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from img_group");
			 while(resultSet.next()){
				 ImgGroup group = new ImgGroup();
				 group.setId(resultSet.getInt("id"));
				 group.setAlt(resultSet.getString("alt"));
				 group.setTagId(resultSet.getInt("tag_id"));
				 group.setUrl(resultSet.getString("url"));
				 group.setStar(resultSet.getInt("star"));
				 group.setCreateTime(resultSet.getDate("create_time"));
				 group.setUpdateTime(resultSet.getDate("update_time"));
				 imgGroups.add(group);
			 }
			 resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imgGroups;
	}
	
}
