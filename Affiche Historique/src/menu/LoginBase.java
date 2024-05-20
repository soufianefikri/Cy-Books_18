package menu;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class LoginBase extends AnchorPane {
	
	protected final Text title;
	protected final Label loginLabel;
	protected final TextField idField;
	protected final PasswordField passwordField ;
	protected final Button loginButton;
	
	
	
    public LoginBase() {
        title = new Text("CY-BOOK");
        title.setFill(javafx.scene.paint.Color.web("#ffb200"));
        title.setStroke(javafx.scene.paint.Color.web("#ffb700"));
        title.setStrokeWidth(0);
        title.setLayoutY(141);
        title.setLayoutX(0);
        title.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        title.setWrappingWidth(800);
        title.setFont(new Font(89));

        AnchorPane AnchorPane2 = new AnchorPane();
        AnchorPane2.setLayoutX(48);
        AnchorPane2.setLayoutY(174);
        AnchorPane2.setPrefWidth(704);
        AnchorPane2.setPrefHeight(410);

        loginLabel = new Label("Login");
        loginLabel.setAlignment(javafx.geometry.Pos.CENTER);
        loginLabel.setLayoutX(216);
        loginLabel.setLayoutY(27);
        loginLabel.setPrefWidth(272);
        loginLabel.setPrefHeight(36);
        loginLabel.setTextFill(javafx.scene.paint.Color.web("#f7ac00"));
        loginLabel.setFont(new Font(25));

        idField = new TextField();
        idField.setPromptText("Id");
        idField.setLayoutX(166);
        idField.setLayoutY(112);
        idField.setPrefWidth(370);
        idField.setPrefHeight(26);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setLayoutX(167);
        passwordField.setLayoutY(204);
        passwordField.setPrefWidth(370);
        passwordField.setPrefHeight(26);

        loginButton = new Button("Connexion");
        loginButton.setId("loginButton");
//        loginButton.getStyleClass().add("");
        loginButton.setLayoutX(303);
        loginButton.setLayoutY(280);
        loginButton.setPrefWidth(98);
        loginButton.setPrefHeight(30);
        loginButton.setTextFill(javafx.scene.paint.Color.web("#ff8800"));
        loginButton.setOnAction(this::login_button);

        AnchorPane2.getChildren().addAll(loginLabel, idField, passwordField, loginButton);

        getChildren().addAll(title, AnchorPane2);
    }

    private void login_button(javafx.event.ActionEvent actionEvent) {

    	String username = idField.getText();
        String password = passwordField.getText();
        if (connexion.checkIdPassword(username, password) == true) {
        	MenuBase menu = new MenuBase();
            Scene currentScene = getScene();
            currentScene.setRoot(menu);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connexion Fail");
            alert.setHeaderText(null);
            alert.setContentText("Id or Password Incorrect.");
            alert.show();
        }
        
    }
    
    
}
