package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;

public class MenubookEdit {
	public void proBookEdit(ArrayList<Book> books) {
		Scanner sc = new Scanner(System.in);

		// 책 번호 체크
		System.out.println("수정할 책 번호를 입력해주세요.");
		String editNum = sc.next();

		boolean bookCheck = false;
		boolean bookEdit = false;
		
		int bookNum = -1;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getNumber().equals(editNum)) {
				bookNum = i;
				bookCheck = true;
			}
		}
		
		sc.nextLine();	// nextLine 오류 때문에 삽입

		if (bookCheck) {
			books.get(bookNum).info();
			bookEdit = true;
		} else {
			System.out.println("수정하실 책 번호를 확인해 주세요.");
			return;
		}

		// 책 정보 수정
		if (bookEdit) {
			System.out.println("변경하실 책 제목을 입력해 주세요.");
			String title = sc.nextLine(); 	// 띄어쓰기 때문에 nextLine 으로 입력받음
			books.get(bookNum).setTitle(title);
			System.out.println(editNum + " 번 책의 제목이 수정되었습니다.");
			books.get(bookNum).info();
		}
	}
}
