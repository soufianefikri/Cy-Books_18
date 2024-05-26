package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import apimangager.ApiCaller;
import controller.UpdateUserBaseController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import model.Book;
import model.LateHistory;
import model.LoanHistory;
import model.User;


public class connexion {

    
    static final String DB_URL = "jdbc:mysql://localhost:3306/cy_books";
    static final String USER = "root";
    static final String PASS = "0805";
    
    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement statement;
    /**
    * Get All informations about an user and display it
    * @param surname_name
    * @return User
    */
    public String[] getUtilisateursFromDatabase(String words) {
        String[] names = new String[10];
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
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
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
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
     * Register a new User in the Database
     * @param firstname of the new user
     * @param lastname of the new user
     * @param address of the new user
     * @param email of the new user
     * @param phone of the new user
     */
    public static void registerUser(String firstname,String lastname,String address,String email,String phone) {
		try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//2.1Connection CHeck

			stmt = conn.createStatement(); 
			String sql="INSERT cy_books.users (name,surname,address,email,phone)"
					+ "VALUES('" + firstname + "','" + lastname + "','" + address + "','" + email + "','" + phone +"');";
			int rowsAffected = stmt.executeUpdate(sql);
		    if (rowsAffected > 0) {
		    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            	alert.setTitle("Nouveau utilisateur créé");
	            	alert.setContentText("Le nouveau utilisateur est bien enregistré dans la base de données");
	           	alert.setHeaderText("Confirmation");
	            	alert.showAndWait();
		    } else {
		    	Alert alert = new Alert(Alert.AlertType.ERROR);
	            	alert.setTitle("Nouveau utilisateur non créé");
	           	alert.setContentText("Le nouveau utilisateur n'est pas enregistré dans la base de données");
	            	alert.setHeaderText("Erreur");
	            	alert.showAndWait();
		    }
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

    /**
     * Get All Information of an existing user and display them in their respective TextFields
     * @param id of the user 
     * @param menu instance of UpdateUserBaseController
     */
    public static void retrieveData(int id,UpdateUserBaseController menu) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
    
            // Check connection
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
    
            // SQL query
            String sql = "SELECT * FROM users WHERE id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
    
            // Execute the SELECT query
            ResultSet rs = statement.executeQuery();
    
            if (rs.next()) {
                String firstname = rs.getString("name");
                String lastname = rs.getString("surname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                // Show data in the existing UpdateUserBase instance
                menu.showData(firstname, lastname, address, email, phone);
            } else {
                System.out.println("No user found with ID: " + id);
            }
    
            // Close the statement and the declaration
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
  * Update/Change User Information in the Database
  * @param id of the user we want to update the informations
  * @param firstname possibly changed
  * @param lastname possibly changed
  * @param address possibly changed
  * @param email possibly changed
  * @param phone possibly changed
  */
    public static void changeUserInfo(int id, String firstname, String lastname, String address, String email, String phone) {
	    try {
	        // Load the driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Establish the connection
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        // Connection Check
	        
	        String sql = "UPDATE cy_books.users SET name=?, surname=?, address=?, email=?, phone=? WHERE id=?";
	        statement = conn.prepareStatement(sql);
	        
	        
	        statement.setString(1, firstname);
	        statement.setString(2, lastname);
	        statement.setString(3, address);
	        statement.setString(4, email);
	        statement.setString(5, phone);
	        statement.setInt(6, id);
	        
	        
	        int rowsAffected = statement.executeUpdate();
	        

	        if (rowsAffected > 0) {
		    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Modification effectuée");
	            alert.setContentText("Les informations de l'utilisateur ont bien été modifiées");
	            alert.setHeaderText("Confirmation");
	            alert.showAndWait();
		} else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Modification non effectuée");
	            alert.setContentText("Les informations de l'utilisateur n'ont pas été modifiées");
	            alert.setHeaderText("Erreur");
	            alert.showAndWait();
	        }
	        
	        statement.close();
	        conn.close();
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
        	conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
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

    
    /** 
     * @param user_id
     * @param book_id
     * @param DateToReturn
     */
    public static void registerNewLoan(int user_id, int book_id, String DateToReturn){
        try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//2.1Connection CHeck

			stmt = conn.createStatement(); 
			String sql="INSERT cy_books.loans (id,id_user,Loan_date,Planned_return_date,Real_return_date)"
					+ "VALUES('" + book_id + "','" + user_id + "','" + LocalDate.now() + "','" + DateToReturn + "','null');";
			int rowsAffected = stmt.executeUpdate(sql);
		    if (rowsAffected > 0) {
		    	System.out.println("User registered successfully.");
		    } else {
		    	System.out.println("Failed to register user.");
		    }
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
    }

    public static void registerLoan(String ISBN, String name, int id_user, int nb, LocalDate Planned_return) {
		try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//2.1Connection CHeck

			stmt = conn.createStatement(); 
			String sql="INSERT cy_books.loans (title,isbn,id_user,copy_number,Loan_date,Planned_return_date,Real_return_date)"
					+ "VALUES('" + name + "','" + ISBN + "','" + id_user +"','" + nb + "', NOW() ,'" + Planned_return +"',NULL);";
			int rowsAffected = stmt.executeUpdate(sql);
		    if (rowsAffected > 0) {
		    	System.out.println("Loan registered successfully.");
		    } else {
		    	System.out.println("Failed to register loan.");
		    }
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

    public static void returnBook(String id){
        try {
	        // Load the driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Establish the connection
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        // Connection Check

	        

	        
	        String sql2 = "UPDATE cy_books.loans SET Real_return_date=NOW() WHERE id=?";
	        statement = conn.prepareStatement(sql2);
	        statement.setString(1, id);
	        
	        
	        int rowsAffected = statement.executeUpdate();
	        

	        if (rowsAffected > 0) {
	            System.out.println("Book bring back.");
	        } else {
	            System.out.println("Failed to update loan.");
	        }
	        
	        statement.close();
	        conn.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
    }

    public static ObservableList<LateHistory> getLateHistory(){
        LateHistory history = new LateHistory();
        ObservableList<LateHistory> lateHistoryList = FXCollections.observableArrayList();

        try  {
        	conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
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


    public static VBox mostLoaned() {
		TableView<ObservableList<String>> tableView = new TableView<>();

		// Connect to the database and execute the SQL query
		ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
		try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.createStatement();
				// only select books that have been loaned 30 days prior today
				ResultSet resultSet = stmt.executeQuery(
						"SELECT ISBN, COUNT(*) AS Number_of_loan FROM loans WHERE Loan_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY) GROUP BY ISBN ORDER BY Number_of_loan DESC");
						
			// add the top of the array
			List<String> header = new ArrayList<String>();
			header.add("Title");
			header.add("Author");
			header.add("Number of loans");
			
			// for every column add a function so their cell value is updated when data is added
			for (int i = 0; i < 3; i++) {
				final int j = i;
				TableColumn<ObservableList<String>, String> column = new TableColumn<>(header.get(i).toString());
				column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(j)));
				tableView.getColumns().add(column);
			}

			// Add rows to the TableView
			while (resultSet.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();

				String query = "(bib.persistentid all \"" + resultSet.getString(1) + "\")";
				List<Book> books = ApiCaller.call(query, 1, 1);
				row.add(books.get(0).getTitle());
				row.add(books.get(0).getAuthor());
				row.add(resultSet.getString(2));

				data.add(row);
			}

			tableView.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		VBox vbox = new VBox();
		vbox.getChildren().add(tableView);
		vbox.setPrefSize(600, 450);
		return vbox;
	}

    public static int numberOfLoan(String isbn){
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
            // SQL query
            String sql = "SELECT COUNT(*) AS number FROM loans WHERE isbn = ?  AND Real_return_date IS NULL";
            statement = conn.prepareStatement(sql);
            statement.setString(1, isbn);
    
            // Execute the SELECT query
            ResultSet rs = statement.executeQuery();
    
            if (rs.next()) {
                int number = rs.getInt("number");
                return number;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
