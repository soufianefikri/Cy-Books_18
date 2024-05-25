package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public abstract class RegisterBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Line line;
    protected final VBox vBox;
    protected final HBox hBox_name;
    protected final VBox vBox0;
    protected final Label label;
    protected final TextField firstname_field;
    protected final VBox vBox1;
    protected final Label label0;
    protected final TextField lastname_field;
    protected final HBox hBox_address;
    protected final VBox vBox2;
    protected final Label label1;
    protected final TextField address_field;
    protected final VBox vBox3;
    protected final Label label2;
    protected final TextField city_field;
    protected final VBox vBox4;
    protected final Label label3;
    protected final TextField zipcode_field;
    protected final HBox hBox_contact;
    protected final VBox vBox5;
    protected final Label label4;
    protected final TextField email_field;
    protected final VBox vBox6;
    protected final Label label5;
    protected final TextField number_field;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;

    public RegisterBase() {

        imageView = new ImageView();
        line = new Line();
        vBox = new VBox();
        hBox_name = new HBox();
        vBox0 = new VBox();
        label = new Label();
        firstname_field = new TextField();
        vBox1 = new VBox();
        label0 = new Label();
        lastname_field = new TextField();
        hBox_address = new HBox();
        vBox2 = new VBox();
        label1 = new Label();
        address_field = new TextField();
        vBox3 = new VBox();
        label2 = new Label();
        city_field = new TextField();
        vBox4 = new VBox();
        label3 = new Label();
        zipcode_field = new TextField();
        hBox_contact = new HBox();
        vBox5 = new VBox();
        label4 = new Label();
        email_field = new TextField();
        vBox6 = new VBox();
        label5 = new Label();
        number_field = new TextField();
        button = new Button();
        button0 = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("root");
        getStylesheets().add("styles/style_users.css");
        

        imageView.setFitHeight(44.0);
        imageView.setFitWidth(67.0);
        imageView.setLayoutX(30.0);
        imageView.setLayoutY(22.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        vBox.setLayoutX(32.0);
        vBox.setLayoutY(106.0);
        vBox.setPrefHeight(423.0);
        vBox.setPrefWidth(739.0);
        vBox.setSpacing(10.0);

        hBox_name.setAlignment(javafx.geometry.Pos.CENTER);
        hBox_name.setPrefHeight(132.0);
        hBox_name.setPrefWidth(100.0);
        hBox_name.getStylesheets().add("styles/style_users.css");

        vBox0.setPrefHeight(132.0);
        vBox0.setPrefWidth(190.0);
        vBox0.setSpacing(15.0);

        label.setText("Prénom :");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        label.setFont(new Font("Arial Bold", 14.0));

        vBox0.setPadding(new Insets(10.0));
        HBox.setMargin(vBox0, new Insets(0.0, 125.0, 0.0, 0.0));

        vBox1.setLayoutX(10.0);
        vBox1.setLayoutY(10.0);
        vBox1.setPrefHeight(132.0);
        vBox1.setPrefWidth(190.0);
        vBox1.setSpacing(15.0);

        label0.setText("Nom de famille :");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        label0.setFont(new Font("Arial Bold", 14.0));

        vBox1.setPadding(new Insets(10.0));
        HBox.setMargin(vBox1, new Insets(0.0, 0.0, 0.0, 125.0));

        hBox_address.setAlignment(javafx.geometry.Pos.CENTER);
        hBox_address.setLayoutX(10.0);
        hBox_address.setLayoutY(10.0);
        hBox_address.setPrefHeight(132.0);
        hBox_address.setPrefWidth(100.0);
        hBox_address.setSpacing(32.0);
        hBox_address.getStylesheets().add("styles/style_users.css");

        vBox2.setPrefHeight(132.0);
        vBox2.setPrefWidth(190.0);
        vBox2.setSpacing(15.0);

        label1.setText("Adresse (numéro et rue):");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        label1.setFont(new Font("Arial Bold", 14.0));

        address_field.setPromptText("ex : 25 rue La Fayette");
        vBox2.setPadding(new Insets(10.0));

        vBox3.setLayoutX(10.0);
        vBox3.setLayoutY(10.0);
        vBox3.setPrefHeight(132.0);
        vBox3.setPrefWidth(190.0);
        vBox3.setSpacing(15.0);

        label2.setText("Ville :");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        label2.setFont(new Font("Arial Bold", 14.0));

        vBox3.setPadding(new Insets(10.0));

        vBox4.setLayoutX(199.0);
        vBox4.setLayoutY(10.0);
        vBox4.setPrefHeight(132.0);
        vBox4.setPrefWidth(190.0);
        vBox4.setSpacing(15.0);

        label3.setText("Code postal :");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        label3.setFont(new Font("Arial Bold", 14.0));

        zipcode_field.setPrefHeight(27.0);
        zipcode_field.setPrefWidth(178.0);
        vBox4.setPadding(new Insets(10.0));

        hBox_contact.setAlignment(javafx.geometry.Pos.CENTER);
        hBox_contact.setLayoutX(10.0);
        hBox_contact.setLayoutY(142.0);
        hBox_contact.setPrefHeight(132.0);
        hBox_contact.setPrefWidth(100.0);
        hBox_contact.getStylesheets().add("styles/style_users.css");

        vBox5.setPrefHeight(132.0);
        vBox5.setPrefWidth(190.0);
        vBox5.setSpacing(15.0);

        label4.setText("Email :");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        label4.setFont(new Font("Arial Bold", 14.0));

        email_field.setPromptText("ex : user@mail.fr");
        vBox5.setPadding(new Insets(10.0));
        HBox.setMargin(vBox5, new Insets(0.0, 125.0, 0.0, 0.0));

        vBox6.setLayoutX(10.0);
        vBox6.setLayoutY(10.0);
        vBox6.setPrefHeight(132.0);
        vBox6.setPrefWidth(189.0);
        vBox6.setSpacing(15.0);

        label5.setText("Numéro de Téléphone :");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        label5.setFont(new Font("Arial Bold", 14.0));

        vBox6.setPadding(new Insets(10.0));
        HBox.setMargin(vBox6, new Insets(0.0, 0.0, 0.0, 125.0));

        button.setLayoutX(550.0);
        button.setLayoutY(500.0);
        button.setPrefHeight(80);
        button.setPrefWidth(85);
        button.setOnAction(this::check_input);
        button.getStyleClass().add("btn");
        button.setId("check_btn");

        button0.setLayoutX(20.0);
        button0.setLayoutY(20.0);
        button0.setPrefHeight(80);
        button0.setPrefWidth(85);
        button0.setMnemonicParsing(false);
        button0.setOnAction(this::home);

        button1.setId("btn_cancel");
        button1.setPrefHeight(80);
        button1.setPrefWidth(85);
        button1.setLayoutX(650.0);
        button1.setLayoutY(500.0);
        button1.getStyleClass().add("btn");
        button1.setOnAction(this::cancel);

        button0.getStyleClass().add("btn");
        button0.setId("btn_home");

        getChildren().add(imageView);
        getChildren().add(line);
        vBox0.getChildren().add(label);
        vBox0.getChildren().add(firstname_field);
        hBox_name.getChildren().add(vBox0);
        vBox1.getChildren().add(label0);
        vBox1.getChildren().add(lastname_field);
        hBox_name.getChildren().add(vBox1);
        vBox.getChildren().add(hBox_name);
        vBox2.getChildren().add(label1);
        vBox2.getChildren().add(address_field);
        hBox_address.getChildren().add(vBox2);
        vBox3.getChildren().add(label2);
        vBox3.getChildren().add(city_field);
        hBox_address.getChildren().add(vBox3);
        vBox4.getChildren().add(label3);
        vBox4.getChildren().add(zipcode_field);
        hBox_address.getChildren().add(vBox4);
        vBox.getChildren().add(hBox_address);
        vBox5.getChildren().add(label4);
        vBox5.getChildren().add(email_field);
        hBox_contact.getChildren().add(vBox5);
        vBox6.getChildren().add(label5);
        vBox6.getChildren().add(number_field);
        hBox_contact.getChildren().add(vBox6);
        vBox.getChildren().add(hBox_contact);
        getChildren().add(vBox);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);

    }
    /** 
     * Check if all the inputs are OK and add a new row in the table users
     * @param actionEvent
     */
    protected abstract void check_input(javafx.event.ActionEvent actionEvent);
    /** 
     * Return to the home menu
     * @param actionEvent
     */
    protected abstract void home(javafx.event.ActionEvent actionEvent);
    /**
     * Return to the previous page, here : user page
     * @param actionEvent
     */
    protected abstract void cancel(javafx.event.ActionEvent actionEvent);
}

