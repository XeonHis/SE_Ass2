package com.se.assessment2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Paul Alan
 * @date 2022/3/7
 */
public class Admin
{
	private static Map<String, String> assignment = new HashMap<>();
	public Map<String, String> getAssignment(){
		for (int i = 0; i < singleList.getClassList().getSize(); i++)
		{
			String currentClassName = singleList.getClassList().get(i).getClassName();
			int tempRate = -1;
			for (int j = 0; j < singleList.getTeacherList().getSize(); j++)
			{
				String currentTeacherMajor = singleList.getTeacherList().get(j).getMajor();
				if (currentClassName.equals(currentTeacherMajor))
				{
					if (singleList.getTeacherList().get(j).getStudent_rating() > tempRate)
					{
						assignment.put(currentClassName,singleList.getTeacherList().get(j).getName());
						tempRate = singleList.getTeacherList().get(j).getStudent_rating();
					}
				}
			}
		}
		System.out.println(assignment);
		for (Map.Entry<String, String> entry:
				assignment.entrySet())
		{
			Teacher teacher = singleList.getTeacherList().find(entry.getValue());
			Class cls = singleList.getClassList().find(entry.getKey());
			teacher.addClass(cls);
			teacher.setTrain(true);
			cls.addTeacher(teacher);
		}
		return assignment;
	}
}
