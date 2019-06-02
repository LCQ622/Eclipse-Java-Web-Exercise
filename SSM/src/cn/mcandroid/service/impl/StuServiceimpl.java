package cn.mcandroid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mcandroid.dao.StuDao;
import cn.mcandroid.service.StuService;
import cn.mcandroid.stus.Stu;


@Service  //Service 的实现类需要在此处@Service
public class StuServiceimpl implements StuService {
	@Autowired
	private  StuDao studao;

	@Override
	public List<Stu> getStuAll() {
		return studao.getStuALL();
	}

}
