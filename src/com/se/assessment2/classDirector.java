package com.se.assessment2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Paul Alan
 * @date 2022/3/7
 */
public class classDirector
{

	public void addClass(String fileName)
	{
		String content = Utils.readFile(fileName);
		String classJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("teaching requirements"));
		for (Class aClass : JSONObject.parseArray(classJsonString, Class.class))
		{
			singleList.getClassList().addClass(aClass);
		}
	}

	public void addTeacher(String fileName)
	{
		String content = Utils.readFile(fileName);
		String teacherJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("Teacher"));
		for (Teacher aTeacher : JSONObject.parseArray(teacherJsonString, Teacher.class))
		{
			singleList.getTeacherList().addTeacher(aTeacher);
		}
	}
}
