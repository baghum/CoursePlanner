package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayCourse")
public class DisplayCourse extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	List<Courses> enteries = new ArrayList<Courses>();

	public DisplayCourse()
	{
		super();

	}

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);

		File file = new File(getServletContext().getRealPath("/WEB-INF/courses.txt"));
		try
		{
			@SuppressWarnings("resource")
			Scanner s = new Scanner(file);
			while (s.hasNextLine())
			{
				String line = s.nextLine();

				if(line.startsWith("#"))
				{
					// do nothing
				}
				else if(line.length() == 0)
				{
					// do nothing
				}

				else
				{
					String[] kp = line.split(",");

					if(kp.length == 3)
					{
						String[] prereq = kp[2].split(" ");
						List<String> listOfPre = new ArrayList<String>(
								Arrays.asList(prereq));
						enteries.add(new Courses(kp[0], kp[1], listOfPre));
					}
					else
					{
						enteries.add(new Courses(kp[0], kp[1], new ArrayList<String>()));
					}

				}
			}
		}
		catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}

		getServletContext().setAttribute("courses", enteries);

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		List<Courses> enteries = (List<Courses>) getServletContext().getAttribute(
				"courses");

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.print("<html><head><title>Display Courses</title></head><body>");
		out.println("<table border='1'>");
		out.println("<tr><th>Code</th><th>Title</th><th>Prerequisites</th><th>Operation</th><th></tr>");
		for (int i = 0; i < enteries.size(); ++i)
		{
			Courses entry = enteries.get(i);
			out.print("<tr><td>" + entry.getCode() + "</td><td> " + entry.getTitle()
					+ "</td><td>");
			for (String s : entry.getPrerequisites())
				out.println(s + " ");
			out.println("</td><td><a href ='EditCourse?index=" + i
					+ "'> Edit</a> </td></tr>");
		}
		out.println("</table>");
		out.println("<p><a href='AddCourse'>Add Course</a></p>");
		out.println("<p><a href='Login'>Login</a></p>");
		out.print("</body></html>");

	}

}
