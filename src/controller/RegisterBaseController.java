package controller;

import javafx.scene.Scene;
import view.RegisterBase;
import view.RegisterInfo;
import view.MenuBase;
import view.UsersBase;
public class RegisterBaseController extends RegisterBase{

    
    /** 
     * Check if all the inputs are OK and add a new row in the table users
     * @param actionEvent
     */
    protected void check_input(javafx.event.ActionEvent actionEvent){
        RegisterInfo reg = new RegisterInfo();
        reg.user_input(actionEvent, firstname_field, lastname_field, address_field, zipcode_field, city_field, email_field, number_field);
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
