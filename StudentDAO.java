package com.slokam.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.slokam.pojo.StudentPojo;

public class StudentDAO {

	 private JdbcTemplate jdbcTemplate;
	 
	 public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean verifyUser(String user,String password){
		
		String  query = "select count(*) from login where username = ? and password=?";
		Integer count = jdbcTemplate.queryForObject(query,Integer.class,user,password );
		
		if(count>0)
			return true;
		else
			return false;
	 }
	
	public void saveStudent(StudentPojo student){
		if(student.getId()==0){
			jdbcTemplate.update("insert into student (name,age,qual,ph,pin) values(?,?,?,?,?)",student.getName(),student.getAge(),student.getQual(),student.getPhone(),student.getPin());
		}else{
			jdbcTemplate.update("update student set name=?,age=?,qual=?,ph=?,pin=? where id=?",student.getName(),student.getAge(),student.getQual(),student.getPhone(),student.getPin(),student.getId());
		}
	
	}
	
	public List<StudentPojo> getAllStudents(){
		List<StudentPojo> list = jdbcTemplate.query("select * from student",new BeanPropertyRowMapper(StudentPojo.class) );
		return list;
	}
	
	public StudentPojo getStudentById(int id){
		StudentPojo studentPojo = (StudentPojo) jdbcTemplate.queryForObject("select * from student where id=?", new BeanPropertyRowMapper(StudentPojo.class),id);
		return studentPojo;
	}
	
	public void deleteStudent(int id){
			jdbcTemplate.update("delete from student where id=?",id);
	}
}






