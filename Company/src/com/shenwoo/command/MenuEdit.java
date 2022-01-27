package com.shenwoo.command;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.data.Staff;

public class MenuEdit {
	public void commandEdit(ArrayList<Staff> staffs) {
		Scanner sc = new Scanner(System.in);

		// while문을 돌리기 위해 불린형 변수 선언
		boolean editTrue = true;
		boolean editStaff = true;

		// 사원 정보수정이 완료 되면 중지, 사원 번호 잘못 입력하면 다시 반복
		while (editTrue) {

			// 사원 목록 보여주기
			MenuStaffList menustafflist = new MenuStaffList();
			menustafflist.commandStaffList(staffs);

			// 수정할 사원 번호 입력 받기
			System.out.println("<수정하실 사원의 번호를 입력해주세요.>");
			String staffNum = sc.next();

			// 입력받은 사원 번호 문자열로 형 변환
			int number = Integer.valueOf(staffNum);

			for (Staff a : staffs) {
				// for-each문을 활용하여 입력받은 사원번호가 있는지 확인
				if (a.getNumber().equals(staffNum)) {
					// 수정할 이름 입력 받고 수정
					System.out.println("<수정하실 이름을 입력하세요.>");
					String name = sc.next();
					staffs.get(number).setName(name);

					// 수정할 나이 입력 받고 수정
					System.out.println("<수정하실 나이를 입력하세요.>");
					String age = sc.next();
					staffs.get(number).setAge(age);
				}
			}
			
			// if문을 다시 사용하여 중복출력 방지
			if (editStaff) {
				System.out.println(staffNum+"번 사원의 정보수정이 완료 되었습니다.");
				// 수정이 완료 되었으므로 while문 종료
				editTrue = false;
			} else {
				System.out.println("<입력하신 번호의 사원이 없습니다.>");
			}
		}
	}
}
