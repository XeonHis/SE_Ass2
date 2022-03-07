package com.se.assessment2;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.awt.desktop.PrintFilesEvent;
import java.io.*;

public class Utils
{
	public static String readFile(String fileName)
	{
		try (FileInputStream fileInputStream = new FileInputStream(fileName))
		{
			int len;
			byte[] bytes = new byte[1024];
			StringBuilder stringBuffer = new StringBuilder();
			while ((len = fileInputStream.read(bytes)) != -1)
			{
				stringBuffer.append(new String(bytes, 0, len));
			}
			return stringBuffer.toString();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}


}
