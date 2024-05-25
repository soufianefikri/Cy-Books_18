package model;


public class User {
	String firstname;
	String lastname;
	String address;
	String email;
	String phone;
	int iD;
	
	
	
	public User(String firstname,String lastname,String address,String email,String phone, int iD) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.iD = iD;
	}
	public User(){

	}
	
	@Override
	public String toString() {
		return "User [name=" + firstname + ", surname=" + lastname + ", adress=" + address + ", email=" + email + ", phone=" + phone + ", id =" + iD + "]";
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
