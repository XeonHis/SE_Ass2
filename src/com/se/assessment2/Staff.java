package com.se.assessment2;

public class Staff
{
	private String name;
	private int id;
	public Staff() {}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Staff(String name, int id)
	{
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString()
	{
		return 	"id: " + id +
				", name: " + name;
	}
}
