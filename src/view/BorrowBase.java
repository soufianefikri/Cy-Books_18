package view;

import java.time.LocalDate;

import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class BorrowBase extends AnchorPane{

    protected final Label titleLabel;
    protected final Label isbnLabel;
    protected final TextField searchfield;
    protected final Label searchUserLabel;
    protected final Text isbn_text;
    protected final Text title_text;
    @SuppressWarnings("rawtypes")
    protected final ListView list_view;
    protected final Button searchButton;
    protected final VBox vbox;
    protected final AnchorPane row1;
    protected final Label label1;
    protected final Text name_text;
    protected final AnchorPane row2;
    protected final Label label2;
    protected final Text surname_text;
    protected final AnchorPane row3;
    protected final Label label3;
    protected final Text phone_text;
    protected final DatePicker datePicker;
    protected final Button borrowButton;
    protected final Button cancelButton;

    public BorrowBase() {
        titleLabel = new Label("Title :");
        isbnLabel = new Label("ISBN :");
        searchfield = new TextField();
        searchUserLabel = new Label("Search user :");
        isbn_text = new Text("Text");
        title_text = new Text("Text");
        list_view = new ListView<>();
        searchButton = new Button("search");
        vbox = new VBox();
        row1 = new AnchorPane();
        label1 = new Label("Name :");
        name_text = new Text("Text");
        row2 = new AnchorPane();
        label2 = new Label("Surname :");
        surname_text = new Text("Text");
        row3 = new AnchorPane();
        label3 = new Label("Phone :");
        phone_text = new Text("Text");
        datePicker = new DatePicker();
        borrowButton = new Button("Borrow the Book");
        cancelButton = new Button("Back");

        titleLabel.setLayoutY(124.0);
        titleLabel.setFont(new Font(20.0));

        isbnLabel.setLayoutX(-2.0);
        isbnLabel.setLayoutY(79.0);
        isbnLabel.setFont(new Font(20.0));

        searchfield.setLayoutX(428.0);
        searchfield.setLayoutY(87.0);
        searchfield.setFont(new Font(20.0));

        searchUserLabel.setLayoutX(307.0);
        searchUserLabel.setLayoutY(94.0);
        searchUserLabel.setFont(new Font(20.0));

        isbn_text.setLayoutX(51.0);
        isbn_text.setLayoutY(102.0);
        isbn_text.setFont(new Font(20.0));


        title_text.setLayoutX(48.0);
        title_text.setLayoutY(147.0);
        title_text.setFont(new Font(20.0));

        list_view.setLayoutX(428.0);
        list_view.setLayoutY(131.0);
        list_view.setPrefHeight(216.0);
        list_view.setPrefWidth(249.0);

        searchButton.setLayoutX(690.0);
        searchButton.setLayoutY(87.0);
        searchButton.setPrefHeight(50.0);
        searchButton.setOnAction(event -> search());


        label1.setLayoutY(14.0);
        label1.setFont(new Font(20.0));

        name_text.setLayoutX(63);
        name_text.setLayoutY(37);
        name_text.setFont(new Font(20.0));

        row1.setPrefHeight(57.0);
        row1.setPrefWidth(800.0);
        row1.getChildren().addAll(label1, name_text);

        label2.setLayoutY(14.0);
        label2.setFont(new Font(20.0));

        surname_text.setLayoutX(88);
        surname_text.setLayoutY(37);
        surname_text.setFont(new Font(20.0));

        row2.setPrefHeight(57.0);
        row2.setPrefWidth(800.0);
        row2.getChildren().addAll(label2, surname_text);

        label3.setLayoutY(14.0);
        label3.setFont(new Font(20.0));

        phone_text.setLayoutX(66);
        phone_text.setLayoutY(36);
        phone_text.setFont(new Font(20.0));

        row3.setPrefHeight(57.0);
        row3.setPrefWidth(800.0);
        row3.getChildren().addAll(label3, phone_text);

        vbox.setLayoutY(181.0);
        vbox.setPrefHeight(402.0);
        vbox.setPrefWidth(800.0);

        datePicker.setLayoutX(430);
        datePicker.setLayoutY(430);
        datePicker.setPrefWidth(249.0);
        datePicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) < 0 );
            }
        });

        borrowButton.setLayoutX(600);
        borrowButton.setLayoutY(534);
        borrowButton.setOnAction(event -> borrow());

        cancelButton.setLayoutX(711);
        cancelButton.setLayoutY(534);
        cancelButton.setOnAction(event -> cancel());

        vbox.getChildren().addAll(row1, row2, row3);
        AnchorPane.setBottomAnchor(vbox, 0.0);
        AnchorPane.setLeftAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox, 0.0);


        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getChildren().addAll(titleLabel, isbnLabel, searchfield, searchUserLabel, isbn_text, title_text, list_view, vbox, searchButton,datePicker,borrowButton,cancelButton);

    }

    public abstract void search();

    public abstract void borrow();

    public abstract void cancel();
}
