package com.shenwoo.bookrental;

import java.util.ArrayList;
import java.util.Scanner;

import com.shenwoo.bookrental.data.Book;
import com.shenwoo.bookrental.data.Member;
import com.shenwoo.bookrental.display.Title;
import com.shenwoo.bookrental.proc.MenuBookInfo;
import com.shenwoo.bookrental.proc.MenuExit;

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
			System.out.println("1:대여하기 / 2:반납하기 / 3:대여목록 / 4:회원정보 / 5:회원등록 / 6:회원수정 / 7:회원삭제 / 8:책정보 / 9:프로그램종료");
			String cmd = sc.next();

			boolean trueOrfalse = false;
			boolean booktof = false;
			switch (cmd) {
			case "1":
				System.out.println("회원 번호를 입력 해주세요");
				String number = sc.next();
				int memberNum = -1;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getNumber().equals(number)) {
						memberNum = i;
						trueOrfalse = true;
					}
				}

				int bookNum = -1;
				if (trueOrfalse) {
					members.get(memberNum).info();
					System.out.println("대여하실 책 번호를 입력 해주세요.");

					String bookNumber = sc.next();
					for (int i = 0; i < books.size(); i++) {
						if (books.get(i).getNumber().equals(bookNumber)) {
							bookNum = i;
							booktof = true;
						}
					}
				} else {
					System.out.println("등록된 회원이 아닙니다.");
				}

				if (booktof) {
					String rentalinfo = books.get(bookNum).getNumber();
					members.get(memberNum).setrental(rentalinfo);

					String rentalbookinfo = books.get(bookNum).getTitle();
					members.get(memberNum).setrentalbook(rentalbookinfo);

					books.get(memberNum).setrental("대여중");
					System.out.println("대여가 완료 되었습니다.");
				} else {
					System.out.println("등록된 책이 없습니다.");
				}
				break;
			case "2":
				System.out.println("회원 번호를 입력 해주세요");
				String memberNum1 = sc.next();
				int saveMemberNum = -1;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getNumber().equals(memberNum1)) {
						saveMemberNum = i;
						trueOrfalse = true;
					}
				}

				int returnBook = -1;
				if (trueOrfalse) {
					members.get(saveMemberNum).info();
					System.out.println("반납하실 책 번호를 입력 해주세요.");

					String bookNumber = sc.next();
					for (int i = 0; i < books.size(); i++) {
						if (books.get(i).getNumber().equals(bookNumber)) {
							returnBook = i;
							booktof = true;
						}
					}
				} else {
					System.out.println("등록된 회원이 아닙니다.");
				}

				if (booktof) {
					String rentalinfo = books.get(returnBook).getNumber();
					members.get(returnBook).setrental(rentalinfo);

					String rentalbookinfo = books.get(returnBook).getTitle();
					members.get(returnBook).setrentalbook(rentalbookinfo);

					books.get(returnBook).setrental("미대여");
					System.out.println("반납이 완료 되었습니다.");
				} else {
					System.out.println("등록된 책이 없습니다.");
				}
				break;
			case "3":
				boolean rentalTof = false;
				int rentalNum = -1;

				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getrental().equals("대여중")) {
						rentalNum = i;
						rentalTof = true;
						books.get(rentalNum).info();
					}
				}
				if (rentalTof) {
					System.out.println("대여중인 책 목록");

				} else {
					System.out.println("대여중인 책이 없습니다.");
				}
				break;
			case "4":
				for (Member a : members) {
					a.info();
				}
				break;
			case "5":
				System.out.println("이름을 입력해 주세요."); // 회원 정보 입력 받기
				String name = sc.next();
				System.out.println("연락처를 입력해주세요");
				String tel = sc.next();

				int member = members.size() + 1; // 회원번호값 형변환을 이용해서 구하기
				String str1 = Integer.toString(member);

				members.add(new Member(str1, name, tel)); // 매개변수 사용해서 회원 등록

				System.out.println("회원등록이 완료 되었습니다. 회원번호는 " + str1 + " 입니다.");
				break;
			case "6":
				System.out.println("수정할 회원번호를 입력해주세요.");
				String editNum = sc.next();

				int editNumber = -1;
				boolean editTof = false;
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getNumber().equals(editNum)) {
						editNumber = i;
						editTof = true;
					}
				}

				if (editTof) {
					System.out.println("변경하실 이름을 입력해 주세요.");
					name = sc.next();
					System.out.println("변경하실 연락처를 입력해 주세요.");
					tel = sc.next();

					members.get(editNumber).setName(name);
					members.get(editNumber).setTel(tel);
					System.out.println(editNum + " 번 회원님의 이름과 연락처가 수정되었습니다.");
				}
				break;
			case "7":
				System.out.println("삭제하실 회원님의 번호를 입력해주세요.");
				String deleteMember = sc.next();

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
				break;
			case "8":
				MenuBookInfo menubookinfo = new MenuBookInfo();
				menubookinfo.proBookInfo(books);
				break;
			case "9":
				MenuExit menuexit = new MenuExit();
				menuexit.proExit();
				whiletrue = false;
			}
		}
	}
}
