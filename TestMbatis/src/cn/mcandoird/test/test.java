package cn.mcandoird.test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.mcandoird.mapper.BillMapper;
import cn.mcandoird.pojo.Bill;

public class test {

	public static void main(String[] args)throws Exception {
		InputStream iStream=Resources.getResourceAsStream("mybatis.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session=factory.openSession();
		
	
		
		
		session.close();
	}

	/**
	  *   多条查询 返回map  
	 * @param session
	 */
	public static void t4(SqlSession session) {
		//session.selectMap(mapper配置文件的命名空间对应的方法，数据库中的字段,将用来做map 的key)
		Map<String, Bill>map=session.selectMap("cn.mcandoird.mapper.BillMapper.getAllmap","id");
		System.out.println(map);
	}

	/**
	  *   单个查询 只返回一个对象
	 * @param session
	 */
	public static void t3(SqlSession session) {
		Bill bill=session.selectOne("cn.mcandoird.mapper.BillMapper.getMaxMoney");
		System.out.println(bill);
	}


	/**
	  * 不使用接口 获取所有数据
	 * @param session
	 */
	public static void t2(SqlSession session) {
		List<Bill>list=session.selectList("cn.mcandoird.mapper.BillMapper.getAll");
		for (Bill bill : list) {
			System.out.println(bill);
		}
	}

	
	/**
	 * 使用接口的方式 获取所有数据
	 * @param session
	 */
	public  static void t1(SqlSession session) {
		//得到接口的实现
		BillMapper mapper=session.getMapper(BillMapper.class);
		//调用接口的方法
		List<Bill> list=mapper.getAll();
		for (Bill bill : list) {
			System.out.println(bill);
		}
	}
}
