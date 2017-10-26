package com.slokam.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.slokam.pojo.StudentPojo;

public class HibStudentDao {

	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void saveStudent(StudentPojo student){
		hibernateTemplate.saveOrUpdate(student);
	}
	
	public List<StudentPojo> getAllStudents(){
		return hibernateTemplate.loadAll(StudentPojo.class);
	}
	
	public StudentPojo getStudentById(int id){
		return hibernateTemplate.get(StudentPojo.class, id);
	}
	@Transactional
	public void deleteStudent(int id){
		StudentPojo studentpojo = new StudentPojo();
		studentpojo.setId(id);
		hibernateTemplate.delete(studentpojo);
	}
	
	public boolean checkStudentByName(String name){
		String hql = "from StudentPojo where name=?";
		List<StudentPojo> list =  (List<StudentPojo>) hibernateTemplate.find(hql, name);
		if(list == null || list.size()==0)
			return false;
		else
			return true;
	}
	
	public List<String> lookupStudentNames(String name){
		
		String hql = "select name from StudentPojo where name like ?";
		List<String> list = (List<String> ) hibernateTemplate.find(hql, name+"%");
		for (String string : list) {
			System.out.println(string);
			
		}
		return list;
		
		
	}
	
}



