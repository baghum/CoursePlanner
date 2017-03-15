package coursePlaner;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public AddCourse()
	{
		super();
	}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String user = (String) request.getSession().getAttribute("user");
		
		if ((user != null))
		{
		
		request.getRequestDispatcher("/WEB-INF/AddCourse.jsp").forward(
				request, response);
		}
		else
		{
			response.sendRedirect("Login");

		}

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException

	{
		List<Courses> enteries = (List<Courses>) getServletContext()
				.getAttribute("courses");

		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String[] check = request.getParameterValues("check");

		if (check != null)
		{
			List<String> Pre = new ArrayList<String>(Arrays.asList(check));
		

			enteries.add(new Courses(enteries.size(), code, title, Pre));
		}
		else
		{
			enteries.add(new Courses(enteries.size(), code, title, new ArrayList<String>()));

		}
		getServletContext().setAttribute("courses", enteries);

		response.sendRedirect("DisplayCourse");
	}
}
