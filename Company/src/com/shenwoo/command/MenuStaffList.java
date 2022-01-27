package com.shenwoo.command;

import java.util.ArrayList;

import com.shenwoo.data.Staff;

public class MenuStaffList {
	public void commandStaffList(ArrayList<Staff> staffs) {
		for (int i = 1; i < staffs.size(); i++) {
			staffs.get(i).info();
		}
	}
}
