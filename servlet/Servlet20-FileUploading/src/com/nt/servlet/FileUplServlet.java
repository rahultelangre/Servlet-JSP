package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

@WebServlet("/updurl")
public class FileUplServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest multi=null;
		UploadBean bean=null;
		Hashtable ht=null;
		Enumeration e=null;
		//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		try {
			//prepare special request object
			multi=new MultipartFormDataRequest(req);
		    //specfy file uploading setting
			bean=new UploadBean();
			bean.setFolderstore("E:/store");
			bean.setFilesizelimit(1000000);
			bean.setOverwrite(false);
			//complete file uploading
			bean.store(multi);
			//display the names of uploaded files
			pw.println("<h1>the uploaded files are </h1>");
			ht=multi.getFiles();
			e=ht.elements();
			while(e.hasMoreElements()) {
				UploadFile file=(UploadFile)e.nextElement();
				pw.println("<br>"+file.getFileName()+" "+file.getFileSize());
			}//while
		}//try
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	

}
