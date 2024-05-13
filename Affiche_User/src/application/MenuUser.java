package application;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.sql.*;


public class MenuUser {
    private VBox vBox;

    public VBox getvBox() {
        return vBox;
    }

    public void getUtilisateursFromDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //for our bdd
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj_jav", "root", "");
            //which user need by id
            PreparedStatement statement = connection.prepareStatement("select * from utilisateurs where id=1 ");
            ResultSet resultSet = statement.executeQuery();

            vBox = new VBox();

            while (resultSet.next()) {
                String surname = resultSet.getString("nom");
                String name = resultSet.getString("prenom");
                String adress = resultSet.getString("adresse");
                String phone = resultSet.getString("numero_telephone");
                String email = resultSet.getString("adresse_mail");

                Label labelName = new Label("Nom: " + surname);
                Label labelSurname = new Label("Prénom: " + name);
                Label labelAdress = new Label("Adresse: " + adress);
                Label labelPhone = new Label("Tel: " + phone);
                Label labelEmail = new Label("Mail: " + email);
                
                vBox.getChildren().addAll(labelName, labelSurname, labelAdress, labelPhone, labelEmail);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
