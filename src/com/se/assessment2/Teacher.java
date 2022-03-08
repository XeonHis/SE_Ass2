package com.se.assessment2;

/**
 * @author : Heting Ying
 * @description : Teacher class to create teacher object
 */
public class Teacher extends Staff
{
	private String major;
	private int student_rating;
	private Class cls;
	private boolean train;

	/**
	 * Get assigned class of teacher
	 *
	 * @return class object
	 */
	public Class getCls()
	{
		return cls;
	}

	private void setCls(Class cls)
	{
		this.cls = cls;
	}

	/**
	 * Add assigned class to teacher
	 *
	 * @param cls class object
	 */
	public void addClass(Class cls)
	{
		this.setCls(cls);
	}

	/**
	 * Non-parameterized constructor
	 */
	public Teacher()
	{
		super();
	}

	/**
	 * Get major of teacher
	 *
	 * @return teacher's major
	 */
	public String getMajor()
	{
		return major;
	}

	/**
	 * Set major of teacher
	 *
	 * @param major teacher's major
	 */
	public void setMajor(String major)
	{
		this.major = major;
	}

	/**
	 * Get student rate of teacher
	 *
	 * @return teacher's student rate
	 */
	public int getStudent_rating()
	{
		return student_rating;
	}

	/**
	 * Set student rate of teacher
	 *
	 * @param student_rating teacher's student rate
	 */
	public void setStudent_rating(int student_rating)
	{
		this.student_rating = student_rating;
	}

	/**
	 * Get train status
	 *
	 * @return true: training, false: not training
	 */
	public boolean isTrain()
	{
		return train;
	}

	/**
	 * Set train status
	 *
	 * @param train true: training, false: not training
	 */
	public void setTrain(boolean train)
	{
		this.train = train;
	}

	/**
	 * Parameterized constructor
	 *
	 * @param name           teacher's name
	 * @param id             teacher's id
	 * @param major          teacher's major
	 * @param student_rating teacher's student rate
	 */
	public Teacher(String name, int id, String major, int student_rating)
	{
		super(name, id);
		this.major = major;
		this.student_rating = student_rating;
	}

	@Override
	public String toString()
	{
		return super.toString() +
				", major: " + major +
				", student_rating: " + student_rating;
	}
}
