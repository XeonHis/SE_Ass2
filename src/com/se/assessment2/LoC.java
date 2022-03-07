package com.se.assessment2;

public class LoC
{
	private Class[] classList;
	private int i;
	private int max;

	public LoC()
	{
		max = 10;
		classList = new Class[max];
		i = 0;
	}

	public void addClass(Class cls)
	{
		if (i >= max)
		{
			max = max + max / 2;
			Class[] newList = new Class[max];
			System.arraycopy(classList, 0, newList, 0, classList.length);
			newList[i++] = cls;
			classList = newList;

		} else
		{
			classList[i++] = cls;
		}
	}


	public void removeClass(Class cls)
	{
		int j;
		for (j = 0; j < i; j++)
			if (classList[j] == cls)
				break;
		i--;
		for (; j < i; j++)
			classList[j] = classList[j + 1];
	}


	public int getSize()
	{
		return classList.length;
	}


	public Class get(int i)
	{
		return classList[i];
	}


}
