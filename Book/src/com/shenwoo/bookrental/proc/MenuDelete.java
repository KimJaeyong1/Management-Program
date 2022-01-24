package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Member;

public class MenuDelete {
	public void proDelete(ArrayList<Member> members) {
		Scanner sc = new Scanner(System.in);
		
		// 회원 번호 체크
		System.out.println("삭제하실 회원님의 번호를 입력해주세요.");
		String deleteMember = sc.next();

		boolean memberDelete = false;
		int deleteNumber = -1;

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(deleteMember)) {
				deleteNumber = i;
				memberDelete = true;
			}
		}
		
		// 회원 삭제
		if (memberDelete) {
			System.out.println(deleteMember + " 번 회원님의 정보를 삭제하였습니다.");
			members.remove(members.get(deleteNumber));
		} else {
			System.out.println(deleteMember + " 번 회원님이 없습니다.");
		}
	}
}
