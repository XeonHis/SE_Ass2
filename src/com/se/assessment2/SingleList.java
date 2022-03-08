package com.se.assessment2;

public class SingleList
{
	private static final ListOfClass listOfClass = new ListOfClass();
	private static final ListOfTeacher listOfTeacher = new ListOfTeacher();


	public static ListOfClass getClassList()
	{
		return listOfClass;
	}
	public static ListOfTeacher getTeacherList()
	{
		return listOfTeacher;
	}
}
