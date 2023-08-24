package com.syed.EmployeeReportingWithH2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.syed.EmployeeReportingWithH2.entity.Employee;
import com.syed.EmployeeReportingWithH2.service.EmployeeService;



@Controller
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	Employee saveEmployee(@RequestBody Employee e)
	{
		Employee emp=employeeService.saveEmployee(e);
		return emp;
	}
	
	@GetMapping("/getMonthlyAllocation/{id}")
	Integer getMonthlyAllocation(@PathVariable Integer id)
	{
		Integer i=employeeService.totalAllocationByManager(id);
		return i;
		
	}
	
	@GetMapping("/getDepartmentAllocation/{dept}")
	Integer getMonthlyAllocation(@PathVariable String dept)
	{
		Integer i=employeeService.totalAllocationByDepartment(dept);
		return i;
		
	}
	
	
	@GetMapping("/managerwithnoteam")
	List<String> managerwithnoteam()
	{
		return(employeeService.getmanagerwithnoteam());
		
	}
	
	
	
	

}
