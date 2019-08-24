/*
 * The assignment was adjusted from originally requiring a GUI to perform functions
 * to only creating the database using MySQL, connecting to the database, and performing 
 * some changes on it, as the purpose of the assignment was to show how to connect to a database and perform
 * changes. Nested in a try catch because there is a possibility that you cannot connect to your database, or you 
 * perform an operation using either one too little or too many parameters. 
 * In essence, you create a string with the MySQL statements (Insert, Update, Delete, Select) where your input replaces the 
 * corresponding ?. You need to ensure that your strings end up EXACTLY as if they were to be written in MySQL.
 * Note how the first ? is identified with 1, not 0 (not an array!).
 * Uses the mysql driver that is located in the referenced library. 
 * 
 */
package assignment10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
	private Connection connect = null;

	public void readDataBase() throws Exception {

		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			System.out.println("MySQL JDBC Driver Registered!");

			System.out.println("connection ");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

			//creates a delete statement
			PreparedStatement psDelete = connect.prepareStatement
					("DELETE FROM STAFF WHERE id = ?");
			psDelete.setString(1, "0");
			psDelete.executeUpdate();
			psDelete.setString(1, "1");
			psDelete.executeUpdate();
			
			// Creates an insert prepared statement
			PreparedStatement ps = connect.prepareStatement
			("insert into Staff (id, lastName, firstName, mi, address, city, state, telephone, email) "+
			 "values (?, ?, ?, ?, ?, ?, ?, ?, ?)" );
			
			ps.setString(1, "0");
			ps.setString(2, "Fieri");
			ps.setString(3, "Guy");
			ps.setString(4, "K");
			ps.setString(5, "150 Meat Steet");
			ps.setString(6, "Flavortown");
			ps.setString(7, "NY");
			ps.setString(8, "8008001000");
			ps.setString(9, "gravyboat@gmail.com");
			
			ps.executeUpdate();
			
			ps.setString(1, "1");
			ps.setString(2, "Guy");
			ps.setString(3, "Pink");
			ps.setString(4, "J");
			ps.setString(5, "5555 Street Pl");
			ps.setString(6, "Brooklyn");
			ps.setString(7, "NY");
			ps.setString(8, "8009870123");
			ps.setString(9, "mememachine@gmail.com");
			
			ps.executeUpdate();
			
			PreparedStatement psView = connect.prepareStatement
			("SELECT * FROM Staff WHERE Staff.id = ?");
			psView.setString(1, "0");
			ResultSet rset = psView.executeQuery();
			
			if (rset.next()) {
				System.out.println(rset.getString(1) + " " + rset.getString(2) + " " + rset.getString(3) + " "
								+ rset.getString(4) + " " + rset.getString(5) + " "+ rset.getString(6) + " " 
								+ rset.getString(7) + " "+ rset.getString(8) + " " + rset.getString(9) + " ");
			}
			else {
				System.out.println("Staff memeber not found.");
			}
			
			PreparedStatement psUpdateEmail = connect.prepareStatement
					("UPDATE Staff SET email = ?" +
					"WHERE id = ?");
			psUpdateEmail.setString(1, "politicz@hotmail.com");
			psUpdateEmail.setString(2, "1");
			
			psUpdateEmail.executeUpdate();
			
			psView.setString(1, "1");
			rset = psView.executeQuery();
			
			if (rset.next()) {
				System.out.println(rset.getString(1) + " " + rset.getString(2) + " " + rset.getString(3) + " "
								+ rset.getString(4) + " " + rset.getString(5) + " "+ rset.getString(6) + " " 
								+ rset.getString(7) + " "+ rset.getString(8) + " " + rset.getString(9) + " ");
			}
			else {
				System.out.println("Staff memeber not found.");
			}

		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception e) {
			throw e;
		}

	}

	public static void main(String[] args) throws Exception {
		JDBCTest dbt = new JDBCTest();
		dbt.readDataBase();
	}
}