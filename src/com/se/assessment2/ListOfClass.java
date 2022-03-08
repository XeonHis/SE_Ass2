package com.se.assessment2;

public class ListOfClass extends ListOfSomething
{
	public ListOfClass()
	{
		super();
	}


	public Class find(String name)
	{
		for (Object o :
				super.getInnerList())
		{
			Class currentClass = (Class) o;
			if (currentClass.getClassName().equals(name))
			{
				return currentClass;
			}
		}
		return null;
	}


}
