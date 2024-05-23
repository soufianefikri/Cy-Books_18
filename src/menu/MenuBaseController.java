package menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class MenuBaseController extends MenuBase{
    /**
     * Launched when menu button is pressed. Opens the left menu.
     */
    protected void menu(javafx.event.ActionEvent actionEvent){
        open_close();
    }
    /**
     * Launched when customer button is pressed. Change Scene To UserBase.
     */
    protected void customer(javafx.event.ActionEvent actionEvent){
        UsersBase usersBase = new UserBaseController();

        Scene currentScene = btn_customer.getScene();

        currentScene.setRoot(usersBase);
    }

    protected  void books(javafx.event.ActionEvent actionEvent){
        Scene scene = btn_customer.getScene();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../searchBook/Main.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					scene.setRoot(parent);
					//searchBook.FXMLController controller = fxmlLoader.getController();
				}
				catch(Exception e){
					e.printStackTrace();
				}
    }
    /**
     * Launched when the close button is pressed. Close the left menu.
     */
    protected  void close_menu(javafx.event.ActionEvent actionEvent){
        open_close();
    }
    /**
     * Launched when calendar button is pressed.
     */
    protected  void calendar(javafx.event.ActionEvent actionEvent){
        LateBase LateView = new LateBase(); 
    	
        Scene currentScene = btn_calendar.getScene();
        
        currentScene.setRoot(LateView);
    }
    /**
     * Launched when borrow button is pressed.
     */
    protected  void borrow(javafx.event.ActionEvent actionEvent){
        VBox vbox2 = connexion.mostLoaned();

        Scene currScene = btn_borrow.getScene();

        currScene.setRoot(vbox2);
    }
    /**
     * Launched when parameters button is pressed.
     */
    protected  void param(javafx.event.ActionEvent actionEvent){
        System.out.println("parametres");
    }
    /**
     * Launched when leave button is pressed.
     */
    protected  void leave(javafx.event.ActionEvent actionEvent){
        System.out.println("leave");
    }
}
