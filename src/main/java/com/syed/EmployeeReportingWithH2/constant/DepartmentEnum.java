package com.syed.EmployeeReportingWithH2.constant;

public enum DepartmentEnum {
	
	
	
	BANKING("banking"), HEALTCARE("healthcare"), PRODUCT("product");

	private String department;

	private DepartmentEnum(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
	}


