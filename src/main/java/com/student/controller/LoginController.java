package com.student.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.entity.Student;
import com.student.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="login controller provider")
@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "get all student details")
	@GetMapping("/details")
	public List<Student> getDetails() {
		return userService.getDetails();
		
	}
	
	@ApiOperation(value = "get student details by id")
	@GetMapping("/details/{id}")
	public Optional<Student> getDetail(@PathVariable long id) {
		return userService.getDetail(id);
		
	}
	
	@ApiOperation(value = "enter new student details")
	@PostMapping("/details")
	public String addDetails(@RequestBody Student student) {
		Student studentExist=userService.findByEmail(student.getEmail());
		if(studentExist !=null) {
			return "User already exist";
		}
		else {
		userService.addDetails(student);
		return "Sucess: details added sucessfully";
		}
		
	}
	
	@ApiOperation(value = "update existing student details")
	@PutMapping("/details")
	public ResponseEntity<?> updateDetails(@RequestBody Student student) {
		
		;
		 return new ResponseEntity<>( userService.updateDetails(student),HttpStatus.OK);
	}

	@ApiOperation(value = "delete existing student")
	@DeleteMapping("/details/{id}")	
	public void deleteDetails(@PathVariable String id) {
		
		userService.deleteDetails(Long.parseLong(id));
		
	}
	
	
}
