package com.shenwoo.command;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.shenwoo.data.Staff;

public class MenuRegister {
	public void commandRegister(ArrayList<Staff> staffs) {
		Scanner sc = new Scanner(System.in);
		
		
		int staffNumber = 0;
		
		for (int i = 0; i < staffs.size(); i++) {
			staffNumber = i+1;
		}
		
		String number = Integer.toString(staffNumber);
		
		System.out.println("<등록하실 사원의 이름을 입력해주세요.>");
		String name = sc.next();
		System.out.println("<등록하실 사원의 나이를 입력해주세요.>");
		String age = sc.next();
		System.out.println("<등록하실 사원의 ID을 입력해주세요.>");
		String id = sc.next();
		System.out.println("<등록하실 사원의 PASSWORD를 입력해주세요.>");
		String password = sc.next();
		
		System.out.println("<사원등록이 완료 되었습니다.>");
		System.out.println();
		staffs.add(new Staff (number, name, age));
		staffs.get(staffNumber).idPw.put(id, password);
	}
}

