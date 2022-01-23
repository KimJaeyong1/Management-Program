package com.shenwoo.bookrental.data;

public class Member {
	private String number;
	private String name;
	private String tel;
	private String rental;
	private String rentalbook;

	public Member(String number, String name, String tel, String rental, String rentalbook) {
		this.number = number;
		this.name = name;
		this.tel = tel;
		this.rental = rental;
		this.rentalbook = rentalbook;
	}
	
	public Member(String number, String name, String tel) {
		this.number = number;
		this.name = name;
		this.tel = tel;
	}
	
	public Member(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public Member(String rental) {
		this.rental = rental;
	}

	public void info() {
		System.out.println("회원번호: " + number + " / 이름: " + name + " / 연락처: " + tel + " / 대여한책번호: " + rental + " / 대여한책이름: " + rentalbook);
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

	public String getRental() {
		return rental;
	}

	public String getRentalbook() {
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

	public void setRental(String rental) {
		this.rental = rental;
	}

	public void setRentalbook(String rentalbook) {
		this.rentalbook = rentalbook;
	}
}
