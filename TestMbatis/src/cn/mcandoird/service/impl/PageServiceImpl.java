package cn.mcandoird.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.mcandoird.page.Page;
import cn.mcandoird.service.PageService;

public class PageServiceImpl implements PageService {

	@Override
	public Page showPage(int start, int size) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<>();
		map.put("start", size * (start - 1));
		map.put("size", size);
		Page page = new Page();
		page.setPageNum(start);
		page.setPageSize(size);
		page.setList(session.selectList("cn.mcandoird.mapper.BillMapper.getPage", map));
		int count = session.selectOne("cn.mcandoird.mapper.BillMapper.getCount");
		page.setTotal(count % size == 0 ? count /size : count / size + 1);

		session.close();
		return page;
	}

}
