package com.shenwoo.command;

import java.util.List;

import com.shenwoo.data.WorkInfo;

public class MenuWorkList {
	public void commandOffwork(List<WorkInfo> workinfo) {
		for(WorkInfo a : workinfo) {
			a.info();
		}
	}
}
