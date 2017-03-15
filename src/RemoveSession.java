package coursePlaner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RemoveSession")
public class RemoveSession extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public RemoveSession()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getSession().invalidate();
		response.sendRedirect("CourseDisplay");
	}

}
