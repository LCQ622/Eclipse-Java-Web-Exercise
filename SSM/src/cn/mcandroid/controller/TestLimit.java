package cn.mcandroid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;

import cn.mcandroid.service.StuService2;
import cn.mcandroid.stus.Stus;

@Controller
public class TestLimit {
	@Autowired
	@Qualifier("stuService2impl2")
	private StuService2 service2;

	
	@RequestMapping(value="/Limit")
	@ResponseBody
	public String  t1() {
		PageHelper.startPage(0, 10, true);
		List< Stus>list=service2.findAll();
		Gson gson=new  Gson();
		return gson.toJson(list);
	}

}
