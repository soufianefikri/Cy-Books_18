package view;

import javafx.animation.PathTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public abstract class MenuBase extends AnchorPane {

    protected final VBox vBox;
    protected final Button btn_menu;
    protected final TextFlow textFlow;
    protected final Text text;
    protected final HBox hBox;
    protected final Button btn_user;
    protected final Button btn_books;
    protected final VBox box_menu;
    protected final Button btn_close_menu;
    protected final Button btn_calendar;
    protected final Button btn_borrow;
    protected final VBox vBox0;
    boolean visble;
    public MenuBase() {

        vBox = new VBox();
        btn_menu = new Button();
        textFlow = new TextFlow();
        text = new Text();
        hBox = new HBox();
        btn_user = new Button();
        btn_books = new Button();
        box_menu = new VBox();
        btn_close_menu = new Button();
        btn_calendar = new Button();
        btn_borrow = new Button();
        vBox0 = new VBox();
        visble = false;

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        

        AnchorPane.setBottomAnchor(vBox, 0.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setRightAnchor(vBox, 0.0);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setId("bg");
        vBox.setLayoutX(10.0);
        vBox.setLayoutY(10.0);
        vBox.setMaxHeight(USE_PREF_SIZE);
        vBox.setMaxWidth(USE_PREF_SIZE);
        vBox.setMinHeight(USE_PREF_SIZE);
        vBox.setMinWidth(USE_PREF_SIZE);
        vBox.setPrefHeight(600.0);
        vBox.setPrefWidth(1102.0);
        vBox.getStylesheets().add("styles/style_menu.css");

        btn_menu.setId("btn_menu");
        btn_menu.getStyleClass().add("btn");
        btn_menu.setMnemonicParsing(false);
        btn_menu.setOnAction(this::leftMenu);
        btn_menu.setPrefHeight(47.0);
        btn_menu.setPrefWidth(54.0);
        btn_menu.getStylesheets().add("styles/style_menu.css");
        VBox.setMargin(btn_menu, new Insets(0.0));

        textFlow.setPrefHeight(170.0);
        textFlow.setPrefWidth(800.0);
        textFlow.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        text.setFill(javafx.scene.paint.Color.valueOf("#ffba26"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setStyle("-fx-font-size: 90; -fx-font-family: Georgia;");
        text.setText("CY BOOK");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(280.3466796875);
        text.setFont(new Font("Georgia", 70.0));
        textFlow.setOpaqueInsets(new Insets(0.0));
        textFlow.setPadding(new Insets(50.0, 0.0, 0.0, 0.0));

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(284.0);
        hBox.setPrefWidth(800.0);
        hBox.setSpacing(30.0);

        btn_user.setId("btn_customer");
        btn_user.getStyleClass().add("btn");
        btn_user.setMnemonicParsing(false);
        btn_user.setOnAction(this::userPage);
        btn_user.setPrefHeight(158.0);
        btn_user.setPrefWidth(158.0);
        btn_user.getStylesheets().add("styles/style_menu.css");

        btn_books.setId("btn_books");
        btn_books.getStyleClass().add("btn");
        btn_books.setMnemonicParsing(false);
        btn_books.setOnAction(this::booksPage);
        btn_books.setPrefHeight(158.0);
        btn_books.setPrefWidth(158.0);
        btn_books.getStylesheets().add("styles/style_menu.css");
        hBox.setOpaqueInsets(new Insets(0.0));
        VBox.setMargin(hBox, new Insets(0.0));
        vBox.setPadding(new Insets(10.0));

        AnchorPane.setBottomAnchor(box_menu, 0.0);
        AnchorPane.setTopAnchor(box_menu, 0.0);
        box_menu.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        box_menu.setLayoutX(-280.0);
        box_menu.setPrefHeight(600.0);
        box_menu.setPrefWidth(280.0);
        box_menu.setSpacing(10.0);
        box_menu.setStyle("-fx-background-color: #FFFF; -fx-border-color: #FFBA26; -fx-border-width: 10;");

        btn_close_menu.setId("btn_close");
        btn_close_menu.getStyleClass().add("btn");
        btn_close_menu.setMnemonicParsing(false);
        btn_close_menu.setOnAction(this::closeLeftMenu);
        btn_close_menu.setPrefHeight(45.0);
        btn_close_menu.setPrefWidth(44.0);
        btn_close_menu.getStylesheets().add("styles/style_menu.css");

        btn_calendar.setId("btn_calendar");
        btn_calendar.getStyleClass().add("btn");
        btn_calendar.setMnemonicParsing(false);
        btn_calendar.setOnAction(this::calendar);
        btn_calendar.setPrefHeight(60.0);
        btn_calendar.setPrefWidth(300.0);
        btn_calendar.getStylesheets().add("styles/style_menu.css");

        btn_borrow.setId("btn_borrow");
        btn_borrow.getStyleClass().add("btn");
        btn_borrow.setMnemonicParsing(false);
        btn_borrow.setOnAction(this::borrow);
        btn_borrow.setPrefHeight(60.0);
        btn_borrow.setPrefWidth(300.0);
        btn_borrow.getStylesheets().add("styles/style_menu.css");


        vBox0.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);
        vBox0.setPrefHeight(316.0);
        vBox0.setPrefWidth(260.0);

        box_menu.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

        vBox.getChildren().add(btn_menu);
        textFlow.getChildren().add(text);
        vBox.getChildren().add(textFlow);
        hBox.getChildren().add(btn_user);
        hBox.getChildren().add(btn_books);
        vBox.getChildren().add(hBox);
        getChildren().add(vBox);
        box_menu.getChildren().add(btn_close_menu);
        box_menu.getChildren().add(btn_calendar);
        box_menu.getChildren().add(btn_borrow);
        box_menu.getChildren().add(vBox0);
        getChildren().add(box_menu);

    }
    /**
        Toggles the menu status between show and hide.
    */
    public void open_close(){
        Path path = new Path(); 
        if (!visble){
            path.getElements().add(new MoveTo(-200, 300));
            path.getElements().add(new LineTo(420, 300));
            visble = true;
        } else{
            path.getElements().add(new MoveTo(420, 300));
            path.getElements().add(new LineTo(-200, 300));
            visble=false;
        }
        
        PathTransition pathTransition = new PathTransition();  
        pathTransition.setDuration(Duration.millis(200));    
        pathTransition.setNode(box_menu);
        pathTransition.setPath(path);
        pathTransition.setAutoReverse(false);

        pathTransition.play();
    }
    protected abstract void leftMenu(javafx.event.ActionEvent actionEvent);

    protected abstract void userPage(javafx.event.ActionEvent actionEvent);

    protected abstract void booksPage(javafx.event.ActionEvent actionEvent);

    protected abstract void closeLeftMenu(javafx.event.ActionEvent actionEvent);

    protected abstract void calendar(javafx.event.ActionEvent actionEvent);

    protected abstract void borrow(javafx.event.ActionEvent actionEvent);

}

