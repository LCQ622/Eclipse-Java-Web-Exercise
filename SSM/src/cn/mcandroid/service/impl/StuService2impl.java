package cn.mcandroid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mcandroid.dao.StusMapper;
import cn.mcandroid.service.StuService2;
import cn.mcandroid.stus.Stus;
import cn.mcandroid.stus.StusExample;

@Service 
public class StuService2impl implements StuService2 {
	@Autowired
	private StusMapper stusMapper;

	@Override
	public List<Stus> findAll() {
		StusExample example=new StusExample();
		example.setOrderByClause("id asc");
		return stusMapper.selectByExample(example);
	}

}
