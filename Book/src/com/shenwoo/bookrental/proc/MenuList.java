package com.shenwoo.bookrental.proc;

import java.util.ArrayList;

import com.shenwoo.bookrental.data.Book;

public class MenuList {
	public void proList(ArrayList<Book> books) {
		boolean rentalTof = false;
		int rentalNum = -1;

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getRental().equals("대여중")) {
				rentalNum = i;
				rentalTof = true;
				books.get(rentalNum).info();
			}
		}
		if (rentalTof) {
			System.out.println("대여중인 책 목록");

		} else {
			System.out.println("대여중인 책이 없습니다.");
		}
	}
}
