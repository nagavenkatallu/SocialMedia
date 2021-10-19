import static org.junit.Assert.*;

import org.junit.Test;


public class ControllerTest {

	@Test
	public void testLogin() {
		User us=new User();
		us.setUsername("venky123");
		us.setPassword("venky123");
		assertEquals(true,new Controller().login(us));;
	}

	@Test
	public void testRegisterUser() {
		User us=new User();
		us.setFirstname("dummy");
		us.setLastname("dummy");
		us.setUsername("dummy123");
		us.setPassword("dummy123");
		us.setEmail("dummy@gmail.com");
		us.setGender("male");
		us.setAge(18);
		assertEquals(true,new Controller().registerUser(us));
	}

	@Test
	public void testForgotPassword() {
		User us=new User();
		us.setUsername("venky123");
		us.setEmail("venkat@123");
		us.setAge(21);
		assertEquals(true,new Controller().forgotPassword(us));
	}
	
}
