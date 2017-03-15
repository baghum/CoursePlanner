package coursePlaner;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet

{
	String error = null;
	private static final long serialVersionUID = 1L;

	List<User> userList = new ArrayList<User>();

	public Register()
	{
		super();
	}

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/Register.jsp").forward(
				request, response);}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		
		List<User> myList = (List<User>) getServletContext().getAttribute(
				"userList");

		String userName = request.getParameter("Username");
		String passWord = request.getParameter("Password");
		String RetypePass = request.getParameter("Re-Password");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");

		if (userName.isEmpty() || passWord.isEmpty() || RetypePass.isEmpty())
		{
			error = "The required field are empty";
			request.setAttribute("error", error);
			doGet(request, response);
			return;
		}
		else if (userName.length() < 4)
		{
			error = "Username must be at least 4 characters";
			request.setAttribute("error", error);
			doGet(request, response);
			return;
		}
		else if (passWord.length() < 4)
		{
			error = "Password must be at least 4 characters";
			request.setAttribute("error", error);
			doGet(request, response);
			return;
		}
		else if (!(passWord.equals(RetypePass)))
		{
			error = "Username must be the same as Re-Type Password ";
			request.setAttribute("error", error);
			doGet(request, response);
			return;
		}

		int i;
		for (i = 0; i < myList.size(); i++)
		{
			if (userName.equals(myList.get(i).userName))
			{

				error = "Username exists ";
				request.setAttribute("error", error);
				doGet(request, response);

				return;

			}
			else
			{

				User myUsers = new User(userName, passWord);
				myList.add(myUsers);
			    response.sendRedirect("Login");
				return;
			}

		}

	}

}