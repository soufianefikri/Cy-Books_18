package menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class connexion {

    
    static final String DB_URL = "jdbc:mysql://localhost:3306/cy_books";
    static final String USER = "root";
    static final String PASS = "0805";
    /**
    * Get All informations about an user and display it
    * @param surname_name
    * @return User
    */
    public String[] getUtilisateursFromDatabase(String words) {
        String[] names = new String[10];
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            int i = 0;
            
            ResultSet resultSet = stmt.executeQuery("select * from users where concat(name,' ',surname) like '"+words+"%' or concat(surname,' ',name) like '"+words+"%'");
                while (resultSet.next()){
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    names[i] = surname +" "+ name;
                    i = i + 1;
                } 
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
        return names;
    }
    /**
    * Get All information about an user from a search and return it
    * @param surname_name
    * @return User
    */
    public static User getUser(String surname_name){
        User u = new User();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from users where concat(surname,' ',name) like '" + surname_name + "'");
                while (resultSet.next()){
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    int id = resultSet.getInt("id");
                    
                    u = new User(name,surname,address,email,phone,id);
                } 
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }
    /**
    * Register A new User in the Database
    * @param id
    * @param firstname
    * @param lastname
    * @param address
    * @param email
    * @param phone
    */
    public static void registerUser(String firstname,String lastname,String address,String email,String phone) {
		try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			//2.1Connection CHeck
			if(connection!= null) {
				System.out.println("Espresso");
			}
			Statement statement = connection.createStatement(); 
			String sql="INSERT cy_books.users (name,surname,address,email,phone)"
					+ "VALUES('" + firstname + "','" + lastname + "','" + address + "','" + email + "','" + phone +"');";
			int rowsAffected = statement.executeUpdate(sql);
		    if (rowsAffected > 0) {
		    	System.out.println("User registered successfully.");
		    } else {
		    	System.out.println("Failed to register user.");
		    }
			statement.close();
			connection.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

    /**
  * Get All Informations of an user and display them in the TextField
  * @param id
  * @param menu
  */
    public static void RetrieveData(int id,UpdateUserBaseController menu) {
        try {
            // Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            // Établissement de la connexion
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
    
            // Vérification de la connexion
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
    
            // Création de l'instruction SQL
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
    
            // Exécution de la requête SELECT
            ResultSet rs = statement.executeQuery();
    
            if (rs.next()) {
                String firstname = rs.getString("name");
                String lastname = rs.getString("surname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                // Affichage des données dans l'instance existante de UpdateUserBase
                menu.showData(firstname, lastname, address, email, phone);
            } else {
                System.out.println("No user found with ID: " + id);
            }
    
            // Fermeture de la connexion et de la déclaration
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
  * Update/Change User Information in the Database
  * @param id
  * @param firstname
  * @param lastname
  * @param address
  * @param email
  * @param phone
  */
    public static void updateUser(int id, String firstname, String lastname, String address, String email, String phone) {
	    try {
	        // Load the driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
	        // Connection Check
	        if (connection != null) {
	            System.out.println("Espresso");
	        }
	        
	        
	        String sql = "UPDATE cy_books.users SET name=?, surname=?, address=?, email=?, phone=? WHERE id=?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        
	        
	        statement.setString(1, firstname);
	        statement.setString(2, lastname);
	        statement.setString(3, address);
	        statement.setString(4, email);
	        statement.setString(5, phone);
	        statement.setInt(6, id);
	        
	        
	        int rowsAffected = statement.executeUpdate();
	        

	        if (rowsAffected > 0) {
	            System.out.println("User updated successfully.");
	        } else {
	            System.out.println("Failed to update user.");
	        }
	        
	        statement.close();
	        connection.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}


    /**
  * get the loan history of a user
  * @param loan_user_id
  * @return loanHistoryList
  */
    public static ObservableList<LoanHistory> getLoanHistory(int loan_user_id) {
    	
    	LoanHistory history = new LoanHistory();
        ObservableList<LoanHistory> loanHistoryList = FXCollections.observableArrayList();

        try  {
        	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT loans.title, loans.Loan_date, loans.Planned_return_date, loans.Real_return_date, loans.id"
            		+ " FROM loans "
                    + " INNER JOIN users ON loans.id_user = users.id "
                    + " WHERE users.id = " + loan_user_id + " "
            		+ "");
            while (resultSet.next()) {
                String bookTitle = resultSet.getString("title");
                String borrowDate = resultSet.getString("Loan_date");
                String dueDate = resultSet.getString("Planned_return_date");
                String returnDate = resultSet.getString("Real_return_date");
                String loan_id = resultSet.getString("id");
                history = new LoanHistory(bookTitle, borrowDate, dueDate, returnDate, loan_id);
                loanHistoryList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loanHistoryList;
    }

    public static void registerNewLoan(int user_id, int book_id, String DateToReturn){
        try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			//2.1Connection CHeck
			if(connection!= null) {
				System.out.println("Espresso");
			}
			Statement statement = connection.createStatement(); 
			String sql="INSERT cy_books.loans (id,id_user,Loan_date,Planned_return_date,Real_return_date)"
					+ "VALUES('" + book_id + "','" + user_id + "','" + LocalDate.now() + "','" + DateToReturn + "','null');";
			int rowsAffected = statement.executeUpdate(sql);
		    if (rowsAffected > 0) {
		    	System.out.println("User registered successfully.");
		    } else {
		    	System.out.println("Failed to register user.");
		    }
			statement.close();
			connection.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
    }

    public static void registerLoan(String ISBN, String name, int id_user, int nb, LocalDate Planned_return) {
		try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			//2.1Connection CHeck
			if(connection!= null) {
				System.out.println("Espresso");
			}

			Statement statement = connection.createStatement(); 
			String sql="INSERT cy_books.loans (title,isbn,id_user,copy_number,Loan_date,Planned_return_date,Real_return_date)"
					+ "VALUES('" + name + "','" + ISBN + "','" + id_user +"','" + nb + "', NOW() ,'" + Planned_return +"',NULL);";
			int rowsAffected = statement.executeUpdate(sql);
		    if (rowsAffected > 0) {
		    	System.out.println("Loan registered successfully.");
		    } else {
		    	System.out.println("Failed to register loan.");
		    }
			statement.close();
			connection.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

    public static void returnBook(String id){
        try {
	        // Load the driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
	        // Connection Check
	        if (connection != null) {
	            System.out.println("Espresso");
	        }
	        

	        
	        String sql2 = "UPDATE cy_books.loans SET Real_return_date=NOW() WHERE id=?";
	        PreparedStatement statement = connection.prepareStatement(sql2);
	        statement.setString(1, id);
	        
	        
	        int rowsAffected = statement.executeUpdate();
	        

	        if (rowsAffected > 0) {
	            System.out.println("Book bring back.");
	        } else {
	            System.out.println("Failed to update loan.");
	        }
	        
	        statement.close();
	        connection.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
    }

    public static ObservableList<LateHistory> getLateHistory(){
        LateHistory history = new LateHistory();
        ObservableList<LateHistory> lateHistoryList = FXCollections.observableArrayList();

        try  {
        	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "SELECT loans.title,users.name,users.surname, loans.Planned_return_date FROM loans INNER JOIN users on users.id = loans.id_user WHERE Planned_return_date<NOW();";
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String plannedReturnDate = resultSet.getString("Planned_return_date");
                history = new LateHistory(title, name, surname, plannedReturnDate);
                lateHistoryList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lateHistoryList;
    }
}
