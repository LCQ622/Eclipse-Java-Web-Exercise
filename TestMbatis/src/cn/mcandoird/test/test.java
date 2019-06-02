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
	  *   ������ѯ ����map  
	 * @param session
	 */
	public static void t4(SqlSession session) {
		//session.selectMap(mapper�����ļ��������ռ��Ӧ�ķ��������ݿ��е��ֶ�,��������map ��key)
		Map<String, Bill>map=session.selectMap("cn.mcandoird.mapper.BillMapper.getAllmap","id");
		System.out.println(map);
	}

	/**
	  *   ������ѯ ֻ����һ������
	 * @param session
	 */
	public static void t3(SqlSession session) {
		Bill bill=session.selectOne("cn.mcandoird.mapper.BillMapper.getMaxMoney");
		System.out.println(bill);
	}


	/**
	  * ��ʹ�ýӿ� ��ȡ��������
	 * @param session
	 */
	public static void t2(SqlSession session) {
		List<Bill>list=session.selectList("cn.mcandoird.mapper.BillMapper.getAll");
		for (Bill bill : list) {
			System.out.println(bill);
		}
	}

	
	/**
	 * ʹ�ýӿڵķ�ʽ ��ȡ��������
	 * @param session
	 */
	public  static void t1(SqlSession session) {
		//�õ��ӿڵ�ʵ��
		BillMapper mapper=session.getMapper(BillMapper.class);
		//���ýӿڵķ���
		List<Bill> list=mapper.getAll();
		for (Bill bill : list) {
			System.out.println(bill);
		}
	}
}
