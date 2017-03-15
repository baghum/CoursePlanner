package src;

import java.io.IOException;
import java.io.PrintWriter;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<html><head><title>Login</title></head><body>");
		out.print("<form action='Login' method='post'>");
		String user = (String) request.getSession().getAttribute("user");
		if(user != null)
			out.print("Username: " + user + "<br />");
		else
			out.print("Username: <input type='text' name='username' /><br />");

		out.print("Password: <input type='text' name='password' /><br />");
		out.print("<input type='submit' name='login' value='Login' /><br />");
		out.print("</form>");
		out.print("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String user = (String) request.getSession().getAttribute("user");
		String password = null;

		if(user == null)
		{
			String username = request.getParameter("username");
			password = request.getParameter("password");

			if(username.equals("andy") && password.equals("12345"))
			{

				// request.getSession().setAttribute("user", username);
				response.sendRedirect("Members");
			}
			request.getSession().setAttribute("user", username);
		}
		else if(user.equals("andy") && password.equals("12345"))
		{

			// request.getSession().setAttribute("user", username);
			response.sendRedirect("Members");
		}
		else
			response.sendRedirect("Login");
	}
}
