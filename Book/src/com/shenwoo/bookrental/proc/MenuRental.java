package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;

public class MenuRental {
	public void proRental(ArrayList<Member> members, ArrayList<Book> books) {
		Scanner sc = new Scanner (System.in);
		
		Member selectedMember = null;
		
		boolean memberCheck = false;
		boolean bookCheck = false;
		boolean rentalCheck = false;
		boolean changeBook = false;
		
		// 회원번호 입력
		System.out.println("회원 번호를 입력 해주세요");
		String number = sc.next();
		
		
		// 회원 번호 체크
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(number)) {
				memberCheck = true;
				selectedMember = members.get(i);
			}
		}
		
		if(memberCheck) {
			selectedMember.info();
			bookCheck = true;
		} else {
			System.out.println(number+"번 회원님은 등록된 회원이 아닙니다.");
			return;
		}

		// 책 번호 입력
		System.out.println("대여하실 책 번호를 입력 해주세요.");
		String bookNumber = sc.next();
		
		
		Book selectedBook = null;
		// 책 번호 체크
		if (bookCheck) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getNumber().equals(bookNumber)) {
					rentalCheck = true;
					selectedBook = books.get(i);
				}
			}
		}
		
		if(rentalCheck) {
			changeBook = true;
		} else {
			System.out.println(bookNumber+"번 책은 등록된 책이 아닙니다.");
			return;
		}
		
		// 회원 책정보 변경, 책의 대여여부 변경
		if (changeBook) {
			if(selectedBook.getRental().equals("대여중")) {
				System.out.println("책이 대여중 입니다.");
			} else {
				System.out.println(selectedBook.getTitle()+" 대여가 완료 되었습니다.");				

				selectedMember.addRentalBook(selectedBook);
				
				
				selectedBook.setRental("대여중");
				selectedBook.setRentalMember(selectedMember);
				selectedMember.info();
				
			}
		}
	}
}
