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





@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	public EditCourse()
	{
		super();
	}
	@SuppressWarnings("unchecked")
	private Courses getEntry(Integer id)
	{
		List<Courses> entries = (List<Courses>) getServletContext()
				.getAttribute("courses");

		for (Courses entry : entries)
			if (entry.getId().equals(id))
				return entry;

		return null;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		List<Courses> enteries = (List<Courses>) getServletContext()
				.getAttribute("courses");
		String user = (String) request.getSession().getAttribute("user");

		if ((user != null))
		{
			
			Integer id = Integer.valueOf(request.getParameter("id"));
			Courses entry = getEntry(id);
			request.setAttribute("entry", entry);

			request.getRequestDispatcher("/WEB-INF/EditCourse.jsp").forward(
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
		
		Integer id = Integer.valueOf(request.getParameter("id"));

		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String[] check = request.getParameterValues("check");
		

		if (check != null)
		{
			List<String> Pre = new ArrayList<String>(Arrays.asList(check));

			enteries.get(id).setCode(code);
			enteries.get(id).setTitle(title);
			enteries.get(id).setPrerequisites(Pre);

		}
		else
		{
			enteries.get(id).setCode(code);
			enteries.get(id).setTitle(title);

		}

		response.sendRedirect("DisplayCourse");
	}
}
