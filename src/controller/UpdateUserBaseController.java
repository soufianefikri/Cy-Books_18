package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.UpdateUserInfo;
import view.UpdateUserBase;
import view.UsersBase;
import view.MenuBase;
import javafx.scene.Scene;

/**
 * This class is used as a controller of the scene in which the user's information can be changed 
 * @author CYTech Student
 * 
 */
public class UpdateUserBaseController extends UpdateUserBase{
    
    public UpdateUserBaseController(int id) {
        super(id);
    }
    
    /**
     * This method is used to call the necessary methods to check the new information and change it in the database
     */

    protected void checkInput(javafx.event.ActionEvent actionEvent){
        UpdateUserInfo ui = new UpdateUserInfo();
        ui.updateUserInfo(actionEvent, firstname_field, lastname_field, address_field, zipcode_field, city_field, email_field, number_field, id);
    };
    /**
     * this method is the action to cancel any changes made
     */
    protected void cancel(javafx.event.ActionEvent actionEvent){
        UsersBase menu = new UserBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }
    /**
     * This method is the action of to go the Home scene of the app
     */
	protected void home(javafx.event.ActionEvent actionEvent){
        MenuBase menu = new MenuBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }
	
	/**
	 * This method shows the information of the user in the scene from the data base
	 * @param firstname of the user from the database
	 * @param lastname of the user from the database
	 * @param address of the user from the database
	 * @param email of the user from the database
	 * @param phone of the user from the database
	 */

    public void showData(String firstname, String lastname, String address, String email, String phone) {
		
    	// this separates the address in the database to three sup strings (address, City, ZIP code) 
		String addressRegex="^(.+?)\\s([a-zA-Z]+(?:-[a-zA-Z]+)*)\\s(\\d{5})$";
		Pattern pattern = Pattern.compile(addressRegex);
		Matcher matcher = pattern.matcher(address);


	        if (matcher.matches()) {
	            String streetAddress = matcher.group(1);
	            String city = matcher.group(2);
	            String zipcode = matcher.group(3);

				firstname_field.setText(firstname);
				lastname_field.setText(lastname);
				address_field.setText(streetAddress);
				city_field.setText(city);
				zipcode_field.setText(zipcode);
				email_field.setText(email);
				number_field.setText(phone);
				

	            
	        } else {
	            System.out.println("Address format doesn't match.");
	        }
	}
}
