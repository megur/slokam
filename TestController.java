package com.slokam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slokam.dao.StudentDAO;


@Controller
public class TestController {

	@Autowired
	private StudentDAO studentDao;
	


	@RequestMapping("test1")
	public String test1(){
		System.out.println("This is test1 ...");
		return "login";
	}
	
	
	@RequestMapping("test2")
	public String test2(String name, String password){
		
		System.out.println(name);
		System.out.println(password);
		boolean result = studentDao.verifyUser(name, password);
		if(result==true)
	 	   return "home1";
		else
		  return "login";	
	}
	
	/*@RequestMapping("test2")
	public void test2(ServletRequest request,ServletResponse response){
		response.setContentType("text/html");
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("User Name::"+userName);
		System.out.println("Password::"+password);
		
		System.out.println("This is test2");
		RequestDispatcher rd = request.getRequestDispatcher("home.html");
		try{
		  rd.forward(request, response);
		}
		catch(ServletException e ){
			e.printStackTrace();
		}
		catch(IOException e ){
			e.printStackTrace();
		}
	}*/
	
	
}




