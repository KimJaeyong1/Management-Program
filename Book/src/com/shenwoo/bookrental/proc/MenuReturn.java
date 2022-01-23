package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;

public class MenuReturn {
	public void proReturn(ArrayList<Member> members, ArrayList<Book> books) {
		
		System.out.println("회원 번호를 입력 해주세요");
		Scanner sc = new Scanner(System.in);
		String memberNum1 = sc.next();
		
		
		int memberNum = -1;
		int bookNum = -1;
		boolean memberCheck = false;
		boolean bookCheck = false;		
		boolean booknumCheck = false;
		boolean returnCheck = false;
		
		// 회원 번호 체크
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(memberNum1)) {
				memberNum = i;
				memberCheck = true;
			}
		}
		
		if(memberCheck) {
			bookCheck = true;
		} else {
			System.out.println("회원 번호를 확인 해주세요.");
			return;
		}

		// 책 번호 체크
		if (bookCheck) {
			members.get(memberNum).info();
			System.out.println("반납하실 책 번호를 입력 해주세요.");

			String bookNumber = sc.next();
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getNumber().equals(bookNumber)) {
					bookNum = i;
					booknumCheck = true;
				}
			}
		}

		if(booknumCheck) {
			returnCheck = true;
		} else {
			System.out.println("책 번호를 확인 해주세요.");
			return;
		}
		
		if (returnCheck) {
			if(members.get(memberNum).getRental().equals(books.get(bookNum).getNumber())) {
				System.out.println("반납이 완료 되었습니다.");
				
				// 회원정보 책 번호 수정
				members.get(memberNum).setRental("0");
				members.get(memberNum).setRentalbook("정보없음");
				
				// 책 대여 정보 변경
				books.get(bookNum).setRental("미대여");				
			} else {
				System.out.println("반납하실 책이 아닙니다.");
			}
		} else {
			System.out.println("등록된 책이 없습니다.");
		}
	}
}
