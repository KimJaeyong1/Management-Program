package com.shenwoo.command;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.data.Staff;

public class MenuDelete {
	public void commandDelete(ArrayList<Staff> staffs) {
		Scanner sc = new Scanner(System.in);

		boolean deleteTrue = true;
		boolean deleteStaff = false;

		while (deleteTrue) {
			MenuStaffList menustafflist = new MenuStaffList();
			menustafflist.commandStaffList(staffs);

			System.out.println("<삭제할 사원 번호를 입력해주세요.>");
			String staffNum = sc.next();
			System.out.println();

			for (Staff a : staffs) {
				if (a.getNumber().equals(staffNum)) {
					deleteStaff = true;
					a.setName("== 퇴사 ==");
					a.setAge(null);
				}
			}

			if (deleteStaff) {
				System.out.println("<퇴사 처리 되었습니다.>");
				System.out.println();
				deleteTrue = false;
			} else {
				System.out.println("<사원 번호를 확인해 주세요.>");
			}
		}
	}
}
