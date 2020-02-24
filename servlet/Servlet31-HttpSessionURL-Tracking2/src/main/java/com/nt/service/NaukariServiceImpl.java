package com.nt.service;

import com.nt.bo.NaukariBO;
import com.nt.dao.NaukariDAOImpl;
import com.nt.dao.NaukariDao;
import com.nt.dto.NaukariDTO;

public class NaukariServiceImpl implements NaukariService {

	public String register(NaukariDTO dto) throws Exception {
		NaukariBO bo=null;
		NaukariDao dao=null;
		int count=0;
		//convert data to dto to bo
		bo=new NaukariBO();
		
		bo.setName(dto.getName());
		bo.setAddrs(dto.getAddrs());
		bo.setAge(dto.getAge());
		bo.setSkills(dto.getSkills());
		bo.setExp(dto.getExp());
		bo.setHobby(dto.getHobby());
		bo.setExpSalary(dto.getExpSalary());
		bo.setPreferCity(dto.getPreferCity());
		
		//get dao obj
		dao=new NaukariDAOImpl();
		//call save method
        count=dao.savaData(bo);		
		if(count==0) {
			return "Your profile is not created";
		}
		else {
			return "Your profile is created all the best for interviews...";
		}

	}//method

}//class
