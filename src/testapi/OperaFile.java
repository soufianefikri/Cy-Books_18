package testapi;

import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;

/**
 * OperaFile is the class to operate on files
 * 
 * @author TDLT
 *
 */
public class OperaFile {

	/**
	 * @param path a path to a xml file
	 */
	public static void createFile(String path) {
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
	public static void writeFile(String path, String body) {
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
}
