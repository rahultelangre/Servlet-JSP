package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.NaukariBO;

public class NaukariDAOImpl implements NaukariDao {
 private static final String INSERT_NAUKARI="INSERT INTO NAUKARI_COM VALUES(NAUKARI_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
	public int savaData(NaukariBO bo) throws Exception{
	  String name=null;
	  String addrs=null;
	  int age=0;
	  String skills=null;
	  int exp=0;
	  String hobby=null;
	  String preferCity=null;
	  float expSalary=0;
	  Connection con=null;
	  PreparedStatement ps=null;
	  int result=0;
	  InitialContext ic=null;
	  DataSource ds=null;
	  
	  //locate the jndi registry
	  ic=new InitialContext();
	  //get DataSource object
	  ds=(DataSource) ic.lookup("java:/comp/env/Dsjndi");
	  
 
	  //get bo object bo=new NaukariBO();
	 
	  
	  name=bo.getName();
	  addrs=bo.getAddrs();
	  age=bo.getAge();
	  skills=bo.getSkills();
	  exp=bo.getExp();
	  hobby=bo.getHobby();
	  preferCity=bo.getPreferCity();
	  expSalary=bo.getExpSalary();
	  
	  //get connection
	  con=ds.getConnection();
	  //create connection
	  ps=con.prepareStatement(INSERT_NAUKARI);
	  //set properties to query
	  ps.setString(1, name);
	  ps.setInt(2, age);
	  ps.setString(3, skills);
	  ps.setInt(4,exp );
	  ps.setString(5,hobby);
	  ps.setString(6,preferCity );
	  ps.setFloat(7,expSalary);
	  ps.setString(8, addrs);
	  
	  result=ps.executeUpdate();
	  return result;
	  }

}
