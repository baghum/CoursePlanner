package coursePlaner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quarter")
public class Quarter extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	static Calendar cal;
	static int week;
	static int year;
	String quarter = null;

	public Quarter()
	{
		super();
		cal = Calendar.getInstance();
		week = cal.get(Calendar.WEEK_OF_YEAR);
		year = cal.get(Calendar.YEAR);

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getSession().getAttribute("firstTime") == null)
			request.getSession().setAttribute("firstTime", true);

		
		ArrayList<SummaryQuarter> summaryCourses = (ArrayList<SummaryQuarter>) request
				.getSession(false).getAttribute("summaryCourses");
		if (summaryCourses == null)
		{
			summaryCourses = new ArrayList<>();

		}

		if (week >= 1 && week <= 12)
		{
			quarter = "Spring";
			request.setAttribute("quarter", quarter);
			request.setAttribute("year", year);
			week += 12;

		}

		else if (week >= 13 && week <= 24)
		{
			quarter = "Summer";
			request.setAttribute("quarter", quarter);
			request.setAttribute("year", year);
			week += 12;

		}
		else if (week > 25 && week < 37)
		{
			quarter = "Fall";
			request.setAttribute("quarter", quarter);
			request.setAttribute("year", year);
			week += 12;

		}
		else if (week > 38 && week < 52)
		{
			quarter = "Winter";
			request.setAttribute("quarter", quarter);
			request.setAttribute("year", year);
			week += 12;

		}

		if (week > 52)
		{
			week = 1;
			request.setAttribute("year", year);
			year += 1;

		}

		boolean firstTime = (boolean) request.getSession().getAttribute(
				"firstTime");
		if (firstTime)
		{

			firstTime = false;
			request.getSession().setAttribute("firstTime", firstTime);
		}
		else
		{
			List<Courses> nc = (List<Courses>) request.getSession()
					.getAttribute("takenCourses");

			summaryCourses.add(new SummaryQuarter(year, quarter, nc));

			request.getSession().setAttribute("summaryCourses", summaryCourses);
		}
		request.getRequestDispatcher("/WEB-INF/Quarter.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{

		response.sendRedirect("DisplayFinalSummary");
	}

}
