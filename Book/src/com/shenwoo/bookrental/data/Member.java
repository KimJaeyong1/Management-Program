package com.shenwoo.bookrental.data;

public class Member {
	private String number;
	private String name;
	private String tel;
	private Book rentalbook;
	
	public Member(String number, String name, String tel) {
		this.number = number;
		this.name = name;
		this.tel = tel;
	}
	
	public Member(String number, String name, String tel, Book rentalBook) {
		this.number = number;
		this.name = name;
		this.tel = tel;
		this.rentalbook = rentalBook;
	}


	public void info() {
		if(rentalbook!=null) {
			System.out.println("[회원번호: " + number + " / 이름: " + name + " / 연락처: " + tel + " / 대여한책번호: " + rentalbook.getNumber() + " / 대여한책이름: " + rentalbook.getTitle()+"]");			
		} else {
			System.out.println("[회원번호: " + number + " / 이름: " + name + " / 연락처: " + tel + " / 대여한책번호: " +  "0  / 대여한책이름: 정보없음]");			
			
		}
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

	public Book getRentalbook() {
		return rentalbook;
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
	
	public void setRentalbook(Book rentalbook) {
		this.rentalbook = rentalbook;
	}

}
