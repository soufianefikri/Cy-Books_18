package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * This class is used the register new users
 *  @author Soufiane Fikri
 *  
 *  
 */
public class RegisterUserInfo {
	
	/**
     * This method calls other methods to check the integrity of user input and adds the good data to the database 
     * @param event work as an action button the the parent scene 
     * @param firstname_field - TextField where the method retrieve the first name of the user from the GUI 
     * @param lastname_field - TextField where the method retrieve the last name of the user from the GUI
     * @param address_field - TextField where the method retrieve the number of the building and the street of the user's address from the GUI
     * @param zipcode_field - TextField where the method retrieve ZIP code of the user of the user's address from the GUI
     * @param city_field - TextField where the method retrieve the name of the city of the user's address from the GUI
     * @param email_field - TextField where the method retrieve the email of the user from the GUI
     * @param number_field - TextField where the method retrieve the phone number of the user from the GUI
     */

    public void userInput(ActionEvent event, TextField firstname_field, TextField lastname_field,
                            TextField address_field,TextField zipcode_field,TextField city_field,
                            TextField email_field,TextField number_field) {
		
		boolean check_firstname = checkName(firstname_field.getText());
		boolean check_lastname = checkName(lastname_field.getText());
		boolean check_address = checkAddress(address_field.getText());
		boolean check_city = checkName(city_field.getText());
		boolean check_zipcode = checkZipcode(zipcode_field.getText());
		boolean check_email = checkEmail(email_field.getText());
		boolean check_number = checkNumber(number_field.getText());
		
		
		if(check_firstname && check_lastname && check_address && check_city && check_zipcode && check_email && check_number) {
			// combine all the address information into one string to put in the database
			String address1= address_field.getText()+" "+city_field.getText()+" "+zipcode_field.getText() ;
			
			String firstname =firstname_field.getText();
			String lastname = lastname_field.getText();
			String address =address1;
			String email = email_field.getText();
			String phone = number_field.getText();
			connexion.registerUser(firstname,lastname,address,email,phone);
			
		}
		else {
			//if one or more input doesn't respect the norms, we check which one is it to show an error message 

			ifInputErrors( check_firstname , check_lastname , check_address , check_city , check_zipcode , check_email , check_number);

		}

		
	}
    /**
	 * This method is used to check if the name parameter is a proper noun  
	 * 
	 * @param name - String , first name, last name and city
	 * @return a boolean, true if the name respects the norms, false if not
	 */
    
	
	public boolean checkName(String name) {
		// name needs to start with an upper-case
		String nameRegex ="^[A-Z][a-zA-Z -]+";
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(name);
		// checks if name has more that one letter, an less that 255 to respect settings of the data base
		if ( name.length() <= 255 && matcher.find() && name.length() >=2) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	/**
	 * This method checks if an email respects the norms. Only .com and .fr work because we suppose that the app will be deployed in France only  
	 * 
	 * @param email of the user in the text field in the GUI
	 * @return a boolean, true if the email respects the norms, false if not
	 */
	public boolean checkEmail(String email) {
		String emailRegex ="^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.(com|fr)$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		// an email needs to have at least 8 characters to be valid and less that 255 to fit in the data base
		if ( email.length() <= 255 && matcher.find() && email.length() >= 8) {
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * This method is used to check if the address has a building number and a street
	 * @param address - String from the text field in the GUI
	 * @return a boolean, true if the address respects the norms, false if not
	 */
	
	public boolean checkAddress(String address) {
		String addressRegex = "^[0-9]+(\\s|,)+([a-zA-Z]|\\s)";
		Pattern pattern = Pattern.compile(addressRegex);
		Matcher matcher = pattern.matcher(address);
		if ( address.length() <= 200 && matcher.find() && address.length() >= 5) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 *  This method checks if the the ZIP code matches the French ZIP code system of the departments 
	 * @param zipcode - String from the text field in the GUI
	 * @return a boolean, true if the ZIP code matches the conditions , false if not
	 */
	
	public boolean checkZipcode(String zipcode) {
		String zipcodeRegex = "[1-9]";
		Pattern pattern = Pattern.compile(zipcodeRegex);
		Matcher matcher = pattern.matcher(zipcode);
		if(matcher.find()) {
			int zp;
			zp=Integer.parseInt(zipcode);
			if( zp >= 10000 && zp < 96000) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	/**
	 * This method checks if the number entered is a French phone number
	 * 
	 * @param phone - String from the text field in the GUI
	 * @return a boolean, true if the phone number matches the conditions , false if not
	 */
	
	public boolean checkNumber(String phone) {
		String phoneRegex = "[0-9]";
		Pattern pattern = Pattern.compile(phoneRegex);
		Matcher matcher = pattern.matcher(phone);
		if(matcher.find()) {
			long number;
			number=Long.parseLong(phone);
			if(number <= 999999999 && number > 100000000) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * This method checks which input failed the check test and call its error method the particular input
	 * 
	 * @param check_firstname - boolean
	 * @param check_lastname - boolean
	 * @param check_address - boolean
	 * @param check_city - boolean
	 * @param check_zipcode - boolean
	 * @param check_email - boolean
	 * @param check_number - boolean
	 */
	
	public void ifInputErrors(boolean check_firstname ,boolean check_lastname ,boolean check_address ,boolean check_city ,boolean check_zipcode ,boolean check_email ,boolean check_number) {
		if(!check_firstname) {
			errorFirstname();
		}
		
		if(!check_lastname) {
			errorLastname();
		}
		
		if(!check_address) {
			errorAddress();
		}
		
		if(!check_city) {
			errorCity();
		}
		
		if(!check_zipcode) {
			errorZipcode();
		}
		
		if(!check_email) {
			errorEmail();
		}
		
		if(!check_number) {
			errorNumber();
		}
	}
	
	/**
	 * This method show an error alert when the first name failed the integrity test
	 */
	private void errorFirstname() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le prénom");
		alert.setContentText("Le prénom doit commencer par une majiscule, ne doit pas contenir de caractères spéciaux (sauf -) et ne doit pas dépasser une taille de 45 caractères");
		alert.setHeaderText("Il semble que le prénom entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	
	/**
	 * This method show an error alert when the last name failed the integrity test
	 */
	private void errorLastname() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le nom de famille");
		alert.setContentText("Le nom de famille doit commencer par une majiscule, ne doit pas contenir de caractères spéciaux (sauf -) et ne doit pas dépasser une taille de 45 caractères");
		alert.setHeaderText("Il semble que le nom entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	/**
	 * This method show an error alert when the address failed the integrity test
	 */
	private void errorAddress() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans l'adresse");
		alert.setContentText("L'adresse doit commencer par le numéro du bâtiment, suivie soit une virgule ou un espace, le nom de la rue (allée etc.) ne doit pas contenir de chiffre et l'adresse ne doit pas dépasser une taille de 60 caractères");
		alert.setHeaderText("Il semble que l'adresse entrée ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	/**
	 * This method show an error alert window when the name of the City failed the integrity test
	 */
	
	private void errorCity() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le nom de la ville");
		alert.setContentText("Le nom de la ville doit commencer par une majiscule, ne doit pas contenir de caractères spéciaux (sauf -) et ne doit pas dépasser une taille de 45 caractères");
		alert.setHeaderText("Il semble que le nom de la ville entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	/**
	 * This method show an error alert window when the ZIP code failed the integrity test
	 */
	private void errorZipcode() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le code postal");
		alert.setContentText("Le code postal doit indiqué un département et un bureau distributeur de la France métropolitaine");
		alert.setHeaderText("Il semble que le code postal entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	/**
	 * This method show an error alert window when the email failed the integrity test
	 */
	
	private void errorEmail() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans l'adresse mail");
		alert.setContentText("L'adresse mail doit être de la forme user@domain.com ou user@domain.fr");
		alert.setHeaderText("Il semble que l'adresse mail entrée ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	/**
	 * This method show an error alert window when the phone number failed the integrity test
	 */
	private void errorNumber() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le numéro de téléphone");
		alert.setContentText("Mettez un numéro de téléphone convenable");
		alert.setHeaderText("Il semble que le numéro de téléphone entré n'est pas conforme aux normes");
		alert.showAndWait();
		
	}
	
	
}
