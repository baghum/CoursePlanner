package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

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

	@SuppressWarnings({ "null", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		 List<User> myList = (List<User>)getServletContext().getAttribute("userList");
		//String user = (String) request.getSession().getAttribute("user");
		//String username = null;
		//String password = null;
		/*String userID = myList
		String passId = */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		for(int i = 0; i < myList.size(); i++){
			
		String userID = myList.get(i).getUsername(); 
		 String passId = myList.get(i).getPassword();
		
		
		
			if(username.equals(userID) && password.equals(passId))
			{				
				// request.getSession().setAttribute("user", username);
			
			
			request.getSession().setAttribute("user", username);
			//request.getSession().setMaxInactiveInterval(10*60);
			//request.getSession().setAttribute("pass", password);
			//request.getSession().setMaxInactiveInterval(10*60);
			response.sendRedirect("DisplayCourse");
			}
			else{
				response.sendRedirect("Login");
				
			}
		}
		
		
		
			//response.sendRedirect("Login");
		
		}
	}

