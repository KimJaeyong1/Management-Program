package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;

public class MenuList {
	public void proList(ArrayList<Member> members, ArrayList<Book> books) {
		Scanner sc = new Scanner(System.in);

		System.out.println("회원 번호를 입력 해주세요");
		String number = sc.next();

		boolean memberCheck = false;

		int memberNum = -1;

		// 회원 번호 체크
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(number)) {
				memberNum = i;
				memberCheck = true;
			}
		}

		if (memberCheck) {
			members.get(memberNum).info();
		} else {
			System.out.println(number + "번 회원님은 등록된 회원이 아닙니다.");
			return;
		}

	}
}