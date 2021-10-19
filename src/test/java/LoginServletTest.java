import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LoginServletTest extends Mockito {
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher rd;
	
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testLoginSuccess() throws Exception{
		when(request.getParameter("username")).thenReturn("venky123");
		when(request.getParameter("password")).thenReturn("venky123");
		when(request.getRequestDispatcher("SuccessServlet")).thenReturn(rd);
		StringWriter stringwriter=new StringWriter();
		PrintWriter writer=new PrintWriter(stringwriter);
		when(response.getWriter()).thenReturn(writer);
		new LoginServlet().doPost(request, response);
		
		String result=stringwriter.getBuffer().toString().trim();
		assertEquals("login success",result);
	}
	
	@Test
	public void testLoginFail() throws Exception
	{
		when(request.getParameter("username")).thenReturn("venky123");
		when(request.getParameter("password")).thenReturn("venky1234");
		when(request.getRequestDispatcher("SuccessServlet")).thenReturn(rd);
		StringWriter stringwriter=new StringWriter();
		PrintWriter writer=new PrintWriter(stringwriter);
		when(response.getWriter()).thenReturn(writer);
		new LoginServlet().doPost(request, response);
		
		String result=stringwriter.getBuffer().toString().trim();
		assertEquals("Invalid credentials",result);
	}

}
