package com.shenwoo.bookrental.proc;

import java.util.ArrayList;

import com.shenwoo.bookrental.data.Member;

public class MenuInfo {
	public void proInfo(ArrayList<Member> members) {
		for (Member a : members) {
			a.memberInfo();
		}
	}
}
