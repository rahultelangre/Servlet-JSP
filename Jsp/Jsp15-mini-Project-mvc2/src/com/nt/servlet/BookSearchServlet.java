package com.nt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.service.BookSearchService;


public class BookSearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String category=null;
		String source=null;
		BookSearchService service=null;
		List<BookDTO> listDTO=null;
		RequestDispatcher rd=null;
		
		//read form data
		category=req.getParameter("category");
		source=req.getParameter("source");
		//use service
		service=new BookSearchService();
		try {
			listDTO=service.search(category);
			
		}
		catch(Exception e) {
			//rd=req.getRequestDispatcher("/err.jsp");
			//rd.forward(req, res);
			e.printStackTrace();
			return;
		}
		//keep
		req.setAttribute("booksList", listDTO);
	    if(source.equals("html")) {
	    	rd=req.getRequestDispatcher("html_screen.jsp");
	    }
	    else {
	    	rd=req.getRequestDispatcher("/excel_screen.jsp");
	    }
	    rd.forward(req, res);
	}//do get
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
