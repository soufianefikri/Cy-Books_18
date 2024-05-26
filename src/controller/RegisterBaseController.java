package controller;

import javafx.scene.Scene;

import view.RegisterBase;
import view.RegisterUserInfo;
import view.MenuBase;
import view.UsersBase;
public class RegisterBaseController extends RegisterBase{

    
    /** 
     * This method is used to call the necessary methods to check information and add the new user to the database
     * @param actionEvent
     */
    protected void checkInput(javafx.event.ActionEvent actionEvent){
        RegisterUserInfo reg = new RegisterUserInfo();
        reg.userInput(actionEvent, firstname_field, lastname_field, address_field, zipcode_field, city_field, email_field, number_field);
    };
    /** 
     * Return to the home menu
     * @param actionEvent
     */
    protected void home(javafx.event.ActionEvent actionEvent){
        MenuBase menu = new MenuBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }
    /**
     * Return to the previous page, here : user page
     * @param actionEvent
     */
    protected void cancel(javafx.event.ActionEvent actionEvent){
        UsersBase menu = new UserBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }
}
