package com.code4devops.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "code4devops_student")
public class StudentPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String fristName;
private String lastName;
private String aadharCard;
private String mobile;
@Transient
private CoursePojo coursePojo;
  
}
