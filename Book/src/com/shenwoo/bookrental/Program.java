package com.shenwoo.bookrental;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;
import com.shenwoo.bookrental.display.Title;
import com.shenwoo.bookrental.proc.MenuBookInfo;
import com.shenwoo.bookrental.proc.MenuDelete;
import com.shenwoo.bookrental.proc.MenuEdit;
import com.shenwoo.bookrental.proc.MenuExit;
import com.shenwoo.bookrental.proc.MenuInfo;
import com.shenwoo.bookrental.proc.MenuList;
import com.shenwoo.bookrental.proc.MenuRegister;
import com.shenwoo.bookrental.proc.MenuRental;
import com.shenwoo.bookrental.proc.MenuReturn;
import com.shenwoo.bookrental.proc.MenubookEdit;

public class Program {
	public void startProgram() {
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(new Member("1", "김씨", "010-1111-1111"));
		members.add(new Member("2", "이씨", "010-2222-2222"));
		members.add(new Member("3", "박씨", "010-3333-3333"));
		members.add(new Member("4", "최씨", "010-4444-4444"));

		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("1", "이누야사 1권", "미대여"));
		books.add(new Book("2", "헌터헌터 1권", "미대여"));
		books.add(new Book("3", "체인소맨 1권", "미대여"));

		Scanner sc = new Scanner(System.in);

		System.out.println(Title.TITLE);
		
		boolean whiletrue = true;
		while (whiletrue) {
			System.out.println("[1:대여하기 / 2:반납하기 / 3:대여목록 / 4:회원정보 / 5:회원등록 / 6:회원수정 / 7:회원삭제 / 8:책정보 / 9:책제목수정 / 0:프로그램종료]");
			String cmd = sc.next();

			// 명령어
			switch (cmd) {
			case "1":
				MenuRental menurental = new MenuRental();
				menurental.proRental(members, books);
				break;
			case "2":
				MenuReturn menureturn = new MenuReturn();
				menureturn.proReturn(members, books);
				break;
			case "3":
				MenuList menulist = new MenuList();
				menulist.proList(members, books);
				break;
			case "4":
				MenuInfo menuinfo = new MenuInfo();
				menuinfo.proInfo(members);
				break;
			case "5":
				MenuRegister menuregister = new MenuRegister();
				menuregister.proRegister(members);
				break;
			case "6":
				MenuEdit menuedit = new MenuEdit();
				menuedit.proEdit(members);
				break;
			case "7":
				MenuDelete menudelete = new MenuDelete();
				menudelete.proDelete(members);
				break;
			case "8":
				MenuBookInfo menubookinfo = new MenuBookInfo();
				menubookinfo.proBookInfo(books);
				break;
			case "9":
				MenubookEdit menubookedit = new MenubookEdit();
				menubookedit.proBookEdit(books);
				break;
			case "0":
				MenuExit menuexit = new MenuExit();
				menuexit.proExit();
				whiletrue = false;
			}
		}
	}
}
