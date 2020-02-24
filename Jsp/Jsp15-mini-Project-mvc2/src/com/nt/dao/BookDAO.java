package com.nt.dao;

import java.util.List;

import com.nt.bo.BookBo;

public interface BookDAO {

	public List<BookBo> findBooks(String category) throws Exception;
	
}
