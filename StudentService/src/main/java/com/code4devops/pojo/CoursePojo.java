package com.code4devops.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePojo {
private Integer id;
private String name;
private String duration;
private String fees;
private String roomNo;  
}
