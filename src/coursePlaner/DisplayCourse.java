package coursePlaner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

		File file = new File(getServletContext().getRealPath(
				"/WEB-INF/courses.txt"));
		try
		{
			@SuppressWarnings("resource")
			Scanner s = new Scanner(file);
			while (s.hasNextLine())
			{
				String line = s.nextLine();

				if (line.startsWith("#"))
				{
					// do nothing
				}
				else if (line.length() == 0)
				{
					// do nothing
				}

				else
				{
					String[] kp = line.split(",");

					if (kp.length == 3)
					{
						String[] prereq = kp[2].split(" ");
						List<String> listOfPre = new ArrayList<String>(
								Arrays.asList(prereq));
						enteries.add(new Courses(enteries.size(), kp[0], kp[1],
								listOfPre));
					}
					else
					{
						enteries.add(new Courses(enteries.size(), kp[0], kp[1],
								new ArrayList<String>()));
					}

				}
			}
		}
		catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}

		List<User> userList = new ArrayList<User>();

		userList.add(new User("cysun", "abcd"));

		userList.add(new User("cs320stu31", "abcd"));

		getServletContext().setAttribute("userList", userList);

		getServletContext().setAttribute("courses", enteries);
		
	
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/DisplayCourse.jsp").forward(
				request, response);
	}
}