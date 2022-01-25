package com.shenwoo.bookrental.data;

public class Book {
	private String number;
	private String title;
	private String rental;
	private Member rentalMember;

	public Book(String number, String title, String rental) {
		this.number = number;
		this.title = title;
		this.rental = rental;
	}

	public Member getRentalMember() {
		return rentalMember;
	}

	public void setRentalMember(Member rentalMember) {
		this.rentalMember = rentalMember;
	}

	public Book(String rental) {
		this.rental = rental;
	}

	public void info() {
		if (rentalMember != null) {
			System.out.println("[책번호: " + number + " / 책제목: " + title + " / 대여여부: " + rental + " / 대여한회원번호: "+ rentalMember.getNumber() +"]");
		} else {
			System.out.println("[책번호: " + number + " / 책제목: " + title + " / 대여여부: " + rental + "]");
		}
	}

	public String getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public String getRental() {
		return rental;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}
}
