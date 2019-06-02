package cn.mcandoird.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.mcandroid.util.DbTools;

public class Test01 {
	public static void main(String[] args) {
		
		Connection conn=DbTools.getConn();
		Statement sta=null;
		try {
			sta = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql="SELECT id,CONCAT(first_name,last_name)AS'name',IF(sex='M','男','女')AS 'sex'FROM stus";
		ResultSet resultSet=null;
		try {
			resultSet=sta.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("ID:"+resultSet.getInt("id")+",姓名："+resultSet.getString("name")+",sex:"+resultSet.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DbTools.Closs(sta, conn, resultSet);
		
	}
}
