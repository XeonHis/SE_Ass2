package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : ListOfClass class which extends to ListOfSomething
 */
public class ListOfClass extends ListOfSomething
{
	private static final ListOfClass instance = new ListOfClass();

	/**
	 * Non-parameterized constructor
	 */
	private ListOfClass()
	{
		super();
	}

	/**
	 * Get ListOfClass instance
	 *
	 * @return ListOfClass object
	 */
	public static ListOfClass getInstance()
	{
		return instance;
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
