package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class connexion {


    static final String DB_URL = "jdbc:mysql://localhost:3306/cy_books";
    static final String USER = "root";
    static final String PASS = "0805";

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
}
