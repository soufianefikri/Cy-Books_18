module UpdateInfo {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires java.sql;
	
	opens UpdateInfo to javafx.graphics, javafx.fxml;
}
