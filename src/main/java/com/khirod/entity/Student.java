package com.khirod.entity;



public class Student {
	
	private int student_id;
	private String name;
	private String parent_name; 
	private String city;
	private long mobile_no;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int student_id, String name, String parent_name, String city, long mobile_no) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.parent_name = parent_name;
		this.city = city;
		this.mobile_no = mobile_no;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	@Override
	public String toString() {
		return "Student [Student_id=" + student_id + ", name=" + name + ", parent_name=" + parent_name + ", city="
				+ city + ", mobile_no=" + mobile_no + "]";
	}
	
}
