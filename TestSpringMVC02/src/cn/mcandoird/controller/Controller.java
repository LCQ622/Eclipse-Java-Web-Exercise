package cn.mcandoird.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping(value="/aaa",method=RequestMethod.GET)
	public ModelAndView  t1() {
		ModelAndView mView=new ModelAndView();
		mView.setViewName("01");
		return mView;
	}
}
