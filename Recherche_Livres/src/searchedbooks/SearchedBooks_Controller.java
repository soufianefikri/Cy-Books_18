package searchedbooks;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import testapi.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SearchedBooks_Controller {
	

	
	
	
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
		
	
	public void test(Book book) {
		ArrayList<Book> info = new ArrayList<Book>();
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
	
	
	
	
	
	
	
	
	

}
