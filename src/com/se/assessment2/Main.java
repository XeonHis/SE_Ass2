package com.se.assessment2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main
{
	public static void main(String[] args)
	{
		LoC listOfClass = new LoC();
		LoT listOfTeacher = new LoT();


		String content = Utils.readFile("file.json");
		String teacherJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("Teacher"));
		String classJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("teaching requirements"));
		for (Teacher aTeacher : JSONObject.parseArray(teacherJsonString, Teacher.class))
		{
			listOfTeacher.addTeacher(aTeacher);
		}
		for (Class aClass : JSONObject.parseArray(classJsonString, Class.class))
		{
			listOfClass.addClass(aClass);
		}

		Map<String, String> assignment = new HashMap<>();

		for (int i = 0; i < listOfClass.getSize(); i++)
		{
			String currentClassName = listOfClass.get(i).getClassName();
			int tempRate = -1;
			for (int j = 0; j < listOfTeacher.getSize(); j++)
			{
				String currentTeacherMajor = listOfTeacher.get(j).getMajor();
				if (currentClassName.equals(currentTeacherMajor))
				{
					if (listOfTeacher.get(j).getStudent_rating() > tempRate)
					{
						assignment.put(currentClassName,listOfTeacher.get(j).getName());
						tempRate = listOfTeacher.get(j).getStudent_rating();
					}
				}
			}
		}
		System.out.println(assignment);
		for (Map.Entry<String, String> entry:
		assignment.entrySet())
		{
			Teacher teacher = listOfTeacher.find(entry.getValue());
			Class cls = listOfClass.find(entry.getKey());
			teacher.addClass(cls);
			teacher.setTrain(true);
			cls.addTeacher(teacher);
		}

		JFrame jf=new JFrame();
		JTextPane textPane1 = new JTextPane();
		jf.setContentPane(textPane1);
		textPane1.setText(assignment.toString());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);


	}

}
