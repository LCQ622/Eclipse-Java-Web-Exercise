package cn.mcandroid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jmx.snmp.SnmpStringFixed;

import cn.mcandroid.service.StuService;
import cn.mcandroid.service.StuService2;
import cn.mcandroid.stus.Stu;
import cn.mcandroid.stus.Stus;

/**
 * 设置控制器
 * 
 * @author XiaoXin-700
 *
 */
@Controller
public class Test1 {

	@Autowired
	private StuService stuService;
	/*
	 * 当接口有多个实现类的时候需要使用 @Qualifier 来限定使用哪个实现类
	 * 
	 * @Qualifier("限定的实现类名") 但是要注意的是，限定的实现类名需要，将首字母小写。
	 */

	@Autowired
	@Qualifier("stuService2impl2")

	private StuService2 stuService2;

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public ModelAndView t1(HttpServletRequest req, HttpSession session) {
		ModelAndView mView = new ModelAndView();
		String str = req.getParameter("str");
		mView.addObject("str", str);
		session.setAttribute("str", str);
		mView.setViewName("test1");
		return mView;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView t2() {
		ModelAndView mView = new ModelAndView();
		List<Stus> list = stuService2.findAll();
		mView.addObject("list", list);
		mView.setViewName("test2");
		return mView;

	}

	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public ModelAndView t3() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("test5");
		return mView;

	}

	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public ModelAndView t6() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("test6");
		return mView;

	}

	@RequestMapping(value = "/test7", method = RequestMethod.GET)
	public ModelAndView t7(@RequestParam(value = "username", defaultValue = "defaultUsername") String user,
			@RequestParam(defaultValue = "defaultPassword") String pwd) {
		ModelAndView mView = new ModelAndView();

		mView.addObject("username", user);
		mView.addObject("pwd", pwd);
		mView.setViewName("test7");
		return mView;

	}

	@RequestMapping(value = "/test8", method = RequestMethod.GET)
	public ModelAndView t8(String username, String pwd) {
		ModelAndView mView = new ModelAndView();

		mView.addObject("username", username);
		mView.addObject("pwd", pwd);
		mView.setViewName("test8");
		return mView;

	}

	@RequestMapping(value = "/test9/{id}/{id2}", method = RequestMethod.GET)
	public ModelAndView t9(@PathVariable String id, @PathVariable String id2) {
		ModelAndView mView = new ModelAndView();
		mView.addObject("id", id);
		mView.addObject("id2", id2);
		mView.setViewName("test9");
		return mView;
	}

	@RequestMapping(value = "/test10", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> t10() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "脏兮兮");
		map.put("age", "21");
		return map;
	}
	
	@RequestMapping(value = "/test11", method = RequestMethod.GET)
	@ResponseBody
	public  List<Stu> t11(){
	List list=stuService.getStuAll();
		return list;
	}
	
	
	@RequestMapping(value="/test12",method=RequestMethod.GET)
	public  ModelAndView t12( ) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("test12");
		return modelAndView;
	}

}
