package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 * 
 * In order to use this, you have to download the Connector/J driver and add
 * its .jar file to your build path.  You can find it here:
 * 
 * http://dev.mysql.com/downloads/connector/j/
 * 
 * You will see the following exception if it's not in your class path:
 * 
 * java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
 * 
 * To add it to your class path:
 * 1. Right click on your project
 * 2. Go to Build Path -> Add External Archives...
 * 3. Select the file mysql-connector-java-5.1.24-bin.jar
 *    NOTE: If you have a different version of the .jar file, the name may be
 *    a little different.
 *    
 * The user name and password are both "root", which should be correct if you followed
 * the advice in the MySQL tutorial. If you want to use different credentials, you can
 * change them below. 
 * 
 * You will get the following exception if the credentials are wrong:
 * 
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using password: YES)
 * 
 * You will instead get the following exception if MySQL isn't installed, isn't
 * running, or if your serverName or portNumber are wrong:
 * 
 * java.net.ConnectException: Connection refused
 */
public class createDB{
	

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "Beu|ah1980*";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "BNB";
	
	/** The name of the table we are using for users */
	private final String tableName = "users";
	
	private final String roomTable = "rooms";
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}
	
	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 */
	public void createUsers() {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
		
		// Create a table for users
				try {
				    String createString =
				    		"DROP TABLE IF EXISTS " + this.tableName + ";" +
				    		"CREATE TABLE " + this.tableName + "(" +
				    		"FIRSTNAME varchar(60) NOT NULL, " +
				    		"LASTNAME varchar(60) NOT NULL, " +
				    		"ADDRESS varchar(200) NOT NULL, " +
				    		"CITY varchar(40) NOT NULL, " +
				    		"STATE varchar(40) NOT NULL, " +
				    		"ZIP varchar(6) NOT NULL, " +
				    		"PHONE varchar(25) NOT NULL, " +
				    		"EMAIL varchar(100) NOT NULL UNIQUE, " +
				    		"USERNAME varchar(40) NOT NULL, " +
					        "PWORD varchar(40) NOT NULL, " +
					        "PRIMARY KEY (EMAIL));";
					this.executeUpdate(conn, createString);
					System.out.println("Created a table");
			    } catch (SQLException e) {
					System.out.println("ERROR: Could not create the table");
					e.printStackTrace();
					return;
				}
	}
				
	public void createRooms() {

	// Connect to MySQL
	Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}		
				try {
				    String createString2 =
				    		 "CREATE TABLE " + this.roomTable + " ( " +
					        		"roomID int NOT NULL AUTO_INCREMENT, " + 
					        		"roomName VARCHAR(25) NOT NULL, " +
					        		"roomType VARCHAR(25) NOT NULL, " + 
					        		"roomDescription VARCHAR(450) NOT NULL, " +
					        		"roomPrice double, " + 
					        		"PRIMARY KEY (roomID));";
					this.executeUpdate(conn, createString2);
					System.out.println("Created a table");
			    } catch (SQLException e) {
					System.out.println("ERROR: Could not create the table");
					e.printStackTrace();
					return;
				}
	}
	
		public void insertRooms() {

					// Connect to MySQL
					Connection conn = null;
					try {
						conn = this.getConnection();
						System.out.println("Connected to database");
					} catch (SQLException e) {
						System.out.println("ERROR: Could not connect to the database");
						e.printStackTrace();
						return;
					}
					//insert users into table
					try{
					
					String insertString = 
							"INSERT INTO " + this.roomTable + " (roomName, roomType, roomDescription, roomPrice) " +
							 "VALUES ('Bordeaux', 'Standard Room', 'A room with a classic feel and modern touches, Bordeaux has a king size bed, a seating area, two dressers and a view of the park. " +
							 			"The room offers a full bathroom and two person tub.', '169'), " +
							 		 "('Caribou', 'Standard Room', 'Cool colors, light floors and furniture and soft fabrics give Caribou a calm and peaceful feel. The room features a small kitchenette and offers plenty of storage as well " +
							 			"as a full bathroom.', '169'), " +
							 		  "('Hey Violet', 'Comfort Room', 'This room may be smaller, but with cool colored walls and bold, plush fabrics it has everything you need to relax and sleep in. Lounge on the couch with a drink from the " +
							 			"hidden min-bar. This room also offers a full bathroom.', '139'), " +
							 		  "('Sunset Rubdown', 'Luxury Suite', 'This room has a warm and spacious feeling. It provides abundant storage for those who like to stay longer and feel at home. A large floor to ceiling window provides natural " +
							 			"sunlight and spectacular views of the sunset. It also offers a full bathroom and wet bar.', '249'), " +
							 		 "('Yo La Tengo', 'Luxury Suite', 'This suite offers a large living space with a king size bed and a spacious lounge area with a sleeper couch and chairs. French doors provide plenty of natural light and an escape " +
							 			"to a private terrace. The bathroom has a shower and deep two-person bathtub.', '249');";
					this.executeUpdate(conn, insertString);
					System.out.println("Values added");
				}catch (SQLException e) {
					System.out.println("ERROR: Could not insert values into table");
					e.printStackTrace();
					return;
				}
		}
					
		public void insertUsers() {

						// Connect to MySQL
						Connection conn = null;
						try {
							conn = this.getConnection();
							System.out.println("Connected to database");
						} catch (SQLException e) {
							System.out.println("ERROR: Could not connect to the database");
							e.printStackTrace();
							return;
						}
						//insert users into table
						try{
						
						String insertString2 = 
								"INSERT INTO " + this.tableName + " (firstname, lastname, address, city, state, zip, phone, email, username, pword) VALUES ('Krista', 'Froiseth', '123 address', 'Gville', 'FL', '32606', '321-795-7558', 'email@email.com', 'kfroi', 'password'); "; 
						this.executeUpdate(conn, insertString2);
						System.out.println("Values added");
					}catch (SQLException e) {
						System.out.println("ERROR: Could not insert values into table");
						e.printStackTrace();
						return;
					}		
					
									

}
				
		/**
		* Connect to the DB and do some stuff
		*/
		public static void main(String[] args) {
			createDB app = new createDB();
			app.createUsers();
			app.createRooms();
			app.insertUsers();
			app.insertRooms();
			}
	}