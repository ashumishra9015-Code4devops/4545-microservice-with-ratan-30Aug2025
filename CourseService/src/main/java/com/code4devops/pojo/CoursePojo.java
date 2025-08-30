package com.code4devops.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "code4devops_Course")
public class CoursePojo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private Integer id;
private String name;
private String duration;
private String fees;
private String roomNo;  
}
