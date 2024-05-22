package menu;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public abstract class UsersBase extends AnchorPane {

    protected final VBox vBox_bg;
    protected final HBox hBox;
    protected final Button btn_home;
    protected final AnchorPane anchorPane;
    protected final TextFlow textFlow;
    protected final Text text;
    protected final Button btn_new;
    protected final TextField textField;
    protected final Button btn_search;
    protected final VBox vBox;
    protected final AnchorPane anchorPane0;
    protected final TextFlow textFlow0;
    protected final Text text0;
    protected final Text text_name;
    protected final Button btn_change;
    protected final TextFlow textFlow1;
    protected final Text text1;
    protected final Text text_surname;
    protected final TextFlow textFlow2;
    protected final Text text2;
    protected final Text text_mail;
    protected final TextFlow textFlow3;
    protected final Text text3;
    protected final Text text_phone;
    protected final TextFlow textFlow4;
    protected final Text text4;
    protected final Text text_address;
    protected final TextFlow textFlow5;
    protected final Text text5;
    protected final Text text_borrow;
    protected final TextFlow textFlow6;
    protected final Text text6;
    protected final Text text_history;
    @SuppressWarnings("rawtypes")
    protected final ListView list_view;

    protected final Button btn_historical;  

    User u;

    @SuppressWarnings("rawtypes")
    public UsersBase() {
        vBox_bg = new VBox();
        hBox = new HBox();
        btn_home = new Button();
        anchorPane = new AnchorPane();
        textFlow = new TextFlow();
        text = new Text();
        btn_new = new Button();
        textField = new TextField();
        btn_search = new Button();
        vBox = new VBox();
        anchorPane0 = new AnchorPane();
        textFlow0 = new TextFlow();
        text0 = new Text();
        text_name = new Text();
        btn_change = new Button();
        textFlow1 = new TextFlow();
        text1 = new Text();
        text_surname = new Text();
        textFlow2 = new TextFlow();
        text2 = new Text();
        text_mail = new Text();
        textFlow3 = new TextFlow();
        text3 = new Text();
        text_phone = new Text();
        textFlow4 = new TextFlow();
        text4 = new Text();
        text_address = new Text();
        textFlow5 = new TextFlow();
        text5 = new Text();
        text_borrow = new Text();
        textFlow6 = new TextFlow();
        text6 = new Text();
        text_history = new Text();
        list_view = new ListView();

        btn_historical = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStyleClass().add("root");
        getStylesheets().add("style_users.css");
        
        

        vBox_bg.setId("bg_vBox");
        vBox_bg.setMaxHeight(USE_PREF_SIZE);
        vBox_bg.setMaxWidth(USE_PREF_SIZE);
        vBox_bg.setMinHeight(USE_PREF_SIZE);
        vBox_bg.setMinWidth(USE_PREF_SIZE);
        vBox_bg.setPrefHeight(600.0);
        vBox_bg.setPrefWidth(800.0);
        vBox_bg.setSpacing(10.0);
        vBox_bg.getStylesheets().add("style_users.css");

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setId("hBox");
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.getStylesheets().add("style_users.css");

        btn_home.setId("btn_home");
        btn_home.getStyleClass().add("btn");
        btn_home.setMnemonicParsing(false);
        btn_home.setOnAction(this::home);
        btn_home.setPrefHeight(80.0);
        btn_home.setPrefWidth(90.0);
        btn_home.getStylesheets().add("style_users.css");

        anchorPane.setPrefHeight(99.0);
        anchorPane.setPrefWidth(285.0);

        textFlow.setLayoutX(5.0);
        textFlow.setLayoutY(31.0);
        textFlow.setPrefHeight(37.0);
        textFlow.setPrefWidth(283.0);
        textFlow.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);

        text.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text.setMouseTransparent(true);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Rechercher un Utilisateur :");
        text.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text.setWrappingWidth(277.28125);
        text.setFont(new Font("Georgia", 22.0));

        btn_new.setId("btn_new");
        btn_new.getStyleClass().add("btn");
        btn_new.setLayoutX(46.0);
        btn_new.setLayoutY(62.0);
        btn_new.setMaxHeight(40.0);
        btn_new.setMnemonicParsing(false);
        btn_new.setOnAction(this::new_user);
        btn_new.setPrefHeight(37.0);
        btn_new.setPrefWidth(201.0);
        btn_new.getStylesheets().add("style_users.css");
        btn_new.setText("Nouvel Utilisateur ?");
        btn_new.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        btn_new.setUnderline(true);
        btn_new.setFont(new Font(20.0));

        textField.setId("text_search");
        textField.setMinWidth(341.0);
        textField.setPrefHeight(44.0);
        textField.setPrefWidth(341.0);
        textField.getStylesheets().add("style_users.css");
        textField.setFont(new Font("Georgia", 23.0));
        textField.setOnAction(this::onEnter);

        btn_search.setId("btn_search");
        btn_search.getStyleClass().add("btn");
        btn_search.setMnemonicParsing(false);
        btn_search.setOnAction(this::search);
        btn_search.setPrefHeight(44.0);
        btn_search.setPrefWidth(52.0);
        btn_search.getStylesheets().add("style_users.css");

        vBox.setPrefHeight(445.0);
        vBox.setPrefWidth(760.0);
        vBox.setSpacing(5.0);
        vBox.setVisible(false);

        anchorPane0.setPrefHeight(50.0);
        anchorPane0.setPrefWidth(760.0);

        textFlow0.setPrefHeight(50.0);
        textFlow0.setPrefWidth(567.0);

        text0.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Nom :");
        text0.setUnderline(true);
        text0.setFont(new Font("Georgia", 28.0));

        text_name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_name.setStrokeWidth(0.0);
        text_name.setText("nom");
        text_name.setFont(new Font(28.0));

        btn_change.setAlignment(javafx.geometry.Pos.CENTER);
        btn_change.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn_change.setId("btn_change");
        btn_change.getStyleClass().add("btn");
        btn_change.setLayoutX(551.0);
        btn_change.setLayoutY(-8.0);
        btn_change.setMaxHeight(44.0);
        btn_change.setMnemonicParsing(false);
        btn_change.setOnAction(this::change_info);
        btn_change.setPrefHeight(44.0);
        btn_change.setPrefWidth(209.0);
        btn_change.getStylesheets().add("style_users.css");
        btn_change.setText("Modifier l'utilisateur");
        btn_change.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn_change.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        btn_change.setUnderline(true);
        btn_change.setFont(new Font(20.0));

        textFlow1.setPrefHeight(50.0);
        textFlow1.setPrefWidth(760.0);

        text1.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Prenom :");
        text1.setUnderline(true);
        text1.setFont(new Font(28.0));

        text_surname.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_surname.setStrokeWidth(0.0);
        text_surname.setText("prenom");
        text_surname.setFont(new Font(28.0));

        textFlow2.setPrefHeight(50.0);
        textFlow2.setPrefWidth(760.0);

        text2.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Mail :");
        text2.setUnderline(true);
        text2.setFont(new Font(28.0));

        text_mail.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_mail.setStrokeWidth(0.0);
        text_mail.setText("mail");
        text_mail.setFont(new Font(28.0));

        textFlow3.setPrefHeight(50.0);
        textFlow3.setPrefWidth(760.0);

        text3.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Telephone :");
        text3.setUnderline(true);
        text3.setFont(new Font(28.0));

        text_phone.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_phone.setStrokeWidth(0.0);
        text_phone.setText("telephone");
        text_phone.setFont(new Font(28.0));

        textFlow4.setPrefHeight(50.0);
        textFlow4.setPrefWidth(760.0);

        text4.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("Adresse :");
        text4.setUnderline(true);
        text4.setFont(new Font(28.0));

        text_address.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_address.setStrokeWidth(0.0);
        text_address.setText("adresse");
        text_address.setFont(new Font(28.0));

        textFlow5.setPrefHeight(50.0);
        textFlow5.setPrefWidth(760.0);

        text5.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("Emprunt actuel :");
        text5.setUnderline(true);
        text5.setFont(new Font(28.0));

        text_borrow.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_borrow.setStrokeWidth(0.0);
        text_borrow.setText("livre");
        text_borrow.setFont(new Font(28.0));

        textFlow6.setPrefHeight(50.0);
        textFlow6.setPrefWidth(760.0);

        text6.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("Historique des Emprunts :");
        text6.setUnderline(true);
        text6.setFont(new Font(28.0));

        text_history.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_history.setStrokeWidth(0.0);
        text_history.setText("Historique");
        text_history.setFont(new Font(28.0));
        vBox_bg.setPadding(new Insets(10.0));

        list_view.setLayoutX(392.0);
        list_view.setLayoutY(98.0);
        list_view.setPrefHeight(200.0);
        list_view.setPrefWidth(341.0);
        list_view.setVisible(false);
        list_view.setId("list");
        list_view.getStylesheets().add("style_users.css");
        list_view.getStyleClass().add("list");

        btn_historical.setPrefHeight(50.0);
        btn_historical.setPrefWidth(760.0);

        //btn_historical.setLayoutX(46.0);
        //btn_historical.setLayoutY(62.0);
        btn_historical.setTextFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        btn_historical.setText("Historique des Emprunts :");
        btn_historical.setUnderline(true);
        btn_historical.setFont(new Font(28.0));
        btn_historical.setOnAction(this::watch_historical);
        btn_historical.getStyleClass().add("btn_historical");


        hBox.getChildren().add(btn_home);
        textFlow.getChildren().add(text);
        anchorPane.getChildren().add(textFlow);
        anchorPane.getChildren().add(btn_new);
        hBox.getChildren().add(anchorPane);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn_search);
        vBox_bg.getChildren().add(hBox);
        textFlow0.getChildren().add(text0);
        textFlow0.getChildren().add(text_name);
        anchorPane0.getChildren().add(textFlow0);
        anchorPane0.getChildren().add(btn_change);
        vBox.getChildren().add(anchorPane0);
        textFlow1.getChildren().add(text1);
        textFlow1.getChildren().add(text_surname);
        vBox.getChildren().add(textFlow1);
        textFlow2.getChildren().add(text2);
        textFlow2.getChildren().add(text_mail);
        vBox.getChildren().add(textFlow2);
        textFlow3.getChildren().add(text3);
        textFlow3.getChildren().add(text_phone);
        vBox.getChildren().add(textFlow3);
        textFlow4.getChildren().add(text4);
        textFlow4.getChildren().add(text_address);
        vBox.getChildren().add(textFlow4);
        textFlow5.getChildren().add(text5);
        textFlow5.getChildren().add(text_borrow);
        vBox.getChildren().add(textFlow5);
        textFlow6.getChildren().add(text6);
        textFlow6.getChildren().add(text_history);
        vBox.getChildren().add(textFlow6);
        vBox_bg.getChildren().add(vBox);
        getChildren().add(vBox_bg);
        getChildren().add(list_view);

        vBox.getChildren().add(btn_historical);
        

    }

    protected abstract void search(javafx.event.ActionEvent actionEvent);

    protected abstract void new_user(javafx.event.ActionEvent actionEvent);

    protected abstract void change_info(javafx.event.ActionEvent actionEvent);

    protected abstract void onEnter(javafx.event.ActionEvent actionEvent);

    protected abstract void home(javafx.event.ActionEvent actionEvent);

    protected abstract void watch_historical(javafx.event.ActionEvent actionEvent);
}
