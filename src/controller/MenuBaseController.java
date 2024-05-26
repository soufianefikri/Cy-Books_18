package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import view.MenuBase;
import view.UsersBase;
import view.LateBase;
import view.connexion;

public class MenuBaseController extends MenuBase{
    /**
     *  Opens the left menu
     * @param actionEvent
     */
    protected void leftMenu(javafx.event.ActionEvent actionEvent){
        open_close();
    }
    /**
     * Change Scene To see user page
     * @param actionEvent
     */
    protected void userPage(javafx.event.ActionEvent actionEvent){
        UsersBase usersBase = new UserBaseController();

        Scene currentScene = btn_user.getScene();

        currentScene.setRoot(usersBase);
    }
    /**
     * Change Scene To see books page
     * @param actionEvent
     */
    protected  void booksPage(javafx.event.ActionEvent actionEvent){
        Scene scene = btn_user.getScene();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/searchBooksView.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					scene.getStylesheets().add(getClass().getResource("../styles/searchpage.css").toExternalForm());
					scene.setRoot(parent);
					//searchBook.FXMLController controller = fxmlLoader.getController();
				}
				catch(Exception e){
					e.printStackTrace();
				}
    }
    /**
     * Close the left menu.
     * @param actionEvent
     */
    protected  void closeLeftMenu(javafx.event.ActionEvent actionEvent){
        open_close();
    }
    /**
     * Look at all the overdue books
     * @param actionEvent
     */
    protected  void calendar(javafx.event.ActionEvent actionEvent){
        LateBase LateView = new LateBase(); 
    	
        Scene currentScene = btn_calendar.getScene();
        
        currentScene.setRoot(LateView);
    }
    /**
     * Look at the top borrowed books
     * @param actionEvent
     */
    protected  void borrow(javafx.event.ActionEvent actionEvent){
        VBox vbox2 = connexion.mostLoaned();

        Scene currScene = btn_borrow.getScene();
	currScene.getStylesheets().add(getClass().getResource("../styles/searchpage.css").toExternalForm());
        currScene.setRoot(vbox2);
    }
    /**
     * null
     */
    protected  void param(javafx.event.ActionEvent actionEvent){
        System.out.println("parametres");
    }
    /**
     * null
     */
    protected  void leave(javafx.event.ActionEvent actionEvent){
        System.out.println("leave");
    }
}
