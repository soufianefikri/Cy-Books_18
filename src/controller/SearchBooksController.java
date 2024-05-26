package controller;

import java.util.List;

import apimangager.ApiCaller;
import apimangager.ApiQuery;
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
import model.Book;
import view.MenuBase;

public class SearchBooksController {
	private int currentPage = 0;

	private ApiQuery.DateRelation dateRelation;
	
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
	private Button nextButton;
	@FXML
	private Button previousButton;
    
	@FXML
	private ToggleGroup searchDateRelation;
	@FXML
	private ToggleGroup searchType;
    
    @FXML
    void changeRelation(ActionEvent event) {
    	if(beforeButton.isSelected()) {
    		dateRelation=ApiQuery.DateRelation.BEFORE;
    	}
    	else if(duringButton.isSelected()) {
    		dateRelation=ApiQuery.DateRelation.DURING;
    	}
    	else if(afterButton.isSelected()) {
    		dateRelation=ApiQuery.DateRelation.AFTER;
    	}
    }

	@FXML
	void search(ActionEvent event) {
    	String query = "";
    	
    	if(generalButton.isSelected()) {
    		query=ApiQuery.generalSearch(keywords.getText(),ApiQuery.Relation.ANY);
    	}
    	else if(titleButton.isSelected()) {
    		query=ApiQuery.searchByTitle(keywords.getText(),ApiQuery.Relation.ANY);
    	}
    	else if(authorButton.isSelected()) {
    		query=ApiQuery.searchByAuthor(keywords.getText(),ApiQuery.Relation.ANY);
    	}
    	else if(subjectButton.isSelected()) {
    		query=ApiQuery.searchBySubject(keywords.getText(),ApiQuery.Relation.ANY);
    	}
    	else if(languageButton.isSelected()) {
    		query=ApiQuery.searchByLanguage(keywords.getText(),ApiQuery.Relation.ANY);
    	}
    	else if(ISBNButton.isSelected()) {
    		query=ApiQuery.searchByISBN(keywords.getText(),ApiQuery.Relation.ANY);
    	}
    	
    	if(searchByYear.isSelected()) {
    		query=query+" and "+apimangager.ApiQuery.searchByDate(date.getText(), dateRelation);
    	}
    	
    	List<Book> books = ApiCaller.call(query, 1+currentPage*10, 10);
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
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/DisplayBook.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					scene.getStylesheets().add(getClass().getResource("../styles/SearchedBooks.css").toExternalForm());
					scene.setRoot(parent);

					controller.DisplayBookController controller = fxmlLoader.getController();
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

	@FXML
	void nextPage(ActionEvent event){
		currentPage +=1;
		search(event);
	}

	@FXML
	void previousPage(ActionEvent event){
		if (currentPage > 0){
			currentPage -=1;
			search(event);
		}
	}

}