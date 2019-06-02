package cn.mcandoird.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.mcandoird.stu.Stu;

public class Test01 {
	public static void main(String[] args) {
		try {
			InputStream is=Resources.getResourceAsStream("mybatis_conf.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession();
			List <Stu>list=session.selectList("cn.mcandoird.Mapper.StuMapper.getStuAll");
			for (Stu stu : list) {
				System.out.println(stu.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
