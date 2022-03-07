package com.se.assessment2;

public class Teacher
{
	private String major;
	private int student_rating;
	private String name;
	private Class cls;
	private boolean train;

	public Class getCls()
	{
		return cls;
	}

	public void setCls(Class cls)
	{
		this.cls = cls;
	}

	public void addClass(Class cls)
	{
		this.setCls(cls);
	}

	public Teacher()
	{
	}


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


	public int getStudent_rating()
	{
		return student_rating;
	}

	public void setStudent_rating(int student_rating)
	{
		this.student_rating = student_rating;
	}

	public boolean isTrain()
	{
		return train;
	}

	public void setTrain(boolean train)
	{
		this.train = train;
	}

	public Teacher(String name, String major, int student_rating)
	{
		this.name = name;
		this.major = major;
		this.student_rating = student_rating;
	}

	@Override
	public String toString()
	{
		return "Teacher{" +
				"name='" + name + '\'' +
				", major='" + major + '\'' +
				", student_rating=" + student_rating +
				'}';
	}
}
