package com.shenwoo.data;

import java.util.Hashtable;
import java.util.Map;

import com.shenwoo.emp.Program;

public class Staff {
	private String number;
	private String name;
	private String age;
	public Map<String, String> idPw = new Hashtable<String, String>();
//	private String gender;
//	private String tel;
//	private String sttaf;
//	private String Department;
//	private String adderss;
//	private String mail;

	// 생성자
	public Staff(String number, String name, String age) {
		this.number = number;
		this.name = name;
		this.age = age;
//		this.gender = gender;
//		this.tel = tel;
//		this.sttaf = sttaf;
//		this.Department = department;
//		this.adderss = adderss;
//		this.mail = mail;
	}

	public void info() {
		if (Program.MasterID.equals(Program.LoginID)) {
			if (age != null) {
				System.out.println("[ " + number + "번 / " + name + " / " + age + " / " + idPw + " ]");
			} else {
				System.out.println("[ " + number + "번 / " + name + " ]");
			}
		} else {
			System.out.println("[ " + number + "번 / " + name + " / " + age + " ]");
		}
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Map<String, String> getIdPw() {
		return idPw;
	}

	public void setIdPw(Map<String, String> idPw) {
		this.idPw = idPw;
	}
}
