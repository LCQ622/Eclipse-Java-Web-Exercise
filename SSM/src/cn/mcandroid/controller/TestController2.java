package cn.mcandroid.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cn.mcandroid.service.StuService2;
import cn.mcandroid.stus.Stus;

@Controller
@RequestMapping("/abc")
public class TestController2 {
	@Autowired
	@Qualifier("stuService2impl2")
	private  StuService2 stuService2;
	
	@RequestMapping(value="/test3",method=RequestMethod.GET)
	public  ModelAndView test() {
		ModelAndView mv=new  ModelAndView();
		mv.setViewName("/test3");
		List<Stus>list=stuService2.findAll();
		mv.addObject("list",list);
		return mv;
	}
	
	
	@RequestMapping(value="/test4",method=RequestMethod.GET)
	public  ModelAndView test2() {
		ModelAndView mView=new ModelAndView();
		List <Stus>list =stuService2.findAll();
		mView.setViewName("test4");
		mView.addObject("list", list);
		return mView;
	}

}
