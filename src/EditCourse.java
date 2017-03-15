package src;

import java.io.IOException;
import java.io.PrintWriter;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		List<Courses> enteries = (List<Courses>) getServletContext().getAttribute(
				"courses");

		int index = Integer.valueOf(request.getParameter("index"));

		Courses entry = enteries.get(index);

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<html><head><title>Edit Course</title></head><body>");
		out.println("<table border = '1' > ");
		out.println("<form action='EditCourse' method='post'>");
		out.println("<tr><td>Code:</td><td> <input type='text'  name='code' value = '"
				+ entry.getCode() + "'></td></tr> <br />");

		out.println("<tr><td>Title:</td><td> <input type='text' size= '45' name='title' value='"
				+ entry.getTitle() + "' /></td></tr> <br />");
		out.println("<tr><td>Prerequisite(s): </td><td> <br />");

		for (Courses c : enteries)
		{
			if(!c.getCode().equals(entry.getCode()))
			{
				if(entry.getPrerequisites().contains(c.getCode()))
				{
					out.println("<input type='checkbox' name = 'check' checked value='" + c.getCode()
							+ "'>" + c.getCode() + "</br>");
				}
				else
				{
					out.println("<input type='checkbox' name = 'check' value='" + c.getCode() + "'>"
							+ c.getCode() + "</br>");
				}
			}
		}

		out.println("</table>");
		out.println("<input type = 'hidden' name = 'index' value = '" + index + "'/>");
		out.println("<input type='submit' name='save' value='Save' /> <br />");
		out.println("</body></html>");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException

	{
		List<Courses> enteries = (List<Courses>) getServletContext().getAttribute(
				"courses");

		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String[] check = request.getParameterValues("check");
		int index = Integer.parseInt(request.getParameter("index"));

		if(check != null)
		{
			List<String> Pre = new ArrayList<String>(Arrays.asList(check));

			enteries.get(index).setCode(code);
			enteries.get(index).setTitle(title);
			enteries.get(index).setPrerequisites(Pre);

			// enteries.add(new Courses(code, title, Pre));
		}
		else
		{
			enteries.get(index).setCode(code);
			enteries.get(index).setTitle(title);
			// enteries.add(new Courses(code, title, new ArrayList<String>()));

		}

		response.sendRedirect("DisplayCourse");
	}
}
