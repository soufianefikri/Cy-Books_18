package application;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import testapi.Book;
public class SearchedBooks_Controller {

	
	ArrayList<Book> info;
	
	@FXML
	HBox titleh;
	
	@FXML
	HBox authorh;
	
	@FXML
	HBox dateh;
	
	@FXML
	HBox idh;
	
	@FXML
	HBox languageh;
		
	
	public void display(Book book) {
            info = new ArrayList<Book>();
            info.add(book);
            Label tl = new Label(info.get(0).getTitle());
            Label al = new Label(info.get(0).getAuthor());
            Label dl = new Label(info.get(0).getDate());
            Label ll = new Label(info.get(0).getLanguage());
            Label il = new Label(info.get(0).getIdentifier());
            
            tl.setId("titleLabel");
            al.setId("authorLabel");
            dl.setId("dateLabel");
            ll.setId("languageLabel");
            il.setId("identifierLabel");
            
            titleh.getChildren().add(tl);
            languageh.getChildren().add(ll);
            dateh.getChildren().add(dl);
            authorh.getChildren().add(al);
            idh.getChildren().add(il);
    }

    public void test() {
        try{
            System.out.println("borrow");
            BorrowBase usersBase = new BorrowController(info.get(0).getTitle(),info.get(0).getIdentifier());

            Scene currentScene = titleh.getScene();

            currentScene.setRoot(usersBase);
        } catch(Exception e) {
			e.printStackTrace();
		}
    }

    public void cancel(){
        Scene scene = titleh.getScene();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../searchBook/Main.fxml"));
				try {
					Parent parent = fxmlLoader.load();
					scene.setRoot(parent);
					//searchBook.FXMLController controller = fxmlLoader.getController();
				}
				catch(Exception e){
					e.printStackTrace();
				}
    }
	
	
	
	
	
	
	
	
	

}
