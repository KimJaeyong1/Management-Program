package com.shenwoo.data;

public class WorkInfo {
	private String workinfo;
	
	public WorkInfo (String workinfo) {
		this.workinfo = workinfo;
	}
	
	public void info() {
		System.out.println(workinfo);
		System.out.println();
	}
}
