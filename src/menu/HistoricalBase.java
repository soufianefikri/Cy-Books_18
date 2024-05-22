package menu;

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


public class HistoricalBase extends AnchorPane {

	Button backButton;
	
    @SuppressWarnings("unchecked")
	public HistoricalBase(User user) {
        

        // Configurez la vue ici, par exemple, un tableau pour afficher les emprunts
        TableView<LoanHistory> tableView = new TableView<>();
        backButton = new Button("Back");
        
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

        Callback<TableColumn<LoanHistory, String>, TableCell<LoanHistory, String>> cellFactory

                = new Callback<TableColumn<LoanHistory, String>, TableCell<LoanHistory, String>>() {
            @Override
            public TableCell call(final TableColumn<LoanHistory, String> param) {
                final TableCell<LoanHistory, String> cell = new TableCell<LoanHistory, String>() {

                    final Button btn = new Button("Rendre");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                LoanHistory history = getTableView().getItems().get(getIndex());
                                System.out.println(history.getId());
                                connexion.returnBook(history.getId());
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };

        statusColumn.setCellFactory(cellFactory);
        
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
        AnchorPane.setBottomAnchor(tableView, 50.0);
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setRightAnchor(tableView, 0.0);

        backButton.setLayoutX(700);
        backButton.setLayoutY(550);
        backButton.setOnAction(event -> cancel());
        getChildren().addAll(tableView,backButton);
        
        

    }

    public void cancel(){
        UsersBase usersBase = new UserBaseController();

        Scene currentScene = backButton.getScene();

        currentScene.setRoot(usersBase);
    }
}
