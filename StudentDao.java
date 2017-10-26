package com.slokam.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.slokam.pojo.Student;
import com.slokam.pojo.StudentPojo;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
   public Student verifyUser(String uname,String password){
	   String qry="select * from f16.studentlogin where uname=? and password=?";
	   Student std=(Student)jdbcTemplate.queryForObject(qry, new BeanPropertyRowMapper(Student.class),uname,password);
	return std;
	   
   }
}
