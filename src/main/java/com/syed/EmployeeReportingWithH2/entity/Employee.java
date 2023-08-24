package com.syed.EmployeeReportingWithH2.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="EmployeeTable")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	private String designation;
	private Integer supervisorId;
	private String department;
	
	public Employee()
	{
		
	}
	
	public Employee(Integer empId, String empName, String designation, Integer supervisorId,String department) {
		super();
		this.empId=empId;
		this.empName = empName;
		this.designation = designation;
		this.supervisorId = supervisorId;
		this.department=department;
	}

}
