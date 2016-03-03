package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

/**
 * Sets up connection to database.
 * @author david
 *
 */
public class ChessDBE  {
	private String myURL;
	private String myUser;
	private String myPassword;
	private Connection myConnection;
	
	/**
	 * Constructor to set the URL, Username, and Password for the DB.
	 * @param URL
	 * @param Username
	 * @param Password
	 */
	public ChessDBE(String URL, String Username, String Password){
		this.myURL = URL;
		this.myUser = Username;
		this.myPassword = Password;
	}
	
	/**
	 * Establishes the database connection.
	 * @throws SQLException
	 */
	public void EstablishConnection() throws SQLException{
		myConnection = (Connection) DriverManager.getConnection(this.myURL, this.myUser, this.myPassword);
	}
	
	/**
	 * Closes the database connection.
	 * @throws SQLException
	 */
	public void CloseConnection() throws SQLException{
		myConnection.close();
	}
	
	/**
	 * Retrieves the current connection.
	 * @return
	 */
	public Connection getConnection(){
		return this.myConnection;
	}

}