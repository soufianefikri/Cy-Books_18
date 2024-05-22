package menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.Scene;

public class UpdateUserBaseController extends UpdateUserBase{
    
    public UpdateUserBaseController(int id) {
        super(id);
    }

    protected void check_input(javafx.event.ActionEvent actionEvent){
        UpdateInfo ui = new UpdateInfo();
        ui.user_update(actionEvent, firstname_field, lastname_field, address_field, zipcode_field, city_field, email_field, number_field, id);
    };

    protected void cancel(javafx.event.ActionEvent actionEvent){
        UsersBase menu = new UserBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }

	protected void home(javafx.event.ActionEvent actionEvent){
        MenuBase menu = new MenuBaseController();

        Scene currentScene = button0.getScene();

        currentScene.setRoot(menu);
    }

    public void showData(String firstname, String lastname, String address, String email, String phone) {
		

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
				

	            System.out.println("Street Address: " + streetAddress);
	            System.out.println("City: " + city);
	            System.out.println("Zipcode: " + zipcode);
	        } else {
	            System.out.println("Address format doesn't match.");
	        }
	}
}
