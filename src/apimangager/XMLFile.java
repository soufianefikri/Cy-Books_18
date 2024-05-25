package apimangager;

import java.io.File; // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import model.Book;

import java.io.FileWriter;

/**
 * OperaFile is the class to operate on files
 * 
 * @author TDLT
 *
 */
public class XMLFile {

	/**
	 * @param path a path to a xml file
	 */
	public static void create(String path) {
		try {
			File myObj = new File(path);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * @param path a path to a xml file
	 * @param body what is needed to be written in the file
	 */
	public static void write(String path, String body) {
		try {
			FileWriter myWriter = new FileWriter("answer.xml");
			myWriter.write(body);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * @param path a path to a xml file
	 * @return a list of books the API returned
	 */
	public static List<Book> Parse(String path) {
		List<Book> books = new ArrayList<Book>();
		Book book = null;

		// an xml reader is created
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader reader;

		// the parsing starts
		try {
			reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path),"utf-8");
			while (reader.hasNext()) {
				XMLEvent nextEvent = reader.nextEvent();
				// if the xml element is a <T>
				if (nextEvent.isStartElement()) {
					StartElement startElement = nextEvent.asStartElement();
					// we check what T is
					switch (startElement.getName().getLocalPart()) {
					// if it's <record> then a new book is created
					case "record":
						book = new Book();
						break;
					case "recordIdentifier":
						nextEvent = reader.nextEvent();
						book.setIdentifier(nextEvent.asCharacters().getData());
						break;
					case "title":
						nextEvent = reader.nextEvent();
						// we remove uneeded additionnal info
						String regexPattern = Pattern.quote("/") + ".*";
						book.setTitle(nextEvent.asCharacters().getData().replaceAll(regexPattern, ""));
						break;
					case "creator":
						nextEvent = reader.nextEvent();
						// we remove uneeded additionnal info
						book.setAuthor(nextEvent.asCharacters().getData().replaceAll(". Auteur du texte", ""));
						break;
					case "date":
						nextEvent = reader.nextEvent();
						book.setDate(nextEvent.asCharacters().getData());
						break;
					case "language":
						nextEvent = reader.nextEvent();

						if (nextEvent.asCharacters().getData().equals("fre")) {
							book.setLanguage("français");
						} else {
							book.setLanguage(nextEvent.asCharacters().getData());
						}
						break;
					}
				}
				// if the xml element is a </T>
				if (nextEvent.isEndElement()) {
					EndElement endElement = nextEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("record")) {
						books.add(book);
					}
				}
			}
		} catch (XMLStreamException | FileNotFoundException e) {
			e.printStackTrace();
		}

		return books;
	}
}
