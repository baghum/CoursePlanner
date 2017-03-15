package src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Members")
public class Members extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public Members()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		String user = (String) request.getSession().getAttribute("user");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(user != null)
		{
			out.print("<html><head><title> Members</title></head><body>");
			out.print("<h1> This is for members only</h1>");
			out.print("<p>welcome " + user + "</p>");
			out.print("<p><a href='Logout'</a>Logout<p>");
			out.print("</html>");
		}
		else
			response.sendRedirect("Login");
	}
}
