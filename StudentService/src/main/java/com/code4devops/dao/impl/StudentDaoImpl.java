package com.code4devops.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code4devops.dao.StudentDao;
import com.code4devops.pojo.StudentPojo;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<StudentPojo> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("from StudentPojo", StudentPojo.class);
		List<StudentPojo> studentList = theQuery.getResultList();
		return studentList;
	}

	@Override
	public StudentPojo findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		StudentPojo student = session.get(StudentPojo.class, id);
		return student;
	}

	@Override
	public StudentPojo save(StudentPojo student) {
		Session session = entityManager.unwrap(Session.class);
		return student=session.merge(student);

	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		//Query<StudentPojo> theQuery = session.createQuery("delete from Customer where StudentPojo=:id");
		Query<StudentPojo> theQuery = session.createQuery("delete from StudentPojo where id = :id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();

	}

}
