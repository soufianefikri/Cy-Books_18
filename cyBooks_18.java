package cyBooks18;
import java.util.Scanner;

public class cyBooks_18 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		String firstname;
		String lastname;
		String adress;
		String email;
		long iD;
		long phone;
		
		System.out.println("Quel est votre prénom :");
		firstname = scanner.nextLine();
		if( firstname.length() > 45) {
			System.out.println("Prénom top long");
			
		}
		System.out.println("Quel est votre nom de famille :");
		lastname = scanner.nextLine();
		if( lastname.length() > 45) {
			System.out.println("Nom de famille top long");
		}
		
		System.out.println("Quelle est votre adresse :");
		adress = scanner.nextLine();
		
		
		System.out.println("Quellr votre adresse mail :");
		email = scanner.nextLine();
		System.out.println("Quel est votre numéro de téléphone");
		phone = scanner.nextLong();
		if(String.valueOf(phone).length() != 9) {
			System.out.println("False");
		}

		scanner.nextLine();
		scanner.close();
		
		
		



	}

}
