package cn.mcandorid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.Scanner;


public class JDBCUtil {
	private static String Driver = null;
	private static String url = null;
	private static String username = null;
	private static String pwd = null;
	

	public static void main(String[] args) throws Exception {
		ResourceBundle rbBundle = ResourceBundle.getBundle("conn");
		Driver = rbBundle.getString("Driver");
		url = rbBundle.getString("url");
		username = rbBundle.getString("username");
		pwd = rbBundle.getString("pwd");
		Class.forName(Driver);
		Connection connection = DriverManager.getConnection(url, username, pwd);
		java.sql.Statement statement = connection.createStatement();
		System.out.println("请输入要查询的日期");
		System.out.println("例如：2050-10-01");
		Scanner scanner=new Scanner(System.in);
		String date =scanner.nextLine();
		String sql="SELECT DATE AS'日期' ," + "money AS '金额' ," + "msg AS'消费详情' FROM bill WHERE DATE='"+date+"'  ORDER BY money DESC";
		ResultSet re = statement.executeQuery(sql);
		int count = 0;
		StringBuffer str = new StringBuffer();
		double sum=0;
		while (re.next()) {
			count++;
			sum+=re.getDouble("金额");
			str.append("日期：" + re.getString("日期") + "  金额：" + re.getDouble("金额") + "  消费：" + re.getString("消费详情")+"\n");
		}
		
		System.out.println("共查到 "+count+" 条记录");
		System.out.println("共消费 "+sum+" 元");
		System.out.println(str.toString());

		connection.close();
		statement.close();
	}

}
