package loan;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import testapi.ApiCaller;
import testapi.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * MostLoaned is the class to show the most loaned books
 * @author TDLT
 *
 */
public class MostLoaned{
	//TODO enter the database info
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dokkan";
	private static final String USERNAME = "user";
	private static final String PASSWORD = "Password1!";


	/**
	 * @return a vbox object that can be added to a scene
	 */
	public static VBox mostLoaned() {
		TableView<ObservableList<String>> tableView = new TableView<>();

		// Connect to the database and execute the SQL query
		ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();
				// only select books that have been loaned 30 days prior today
				ResultSet resultSet = statement.executeQuery(
						"SELECT idlivre, COUNT(*) AS Number_of_loan FROM Emprunt WHERE dateemprunt >= DATE_SUB(CURDATE(), INTERVAL 30 DAY) GROUP BY idlivre ORDER BY Number_of_loan DESC")) {
			// add the top of the array
			List<String> header = new ArrayList<String>();
			header.add("Title");
			header.add("Author");
			header.add("Number of loans");
			
			// for every column add a function so their cell value is updated when data is added
			for (int i = 0; i < 3; i++) {
				final int j = i;
				TableColumn<ObservableList<String>, String> column = new TableColumn<>(header.get(i).toString());
				column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(j)));
				tableView.getColumns().add(column);
			}

			// Add rows to the TableView
			while (resultSet.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();

				String query = "(bib.persistentid all \"" + resultSet.getString(1) + "\")";
				List<Book> books = ApiCaller.call(query, 1, 1);
				row.add(books.get(0).getTitle());
				row.add(books.get(0).getAuthor());
				row.add(resultSet.getString(2));

				data.add(row);
			}

			tableView.setItems(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		VBox vbox = new VBox();
		vbox.getChildren().add(tableView);
		vbox.setPrefSize(600, 450);
		return vbox;
	}
}
