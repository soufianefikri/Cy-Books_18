package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class test_register {

    public void user_input(ActionEvent event, TextField firstname_field, TextField lastname_field,
                            TextField address_field,TextField zipcode_field,TextField city_field,
                            TextField email_field,TextField number_field) {
		
		boolean check_firstname = check_name(firstname_field.getText());
		boolean check_lastname = check_name(lastname_field.getText());
		boolean check_address = check_address(address_field.getText());
		boolean check_city = check_name(city_field.getText());
		boolean check_zipcode = check_zipcode(zipcode_field.getText());
		boolean check_email = check_email(email_field.getText());
		boolean check_number = check_number(number_field.getText());
		
		
		if(check_firstname && check_lastname && check_address && check_city && check_zipcode && check_email && check_number) {
			String address1= address_field.getText()+" "+city_field.getText()+" "+zipcode_field.getText() ;
			System.out.println(address1);
			String firstname =firstname_field.getText();
			String lastname = lastname_field.getText();
			String address =address1;
			String email = email_field.getText();
			String phone = number_field.getText();
			registerUser(firstname,lastname,address,email,phone);
			
		}
		else {
			IfInputErrors( check_firstname , check_lastname , check_address , check_city , check_zipcode , check_email , check_number);

		}
		
		
		
		
		
		
	}
	
	public boolean check_name(String n) {
	
		String nameRegex ="^[A-Z][a-zA-Z -]+";
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(n);
		if ( n.length() <= 45 && matcher.find() && n.length() >=2) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	public boolean check_email(String e) {
		String emailRegex ="^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.(com|fr)$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(e);
		if ( e.length() <= 45 && matcher.find() && e.length() >= 8) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean check_address(String a) {
		String addressRegex = "^[0-9]+(\\s|,)+([a-zA-Z]|\\s)";
		Pattern pattern = Pattern.compile(addressRegex);
		Matcher matcher = pattern.matcher(a);
		if ( a.length() <= 60 && matcher.find() && a.length() >= 5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean check_zipcode(String z) {
		String zipcodeRegex = "[1-9]";
		Pattern pattern = Pattern.compile(zipcodeRegex);
		Matcher matcher = pattern.matcher(z);
		if(matcher.find()) {
			int zp;
			zp=Integer.parseInt(z);
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
	
	public boolean check_number(String p) {
		String phoneRegex = "[0-9]";
		Pattern pattern = Pattern.compile(phoneRegex);
		Matcher matcher = pattern.matcher(p);
		if(matcher.find()) {
			long number;
			number=Long.parseLong(p);
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
	
	public void IfInputErrors(boolean check_firstname ,boolean check_lastname ,boolean check_address ,boolean check_city ,boolean check_zipcode ,boolean check_email ,boolean check_number) {
		if(!check_firstname) {
			ErrorFirstname();
		}
		
		if(!check_lastname) {
			ErrorLastname();
		}
		
		if(!check_address) {
			ErrorAddress();
		}
		
		if(!check_city) {
			ErrorCity();
		}
		
		if(!check_zipcode) {
			ErrorZipcode();
		}
		
		if(!check_email) {
			ErrorEmail();
		}
		
		if(!check_number) {
			ErrorNumber();
		}
	}
	
	private void ErrorFirstname() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le prénom");
		alert.setContentText("Le prénom doit commencer par une majiscule, ne doit pas contenir de caractères spéciaux (sauf -) et ne doit pas dépasser une taille de 45 caractères");
		alert.setHeaderText("Il semble que le prénom entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	
	
	private void ErrorLastname() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le nom de famille");
		alert.setContentText("Le nom de famille doit commencer par une majiscule, ne doit pas contenir de caractères spéciaux (sauf -) et ne doit pas dépasser une taille de 45 caractères");
		alert.setHeaderText("Il semble que le nom entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	
	private void ErrorAddress() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans l'adresse");
		alert.setContentText("L'adresse doit commencer par le numéro du bâtiment, suivie soit une virgule ou un espace, le nom de la rue (allée etc.) ne doit pas contenir de chiffre et l'adresse ne doit pas dépasser une taille de 60 caractères");
		alert.setHeaderText("Il semble que l'adresse entrée ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	private void ErrorCity() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le nom de la ville");
		alert.setContentText("Le nom de la ville doit commencer par une majiscule, ne doit pas contenir de caractères spéciaux (sauf -) et ne doit pas dépasser une taille de 45 caractères");
		alert.setHeaderText("Il semble que le nom de la ville entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	
	private void ErrorZipcode() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le code postal");
		alert.setContentText("Le code postal doit indiqué un département et un bureau distributeur de la France métropolitaine");
		alert.setHeaderText("Il semble que le code postal entré ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	
	private void ErrorEmail() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans l'adresse mail");
		alert.setContentText("L'adresse mail doit être de la forme user@domain.com ou user@domain.fr");
		alert.setHeaderText("Il semble que l'adresse mail entrée ne respecte pas les critères en dessous");
		alert.showAndWait();
		
	}
	
	
	private void ErrorNumber() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur dans le numéro de téléphone");
		alert.setContentText("Mettez un numéro de téléphone convenable");
		alert.setHeaderText("Il semble que le numéro de téléphone entré n'est pas conforme aux normes");
		alert.showAndWait();
		
	}
	
	public void registerUser(String firstname,String lastname,String address,String email,String phone) {
		try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cy_books","root","0805");
			//2.1Connection CHeck
			if(connection!= null) {
				System.out.println("Espresso");
			}
			Statement statement = connection.createStatement(); 
			String sql="INSERT cy_books.users (name,surname,address,email,phone)"
					+ "VALUES('" + firstname + "','" + lastname + "','" + address + "','" + email + "','" + phone +"');";
			int rowsAffected = statement.executeUpdate(sql);
		    if (rowsAffected > 0) {
		    	System.out.println("User registered successfully.");
		    } else {
		    	System.out.println("Failed to register user.");
		    }
			statement.close();
			connection.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
