package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO  {

	private static final String REGISTER_QUERY="INSERT INTO LAYERED_STUDENT VALUES(?,?,?,?,?)";
	private static Connection getpooledConnection() throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		//locate the jndi registry
		ic=new InitialContext();
		//get DataSource object
		ds=(DataSource) ic.lookup("java:/comp/env/Dsjndi");
		//get connection
		con=ds.getConnection();
		return con;
		
		
	}//get pooled connectio
	@Override
	public int register(StudentBO bo) throws Exception {
        
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get connection
		con=getpooledConnection();
		//create prepare statment
		ps=con.prepareStatement(REGISTER_QUERY);
		//set values to prepare statement
		ps.setInt(1,bo.getSno());
		ps.setString(2, bo.getSname());
		ps.setFloat(3,bo.getTotalNumber());
		ps.setFloat(4,bo.getAvg());
		ps.setString(5,bo.getResult());
		
		//execute the query
		result=ps.executeUpdate();
		
		return result;
	}//register

}//class
