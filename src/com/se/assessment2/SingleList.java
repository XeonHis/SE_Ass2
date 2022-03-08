package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : Singleton class to get ListOfClass and ListOfTeacher
 */
public class SingleList
{
	private static final ListOfClass listOfClass = new ListOfClass();
	private static final ListOfTeacher listOfTeacher = new ListOfTeacher();

	/**
	 * Get the object of list of class
	 *
	 * @return ListOfClass object
	 */
	public static ListOfClass getClassList()
	{
		return listOfClass;
	}

	/**
	 * Get the object of list of teacher
	 *
	 * @return ListOfTeacher object
	 */
	public static ListOfTeacher getTeacherList()
	{
		return listOfTeacher;
	}
}
