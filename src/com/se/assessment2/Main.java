package com.se.assessment2;


/**
 * @author : Heting Ying
 * @description : Main class to paint GUI
 */
public class Main
{
	public static void main(String[] args)
	{
		// Create class director object
		ClassDirector classDirector = new ClassDirector("Class Director", 5);
		classDirector.addClass("file.json");
		classDirector.addTeacher("file.json");

		// Create admin object
		Admin admin = new Admin("Admin", 0);

		new RoleSelectionFrame("Role Selection Interface", admin);
	}

}
