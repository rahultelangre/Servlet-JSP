package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		float total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		StudentDAO dao=null;
		int count=0;
		//use b.logic
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3;
		if(avg<35) {
			result="fail";
		}else {
			result="pass";
		}
		//prepare bo class object  having persitable
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotalNumber(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use dao
		dao=new StudentDAOImpl();
		//invoke register method
		count=dao.register(bo);
		if(count==0) {
			return "registration failed";
		}else {
			return "registration succeded ::"+result;
		}//else
		
	}//generate result

}//class
