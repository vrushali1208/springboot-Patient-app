package com.example.Patient;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class PatientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String pid;

	private String fname;
	
	private String lname;
	
	private String age;
	
	private String phone;
	
	private String address;
	
	

	public PatientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "PatientEntity [pid=" + pid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", phone="
				+ phone + ", address=" + address + "]";
	}

	public PatientEntity(String pid, String fname, String lname, String age, String phone, String address) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
}
