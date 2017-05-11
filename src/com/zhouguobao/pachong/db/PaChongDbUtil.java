package com.zhouguobao.pachong.db;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.zhouguobao.pachong.model.ImgTag;

import javafx.scene.control.Tab;

public class PaChongDbUtil {
	public static void main(String[] args) {
		// 声明Connection对象
		Connection con;
		// 驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		String dburl = "jdbc:mysql://localhost:3306/pachong";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "root";
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(dburl, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句
			String sql = "select * from tag";
			// 3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println("姓名" + "\t" + "职称");
			System.out.println("-----------------");

			String url = null;
			String tag = null;
			while (rs.next()) {
				// 获取stuname这列数据
				url = rs.getString("url");
				// 获取stuid这列数据
				tag = rs.getString("tag");

				// 输出结果
				System.out.println(url + "\t" + tag);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("数据库数据成功获取！！");
		}
	}

	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	public static final String DBNAME = "pachong";
	public static final String HOSTNAME = "localhost";
	public static final String PORT = "3306";

	private Connection connection;
	
	private static PaChongDbUtil instance ;
	private PaChongDbUtil() {
	}
	public static PaChongDbUtil get(){
		if (instance == null) {
			instance = new PaChongDbUtil();
		}
		return instance;
	}
	
	/**
	 * 获取数据库的连接对象
	 * 
	 * @return
	 */
	public Connection getDBConnection() {
		// 声明Connection对象
		Connection con = null;
		// 驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
		// URL指向要访问的数据库名
		String dburl = "jdbc:mysql://"+HOSTNAME+":"+PORT+"/" + DBNAME+"?useUnicode=true&characterEncoding=utf8";
		// MySQL配置时的用户名
		String user = USERNAME;
		// MySQL配置时的密码
		String password = PASSWORD;
		// 加载驱动程序
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl, user, password);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	

	public void closeConn(){
		try {
			if (connection != null && connection.isClosed() == false) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getOpenConn(){
		try {
			if (connection == null || connection.isClosed()) {
				connection = getDBConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

}
