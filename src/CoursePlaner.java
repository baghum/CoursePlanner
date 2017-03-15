package coursePlaner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoursePlaner")
public class CoursePlaner extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public CoursePlaner()
	{
		super();
	}

	private boolean isCourseTaken(List<Courses> l, String code)
	{
		Courses entry = null;

		for (int i = 0; i < l.size(); i++)
		{
			if (code.equals(l.get(i).getCode()))

				entry = l.get(i);

		}
		//return false;
		return entry.isTaken();
		

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/CoursePlaner.jsp").forward(
				request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		List<Courses> enteries = (List<Courses>) getServletContext()
				.getAttribute("courses");
		
		List<Courses> takenCourses = new ArrayList<Courses>();

		String[] check = request.getParameterValues("check");
		List<Courses> nextCourses = new ArrayList<Courses>();
		
		//get row number 
		if (check != null)
		{
			int[] rowNumbers = new int[check.length];

			for (int i = 0; i < check.length; i++)
			{
				for (int j = 0; j < enteries.size(); j++)
				{
					if (enteries.get(j).getCode().equals(check[i]))
					{
						rowNumbers[i] = j;
						enteries.get(j).setTaken(true);
						takenCourses.add(enteries.get(j));
					}
				}
			}

			

			for (int k = 0; k < enteries.size(); k++)
			{

				if (enteries.get(k).getPrerequisites().size() == 0
						&& !(enteries.get(k).isTaken())) 
				{
					nextCourses.add(enteries.get(k));
				}
				else if (enteries.get(k).getPrerequisites().size() > 0
						&& !(enteries.get(k).isTaken()))
				{

					List<String> pre = enteries.get(k).getPrerequisites();
					boolean isTrue = true;

					for (int p = 0; p < pre.size(); p++)
					{
						if (!isCourseTaken(enteries, pre.get(p)))
						{
							isTrue = false;

						}

					}
					if (isTrue)
					{
						nextCourses.add(enteries.get(k));

					}
				}
				
			}
			request.getSession().setAttribute("takenCourses", takenCourses);
			request.getSession().setAttribute("nextCourses", nextCourses);
			
		}

	/*	boolean temp = true;
		for (int k = 0; k < enteries.size(); k++)
		{
			if (!enteries.get(k).isTaken())
			{
				temp = false;
				break;
			}
		}

		if (temp)
		{
			for (int k = 0; k < enteries.size(); k++)
			{
				enteries.get(k).setTaken(false);
			}
			response.sendRedirect("DisplayFinalSummary");
		}
		else*/
			response.sendRedirect("Quarter");

	}
}
