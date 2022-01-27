package com.shenwoo.emp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.shenwoo.command.MenuDelete;
import com.shenwoo.command.MenuEdit;
import com.shenwoo.command.MenuExit;
import com.shenwoo.command.MenuWorkList;
import com.shenwoo.command.MenuRegister;
import com.shenwoo.command.MenuStaffList;
import com.shenwoo.command.MenuWork;
import com.shenwoo.data.Staff;
import com.shenwoo.data.WorkInfo;
import com.shenwoo.display.Title;

public class Program {
	
	public static String MasterID = "master";
	public static String LoginID = "";
	
	public void startProgram() {
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		staffs.add(new Staff("0", "마스터", "00"));
		staffs.add(new Staff("1", "제라드", "45"));
		staffs.add(new Staff("2", "이강인", "21"));
		staffs.add(new Staff("3", "손흥민", "29"));
		staffs.add(new Staff("4", "황희찬", "26"));

		Map<String, String> idPw = new Hashtable<String, String>();
		staffs.get(0).idPw.put("master", "1234");
		staffs.get(1).idPw.put("one", "1234");
		staffs.get(2).idPw.put("two", "1234");
		staffs.get(3).idPw.put("three", "1234");
		staffs.get(4).idPw.put("four", "1234");

		List<WorkInfo> workinfo = new ArrayList<WorkInfo>();

		Scanner sc = new Scanner(System.in);

		System.out.println(Title.TITLE);

		boolean loginCheck = true;
		boolean startProgram = false;
		
		while (loginCheck) {

			// 로그인 반복
			System.out.println("<ID를 입력해주세요.>");
			String id = sc.next();
			System.out.println();
			System.out.println("<PASSWORD를 입력해주세요.>");
			String password = sc.next();
			System.out.println();

			for (int i = 0; i < staffs.size(); i++) {
				if (staffs.get(i).idPw.containsKey(id)) {
					if (staffs.get(i).idPw.get(id).equals(password)) {
						System.out.println("<"+staffs.get(i).getName()+"님이 로그인 하셨습니다.>");
						System.out.println();
						loginCheck = false;
						startProgram = true;
						LoginID = id;
						break;
					}
				}
			}

			if (startProgram == false) {
				System.out.println("<입력하신 아이디와 비밀번호를 확인해주세요.>");
			}
		}

		// 메뉴 반복
		if (startProgram) {

			boolean trueRun = true;
			while (trueRun) {
				System.out.println(
						"Menu===========================================================================\n"
						+ "[ 1:출퇴근등록 / 2:출퇴근기록 / 3:직원목록 / 4:직원등록 / 5:직원수정 / 6:퇴사처리 / 0:프로그램종료 ]\n"
						+"===============================================================================\n");
				String cmd = sc.next();

				switch (cmd) {
				case "1":
					MenuWork menuwork = new MenuWork();
					menuwork.commandWork(workinfo);
					break;
				case "2":
					MenuWorkList menuoffwork = new MenuWorkList();
					menuoffwork.commandOffwork(workinfo);
					break;
				case "3":
					MenuStaffList menustafflist = new MenuStaffList();
					menustafflist.commandStaffList(staffs);
					break;
				case "4":
					if (MasterID.equals(LoginID)) {
						MenuRegister menuregister = new MenuRegister();
						menuregister.commandRegister(staffs);
					} else {
						System.out.println("선택하신 메뉴의 권한이 없습니다.");
						System.out.println();
					}
					break;
				case "5":
					if (MasterID.equals(LoginID)) {
						MenuEdit menuedit = new MenuEdit();
						menuedit.commandEdit(staffs);
					} else {
						System.out.println("선택하신 메뉴의 권한이 없습니다.");
						System.out.println();
					}
					break;
				case "6":
					if (MasterID.equals(LoginID)) {
						MenuDelete menudelete = new MenuDelete();
						menudelete.commandDelete(staffs);
					} else {
						System.out.println("선택하신 메뉴의 권한이 없습니다.");
						System.out.println();
					}
					break;
				case "0":
					MenuExit menuexit = new MenuExit();
					menuexit.CommmdExit();
					trueRun = false;
					break;
				}
			}
		}
	}
}
