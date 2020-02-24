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
public class FileDownloadServlet extends HttpServlet{
	
       
    

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext sc=null;
		File file=null;
		String path=null;
		String filename=null;
		long length=0;
		String mimeType=null;
		InputStream is=null;
		ServletOutputStream sos=null;
		byte[] buffer=new byte[4096];
		int count=0;
		//get  servlet context
		sc=getServletContext();
		//get path of file to be download
		path=sc.getRealPath("E:/store/man.jpeg");
		//filename=req.getParameter("file");
		//get length of the file and make it as the response content length
		file=new File(path);
		length=file.length();
		res.setContentLengthLong(length);
		//create input stream pointing to the file
				is=new FileInputStream(file);
		//GET THE MIME type of the file and make it as responcrmime type
		mimeType=sc.getMimeType(file.getAbsolutePath());
		res.setContentType(mimeType);
		//set content type
		res.setHeader("content-disposition","attachment;fileName=man.jpeg");
		
		//get outputStream pointing to responce
		sos=res.getOutputStream();
		//writer buffer based logic to complete file copy activity(file download)
		while((count=is.read(buffer))!=-1) {
			sos.write(buffer,0,count);
		}//while
		is.close();
		sos.close();
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
