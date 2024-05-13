package cyBooks18;


public class User {
	String firstname;
	String lastname;
	String adress;
	String email;
	long iD;
	long phone;
	
	
	
	public User(String firstname,String lastname,String adress,String email,long iD,long phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.email = email;
		this.iD = iD;
		this.phone = phone;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "User [name=" + firstname + ", surname=" + lastname + ", adress=" + adress + ", email=" + email + ", iD=" + iD
				+ ", phone=" + phone + "]";
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
	public long getiD() {
		return iD;
	}
	public void setiD(long iD) {
		this.iD = iD;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

}
