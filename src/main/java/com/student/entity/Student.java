package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Student details")
@Entity
@Table(name ="user")
public class Student {

	@ApiModelProperty(notes="auto generated")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ApiModelProperty(required=true, notes="enter email")
    private String email;
	
	@ApiModelProperty(required=true, notes="enter password")
	@Size(
	    min=6,
	    max=12,
	    message="property '${validatedValue}' should be between {min} and {max} characters")
	
    private String password;
	
	@ApiModelProperty(required=true, notes="enter name")
	@Size(
		    min=3,
		    max=15,
		    message="property '${validatedValue}' should be between {min} and {max} characters")
    private String name;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String email, String password, String name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
    
   
    
   
    
   
    
}
