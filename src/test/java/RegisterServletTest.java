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

public class RegisterServletTest {
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
	public void testRegisterFail() throws Exception {
		when(request.getParameter("firstname")).thenReturn("dummy");
		when(request.getParameter("lastname")).thenReturn("dummy");
		when(request.getParameter("username")).thenReturn("dummy123");
		when(request.getParameter("email")).thenReturn("dummy@gmail.com");
		when(request.getParameter("password")).thenReturn("dummy123");
		when(request.getParameter("reenter")).thenReturn("dummy1234");
		when(request.getParameter("gender")).thenReturn("male");
		when(request.getParameter("age")).thenReturn("20");
		when(request.getRequestDispatcher("SuccessServlet")).thenReturn(rd);
		StringWriter stringwriter=new StringWriter();
		PrintWriter writer=new PrintWriter(stringwriter);
		when(response.getWriter()).thenReturn(writer);
		new RegisterServlet().doPost(request, response);
		String result=stringwriter.getBuffer().toString().trim();
		assertEquals("Registration failed.The passwords are not matching.",result);
	}

}
