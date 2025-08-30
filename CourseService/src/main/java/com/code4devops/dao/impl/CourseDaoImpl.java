package com.code4devops.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code4devops.dao.CourseDao;
import com.code4devops.pojo.CoursePojo;

import jakarta.persistence.EntityManager;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<CoursePojo> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("from CoursePojo", CoursePojo.class);
		List<CoursePojo> studentList = theQuery.getResultList();
		return studentList;
	}

	@Override
	public CoursePojo findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		CoursePojo student = session.get(CoursePojo.class, id);
		return student;
	}

	@Override
	public CoursePojo save(CoursePojo course) {
		Session session = entityManager.unwrap(Session.class);
		return course=session.merge(course);

	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		//Query<CoursePojo> theQuery = session.createQuery("delete from Customer where CoursePojo=:id");
		Query<CoursePojo> theQuery = session.createQuery("delete from CoursePojo where id = :id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();

	}

}
