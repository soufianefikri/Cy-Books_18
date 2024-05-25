package view;

import controller.MenuBaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.LateHistory;


public class LateBase extends AnchorPane {

	Button backButton;
	
    @SuppressWarnings("unchecked")
	public LateBase() {
        

        // Configurez la vue ici, par exemple, un tableau pour afficher les emprunts
        TableView<LateHistory> tableView = new TableView<>();
        backButton = new Button("Back");
        
        TableColumn<LateHistory, String> bookColumn = new TableColumn<>("Book");
        TableColumn<LateHistory, String> nameColumn = new TableColumn<>("Name");
        TableColumn<LateHistory, String> surnameColumn = new TableColumn<>("Surname");
        TableColumn<LateHistory, String> plannedDateColumn = new TableColumn<>("Planned Return Date");

        bookColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        plannedDateColumn.setCellValueFactory(new PropertyValueFactory<>("plannedDate"));

        
        tableView.getColumns().addAll(bookColumn, nameColumn, surnameColumn, plannedDateColumn);

        // set info to the table
        ObservableList<LateHistory> lateHistoryList = FXCollections.observableArrayList(connexion.getLateHistory());
        tableView.setItems(lateHistoryList);
        
        //set the size of the column
        bookColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.43));
        nameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        surnameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        plannedDateColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        

        // set the size of the box with the column
        AnchorPane.setTopAnchor(tableView, 0.0);
        AnchorPane.setBottomAnchor(tableView, 50.0);
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setRightAnchor(tableView, 0.0);

        backButton.setLayoutX(700);
        backButton.setLayoutY(550);
        backButton.setOnAction(event -> cancel());
        getChildren().addAll(tableView,backButton);
        
        

    }

    public void cancel(){
        MenuBase menu = new MenuBaseController();

        Scene currentScene = backButton.getScene();

        currentScene.setRoot(menu);
    }
}
