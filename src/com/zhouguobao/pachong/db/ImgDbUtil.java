package com.zhouguobao.pachong.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhouguobao.pachong.model.ImgGroup;
import com.zhouguobao.pachong.model.ImgModel;
import com.zhouguobao.pachong.model.ImgTag;

public class ImgDbUtil {
	private static ImgDbUtil instance ;
	private ImgDbUtil() {
	}
	public static ImgDbUtil get(){
		if (instance == null) {
			instance = new ImgDbUtil();
		}
		return instance;
	}
	
	public void insetTag(ArrayList<ImgModel> imgModels){
		Connection connection = PaChongDbUtil.get().getOpenConn();
		// 2.创建statement类对象，用来执行SQL语句！！
		try {
			String sql = "INSERT INTO img (url,group_id,star,failure_num) VALUES (?,?,?,?);";
			PreparedStatement psql = connection.prepareStatement(sql);
			for (ImgModel imgModel : imgModels) {
				psql.setString(1, imgModel.getUrl());
				psql.setInt(2, imgModel.getGroupId());
				psql.setInt(3, imgModel.getStar());
				psql.setInt(4, imgModel.getFailureNum());
				psql.executeUpdate();
			}
			psql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ImgModel> getImgGroups(){
		ArrayList<ImgModel> imgModels = new ArrayList<>();
		Connection connection = PaChongDbUtil.get().getOpenConn();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from img");
			 while(resultSet.next()){
				 ImgModel imgModel = new ImgModel();
				 imgModel.setId(resultSet.getInt("id"));
				 imgModel.setGroupId(resultSet.getInt("group_id"));
				 imgModel.setUrl(resultSet.getString("url"));
				 imgModel.setStar(resultSet.getInt("star"));
				 imgModel.setFailureNum(resultSet.getInt("failure_num"));
				 imgModel.setCreateTime(resultSet.getDate("create_time"));
				 imgModel.setUpdateTime(resultSet.getDate("update_time"));
				 imgModels.add(imgModel);
			 }
			 resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imgModels;
	}
	
}
