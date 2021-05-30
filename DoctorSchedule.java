package Assignment_Final;

class DoctorSchedule {
	
	private String time;
	private String date;
	private String doctorStatus;
	private String DoctorScheduleID;
	
	public DoctorSchedule(String DoctorScheduleID, String time, String date, String doctorStatus) {
		this.DoctorScheduleID = DoctorScheduleID;
		this.time = time;
		this.date = date;
		this.doctorStatus = doctorStatus;
	}
	
	public String getDoctorScheduleID() {
		return DoctorScheduleID;
	}
	
	public String getTime() {
		return time;
	}


	public String getDate() {
		return date;
	}


	public String getDoctorStatus() {
		return doctorStatus;
	}

	public void setStatus(String doctorStatus) {
		this.doctorStatus = doctorStatus;
	}
	
	public String displayDoctorSchedule() {
			return "\nDoctorSchedule ID: " + DoctorScheduleID + "\nTime: " + time + "\nDate: " + date + "\nDoctor's Status: " + doctorStatus;
		
		}
	}

