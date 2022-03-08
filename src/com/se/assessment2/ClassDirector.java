package com.se.assessment2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author : Heting Ying
 * @description : ClassDirector class to create class director object
 */
public class ClassDirector extends Staff
{

	/**
	 * Parameterized constructor
	 *
	 * @param name name of class director
	 * @param id   id of class director
	 */
	public ClassDirector(String name, int id)
	{
		super(name, id);
	}

	/**
	 * Parse json file and add class teaching requirements into ListOfClass
	 *
	 * @param fileName json file which contains class teaching requirements
	 */
	public void addClass(String fileName)
	{
		String content = Utils.readFile(fileName);
		String classJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("Class Requirements"));
		for (Class aClass : JSONObject.parseArray(classJsonString, Class.class))
		{
			SingleList.getClassList().add(aClass);
		}
	}

	/**
	 * Parse json file and add teacher details into ListOfTeacher
	 *
	 * @param fileName json file which contains teacher details
	 */
	public void addTeacher(String fileName)
	{
		String content = Utils.readFile(fileName);
		String teacherJsonString = JSONObject.toJSONString(JSON.parseObject(content).getJSONArray("Teacher Details"));
		for (Teacher aTeacher : JSONObject.parseArray(teacherJsonString, Teacher.class))
		{
			SingleList.getTeacherList().add(aTeacher);
		}
	}
}
