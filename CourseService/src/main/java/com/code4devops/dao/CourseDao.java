package com.code4devops.dao;

import java.util.List;

import com.code4devops.pojo.CoursePojo;

public interface CourseDao {
	public abstract List<CoursePojo> findAll();
	public abstract CoursePojo findById(int id);
	public abstract CoursePojo save(CoursePojo course);
	public abstract void deleteById(int id);
}
