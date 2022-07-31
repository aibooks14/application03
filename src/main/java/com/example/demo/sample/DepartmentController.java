package com.example.demo.sample;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private  DepartmentService departmentservice ;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class) ;
	
	
	//To save the data
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		System.out.println("Running saveDepartment in Department conroller & Data is saved to database ");
		LOGGER.info("Inside saveDepartment of  DepartmentController" ) ;
		return departmentservice.saveDepartment(department) ;// service layer & repository is working
	}
	
	@Autowired
	private DepartmentService departmentService;
	
	//To get all the departments saved into the DB.
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		System.out.println("Fetching departmentList in Department conroller from database ");
		LOGGER.info("Inside fetchDepartmentList of DepartmentController") ;
		return departmentService.fetchDepartmentList() ;
	}
	

	//To get(fetch) the data from database by entering the ID only.
	@GetMapping("/departments/{id}") 
	public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		System.out.println("Fetching the data from the databse of the ID " + departmentId );
		return departmentService.fetchDepartmentById(departmentId) ;
	}
	
	//TO delete data from DB by using ID
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId) ;
		System.out.println("Data of ID " + departmentId +" is deleted Successfully ");
		return "Department deleted Successfully" ;
	}
	
	//To Update the data
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		System.out.println("Data of " + departmentId + " is updated");
		return departmentService.updateDepartment(departmentId, department) ;
	}
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		System.out.println("Department Name is Fetched from Database " + departmentName);
		return departmentService.fetchDepartmentByName(departmentName) ;
		
	}
	
}






















