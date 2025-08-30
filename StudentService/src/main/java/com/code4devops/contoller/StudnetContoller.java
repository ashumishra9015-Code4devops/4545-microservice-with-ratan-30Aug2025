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
import org.springframework.web.client.RestTemplate;

import com.code4devops.pojo.CoursePojo;
import com.code4devops.pojo.StudentPojo;
import com.code4devops.service.StudentService;

@RestController
@RequestMapping("student/api")
public class StudnetContoller {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RestTemplate restTemplate;
		
	@PostMapping("/save")
	public  StudentPojo getEmployeeSave(@RequestBody StudentPojo theStudentPojo) {
		//theStudentPojo.setId(0);
		StudentPojo studentPojo=studentService.save(theStudentPojo);
		return studentPojo;
	}
		
	
	@GetMapping("/list")
	public List<StudentPojo> getAllEmployeeList() {
		return studentService.findAll();
		
	}
			
	
	@GetMapping("/view/{theStudentPojoId}")
	public StudentPojo getSingleStudentPojoView(@PathVariable("theStudentPojoId") int theStudentPojoId) {
		StudentPojo student=studentService.findById(theStudentPojoId);
		//CoursePojo course=this.restTemplate.getForObject("http://localhost:8082/course/api/view/"+student.getId(), CoursePojo.class);
		
		CoursePojo course=this.restTemplate.getForObject("http://course-service/course/api/view/"+student.getId(), CoursePojo.class);
		student.setCoursePojo(course);
		return student;
	}
	
	
	@DeleteMapping("/delete/{theStudentPojoId}")
	public String getEmployee(@PathVariable("theStudentPojoId") int theStudentPojoId) {
		StudentPojo StudentPojo=studentService.findById(theStudentPojoId);
			if( StudentPojo == null) {
				throw new RuntimeException("Employee id not found  :"+ theStudentPojoId);
			}
			studentService.deleteById(theStudentPojoId);
			
		return "Delete StudentPojo id :" +theStudentPojoId;	
	}
	
	
	@PutMapping("/update")
	public StudentPojo getEmployeeUpdate(@RequestBody StudentPojo StudentPojo) {
		studentService.save(StudentPojo);
		return StudentPojo;
	}
}
