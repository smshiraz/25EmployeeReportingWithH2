package com.syed.EmployeeReportingWithH2.constant;

public enum EmployeeType {

	MANAGER("manager", 600), QATESTER("qatester", 1000), DEVELOPER("developer", 2000);

	private String empType;
	private int allocation;

	private EmployeeType(String empType, int allocation) {
		this.empType = empType;
		this.allocation = allocation;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public int getAllocation() {
		return allocation;
	}

	public void setAllocation(int allocation) {
		this.allocation = allocation;
	}

}
