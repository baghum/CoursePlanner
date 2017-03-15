package coursePlaner;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public Login()
	{
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(
				request, response);
		
	}

	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		List<User> myList = (List<User>) getServletContext().getAttribute(
				"userList");
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		for (int i = 0; i < myList.size(); i++)
		{

			String userID = myList.get(i).getUserName();
			String passId = myList.get(i).getPassWord();

			if (username.equals(userID) && password.equals(passId))
			{
			
				request.getSession().setAttribute("user", username);
				response.sendRedirect("DisplayCourse");
				return;
			}

		}

		response.sendRedirect("Login");
	}

}
