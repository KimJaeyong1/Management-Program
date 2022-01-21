package com.shenwoo.bookrental.data;

public class Book {
	private String number;
	private String title;
	private String rental;

	public Book(String number, String title, String rental) {
		this.number = number;
		this.title = title;
		this.rental = rental;
	}
	
	public Book(String rental) {
		this.rental = rental;
	}

	public void info() {
		System.out.println("책번호: " + number + " 책제목: " + title+" 대여여부: " +rental);
	}

	public String getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public String getrental() {
		return rental;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setrental(String rental) {
		this.rental = rental;
	}
}
