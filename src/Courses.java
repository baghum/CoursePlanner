package coursePlaner;

import java.util.List;

public class Courses
{
	Integer id;
	String code;
	String title;
	List<String> prerequisites;
	boolean isTaken;

	public Courses(Integer id, String code, String title, List<String> prerequisites)
	{
		//courses take id too but we never give it an id and i think thats y 
		//we give it the whole list
		
		this.id = id;
		this.code = code;
		this.title = title;
		this.prerequisites = prerequisites;
		isTaken = false;

	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public boolean isTaken()
	{
		return isTaken;
	}

	public void setTaken(boolean isTaken)
	{
		this.isTaken = isTaken;
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
