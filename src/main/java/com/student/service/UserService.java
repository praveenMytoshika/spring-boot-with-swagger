package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.student.entity.Student;
import com.student.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	public List<Student> getDetails(){
		
		return userRepository.findAll();
	}
	
	 public Optional<Student> getDetail(long id) {
	    	
	    	return userRepository.findById(id);
	    }
	 
	 public Student findByEmail(String email) {
		 return userRepository.findByEmail(email);
	 }
	
    public Student addDetails(Student student) {
      
        return userRepository.save(student); 
    }
    
    public boolean updateDetails(Student student) {
    	
    	Optional<Student>entityOptional=userRepository.findById(student.getId());
    	if(!entityOptional.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID is not valid");
    	}
    	userRepository.save(student);
    	
    	
    	return true;
    }
    
    public void deleteDetails(long id) {
    	
    	Student entity=userRepository.getOne(id);
    	 userRepository.delete(entity);
    	
    } 

   
}