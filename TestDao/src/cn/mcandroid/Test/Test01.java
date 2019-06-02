package cn.mcandroid.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.mcandroid.Stu;

public class Test01 {
	public static void main(String[] args) throws IOException {
		InputStream iStream=Resources .getResourceAsStream("mybatis_config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session=factory.openSession();
		List<Stu>list=session.selectList("cn.mcandroid.dao.StuMapper.getAllStus");
		for(Stu s:list) {
			System.out.println(s.toString());
		}
		
		session.close();
	}

}
