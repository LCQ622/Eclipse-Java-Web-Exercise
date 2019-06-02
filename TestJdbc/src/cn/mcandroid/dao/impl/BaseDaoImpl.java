package cn.mcandroid.dao.impl;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import java.sql.Statement;
import java.sql.ResultSet;
public class BaseDaoImpl 
{

	private String url="jdbc:mysql://localhost:3306/lcq";
	private String pwd="root";
	private String userName="root";
	private String className="com.mysql.jdbc.Driver";

	public Connection getConn()
	{
	
		Connection conn=null;
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url,userName,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeAll(Connection conn,Statement state,ResultSet rs)
	{
	
		try {
			if(rs!=null)
				rs.close();
			if(state!=null)
				state.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BaseDaoImpl()
	{
	}

}