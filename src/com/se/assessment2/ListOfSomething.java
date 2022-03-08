package com.se.assessment2;

public class ListOfSomething
{
	private Object[] innerList;
	private int i;
	private int max;
	public Object[] getInnerList()
	{
		return innerList;
	}

	public void setInnerList(Object[] innerList)
	{
		this.innerList = innerList;
	}


	public ListOfSomething()
	{
		max = 10;
		innerList = new Object[max];
		i = 0;
	}

	public void add(Object obj)
	{
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

	public Object find(String name)
	{
		return null;
	}


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


	public Object get(int i)
	{
		return innerList[i];
	}


}
