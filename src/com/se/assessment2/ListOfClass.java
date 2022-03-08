package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : ListOfClass class which extends to ListOfSomething
 */
public class ListOfClass extends ListOfSomething
{
	/**
	 * Non-parameterized constructor
	 */
	public ListOfClass()
	{
		super();
	}

	/**
	 * Find specific class object by class name
	 *
	 * @param name class name
	 * @return class object or null(if not existed)
	 */
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
