import java.sql.*;


public class dbtest
{
  public static void main(String[] args) throws ClassNotFoundException
  {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;

		try {		

			connection = DriverManager.getConnection("jdbc:sqlite:wc.db");

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
		
			ResultSet rs = statement.executeQuery("SELECT Teams.name,code FROM Teams,Groups WHERE groupId=Groups.id AND Groups.name='B'");

			while (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("name"));
			}
		}
		catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        System.err.println(e);
      }
    }
	}
}