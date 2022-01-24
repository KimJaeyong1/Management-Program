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
		
		// 회원번호 입력
		System.out.println("회원 번호를 입력 해주세요");
		String number = sc.next();
		
		// 회원번호 체크
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
		System.out.println("반납하실 책 번호를 입력 해주세요.");
		String bookNumber = sc.next();
		
		// 책 번호 체크
		int returnBook = -1;
		if (bookCheck) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getNumber().equals(bookNumber )) {
					returnBook = i;
					rentalCheck = true;
				}
			}
		}
		
		if(rentalCheck) {
			changeBook = true;
		} else {
			System.out.println(bookNumber+"번 책은 등록된 책이 아닙니다.");
		}
		
		
		// 회원정보의 책 정보 변경, 책 대여상태 변경
		if (changeBook) {
			if(members.get(memberNum).getRental().equals(books.get(returnBook).getNumber())) {
				System.out.println(books.get(returnBook).getTitle()+" 반납이 완료 되었습니다.");
				// 회원 대여 정보 변경
				members.get(memberNum).setRental("0");
				members.get(memberNum).setRentalbook("정보없음");
				
				// 책 대여 상태 변경
				books.get(returnBook).setRental("미대여");
				members.get(memberNum).info();
			} else {
				System.out.println(books.get(returnBook).getTitle()+" 을 대여중이 아닙니다.");
			}
		}
	}
}
