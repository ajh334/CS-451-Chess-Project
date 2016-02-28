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
	private String mURL;
	private String mUser;
	private String mPassword;
	private Connection mConnection;
	
	/**
	 * Constructor to set the URL, Username, and Password for the DB.
	 * @param URL
	 * @param Username
	 * @param Password
	 */
	public ChessDBE(String URL, String Username, String Password){
		this.mURL = URL;
		this.mUser = Username;
		this.mPassword = Password;
	}
	
	/**
	 * Establishes the database connection.
	 * @throws SQLException
	 */
	public void EstablishConnection() throws SQLException{
		mConnection = (Connection) DriverManager.getConnection(this.mURL, this.mUser, this.mPassword);
	}
	
	/**
	 * Closes the database connection.
	 * @throws SQLException
	 */
	public void CloseConnection() throws SQLException{
		mConnection.close();
	}
	
	/**
	 * Retrieves the current connection.
	 * @return
	 */
	public Connection getConnection(){
		return this.mConnection;
	}

}