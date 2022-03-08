package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : Staff class to create staff object
 */
public class Staff
{
	private String name;
	private int id;

	/**
	 * Non-parameterized constructor
	 */
	public Staff()
	{
	}

	/**
	 * Get name of staff
	 *
	 * @return name of staff
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set name of staff
	 *
	 * @param name name of staff
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Get id of staff
	 *
	 * @return id of staff
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Set id of staff
	 *
	 * @param id id of staff
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Parameterized constructor
	 *
	 * @param name name of staff
	 * @param id   id of staff
	 */
	public Staff(String name, int id)
	{
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "id: " + id +
				", name: " + name;
	}
}
