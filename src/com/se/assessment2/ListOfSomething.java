package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : ListOfSomething class to create self-built list
 */
public class ListOfSomething
{
	private Object[] innerList;
	private int i;
	private int max;

	/**
	 * Get list
	 *
	 * @return array of some objects
	 */
	public Object[] getInnerList()
	{
		return innerList;
	}

	/**
	 * Set list
	 *
	 * @param innerList array of some objects
	 */
	public void setInnerList(Object[] innerList)
	{
		this.innerList = innerList;
	}

	/**
	 * Non-parameterized constructor
	 */
	public ListOfSomething()
	{
		max = 10;
		innerList = new Object[max];
		i = 0;
	}

	/**
	 * Add object into list
	 *
	 * @param obj object needs to be added
	 */
	public void add(Object obj)
	{
		/*
		Check whether automatic capacity expansion is needed
		 */
		if (i >= max)
		{
			max = max + max / 2;
			Object[] newList = new Object[max];
			System.arraycopy(innerList, 0, newList, 0, innerList.length);
			newList[i++] = obj;
			innerList = newList;

		} else
		{
			innerList[i++] = obj;
		}
	}

	/**
	 * Remove specific object of list
	 *
	 * @param obj object needs to be removed
	 */
	public void remove(Object obj)
	{
		int j;
		for (j = 0; j < i; j++)
			if (innerList[j] == obj)
				break;
		i--;
		for (; j < i; j++)
			innerList[j] = innerList[j + 1];
	}

	/**
	 * Find specific object by name (needs to be overridden)
	 *
	 * @param name name
	 * @return null
	 */
	public Object find(String name)
	{
		return null;
	}

	/**
	 * Get the count of not-null object in list
	 *
	 * @return the size of list
	 */
	public int getSize()
	{
		int count = 0;
		for (Object obj :
				innerList)
		{
			if (obj != null)
			{
				count++;
			}
		}
		return count;
	}

	/**
	 * Find specific object by index
	 *
	 * @param i index
	 * @return object
	 */
	public Object get(int i)
	{
		return innerList[i];
	}


}
