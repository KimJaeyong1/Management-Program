package com.shenwoo.bookrental.proc;

import java.util.ArrayList;

import com.shenwoo.bookrental.data.Book;

public class MenuBookInfo {
	
	public void proBookInfo(ArrayList<Book> books) {
		for (Book a : books) {
			a.info();
		}
	}
}
