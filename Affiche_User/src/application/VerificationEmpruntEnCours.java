package application;

import java.sql.*;
/**
 * checks if a user has a book with them using the effective return date
 *return true if yes 
 * else return false
 */
public class VerificationEmpruntEnCours {
	
	/**
	 * boolean check if user has books
	 * @param idUser
	 * @return
	 */
	public static boolean UtilisateurEmprunt(int idUser) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
            // Connection to bdd, need to adapt to your bdd
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_jav", "root", "");

            // execute SQL request and check in bdd if has books
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS nb_emprunts "
            		+ "FROM Emprunts "
            		+ "Where Utilisateur_ID = ? AND Date_Retour_Effective IS NULL");
            //attribut au premier point d'interogation(?) la valeur de l'id user
            preparedStatement.setInt(1, idUser);
            resultSet = preparedStatement.executeQuery();
            // Récupération du nombre d'emprunts en cours pour l'utilisateur
	        if (resultSet.next()) {
	            int nbEmprunts = resultSet.getInt("nb_emprunts");
	            System.out.println(nbEmprunts);
	            return nbEmprunts > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // free memory
	        try {
	            if (resultSet != null) {
	            	resultSet.close();
	            }
	            if (preparedStatement != null) {
	            	preparedStatement.close();
	            }
	            if (connection != null) {
	            	connection.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return false; // Retour false if no loan or error
	}
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
        //Pour le test
        boolean nbrr = VerificationEmpruntEnCours.UtilisateurEmprunt(4);
        System.out.println(nbrr);
    }
	
}
