package com.nt.service;

public class SimpleIntrest {
	
	public static int simpleintrest(int principal,int time,int rate) {
		
		if(principal<0 || time<0 || rate<0)
			throw new IllegalArgumentException();
	        return ((principal*time*rate)/100);
	        	
	}
	
	

}
