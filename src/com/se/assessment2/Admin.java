package com.se.assessment2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Heting Ying
 * @description : Admin class to create admin object
 */
public class Admin extends Staff
{
	/**
	 * Parameterized constructor
	 *
	 * @param name name of Admin
	 * @param id   id of Admin
	 */
	public Admin(String name, int id)
	{
		super(name, id);
		findAssignment();
	}

	// Store assignment of class and teacher
	private static Map<String, String> assignment = new HashMap<>();

	public static Map<String, String> getAssignment()
	{
		return assignment;
	}

	/**
	 * Algorithm to find assignment (select highest student rating one if same major).
	 *
	 * @return Automatic assignment
	 */
	public static void findAssignment()
	{
		/*
		Iterate all classes requirements
		 */
		for (int i = 0; i < SingleList.getClassList().getSize(); i++)
		{
			// Get current class object
			Class currentClass = (Class) SingleList.getClassList().get(i);
			// Get current class name
			String currentClassName = currentClass.getClassName();
			// Set temporary student rating as -1 for further comparison
			int tempRate = -1;
			/*
			Iterate all teachers
			 */
			for (int j = 0; j < SingleList.getTeacherList().getSize(); j++)
			{
				// Get current teacher object
				Teacher currentTeacher = (Teacher) SingleList.getTeacherList().get(j);
				// Get current teacher's major
				String currentTeacherMajor = currentTeacher.getMajor();
				/*
				Find a match between current class name and current teacher's major.
				Chose the teacher who has the highest student rating.
				 */
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
		/*
		Iterate assignment, add teacher in every class and add class to teachers.
		 */
		for (Map.Entry<String, String> entry :
				assignment.entrySet())
		{
			Teacher teacher = SingleList.getTeacherList().find(entry.getValue());
			Class cls = SingleList.getClassList().find(entry.getKey());
			teacher.addClass(cls);
			teacher.setTrain(true);
			cls.addTeacher(teacher);
		}

//		return assignment;
	}
}
