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
		System.out.println("������Ҫ��ѯ������");
		System.out.println("���磺2050-10-01");
		Scanner scanner=new Scanner(System.in);
		String date =scanner.nextLine();
		String sql="SELECT DATE AS'����' ," + "money AS '���' ," + "msg AS'��������' FROM bill WHERE DATE='"+date+"'  ORDER BY money DESC";
		ResultSet re = statement.executeQuery(sql);
		int count = 0;
		StringBuffer str = new StringBuffer();
		double sum=0;
		while (re.next()) {
			count++;
			sum+=re.getDouble("���");
			str.append("���ڣ�" + re.getString("����") + "  ��" + re.getDouble("���") + "  ���ѣ�" + re.getString("��������")+"\n");
		}
		
		System.out.println("���鵽 "+count+" ����¼");
		System.out.println("������ "+sum+" Ԫ");
		System.out.println(str.toString());

		connection.close();
		statement.close();
	}

}
