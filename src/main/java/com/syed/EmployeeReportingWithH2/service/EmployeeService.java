package com.syed.EmployeeReportingWithH2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syed.EmployeeReportingWithH2.constant.EmployeeType;
import com.syed.EmployeeReportingWithH2.entity.Employee;
import com.syed.EmployeeReportingWithH2.exception.ResourceNotFoundException;
import com.syed.EmployeeReportingWithH2.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	int totalAllocation;
	int totalAllocationbydept;

	public Employee saveEmployee(Employee employee) {

		return repository.save(employee);
	}

	public int totalAllocationByManager(int id)
	{
		 totalAllocation=EmployeeType.MANAGER.getAllocation();
		Employee e=repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id:" + id));
		
		if(!(e.getDesignation().equals(EmployeeType.MANAGER.getEmpType())))
				{
			     throw new RuntimeException("id is not of a manger");
				}
		
		List<Employee> empList=repository.findBySupervisorId(id);
		if(empList!=null)
		{
		empList.forEach(i->
	      {
			if(i.getDesignation().equals(EmployeeType.MANAGER.getEmpType()))
		    {
				totalAllocation=totalAllocation+EmployeeType.MANAGER.getAllocation();
				
				List<Employee> empList2=repository.findBySupervisorId(i.getEmpId());
				if(empList2!=null)
				{
				empList2.forEach(j->
			      {
					if(j.getDesignation().equals(EmployeeType.MANAGER.getEmpType()))
				    {
						totalAllocation=totalAllocation+EmployeeType.MANAGER.getAllocation();
						
						
					}
					
					if(j.getDesignation().equals(EmployeeType.DEVELOPER.getEmpType()))
				    {
						totalAllocation=totalAllocation+EmployeeType.DEVELOPER.getAllocation();
					}
					if(j.getDesignation().equals(EmployeeType.QATESTER.getEmpType()))
				    {
						totalAllocation=totalAllocation+EmployeeType.QATESTER.getAllocation();
					}
					
			      });
				}
		    }
			
			if(i.getDesignation().equals(EmployeeType.DEVELOPER.getEmpType()))
		    {
				totalAllocation=totalAllocation+EmployeeType.DEVELOPER.getAllocation();
			}
			if(i.getDesignation().equals(EmployeeType.QATESTER.getEmpType()))
		    {
				totalAllocation=totalAllocation+EmployeeType.QATESTER.getAllocation();
			}
			
	      });
		}
		return totalAllocation;
	}
	
	public int totalAllocationByDepartment(String departmentName)
	{
		totalAllocationbydept=0;
		List<Employee> empList=repository.findByDepartment(departmentName);
		empList.forEach(i->
	      {
			if(i.getDesignation().equals(EmployeeType.MANAGER.getEmpType()))
		    {
				totalAllocationbydept=totalAllocationbydept+EmployeeType.MANAGER.getAllocation();
		    }
			if(i.getDesignation().equals(EmployeeType.DEVELOPER.getEmpType()))
		    {
				totalAllocationbydept=totalAllocationbydept+EmployeeType.DEVELOPER.getAllocation();
			}
			if(i.getDesignation().equals(EmployeeType.QATESTER.getEmpType()))
		    {
				totalAllocationbydept=totalAllocationbydept+EmployeeType.QATESTER.getAllocation();
			}
			
	      });
		return totalAllocationbydept;
	}
	
	public List<String> getmanagerwithnoteam()
	{
		return(repository.getManagerWithNoTeam());
	}

}
