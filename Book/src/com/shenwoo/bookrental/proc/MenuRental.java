package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;

public class MenuRental {
	public void proRental(ArrayList<Member> members, ArrayList<Book> books) {
		Scanner sc = new Scanner (System.in);
		
		boolean memberCheck = false;
		boolean bookCheck = false;
		boolean rentalCheck = false;
		boolean changeBook = false;
		
		// 회원번호 입력
		System.out.println("회원 번호를 입력 해주세요");
		String number = sc.next();
		
		
		// 회원 번호 체크
		int memberNum = -1;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(number)) {
				memberNum = i;
				memberCheck = true;
			}
		}
		
		if(memberCheck) {
			members.get(memberNum).info();
			bookCheck = true;
		} else {
			System.out.println(number+"번 회원님은 등록된 회원이 아닙니다.");
			return;
		}

		// 책 번호 입력
		System.out.println("대여하실 책 번호를 입력 해주세요.");
		String bookNumber = sc.next();
		
		// 책 번호 체크
		int bookNum = -1;
		if (bookCheck) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getNumber().equals(bookNumber)) {
					bookNum = i;
					rentalCheck = true;
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
			if(books.get(bookNum).getRental().equals("대여중")) {
				System.out.println("책이 대여중 입니다.");
			} else {
				System.out.println(books.get(bookNum).getTitle()+" 대여가 완료 되었습니다.");				

				Book b = books.get(bookNum);
				members.get(memberNum).setRentalbook(b);
				
				books.get(memberNum).setRental("대여중");
				members.get(memberNum).info();
				
			}
		}
	}
}
