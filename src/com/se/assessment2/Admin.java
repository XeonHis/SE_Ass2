package com.se.assessment2;

import java.util.HashMap;
import java.util.Map;

public class Admin extends Staff
{
	public Admin(String name, int id)
	{
		super(name, id);
	}

	private static Map<String, String> assignment = new HashMap<>();

	public Map<String, String> getAssignment()
	{
		for (int i = 0; i < SingleList.getClassList().getSize(); i++)
		{
			Class currentClass = (Class) SingleList.getClassList().get(i);
			String currentClassName = currentClass.getClassName();
			int tempRate = -1;
			for (int j = 0; j < SingleList.getTeacherList().getSize(); j++)
			{
				Teacher currentTeacher = (Teacher) SingleList.getTeacherList().get(j);
				String currentTeacherMajor = currentTeacher.getMajor();
				if (currentClassName.equals(currentTeacherMajor))
				{
					if (currentTeacher.getStudent_rating() > tempRate)
					{
						assignment.put(currentClassName, currentTeacher.getName());
						tempRate = currentTeacher.getStudent_rating();
					}
				}
			}
		}
//		System.out.println(assignment);
		for (Map.Entry<String, String> entry :
				assignment.entrySet())
		{
			Teacher teacher = SingleList.getTeacherList().find(entry.getValue());
			Class cls = SingleList.getClassList().find(entry.getKey());
			teacher.addClass(cls);
			teacher.setTrain(true);
			cls.addTeacher(teacher);
		}
		return assignment;
	}
}
