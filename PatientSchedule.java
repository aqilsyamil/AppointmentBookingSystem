package Assignment_Final;


import java.text.*;
import java.time.LocalDateTime;
import java.util.*;

public class PatientSchedule {

	private Hospital hospital;
	private Doctor doctor;
	private DoctorSchedule doctorSchedule;
	private String consultStatus;
	private String ID, hospitalName, doctorName, doctorSpecialty, doctorDate, doctorTime, due;
	private double fees;
	
	public PatientSchedule(String ID, String hospitalName, String doctorName, String doctorSpecialty, String doctorDate, String doctorTime, double fees, String consultStatus, String due) {
		this.ID = ID;
		this.hospitalName = hospitalName;
		this.doctorName = doctorName;
		this.doctorSpecialty = doctorSpecialty;
		this.doctorDate = doctorDate;
		this.doctorTime = doctorTime;
		this.due = due;
		this.fees = fees;
		this.consultStatus = consultStatus;
	}

	public PatientSchedule(Hospital hospital, Doctor doctor, DoctorSchedule doctorSchedule, String consultStatus) {
		this.hospital = hospital;
		this.doctor = doctor;
		this.doctorSchedule = doctorSchedule;
		this.consultStatus = consultStatus;
	}
	
	public String getpID() {
		return ID;
	}

	public String getHospital() {
		return hospital.getHospitalName();
	}
	
	public String getpHospital() {
		return hospitalName;
	}

	public String getDoctor() {
		return doctor.getDoctorName();
	}

	public String getpDoctor() {
		return doctorName;
	}

	public String getDoctorSpecialty() {
		return doctor.getSpecialty();
	}

	public String getDoctorpSpecialty() {
		return doctorSpecialty;
	}

	public String getDoctorDate() {
		return doctorSchedule.getDate();
	}

	public String getDoctorpDate() {
		return doctorDate;
	}

	public String getDoctorTime() {
		return doctorSchedule.getTime();
	}

	public String getDoctorpTime() {
		return doctorTime;
	}
	
	public double getDoctorFees() {
		return doctor.getFees();
	}

	public double getDoctorpFees() {
		return fees;
	}
	
	public String getConsultStatus() {
		return consultStatus;
	}
	
	public void setConsultStatus(String consultStatus) {
		this.consultStatus = consultStatus;
	}
	
	public String getDue() {
		return due;
	}
	public String dueCondition(String date) throws Exception {
		
//		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
//	      Date d1 = sdformat.parse("2019-04-15");
//	      Date d2 = sdformat.parse("2019-08-10");
//	      System.out.println("The date 1 is: " + sdformat.format(d1));
//	      System.out.println("The date 2 is: " + sdformat.format(d2));
//	      if(d1.compareTo(d2) > 0) {
//	         System.out.println("Date 1 occurs after Date 2");
//	      } else if(d1.compareTo(d2) < 0) {
//	         System.out.println("Date 1 occurs before Date 2");
//	      } else if(d1.compareTo(d2) == 0) {
//	         System.out.println("Both dates are equal");
//	      }
	     
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
      Date currentDate = new Date();  

		Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		long timeDiff = 0;
		long difference_In_Days = 0;
		String result = "";
		
	      if(currentDate.compareTo(newDate) > 0) {
	    	  timeDiff = currentDate.getTime() - newDate.getTime();
	    	   difference_In_Days = (timeDiff / (1000 * 60 * 60 * 24)) % 365;
	    	   result = "Your consultation is in " + difference_In_Days + " day(s)";
	      } 
	      else if(currentDate.compareTo(newDate) < 0) {
	    	  timeDiff = newDate.getTime() - currentDate.getTime();  
	    	  difference_In_Days = (timeDiff / (1000 * 60 * 60 * 24)) % 365;
	    	  result = "Your consultation overdued by " + difference_In_Days + " day(s)";
	      } 
	      else if(currentDate.compareTo(newDate) == 0) {
	    	  result = "Your consultation is today!";
	      }	
	      return result;
		}
	}