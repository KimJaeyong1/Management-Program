package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Member;

public class MenuEdit {
	public void proEdit(ArrayList<Member> members) {
		Scanner sc = new Scanner(System.in);
		
		boolean memberCheck = false;
		boolean memberEdit = false;
		
		// 회원 번호 체크
		System.out.println("수정할 회원번호를 입력해주세요.");
		String editNum = sc.next();

		int memberNum = -1;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getNumber().equals(editNum)) {
				memberNum = i;
				memberCheck = true;
			}
		}
		
		if(memberCheck) {
			members.get(memberNum).info();
			memberEdit = true;
		} else {
			System.out.println("수정하실 회원번호를 확인해 주세요.");
		}

		// 회원 정보 수정
		if (memberEdit) {
			System.out.println("변경하실 이름을 입력해 주세요.");
			String name = sc.next();
			System.out.println("변경하실 연락처를 입력해 주세요.");
			String tel = sc.next();

			members.get(memberNum).setName(name);
			members.get(memberNum).setTel(tel);
			
			System.out.println(editNum + " 번 회원님의 이름과 연락처가 수정되었습니다.");
			members.get(memberNum).info();
		}
	}
}
