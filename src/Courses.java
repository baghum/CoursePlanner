package src;

import java.util.List;

public class Courses
{
	int index;
	String code;
	String title;
	List<String> prerequisites;

	public Courses(String code, String title, List<String> prerequisites)
	{

		this.code = code;
		this.title = title;
		this.prerequisites = prerequisites;

	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public List<String> getPrerequisites()
	{
		return prerequisites;
	}

	public void setPrerequisites(List<String> prerequisites)
	{
		this.prerequisites = prerequisites;
	}

}
