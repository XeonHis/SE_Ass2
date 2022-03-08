package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : Class class to create class object
 */
public class Class
{
	private String className;
	private String college;
	private Teacher teacher;

	/**
	 * Non-parameterized constructor
	 */
	public Class()
	{
	}

	/**
	 * Parameterized constructor
	 * @param className class name
	 * @param college college name
	 */
	public Class(String className, String college)
	{
		this.className = className;
		this.college = college;
	}

	/**
	 * Get college name
	 * @return college name
	 */
	public String getCollege()
	{
		return college;
	}

	/**
	 * Set college name
	 * @param college college name
	 */
	public void setCollege(String college)
	{
		this.college = college;
	}

	/**
	 * Get class name
	 * @return class name
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * Set class name
	 * @param className class name
	 */
	public void setClassName(String className)
	{
		this.className = className;
	}

	/**
	 * Add teacher in class object
	 * @param teacher teacher object
	 */
	public void addTeacher(Teacher teacher)
	{
		this.setTeacher(teacher);
	}

	/**
	 * Get teacher object of class object
	 * @return teacher object
	 */
	public Teacher getTeacher()
	{
		return teacher;
	}

	/**
	 * Set teacher object
	 * @param teacher teacher object
	 */
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}

	@Override
	public String toString()
	{
		return "College: " + college +
				", Class Name: " + className;
	}
}
