package cn.mcandoird.test;

import java.sql.SQLException;
import java.util.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.mcandroid.util.DbTools;

public class Test02 {

	public static void main(String[] args) {
		String sql = "SELECT id,CONCAT(first_name,last_name)AS'name',IF(sex='M','男','女')AS 'sex'FROM stus";
		QueryRunner qr = new QueryRunner();
		List<Map<String, Object>> list = null;
		try {
			list = qr.query(DbTools.getConn(), sql, new MapListHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i <list.size(); i++) {
		
		System.out.println("ID:"+list.get(i).get("id")+",姓名："+list.get(i).get("name")+",sex:"+list.get(i).get("sex"));
		}
	}
}
