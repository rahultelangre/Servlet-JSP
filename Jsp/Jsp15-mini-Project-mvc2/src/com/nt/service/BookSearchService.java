package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBo;
import com.nt.dao.BookDAO;
import com.nt.dao.BookDAOImpl;
import com.nt.dto.BookDTO;

public class BookSearchService {
	public List<BookDTO> search(String category)throws Exception{
		
		BookDAO dao=null;
		List<BookBo> listBo=null;
		List<BookDTO>  listdto=null;
		BookDTO dto=null;
		//use dao
		dao=new BookDAOImpl();
		listBo=dao.findBooks(category);
		listdto=new ArrayList<BookDTO>();
		
		for(BookBo bo:listBo) {
			//copyh each record to dto
			dto=new BookDTO();
			dto.setBookid(bo.getBookid());
			dto.setBookname(bo.getBookName());
			dto.setAuthor(bo.getAuthor());
			dto.setCategory(bo.getCategory());
			dto.setStatus(bo.getStatus());
			listdto.add(dto);
		}//for
		
		return listdto;
		
	}

}
