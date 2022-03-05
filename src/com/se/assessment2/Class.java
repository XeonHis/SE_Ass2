package com.se.assessment2;

public class Class
{
	private String className;
	private String college;
	private Teacher teacher;

	public Class()
	{
	}

	public Class(String className, String college)
	{
		this.className = className;
		this.college = college;
	}

	public String getCollege()
	{
		return college;
	}


	public void setCollege(String college)
	{
		this.college = college;
	}

	public String getClassName()
	{
		return className;
	}


	public void setClassName(String className)
	{
		this.className = className;
	}

	public void addTeacher(Teacher teacher)
	{
		this.setTeacher(teacher);
	}

	public Teacher getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}

	@Override
	public String toString()
	{
		return "Class{" +
				"className='" + className + '\'' +
				", college='" + college + '\'' +
				'}';
	}
}
