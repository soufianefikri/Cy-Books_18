package cyBooks18;

public class User {
	String name;
	String surname;
	String adress;
	String email;
	long iD;
	long phone;
	
	public User(String name,String surname,String adress,String email,long iD,long phone) {
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.email = email;
		this.iD = iD;
		this.phone = phone;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", adress=" + adress + ", email=" + email + ", iD=" + iD
				+ ", phone=" + phone + "]";
	}












	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public void setiD(int iD) {
		this.iD = iD;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
