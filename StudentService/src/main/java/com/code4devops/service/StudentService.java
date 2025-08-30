package com.code4devops.service;

import java.util.List;

import com.code4devops.pojo.StudentPojo;

public interface StudentService {
	public abstract List<StudentPojo> findAll();
	public abstract StudentPojo findById(int id);
	public abstract StudentPojo save(StudentPojo student);
	public abstract void deleteById(int id);
}
