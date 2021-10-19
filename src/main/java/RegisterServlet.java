

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Controller controller=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	controller=new Controller();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String reenter=request.getParameter("reenter");
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		User us=new User();
		us.setFirstname(firstname);
		us.setLastname(lastname);
		us.setUsername(username);
		us.setEmail(email);
		us.setPassword(password);
		us.setGender(gender);
		try
		{
			int age_new=Integer.parseInt(age);
			us.setAge(age_new);
		}
		catch(Exception e)
		{e.printStackTrace();}
		if(password.equals(reenter))
		{
			boolean b=controller.registerUser(us);
			if(b==true)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				PrintWriter out=response.getWriter();
				out.println("Successfully register");
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
				PrintWriter out=response.getWriter();
				out.println("Registration failed.Try with different username");
				rd.include(request, response);
			}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			PrintWriter out=response.getWriter();
			out.println("Registration failed.The passwords are not matching.");
			rd.include(request, response);
		}
	}

}
