package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class connexion {


    static final String DB_URL = "jdbc:mysql://localhost:3306/cy-book";
    static final String USER = "root";
    static final String PASS = "";

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
            ResultSet resultSet = stmt.executeQuery("SELECT Users.name, Users.surname, Livres.Title, Loans.Borrow_Date, Loans.Due_Date, Loans.Return_Date, Loans.Loan_Status "
            		+ "FROM Loans "
            		+ "INNER JOIN Users ON Loans.User_ID = Users.ID "
            		+ "INNER JOIN Livres ON Loans.Book_ID = Livres.ID "
            		+ "WHERE Users.ID = " + loan_user_id + " "
            		+ "");
            while (resultSet.next()) {
                String userName = resultSet.getString("name") + " " + resultSet.getString("surname");
                String bookTitle = resultSet.getString("Title");
                String borrowDate = resultSet.getString("Borrow_Date");
                String dueDate = resultSet.getString("Due_Date");
                String returnDate = resultSet.getString("Return_Date");
                String loanStatus = resultSet.getString("Loan_Status");
                history = new LoanHistory(userName, bookTitle, borrowDate, dueDate, returnDate, loanStatus);
                loanHistoryList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loanHistoryList;
    }
    
    
}
