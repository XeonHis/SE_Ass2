package com.se.assessment2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class ClassDirector extends Staff
{

	public ClassDirector(String name, int id)
	{
		super(name, id);
	}

	public void addClass(String fileName)
	{
		String content = Utils.readFile(fileName);
		String classJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("teaching requirements"));
		for (Class aClass : JSONObject.parseArray(classJsonString, Class.class))
		{
			SingleList.getClassList().add(aClass);
		}
	}

	public void addTeacher(String fileName)
	{
		String content = Utils.readFile(fileName);
		String teacherJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("Teacher"));
		for (Teacher aTeacher : JSONObject.parseArray(teacherJsonString, Teacher.class))
		{
			SingleList.getTeacherList().add(aTeacher);
		}
	}
}
