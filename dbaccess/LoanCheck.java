package dbaccess;

import java.sql.*;

/**
 * LoanCheck is the class to check the number of loans
 * 
 * @author TDLT
 *
 */
public class LoanCheck {

	/**
	 * @param idLivre the id of the book
	 * @return a boolean, true if book can be loaned
	 */
	public static boolean loanChecker(String idLivre) {
		// JDBC URL, username, and password for the database
		// TODO enter information
		String jdbcUrl = "jdbc:mysql://localhost:3306/";
		String username = "";
		String password = "";

		// SQL query to count rows in a table
		String sqlQuery = "SELECT COUNT(*) AS row_count FROM Emprunt WHERE idlivre=" + idLivre
				+ " AND statut NOT LIKE 'terminé';";
		// connection starts
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			// Retrieve the row count from the result set
			if (resultSet.next()) {
				int rowCount = resultSet.getInt("row_count");
				if (rowCount <= 5) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
