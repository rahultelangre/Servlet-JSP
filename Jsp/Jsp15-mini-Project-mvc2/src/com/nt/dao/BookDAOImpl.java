package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBo;

public class BookDAOImpl implements BookDAO{
 private static final String QUERY_FOR_RETRIVE="SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,CATEGORY FROM BOOK_DETAILS WHERE CATEGORY=? ";
	@Override
	public List<BookBo> findBooks(String category) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookBo> listBo=null;
		BookBo  bo=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//get Connection  from conn pool
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		//create prepare statement
		ps=con.prepareStatement(QUERY_FOR_RETRIVE);
		//execute query
	      //set the data
		ps.setString(1, category);
		//execute Query
		rs=ps.executeQuery();
		//copy result set object records listBo
		listBo=new ArrayList<BookBo>();
		while(rs.next()) {
			//copy record of rs to bo class object
			bo=new BookBo();
			bo.setBookid(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setCategory(rs.getString(5));
			listBo.add(bo);
		}
		//add BookBo Object to listBo
		
		return listBo;
		
	}//method
}//class
