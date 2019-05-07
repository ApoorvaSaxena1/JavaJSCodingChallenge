package folder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";


	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public List<Entry> getData() {
		Connection conn = null;
		Statement stmt = null;
		List <Entry> entries=new ArrayList<Entry>();
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String SQL = "SELECT * FROM sakila.titanictb";

			ResultSet rs = stmt.executeQuery(SQL);
			
			//STEP 5: Extract data from result set
			while(rs.next()){
				Entry entry = new Entry();
				entry.setPassenger(rs.getInt("Passenger"));
				entry.setSurvived(rs.getInt("Survived"));
				entry.setPclass(rs.getInt("Pclass"));
				entry.setName(rs.getString("Name"));
				entry.setSex(rs.getString("Sex"));
				entry.setAge(rs.getInt("Age"));
				entry.setSibSp(rs.getInt("SibSp"));
				entry.setParch(rs.getInt("Parch"));
				entry.setTicket(rs.getString("Ticket"));
				entry.setFare(rs.getFloat("Fare"));
				entries.add(entry);
			}
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return entries;
	}//end main
}//end FirstExample


