package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	
	public List<Department> fetchDepartmentList() ;
	
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;


	public void deleteDepartmentById(Long departmentId);


	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
