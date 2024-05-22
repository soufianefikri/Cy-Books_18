package menu;

import javafx.scene.Scene;

public class RegisterBaseController extends RegisterBase{

    protected void check_input(javafx.event.ActionEvent actionEvent){
        RegisterInfo reg = new RegisterInfo();
        reg.user_input(actionEvent, firstname_field, lastname_field, address_field, zipcode_field, city_field, email_field, number_field);
    };

    protected void home(javafx.event.ActionEvent actionEvent){
        MenuBase menu = new MenuBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }

    protected void cancel(javafx.event.ActionEvent actionEvent){
        UsersBase menu = new UserBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }
}
