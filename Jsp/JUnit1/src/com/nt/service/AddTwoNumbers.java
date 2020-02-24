package com.nt.service;

public class AddTwoNumbers {
	
	
	public static  int sum(int a,int b) {
		int s=0;
		if(a<0 || b<0) 
		  throw new IllegalArgumentException();
			return a+b;
	}

}
