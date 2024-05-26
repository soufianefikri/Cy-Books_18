package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import view.UsersBase;
import view.connexion;
import view.MenuBase;
import view.RegisterBase;
import view.HistoricalBase;
public class UserBaseController extends UsersBase{
    
    @SuppressWarnings("unchecked")
    /** 
     * Read the textField and display all users that match with the text.
     */
    public void searchBar(){
        u=null;
        list_view.getItems().clear();
        connexion co = new connexion();

        String[] names = co.getUtilisateursFromDatabase(textField.getText());
        // Remove all null items
        List<String> nonNullNames = Arrays.stream(names).filter(Objects::nonNull).collect(Collectors.toList());
        // Add them to the ListView
        list_view.getItems().addAll(nonNullNames);
        if (nonNullNames.size() > 0){
            list_view.setVisible(true);
        } else {
            list_view.setVisible(false);
        }

        list_view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                u = connexion.getUser(list_view.getSelectionModel().getSelectedItem().toString());
                text_name.setText(u.getFirstame());
                text_surname.setText(u.getLastname());
                text_address.setText(u.getAddress());
                text_phone.setText(u.getPhone());
                text_mail.setText(u.getEmail());
                vBox.setVisible(true);
                list_view.setVisible(false);
            }
            
        });
    }

    
    /** 
     * Return to the home page
     * @param actionEvent
     */
    protected void home(javafx.event.ActionEvent actionEvent){
        MenuBase menu = new MenuBaseController();

        Scene currentScene = btn_home.getScene();

        currentScene.setRoot(menu);
    };
    /** 
     * Go to the RegisterUser Page
     * @param actionEvent
     */
    protected void newUser(javafx.event.ActionEvent actionEvent){
        RegisterBase menu = new RegisterBaseController();
        
        Scene currentScene = btn_new.getScene();
        
        currentScene.setRoot(menu);
    };
    /** 
     * Call the searchBar funtion (active on button click)
     * @param actionEvent
     */
    protected void search(javafx.event.ActionEvent actionEvent){
        searchBar();
    };
    /** 
     * call the searchBar funtion (active on EnterKey Pressed)
     * @param actionEvent
     */
    public void onEnter(javafx.event.ActionEvent actionEvent){
        searchBar();
    }
    /** 
     * Go to the Update Info User
     * @param actionEvent
     */
    protected void changeUser(javafx.event.ActionEvent actionEvent){

        UpdateUserBaseController menu = new UpdateUserBaseController(u.getiD());
        Scene currentScene = btn_change.getScene();
        currentScene.setRoot(menu);

        connexion.retrieveData(u.getiD(),menu);
    
        
    };
    /** 
     * View all books borrowed from the user 
     * @param actionEvent
     */
    protected void watch_historical(javafx.event.ActionEvent actionEvent){
        HistoricalBase historicalView = new HistoricalBase(u); 
    	
        Scene currentScene = btn_historical.getScene();
        
        currentScene.setRoot(historicalView);
    }
}
