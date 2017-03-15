package coursePlaner;


import java.util.List;

public class SummaryQuarter
{
	private Integer year;
	private String quarter;
	private List<Courses> coursesQuar;

	public SummaryQuarter(Integer year, String quarter, List<Courses> coursesQuar)
	{

		this.year = year;
		this.quarter = quarter;
		this.coursesQuar = coursesQuar;

	}

	public List<Courses> getCoursesQuar()
	{
		return coursesQuar;
	}

	public void setCoursesQuar(List<Courses> coursesQuar)
	{
		this.coursesQuar = coursesQuar;
	}

	public Integer getYear()
	{
		return year;
	}

	public void setYear(Integer year)
	{
		this.year = year;
	}

	public String getQuarter()
	{
		return quarter;
	}

	public void setQuarter(String quarter)
	{
		this.quarter = quarter;
	}
}