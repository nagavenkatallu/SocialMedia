

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
/**
 * Servlet implementation class ForgotServlet
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Controller controller;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
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
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String ages=request.getParameter("age");
		session.setAttribute("username",username);
		int age=0;
		try
		{
			age=Integer.parseInt(ages);
			User us=new User();
			us.setAge(age);
			us.setUsername(username);
			us.setEmail(email);
			boolean b=controller.forgotPassword(us);
			if(b)
			{
				RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ForgotPassword.jsp");
				PrintWriter out=response.getWriter();
				out.println("User not found with these details");
				rd.include(request, response);
			}
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ForgotPassword.jsp");
			PrintWriter out=response.getWriter();
			out.println("Please enter age correctly");
			rd.include(request, response);
		}
	}

}
