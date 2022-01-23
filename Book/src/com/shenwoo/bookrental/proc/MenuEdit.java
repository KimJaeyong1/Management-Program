package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Member;

public class MenuEdit {
	public void proEdit(ArrayList<Member> members) {
		Scanner sc = new Scanner(System.in);
		String editNum = sc.next();
		System.out.println("수정할 회원번호를 입력해주세요.");

		int editNumber = -1;
		boolean editTof = false;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(editNum)) {
				editNumber = i;
				editTof = true;
			}
		}

		if (editTof) {
			System.out.println("변경하실 이름을 입력해 주세요.");
			String name = sc.next();
			System.out.println("변경하실 연락처를 입력해 주세요.");
			String tel = sc.next();

			members.get(editNumber).setName(name);
			members.get(editNumber).setTel(tel);
			System.out.println(editNum + " 번 회원님의 이름과 연락처가 수정되었습니다.");
		}
	}
}
