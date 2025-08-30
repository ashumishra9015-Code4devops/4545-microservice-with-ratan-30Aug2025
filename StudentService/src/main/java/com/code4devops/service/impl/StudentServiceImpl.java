package com.code4devops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code4devops.dao.StudentDao;
import com.code4devops.pojo.StudentPojo;
import com.code4devops.service.StudentService;

@Service

public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	
	@Override
	@Transactional
	public List<StudentPojo> findAll() {
		return studentDao.findAll();
	}

	@Override
	@Transactional
	public StudentPojo findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	@Transactional
	public StudentPojo save(StudentPojo student) {
		return studentDao.save(student);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		studentDao.deleteById(id);
	}

}
