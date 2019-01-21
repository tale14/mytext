package com.gxwuz.call.bean;
public class Stu {
	private String className;
	private int classNumber;
	private String instructor;
	private String courseName;
	private String courseTime;
	private String coursePeriod;
	private String username;
	private String password;
	private String name;
	private String classNo;
	private int mark;
	private int last;
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Stu() {
		super();
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(String coursePeriod) {
		this.coursePeriod = coursePeriod;
	}

	public  Stu(String courseName, String courseTime, String coursePeriod) {
		super();
		this.courseName = courseName;
		this.courseTime = courseTime;
		this.coursePeriod = coursePeriod;
	}
//	public  Stu(String className, int classNumber, String instructor) {
//		super();
//		this.className = className;
//		this.classNumber = classNumber;
//		this.instructor = instructor;
//	}
//	
//	public Stu(String name, String classNo) {
//		super();
//		this.name = name;
//		this.classNo = classNo;
//	}
	
	public Stu(String name, String classNo, int mark, int last) {
		super();
		this.name = name;
		this.classNo = classNo;
		this.mark = mark;
		this.last = last;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

}
