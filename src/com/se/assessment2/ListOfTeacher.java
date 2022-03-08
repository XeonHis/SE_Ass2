package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : ListOfTeacher class which extends to ListOfSomething
 */
public class ListOfTeacher extends ListOfSomething
{
	/**
	 * Non-parameterized constructor
	 */
	public ListOfTeacher()
	{
	}

	/**
	 * Find specific teacher object by teacher name
	 *
	 * @param name teacher name
	 * @return teacher object or null(if not existed)
	 */
	public Teacher find(String name)
	{
		for (Object o :
				super.getInnerList())
		{
			Teacher currentTeacher = (Teacher) o;
			if (currentTeacher.getName().equals(name))
			{
				return currentTeacher;
			}
		}
		return null;
	}

}
