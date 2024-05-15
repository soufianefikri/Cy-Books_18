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

    public User getUtilisateursFromDatabase(String words) {
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            User u;
            ResultSet resultSet = stmt.executeQuery("select * from users where concat(name,' ',surname) like '"+words+"%'");
                if (resultSet.next()){
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String adress = resultSet.getString("adress");
                    String phone = resultSet.getString("phone");
                    String email = resultSet.getString("email");
                    int id = resultSet.getInt("id");
                    u = new User(surname,name,adress,email,phone,id);
                } else {
                    u = null;
                }
            
            return u;
        } catch (SQLException e){
            e.printStackTrace();
            return new User();
        }
    }
}
