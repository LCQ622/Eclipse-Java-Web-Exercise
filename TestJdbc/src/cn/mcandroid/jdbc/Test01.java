package cn.mcandroid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class Test01 {
	public static void main(String[] args) throws Exception {
		//1.
		Class.forName("com.mysql.jdbc.Driver");
		//2.
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lcq", "root", "root");
		//3.
		java.sql.Statement stm=conn.createStatement();
		ResultSet resultSet=stm.executeQuery("SELECT id,CONCAT(first_name,last_name) AS NAME,IF(sex='M','ÄÐ','Å®')AS sex FROM stus");
		
		while(resultSet.next()) {
			int id=resultSet.getInt("id");
			String name=resultSet.getString("name");
			String sex=resultSet.getString("sex");
			System.out.println("id:"+id+",name:"+name+",sex:"+sex);
		}
		
		
	
		
	}
}
