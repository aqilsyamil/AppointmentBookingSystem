package Assignment_Final;

public class Doctor {
	private String specialty;
	private String doctorID;
	private String doctorName;
	private String phone;
	private double fees;
	

	public Doctor(String doctorID, String doctorName, String phone, String specialty, double fees) {
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.phone = phone;
		this.specialty = specialty;
		this.fees = fees;
	}
	
	public Doctor(String doctorID, String doctorName) {
		this.doctorID = doctorID;
		this.doctorName = doctorName;
	}

	public String getDoctorID() {
		return doctorID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public String getPhone() {
		return phone;
	}
	public String getSpecialty() {
		return specialty;
	}

	public double getFees() {
		return fees;
	}

	public String toString() {
		return "\nDoctor ID: "+ doctorID + "\nDoctor Name: "+ doctorName + "\nDoctor's phone: " 
				+ phone + "\nDoctor's Specialty: " + specialty + "\nDoctor's Fee: " + fees; 
	}
  
}
