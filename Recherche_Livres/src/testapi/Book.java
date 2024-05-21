package testapi;

/**
 * Book is to have a usable java class of books
 * @author TDLT
 * 
 */
public class Book {
	private String identifier;
	private String title;
	private String author;
	private String date;
	private String language;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String identifier, String title, String author, String date, String language) {
		this.identifier = identifier;
		this.title = title;
		this.author = author;
		this.date = date;
		this.language = language;
	}

	public Book() {
		this("", "", "", "", "");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (getTitle() + " is a book from " + getAuthor() + " published in " + getDate() + " written in "
				+ getLanguage());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book obv = (Book) obj;
			if (this.getIdentifier().equals(obv.getIdentifier())) {
				return true;
			}
		}
		return false;
	}
}