package com.shenwoo.bookrental.proc;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Member;

public class MenuRegister {
	public void proRegister(ArrayList<Member> members) {
		Scanner sc = new Scanner(System.in);
		
		// 회원 정보 입력 받기
		System.out.println("등록하실 이름을 입력해 주세요."); 
		String name = sc.next();
		System.out.println("등록하실 연락처를 입력해주세요");
		String tel = sc.next();

		int member = members.size() + 1; // 회원번호값 형변환을 이용해서 구하기
		String str1 = Integer.toString(member);
		String str2 = "0";
		String str3 = "정보없음";

		members.add(new Member(str1, name, tel, str2, str3)); // 매개변수 사용해서 회원 등록

		System.out.println("회원등록이 완료 되었습니다. 회원번호는 " + str1 + " 입니다.");
	}
}
