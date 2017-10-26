package com.slokam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.slokam.dao.StudentDao1;
import com.slokam.pojo.Student;
import com.slokam.pojo.StudentPojo;
@Controller
public class StudentController1 {
	@Autowired
	private StudentDao1 hibernateDao;
	
/*	@RequestMapping("test2")
	public ModelAndView test2(String uname,String password){
		System.out.println(uname);
		System.out.println(password);
		
		List<Student> std = hibernateDao.verifyUser();
		ModelAndView mav=new ModelAndView();
		for (Student student : std) {
			if(uname.equals(student.getUname()) && password.equals(student.getPassword())){
				mav.setViewName("home1");
				return mav;
			}else{
				mav.setViewName("login1");
				return mav;
			}
		}
		return mav;
	
	}*/
	@RequestMapping("test3")
	public ModelAndView test3(StudentPojo student) {
		
		hibernateDao.saveAndUpdate(student);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home1");
		
		return mav ;
	}
	@RequestMapping("getall")
	public ModelAndView test4(){
		List<StudentPojo> allStudentsData = hibernateDao.getAllStudentsData();
		//req.setAttribute("getstudentAttr", allStudentsData);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home1");
		mav.addObject("getstudentAttr", allStudentsData);
		return mav;
	}
	@RequestMapping("getstudentbyid")
	public ModelAndView test5(int id){
		StudentPojo allStudentsData =hibernateDao.getStudentById(id);
		//System.out.println(id);
		//req.setAttribute("studentAttr", allStudentsData);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home2");
		mav.addObject("studentAttr", allStudentsData);
		return mav;
	}
	@RequestMapping("deletestudent")
	public ModelAndView test6(int id){
		hibernateDao.deleteStudent(id);
		//System.out.println(id);
		//req.setAttribute("studentAttr", allStudentsData);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home2");
		return mav;
	}
	
	@RequestMapping("checkname")
	public @ResponseBody String test7(){
		/*hibernateDao.deleteStudent(id);
		System.out.println(id);
		req.setAttribute("studentAttr", allStudentsData);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home2");*/
		System.out.println("checkname");
		return "Hello";
	}

}
