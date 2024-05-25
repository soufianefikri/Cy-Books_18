package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import view.BorrowBase;
import view.connexion;

public class BorrowController extends BorrowBase{

    String title;
    String isbn;
    int id_user;
    int nb;
    public BorrowController(String title, String isbn){
        this.title = title;
        this.isbn = isbn;
        title_text.setText(title);
        isbn_text.setText(isbn);
    }

    @SuppressWarnings("unchecked")
    /** 
     * Read the textField and display all users that match with the text.
     */
    public void search(){

        list_view.getItems().clear();
        System.out.println("test1");
        view.connexion co = new connexion();
        System.out.println("test1");
        String[] names = co.getUtilisateursFromDatabase(searchfield.getText());
        // Remove all null items
        List<String> nonNullNames = Arrays.stream(names).filter(Objects::nonNull).collect(Collectors.toList());
        // Add them to the ListView
        list_view.getItems().addAll(nonNullNames);
        

        list_view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                model.User u = view.connexion.getUser(list_view.getSelectionModel().getSelectedItem().toString());
                name_text.setText(u.getFirstame());
                surname_text.setText(u.getLastname());
                phone_text.setText(u.getPhone());
                id_user = u.getiD();
                //list_view.setVisible(false);
            }
            
        });
    }

    public void borrow(){
        view.connexion.registerLoan(isbn, title, id_user, nb,datePicker.getValue());
    }

    public void cancel(){
        Scene scene = cancelButton.getScene();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/searchBooksView.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					scene.setRoot(parent);
					//searchBook.FXMLController controller = fxmlLoader.getController();
				}
				catch(Exception e){
					e.printStackTrace();
				}
    }

}
