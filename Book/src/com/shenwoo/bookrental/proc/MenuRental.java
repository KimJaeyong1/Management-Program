package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;

public class MenuRental {
	public void proRental(ArrayList<Member> members, ArrayList<Book> books) {
		
		System.out.println("회원 번호를 입력 해주세요");
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		
		//회원 번호 체크
		int memberNum = -1;
		boolean memberCheck = false;
		boolean bookCheck = false;
		boolean booknumCheck = false;
		boolean rentalCheck = false;
		
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(number)) {
				memberNum = i;
				memberCheck = true;
			}
		}
		
		if(memberCheck) {
			bookCheck = true;
		} else {
			System.out.println("회원 번호를 확인해 주세요.");
			return;
		}

		// 책 번호 체크
		int bookNum = -1;
		System.out.println("대여하실 책 번호를 입력 해주세요.");
		String bookNumber = sc.next();
		
		if (bookCheck) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getNumber().equals(bookNumber)) {
					bookNum = i;
					booknumCheck = true;
				}
			}
		}
		
		if(booknumCheck) {
			rentalCheck = true;
		} else {
			System.out.println("책 번호를 확인해 주세요.");
			return;
		}

		if (rentalCheck) {
			if(books.get(bookNum).getRental().equals("대여중")) {
				System.out.println(books.get(bookNum).getTitle()+"이 대여중 입니다.");
			} else {
				System.out.println(books.get(bookNum).getTitle()+" 대여가 완료 되었습니다.");
				String rentalinfo = books.get(bookNum).getNumber();
				members.get(memberNum).setRental(rentalinfo);
				
				String rentalbookinfo = books.get(bookNum).getTitle();
				members.get(memberNum).setRentalbook(rentalbookinfo);
				
				books.get(bookNum).setRental("대여중");		
				
				members.get(memberNum).info();

			}
		} else {
			System.out.println("등록된 책이 없습니다.");
		}
	}
}
