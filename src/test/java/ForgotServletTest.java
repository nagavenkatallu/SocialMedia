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

public class ForgotServletTest {
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
	public void testForgotFail() throws Exception {
		when(request.getParameter("username")).thenReturn("venky123");
		when(request.getParameter("password")).thenReturn("venky123");
		when(request.getParameter("email")).thenReturn("venkat@123");
		when(request.getParameter("age")).thenReturn("21e");
		StringWriter stringwriter=new StringWriter();
		PrintWriter writer=new PrintWriter(stringwriter);
		when(response.getWriter()).thenReturn(writer);
		new ForgotServlet().doPost(request, response);
		String result=stringwriter.getBuffer().toString().trim();
		assertEquals("Please enter age correctly",result);
	}

}
