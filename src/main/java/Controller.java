import java.sql.*;
public class Controller {
	public boolean login(User us)
	{
		boolean result=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB","SYS as SYSDBA","Oradoc_db1");
			pst=con.prepareStatement("select * from data where username = ? and password = ?");
			pst.setString(1,us.getUsername());
			pst.setString(2,us.getPassword());
			ResultSet rs=pst.executeQuery();
			result=rs.next();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pst!=null)
					pst.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
			try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
		}
		return result;
	}
	public boolean registerUser(User us)
	{
		boolean result=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		Connection con=null;
		PreparedStatement pst=null;
		String insert="insert into data values "+"(?,?,?,?,?,?,?)";
		try
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB","SYS as SYSDBA","Oradoc_db1");
			pst=con.prepareStatement(insert);
			pst.setString(1,us.getFirstname());
			pst.setString(2,us.getLastname());
			pst.setString(3,us.getUsername());
			pst.setString(4,us.getEmail());
			pst.setString(5,us.getPassword());
			pst.setString(6,us.getGender());
			pst.setString(7,us.getAge()+"");
			if(pst.executeUpdate()>0)
			{result=true;}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pst!=null)
					pst.close(); 
			}
			catch(SQLException se)
			{se.printStackTrace();}
			try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
		}
		return result;
	}
	public User getDetails(String username)
	{
		User us=new User();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		Connection con=null;
		PreparedStatement pst=null;
		String query="select firstname,lastname,email,gender,age from data where username="+username;
		try
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB","SYS as SYSDBA","Oradoc_db1");
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				us.setFirstname(rs.getString("firstname"));
				us.setLastname(rs.getString("lastname"));
				us.setEmail(rs.getString("email"));
				us.setGender(rs.getString("gender"));
				us.setAge(rs.getInt("age"));
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pst!=null)
					pst.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
			try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
		}
		return us;
	}
	public boolean changePassword(String username,String password)
	{
		boolean result=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		Connection con=null;
		PreparedStatement pst=null;
		String query="update data set password=? where username=?;";
		try
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB","SYS as SYSDBA","Oradoc_db1");
			pst=con.prepareStatement(query);
			pst.setString(1,password);
			pst.setString(2,username);
			int n=pst.executeUpdate();
			if(n>0)
				result=true;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pst!=null)
					pst.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
			try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
		}
		return result;
	}
	public boolean forgotPassword(User us)
	{
		boolean result=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		Connection con=null;
		PreparedStatement pst=null;
		String query="Select * from data where username=? and email=? and age=?;";
		try
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB","SYS as SYSDBA","Oradoc_db1");
			pst=con.prepareStatement(query);
			pst.setString(1,us.getUsername());
			pst.setString(2,us.getEmail());
			pst.setInt(3,us.getAge());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				result=true;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pst!=null)
					pst.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
			try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{se.printStackTrace();}
		}
		return result;
	}
}
