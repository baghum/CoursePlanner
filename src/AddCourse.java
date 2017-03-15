package src;
import java.awt.Checkbox;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCourse() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Courses> enteries = (List<Courses>) getServletContext()
				.getAttribute("courses");

		String user = (String) request.getSession().getAttribute("user");
		String pass = (String) request.getSession().getAttribute("pass");
		List<User> myList = (List<User>) getServletContext().getAttribute("userList");
		//String userID = null;
		//String passId = null;
		for (int j = 0; j < myList.size(); j++) {
			String userID = myList.get(j).getUsername();
			String passId = myList.get(j).getPassword();
		

		if ((user != null) && (user.equals(userID)) && passId.equals(pass)) {

			PrintWriter out = response.getWriter();

			response.setContentType("text/html");

			out.println("<html><head><title>Add Course</title></head><body>");
			out.println("<table border = '1'>");
			out.println("<form action='AddCourse' method='post'>");

			out.println("<tr><td>Code:</td><td> <input type='text' name='code' /></td></tr> <br />");
			out.println("<tr><td>Title:</td><td> <input type='text' name='title' /></td></tr> <br />");

			out.println("<td>Prerequisite(s):</td>");

			for (int i = 0; i < enteries.size(); i++) {
				out.println("<tr><td>");
				Courses entry = enteries.get(i);
				out.println("<td>" + entry.getCode()
						+ "<input Type = 'checkbox' name = 'check' value= '"
						+ entry.getCode() + "' /></td>");

				out.println("</td></tr>");

			}
		

			out.println("</table>");
			out.println("<input type='submit' name='add' value='Add' /> <br />");
			out.println("</body></html>");
		
		}
		
		else {
			response.sendRedirect("Login");
		
		}}
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

		if (check != null) {
			List<String> Pre = new ArrayList<String>(Arrays.asList(check));

			enteries.add(new Courses(code, title, Pre));
		} else {
			enteries.add(new Courses(code, title, new ArrayList<String>()));

		}
		getServletContext().setAttribute("courses", enteries);

		response.sendRedirect("DisplayCourse");
	}
}
