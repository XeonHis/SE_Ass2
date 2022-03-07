package com.se.assessment2;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.List;

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


//		for (int i = 0; i<listOfClass.size(); i++){
//			String currentClassName = listOfClass.get(i).getClassName();
//			System.out.println(currentClassName);
//			for (int j = 0; j <listOfTeacher.size(); j++) {
//			    String currentTeacherMajor=listOfTeacher.get(j).getMajor();
//				if(currentClassName.equals(currentTeacherMajor)){
//					System.out.println(listOfTeacher.get(j).getName() + " teaches "+currentClassName);
//				}
//			}
//		}


	}
}
