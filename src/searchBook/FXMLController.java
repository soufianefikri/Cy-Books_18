package searchBook;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import menu.MenuBase;
import menu.MenuBaseController;
import testapi.ApiCaller;
import testapi.Book;
import testapi.Query;

public class FXMLController {
	private Query.DateRelation dateRelation;
	
	@FXML
	private AnchorPane bg;
	
	@FXML
	private RadioButton generalButton;
	@FXML
	private RadioButton titleButton;
	@FXML
	private RadioButton authorButton;
	@FXML
	private RadioButton subjectButton;
	@FXML
	private RadioButton languageButton;
	@FXML
	private RadioButton ISBNButton;
    
    
	@FXML
    private RadioButton beforeButton;
	@FXML
	private RadioButton duringButton;
	@FXML
	private RadioButton afterButton;

	@FXML
	private TextField keywords;
	@FXML
	private TextField date;

	@FXML
	private ListView<String> listBooks;
	@FXML
	private Button searchButton;
	@FXML
	private CheckBox searchByYear;
	@FXML
	private Button cancelButton;
    
	@FXML
	private ToggleGroup searchDateRelation;
	@FXML
	private ToggleGroup searchType;
    
    @FXML
    void changeRelation(ActionEvent event) {
    	if(beforeButton.isSelected()) {
    		dateRelation=Query.DateRelation.BEFORE;
    	}
    	else if(duringButton.isSelected()) {
    		dateRelation=Query.DateRelation.DURING;
    	}
    	else if(afterButton.isSelected()) {
    		dateRelation=Query.DateRelation.AFTER;
    	}
    }


    @FXML
    void search(ActionEvent event) {
    	String query = "";
    	
    	if(generalButton.isSelected()) {
    		query=Query.generalSearch(keywords.getText(),Query.Relation.ANY);
    	}
    	else if(titleButton.isSelected()) {
    		query=Query.searchByTitle(keywords.getText(),Query.Relation.ANY);
    	}
    	else if(authorButton.isSelected()) {
    		query=Query.searchByAuthor(keywords.getText(),Query.Relation.ANY);
    	}
    	else if(subjectButton.isSelected()) {
    		query=Query.searchBySubject(keywords.getText(),Query.Relation.ANY);
    	}
    	else if(languageButton.isSelected()) {
    		query=Query.searchByLanguage(keywords.getText(),Query.Relation.ANY);
    	}
    	else if(ISBNButton.isSelected()) {
    		query=Query.searchByISBN(keywords.getText(),Query.Relation.ANY);
    	}
    	
    	if(searchByYear.isSelected()) {
    		query=query+" and "+testapi.Query.searchByDate(date.getText(), dateRelation);
    	}
    	
    	List<Book> books = ApiCaller.call(query, 1, 9);
    	ObservableList<String> names = FXCollections.observableArrayList();
    	for(int i=0;i<books.size();i++) {
    		Book book = books.get(i);
    		names.add(book.getTitle()+" "+book.getAuthor()+" "+book.getIdentifier());
    	}
    	listBooks.setItems(names);
    	listBooks.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				int i = listBooks.getSelectionModel().getSelectedIndex();
				Book book = books.get(i);
				Scene scene = listBooks.getScene();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../SearchedBooks.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					scene.getStylesheets().add(getClass().getResource("../application/SearchedBooks.css").toExternalForm());
					scene.setRoot(parent);

					application.SearchedBooks_Controller controller = fxmlLoader.getController();
					controller.display(book);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
    		
    	});
    }

	@FXML
	void cancel(){
		MenuBase menu = new MenuBaseController();

        Scene currentScene = cancelButton.getScene();

        currentScene.setRoot(menu);
	}

}
