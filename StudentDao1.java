package com.slokam.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.slokam.pojo.Student;
import com.slokam.pojo.StudentPojo;

public class StudentDao1 {
	private HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	//List<Student> list=new ArrayList<Student>();
	public List<Student> verifyUser(){
		
		List<Student> std=(List<Student>)ht.loadAll(Student.class);
		return std;
	}
	  @Transactional
		public void saveAndUpdate(StudentPojo student) {
			ht.saveOrUpdate(student);
		}

		public List<StudentPojo> getAllStudentsData() {
			List<StudentPojo> loadAll = ht.loadAll(StudentPojo.class);
			return loadAll;
		}

		public StudentPojo getStudentById(int id) {
			StudentPojo student = ht.get(StudentPojo.class, id);
			return student;
		}
		 @Transactional
		public void deleteStudent(int id) {
			StudentPojo std = new StudentPojo();
			std.setId(id);
			ht.delete(std);

		}

}
