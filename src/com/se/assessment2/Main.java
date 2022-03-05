package com.se.assessment2;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		List<Class> listOfClass;
		List<Teacher> listOfTeacher;


		String teacherContent = Utils.readFile("file.json");
		JSONObject teacherJsonObject = JSON.parseObject(teacherContent);
		JSONArray teacherArray = teacherJsonObject.getJSONArray("Teacher");
		String teacherString = JSONObject.toJSONString(teacherArray);
		listOfTeacher = JSONObject.parseArray(teacherString, Teacher.class);

		String classContent = Utils.readFile("file.json");
		JSONObject classJsonObject = JSON.parseObject(classContent);
		JSONArray classArray = classJsonObject.getJSONArray("teaching requirements");
		String classString = JSONObject.toJSONString(classArray);
		listOfClass = JSONObject.parseArray(classString, Class.class);

		for (int i = 0; i<listOfClass.size(); i++){
			String currentClassName = listOfClass.get(i).getClassName();
//			System.out.println(currentClassName);
			for (int j = 0; j <listOfTeacher.size(); j++) {
			    String currentTeacherMajor=listOfTeacher.get(j).getMajor();
				if(currentClassName.equals(currentTeacherMajor)){
					System.out.println(listOfTeacher.get(j).getName() + " teaches "+currentClassName);
				}
			}
		}


	}
}
