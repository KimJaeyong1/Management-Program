package com.shenwoo.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.shenwoo.data.WorkInfo;

public class MenuWork {
	public void commandWork(List<WorkInfo> workinfo) {

		Date time = new Date();	
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");	
		String time1 = format1.format(time);

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(
				"Menu====================\n"
				+"[ 1:출근 등록 / 2:퇴근 등록 ]\n"
				+"========================\n"
				);
		String cmd = sc.next();
		
		switch (cmd) {
		case "1":
			System.out.println("<출근 등록이 완료 되었습니다.>");
			workinfo.add(new WorkInfo("출근시간: "+time1));
			System.out.println();
			break;
		case "2":			
			System.out.println("<퇴근 등록이 완료 되었습니다.>");
			workinfo.add(new WorkInfo("퇴근시간: "+time1));
			System.out.println();
			break;
		}
	}
}
