package cn.mcandroid.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.mcandroid.stu.Student;

public class Test1 {
	public static void main(String[] args) {
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis_conf.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		List<Student>list=session.selectList("cn.mcandroid.mapper.StuMapperxml.getStuAll");
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}

}
