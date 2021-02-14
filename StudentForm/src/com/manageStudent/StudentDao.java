package com.manageStudent;

import java.util.List;

import com.pojos.Student;

public interface StudentDao {
	
	public void addStudent(Student student);
	
	public List<Student> getStudents();

}
