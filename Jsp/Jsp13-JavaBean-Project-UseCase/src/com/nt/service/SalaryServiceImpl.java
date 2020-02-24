package com.nt.service;

import com.nt.dto.StudentBean;

public class SalaryServiceImpl implements SalaryService {

	@Override
	public void paySlip(StudentBean dto) {
		// TODO Auto-generated method stub
		float grosSalary=0.0f,netSalary=0.0f;
		//write b.logic 
		grosSalary=dto.getBasicSalary()+dto.getBasicSalary()*0.04f;
		netSalary=grosSalary-dto.getBasicSalary()*0.2f;
		//set gross,netSalary to dto object
		dto.setGrosSalary(grosSalary);
		dto.setNetSalary(netSalary);
	}
}
