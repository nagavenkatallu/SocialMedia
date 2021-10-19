

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeServlet
 */
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Controller controller;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
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
		response.setContentType("text/html");
		String password=request.getParameter("password");
		String reenter=request.getParameter("reenter");
		if(password.equals(reenter))
		{
			HttpSession session=request.getSession(false);
			String username=(String)session.getAttribute("username");
			boolean b=controller.changePassword(username,password);
			if(b)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				PrintWriter out=response.getWriter();
				out.println("Password changerd Succesfully.Please login with new password");
				rd.include(request, response);
			}
			else
			{
				PrintWriter out=response.getWriter();
				out.println("Password change failed");
			}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
			PrintWriter out=response.getWriter();
			out.println("Your passwords are not matching");
			rd.include(request, response);
		}
	}

}
