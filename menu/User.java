package menu;


public class User {
	String firstname;
	String lastname;
	String adress;
	String email;
	String phone;
	int iD;
	
	
	
	public User(String firstname,String lastname,String adress,String email,String phone, int iD) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.email = email;
		this.phone = phone;
		this.iD = iD;
	}
	public User(){

	}
	
	@Override
	public String toString() {
		return "User [name=" + firstname + ", surname=" + lastname + ", adress=" + adress + ", email=" + email + ", phone=" + phone + ", id =" + iD + "]";
	}
	public int getiD(){
		return iD;
	}
	public void setiD(int iD){
		this.iD = iD;
	}
	public String getFirstame() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
