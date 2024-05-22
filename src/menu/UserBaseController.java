package menu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;

public class UserBaseController extends UsersBase{
    
    @SuppressWarnings("unchecked")
    public void search_view(){
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

    protected void home(javafx.event.ActionEvent actionEvent){
        MenuBase menu = new MenuBaseController();

        Scene currentScene = btn_home.getScene();

        currentScene.setRoot(menu);
    };

    protected void new_user(javafx.event.ActionEvent actionEvent){
        RegisterBase menu = new RegisterBaseController();
        
        Scene currentScene = btn_new.getScene();
        
        currentScene.setRoot(menu);
    };

    protected void search(javafx.event.ActionEvent actionEvent){
        search_view();
    };

    public void onEnter(javafx.event.ActionEvent actionEvent){
        search_view();
    }

    protected void change_info(javafx.event.ActionEvent actionEvent){

        UpdateUserBaseController menu = new UpdateUserBaseController(u.getiD());
        Scene currentScene = btn_change.getScene();
        currentScene.setRoot(menu);

        connexion.RetrieveData(u.getiD(),menu);
    
        
    };

    protected void watch_historical(javafx.event.ActionEvent actionEvent){
        HistoricalBase historicalView = new HistoricalBase(u); 
    	
        Scene currentScene = btn_historical.getScene();
        
        currentScene.setRoot(historicalView);
    }
}
