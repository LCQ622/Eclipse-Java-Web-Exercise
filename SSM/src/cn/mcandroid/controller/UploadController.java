package cn.mcandroid.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public ModelAndView t1() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("upload");
		return mv;
	}
	
	
	@RequestMapping(value="/upsub",method=RequestMethod.POST)
	@ResponseBody
	public String t2(@RequestParam("file") MultipartFile file ,HttpServletRequest req) {
		try {
			file.transferTo(new File("e:/"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "上传成功，"+file.getOriginalFilename()+",文本1："+req.getParameter("msg1")+",文本2："+req.getParameter("msg2");
	}
}
