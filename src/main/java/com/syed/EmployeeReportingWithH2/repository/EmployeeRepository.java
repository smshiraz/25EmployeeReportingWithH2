package com.syed.EmployeeReportingWithH2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.syed.EmployeeReportingWithH2.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	public List<Employee> findBySupervisorId(@Param("empId") Integer empId);
	
	public List<Employee> findByDepartment(@Param("department") String department);
	
	
	@Query("Select E.empName from Employee E where E.designation='manager' AND E.empId NOT IN( Select F.supervisorId from Employee F )")
	public List<String> getManagerWithNoTeam();
	

}
