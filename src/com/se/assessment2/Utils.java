package com.se.assessment2;

import java.io.*;

/**
 * @author : Heting Ying
 * @description : Utils class
 */
public class Utils
{
	/**
	 * Read file and export to Java.lang.String
	 *
	 * @param fileName file path with name
	 * @return content of file or null(if file not existed)
	 */
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
