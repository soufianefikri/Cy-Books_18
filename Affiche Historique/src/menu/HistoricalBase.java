package menu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class HistoricalBase extends AnchorPane {

	
	
    @SuppressWarnings("unchecked")
	public HistoricalBase(User user) {
        

        // Configurez la vue ici, par exemple, un tableau pour afficher les emprunts
        TableView<LoanHistory> tableView = new TableView<>();
        
        TableColumn<LoanHistory, String> bookColumn = new TableColumn<>("Book");
        TableColumn<LoanHistory, String> borrowDateColumn = new TableColumn<>("Borrow Date");
        TableColumn<LoanHistory, String> dueDateColumn = new TableColumn<>("Due Date");
        TableColumn<LoanHistory, String> returnDateColumn = new TableColumn<>("Return Date");
        TableColumn<LoanHistory, String> statusColumn = new TableColumn<>("Status");

        bookColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        borrowDateColumn.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("loanStatus"));

        
        tableView.getColumns().addAll(bookColumn, borrowDateColumn, dueDateColumn, returnDateColumn, statusColumn);

        // set info to the table
        ObservableList<LoanHistory> loanHistoryList = FXCollections.observableArrayList(connexion.getLoanHistory(user.getiD()));
        tableView.setItems(loanHistoryList);
        
        //set the size of the column
        bookColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.43));
        borrowDateColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        dueDateColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        returnDateColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        statusColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.12));
        

        // set the size of the box with the column
        AnchorPane.setTopAnchor(tableView, 0.0);
        AnchorPane.setBottomAnchor(tableView, 0.0);
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setRightAnchor(tableView, 0.0);

        
        getChildren().add(tableView);
        
        

    }
}
