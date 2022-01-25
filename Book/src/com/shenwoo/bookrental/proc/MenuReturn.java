package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;

public class MenuReturn {
	public void proReturn(ArrayList<Member> members, ArrayList<Book> books) {
		Scanner sc = new Scanner(System.in);

		boolean memberCheck = false;
		boolean bookCheck = false;
		boolean rentalCheck = false;
		boolean changeBook = false;

		Member selectedMember = null;

		// 회원번호 입력
		System.out.println("회원 번호를 입력 해주세요");
		String number = sc.next();

		// 회원번호 체크
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(number)) {
				selectedMember = members.get(i);
				memberCheck = true;
			}
		}

		if (memberCheck) {
			selectedMember.info();
			bookCheck = true;
		} else {
			System.out.println(number + "번 회원님은 등록된 회원이 아닙니다.");
			return;
		}

		// 책 번호 입력
		System.out.println("반납하실 책 번호를 입력 해주세요.");
		String bookNumber = sc.next();

		// 책 번호 체크
		if (bookCheck) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getNumber().equals(bookNumber)) {
					rentalCheck = true;
				}
			}
		}

		if (rentalCheck) {
		} else {
			System.out.println(bookNumber + "번 책은 등록된 책이 아닙니다.");
			return;
		}

		ArrayList<Book> rentalbooks = selectedMember.getRentalbooks();

		int rentalBookCheck = -1;
		for (int i = 0; i < rentalbooks.size(); i++) {
			if (rentalbooks.get(i).getNumber().equals(bookNumber)) {
				rentalBookCheck = i;
				changeBook = true;
			}

		}
		if (changeBook) {
			System.out.println(books.get(rentalBookCheck).getTitle()+" 반납이 완료 되었습니다.");
			rentalbooks.remove(rentalBookCheck);
			for (int j = 0; j < books.size(); j++) {
				if (books.get(j).getNumber().equals(bookNumber)) {
					books.get(j).setRental("미대여");
					books.get(j).setRentalMember(null);
				}
			} 
		} else {
			System.out.println("대여한 책이 없습니다.");
		}
	}
}
