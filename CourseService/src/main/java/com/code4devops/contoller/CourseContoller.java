package com.code4devops.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code4devops.pojo.CoursePojo;
import com.code4devops.service.CourseService;

@RestController
@RequestMapping("course/api")
public class CourseContoller {
	
	@Autowired
	private CourseService courseService;
		
	@PostMapping("/save")
	public  CoursePojo getEmployeeSave(@RequestBody CoursePojo theCoursePojo) {
		CoursePojo coursePojo=courseService.save(theCoursePojo);
		return coursePojo;
	}
		
	
	@GetMapping("/list")
	public List<CoursePojo> getAllEmployeeList() {
		return courseService.findAll();
		
	}
			
	
	@GetMapping("/view/{theCoursePojoId}")
	public CoursePojo getSingleStudentPojoView(@PathVariable("theCoursePojoId") int theCoursePojoId) {
		return courseService.findById(theCoursePojoId);
	}
	
	
	@DeleteMapping("/delete/{theStudentPojoId}")
	public String getEmployee(@PathVariable("theCoursePojoId") int theCoursePojoId) {
		CoursePojo coursePojo=courseService.findById(theCoursePojoId);
			if( coursePojo == null) {
				throw new RuntimeException("Course id not found  :"+ theCoursePojoId);
			}
			courseService.deleteById(theCoursePojoId);
			
		return "Delete Course id :" +theCoursePojoId;	
	}
	
	
	@PutMapping("/update")
	public CoursePojo getEmployeeUpdate(@RequestBody CoursePojo coursePojo) {
		courseService.save(coursePojo);
		return coursePojo;
	}
}
