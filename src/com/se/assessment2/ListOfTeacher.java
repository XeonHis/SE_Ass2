package com.se.assessment2;

public class ListOfTeacher extends ListOfSomething
{
	public ListOfTeacher() {}

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
