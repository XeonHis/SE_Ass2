package com.se.assessment2;

/**
 * @author Paul Alan
 * @date 2022/3/7
 */
public class singleList
{
	private static final LoC listOfClass = new LoC();
	private static final LoT listOfTeacher = new LoT();

	public singleList()
	{
	}

	public static LoC getClassList()
	{
		return listOfClass;
	}
	public static LoT getTeacherList()
	{
		return listOfTeacher;
	}
}
