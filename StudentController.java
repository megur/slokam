package com.slokam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.dao.StudentDao;
import com.slokam.pojo.Student;
import com.slokam.pojo.StudentPojo;


@Controller
public class StudentController {
	@Autowired
	private StudentDao stdDao;
	
	@RequestMapping("studentlogin")
	public  String test7(){
		/*hibernateDao.deleteStudent(id);
		System.out.println(id);
		req.setAttribute("studentAttr", allStudentsData);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home2");*/
		
		return "login1";
	}
	
    @RequestMapping("test1")
	public ModelAndView test1(String uname,String password){
	/*System.out.println(uname);
	System.out.println(password);*/
	ModelAndView mav=new ModelAndView();
	System.out.println(uname);
	System.out.println(password);
	Student std=stdDao.verifyUser(uname,password);
	if(uname.equals(std.getUname()) && password.equals(std.getPassword())){
		mav.setViewName("home1");
		return mav;
	}
	else{
		mav.setViewName("login1");
		return mav;
	}
	
		
	}
}
