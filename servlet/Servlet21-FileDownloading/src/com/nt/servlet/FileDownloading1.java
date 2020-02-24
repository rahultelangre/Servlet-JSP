package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/downloadurl")
public class FileDownloading1 extends HttpServlet  {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext sc=null;
		File file=null;
		String path=null;
		String fileName=null;
		long length=0;
		String mimeType=null;
		InputStream is=null;
		ServletOutputStream os=null;
		
		int count=0;
		//get request param value
		fileName=req.getParameter("file");
		//create file class object and hold afile
		file=new File("E:/store/"+fileName);
		//create input stream to pointing to a file
		is=new FileInputStream(file);
		//get length of file
		res.setContentLengthLong(file.length());
		//make file mime type
		sc=getServletContext();
		mimeType=sc.getMimeType(file.getAbsolutePath());
		//set Content type
		res.setContentType(mimeType);
		//set content -disposition
		res.setHeader("Content-Disposition","attachment;fileName"+file.getName());
		//create out put strame
		os=res.getOutputStream();
		//place strame based logic
		byte buffer[]=new byte[4096];
		while((count=is.read(buffer))!=-1) {
			os.write(buffer,0,count);
		}
		
		//close stream
		os.close();
		is.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
        doPost(req, res);
	}

}
