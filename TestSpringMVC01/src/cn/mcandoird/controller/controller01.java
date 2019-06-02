package cn.mcandoird.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller01 {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView t1() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("01");
		return mv;
	}
}
