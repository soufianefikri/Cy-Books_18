package menu;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MenuBase extends VBox {

    protected final Button button;
    protected final TextFlow textFlow;
    protected final Text text;
    protected final HBox hBox;
    protected final Button button0;
    protected final Button button1;

    public MenuBase() {

        button = new Button();
        textFlow = new TextFlow();
        text = new Text();
        hBox = new HBox();
        button0 = new Button();
        button1 = new Button();

        setId("bg");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStylesheets().add("style_menu.css");
        setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

        button.setId("btn_menu");
        button.setMnemonicParsing(false);
        button.setPrefHeight(47.0);
        button.setPrefWidth(54.0);
        button.getStylesheets().add("style_menu.css");

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

        button0.setId("btn_client");
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(158.0);
        button0.setPrefWidth(158.0);
        button0.getStylesheets().add("style_menu.css");

        button1.setId("btn_books");
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(158.0);
        button1.setPrefWidth(158.0);
        button1.getStylesheets().add("style_menu.css");
        hBox.setOpaqueInsets(new Insets(0.0));
        VBox.setMargin(hBox, new Insets(0.0));

        getChildren().add(button);
        textFlow.getChildren().add(text);
        getChildren().add(textFlow);
        hBox.getChildren().add(button0);
        hBox.getChildren().add(button1);
        getChildren().add(hBox);

    }

}

