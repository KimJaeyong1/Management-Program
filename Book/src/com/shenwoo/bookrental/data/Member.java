package com.shenwoo.bookrental.data;

import java.util.ArrayList;

public class Member {
	private String number;
	private String name;
	private String tel;
	private ArrayList<Book> rentalbooks = new ArrayList<Book>();
	
	public Member(String number, String name, String tel) {
		this.number = number;
		this.name = name;
		this.tel = tel;
	}

	public ArrayList<Book> getRentalbooks() {
		return rentalbooks;
	}

	public void setRentalbooks(ArrayList<Book> rentalbooks) {
		this.rentalbooks = rentalbooks;
	}

	public void info() {
		if(rentalbooks != null) {
			System.out.println("[회원번호: " + number + " / 이름: " + name + " / 연락처: " + tel + "]");
			showRentalBooks();
		} else {
			System.out.println("[회원번호: " + number + " / 이름: " + name + " / 연락처: " + tel +" ]");			
		}
	}
	
	public void memberInfo() {
		System.out.println("[회원번호: " + number + " / 이름: " + name + " / 연락처: " + tel + "]");
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void addRentalBook(Book addRentalBook) {
		rentalbooks.add(addRentalBook);
	}
	
	public void showRentalBooks() {
		System.out.println("*-----------------------------대여한 책목록------------------------------*");
		for(Book a :rentalbooks) {
			System.out.println(a.getTitle());
		}
		System.out.println("*--------------------------------------------------------------------*");
	}
}

