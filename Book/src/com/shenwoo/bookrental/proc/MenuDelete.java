package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Member;

public class MenuDelete {
	public void proDelete(ArrayList<Member> members) {
		Scanner sc = new Scanner(System.in);
		String deleteMember = sc.next();
		
		System.out.println("삭제하실 회원님의 번호를 입력해주세요.");

		boolean deleteTof = false;
		int deleteNumber = -1;

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(deleteMember)) {
				deleteNumber = i;
				deleteTof = true;
			}
		}
		if (deleteTof) {
			members.remove(members.get(deleteNumber));
			System.out.println(deleteMember + " 번 회원님의 정보를 삭제하였습니다.");
		} else {
			System.out.println(deleteMember + " 번 회원님이 없습니다.");
		}
	}
}
