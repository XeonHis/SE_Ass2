package com.se.assessment2;

public class LoT
{
	private Teacher[] teacherList;
	private int i;
	private int max;

	public LoT()
	{
		max = 10;
		teacherList = new Teacher[max];
		i = 0;
	}

	public void addTeacher(Teacher teacher)
	{
		if (i >= max)
		{
			max = max + max / 2;
			Teacher[] newList = new Teacher[max];
			System.arraycopy(teacherList, 0, newList, 0, teacherList.length);
			newList[i++] = teacher;
			teacherList = newList;

		} else
		{
			teacherList[i++] = teacher;
		}
	}


	public void removeTeacher(Teacher teacher)
	{
		int j;
		for (j = 0; j < i; j++)
			if (teacherList[j] == teacher)
				break;
		i--;
		for (; j < i; j++)
			teacherList[j] = teacherList[j + 1];
	}


	public int getSize()
	{
		int count = 0;
		for (Teacher teacher :
				teacherList)
		{
			if (teacher != null)
			{
				count++;
			}
		}
		return count;
	}


	public Teacher get(int i)
	{
		return teacherList[i];
	}


}
