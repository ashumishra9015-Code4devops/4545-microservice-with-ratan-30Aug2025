package com.code4devops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code4devops.dao.CourseDao;
import com.code4devops.pojo.CoursePojo;
import com.code4devops.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	
	@Override
	@Transactional
	public List<CoursePojo> findAll() {
		return courseDao.findAll();
	}

	@Override
	@Transactional
	public CoursePojo findById(int id) {
		return courseDao.findById(id);
	}

	@Override
	@Transactional
	public CoursePojo save(CoursePojo course) {
		return courseDao.save(course);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		courseDao.deleteById(id);
	}

}
