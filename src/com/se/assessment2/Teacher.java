package com.se.assessment2;

public class Teacher
{
	private String name;
	private Class cls;

	public Class getCls()
	{
		return cls;
	}

	public void setCls(Class cls)
	{
		this.cls = cls;
	}
	public void addClass(Class cls){
		this.setCls(cls);
	}

	public Teacher()
	{
	}

	@Override
	public String toString()
	{
		return "Teacher{" +
				"name='" + name + '\'' +
				", major='" + major + '\'' +
				", teaching_year=" + teaching_year +
				", course_on_charge=" + course_on_charge +
				", student_rating=" + student_rating +
				'}';
	}

	private String major;
	private int teaching_year;
	private int course_on_charge;
	private int student_rating;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMajor()
	{
		return major;
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public int getTeaching_year()
	{
		return teaching_year;
	}

	public void setTeaching_year(int teaching_year)
	{
		this.teaching_year = teaching_year;
	}

	public int getCourse_on_charge()
	{
		return course_on_charge;
	}

	public void setCourse_on_charge(int course_on_charge)
	{
		this.course_on_charge = course_on_charge;
	}

	public int getStudent_rating()
	{
		return student_rating;
	}

	public void setStudent_rating(int student_rating)
	{
		this.student_rating = student_rating;
	}

	public Teacher(String name, String major, int teaching_year, int course_on_charge, int student_rating)
	{
		this.name = name;
		this.major = major;
		this.teaching_year = teaching_year;
		this.course_on_charge = course_on_charge;
		this.student_rating = student_rating;
	}
}
