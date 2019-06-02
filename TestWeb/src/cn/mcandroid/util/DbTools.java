package cn.mcandroid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbTools {
	private static String username ="root";
	private static String pwd ="root";
	private static String url="jdbc:mysql://localhost:3306/lcq" ;
	private static String driver ="com.mysql.jdbc.Driver";

	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 该方法用于获取数据库的连接
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * 该方法用于关闭数据库的连接
	 * 
	 * @param sta
	 * @param conn
	 * @param re
	 */
	public static void Closs(Statement sta, Connection conn, ResultSet re) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (re != null) {
			try {
				re.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
