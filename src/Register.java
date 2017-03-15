package src;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<User> userList = new ArrayList<User>();

	public Register() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//List<User> userList = new ArrayList<User>();

		userList.add(new User("cysun", "abcd"));
		
		userList.add(new User("cs320stu31 ", "abcd"));
		
		getServletContext().setAttribute("userList", userList);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<html><head><title>Register</title></head><body>");
		out.println("<table border = '1'>");
		out.println("<form action='Register' method='post'>");

		out.println("<tr><td>Username*:</td><td> <input type='text' name='Username' /></td> <br /></tr>");
		out.println("<tr><td>Password*:</td><td> <input type='text' name='Password' /></td> <br /></tr>");
		out.println("<tr><td>Re-Type password*:</td><td> <input type='text' name='Re-Password' /></td> <br /></tr>");
		out.println("<tr><td>First Name(Optional):</td><td> <input type='text' name='firstname' /></td> <br /></tr>");
		out.println("<tr><td>Last Name(Optional):</td><td> <input type='text' name='lastname' /></td> <br /></tr>");
		out.println("</table>");
		out.println("<input type='submit' name='register' value='Register' /> <br />");
		out.println("</body></html>");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<User> myList = (List<User>)getServletContext().getAttribute("userList");

		String userName = request.getParameter("Username");
		String passWord = request.getParameter("Password");
		String RetypePass = request.getParameter("Re-Password");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		out.println("Thank you for registering" + "<br />");
		out.println("<p><a href='Login'>Please click here to login</a></p>");

		if (userName.isEmpty() || passWord.isEmpty() || RetypePass.isEmpty()) {
			out.println("The required fields are empty!<br/>");
		} else if (userName.length() < 4) {
			out.println("Username must be at least 4 characters!<br/>");

		} else if (passWord.length() < 4) {
			out.println("PassWord must be at least 4 characters<br/>");
		} else if (!(passWord.equals(RetypePass))) {
			out.println("Password and re-typed password do not match<br/>");
		}
		
		for (int i = 0; i < myList.size(); i++) {
			if (userName.equals(myList.get(i).getUsername())) 
			{
				out.println("user exists");

			
			   }
			
			}
			
             User myUsers = new User(userName, passWord);
			 // myList.add(new User())
			//getServletContext().setAttribute( "userList", userList );
			//response.sendRedirect("Login");
			
		}
	}

