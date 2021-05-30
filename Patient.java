package Assignment_Final;

public class Patient {
	
	private String userID;
	private String name, email, DOB, password, phone;
	
	Patient() {
		
	}
	
	
	Patient(String userID, String name, String password, String email, String phone, String DOB) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.DOB = DOB;
		this.password = password;
		this.phone = phone;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	
	public String getPass() {
		return password;
	}
	
	public void setPass(String password) {
		this.password = password;
	}
	
	public String getphone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}









