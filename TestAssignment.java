package Assignment_Final;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TestAssignment {
	public static String dueCondition(String date) throws Exception {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
      Date currentDate = new Date();  

		Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		long timeDiff = 0;
		long difference_In_Days = 0;
		String result = "";
		
		// overdue
	      if(currentDate.compareTo(newDate) > 0) {
	    	  timeDiff =  currentDate.getTime()-newDate.getTime() ;  
	    	   difference_In_Days = (timeDiff / (1000 * 60 * 60 * 24)) % 365;
		    	 result = "Your consultation overdued by " + difference_In_Days + " day(s)";
	      } 
	      else if(currentDate.compareTo(newDate) < 0) {
	    	  timeDiff = newDate.getTime()- currentDate.getTime();
	    	  difference_In_Days = (timeDiff / (1000 * 60 * 60 * 24)) % 365;
	    	  result = "Your consultation is in " + difference_In_Days + " day(s)";
	      } 
	      else if(currentDate.compareTo(newDate) == 0) {
	    	  result = "Your consultation is today!";
	      }	
	      return result;
		}
	
	public static void editRecord(String filename, String editTerm){
		String tempFile = "scheduleDatabase/temp.txt";
		File oldFile = new File(filename);
		File newFile = new File(tempFile);
		Path filePath = Paths.get(filename);
		String ID = "", time = "", date = "", status = "";
		
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner x = new Scanner(new File(filename));
			BufferedReader br = Files.newBufferedReader(filePath);
			x.useDelimiter("[\t\n]");
			
			ID = x.next();
			time = x.next();
			date = x.next();
			status = x.next();
			pw.print(ID + "\t" + time + "\t" + date + "\t" + status);

			while(x.hasNext()){
				ID = x.next();
				time = x.next();
				date = x.next();
				status = x.next();
				if(ID.equals(editTerm))
				{
					pw.print("\n" + ID + "\t" + time + "\t" + date + "\tUnavailable");
				}
				else
				{
					pw.print("\n" + ID + "\t" + time + "\t" + date + "\t" + status);
				}
			}
			x.close();
			br.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filename);
			newFile.renameTo(dump);

		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	public static String genPatientID(ArrayList<Patient> patient) {
	   
		ArrayList<String> randomID = new ArrayList();
		
		for(int i=0; i < patient.size(); i++) {
			
			randomID.add(patient.get(i).getUserID());
			
		}
		
	    int min = 10000;
	    int max = 99999;
	    
	    String newPatientID = (Integer.toString((int)Math.floor(Math.random()*(max-min+1)+min)));
	    
	    while(randomID.contains(newPatientID)) {
	    	
	    	newPatientID = (Integer.toString((int)Math.floor(Math.random()*(max-min+1)+min)));
	    	
	    }
	    
	    	randomID.add(newPatientID);
	    	
	    	return newPatientID;
	    
 	}
	
	 public static String genPatientScheduleID(ArrayList<PatientSchedule> patientSchedule) {
	   
		ArrayList<String> randomID = new ArrayList();
		
		for(int i=0; i < patientSchedule.size(); i++) {
			
			randomID.add(patientSchedule.get(i).getpID());
			
		}
		
	    int min = 10000;
	    int max = 99999;
	    
	    String newpID = (Integer.toString((int)Math.floor(Math.random()*(max-min+1)+min)));
	    
	    while(randomID.contains(newpID)) {
	    	
	    	newpID = (Integer.toString((int)Math.floor(Math.random()*(max-min+1)+min)));
	    	
	    }
	    
	    	randomID.add(newpID);
	    	
	    	return newpID;
	    
 	}
	
	
	
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<PatientSchedule> patientSchedules = new ArrayList();

		int dashB = 0;
		String userB = "", passwordB = "", idB = "";

		
		System.out.println("\n\n****************************************************************************************************************************************");
		System.out.println("\n				WELCOME TO APPOINTMENT BOOKING SYSTEM, GET YOUR CONSULTATION BOOKED NOW!\n");
		System.out.println("****************************************************************************************************************************************");
		System.out.println("\n");
		
		System.out.print("Press 1 to Register (New User)");
		System.out.print("\nPress 2 to Login (Existing User)");
		System.out.print("\nAre you a new or an existing user?\t");
		int determine;
		determine = scanner.nextInt();
		
		System.out.print("\n****************************************************************************************************************************************");

		String patientFileName = "patientDatabase.txt";
		Path patientFilePath = Paths.get(patientFileName);
		
		String lines = "";
		ArrayList<Patient> patients = new ArrayList();
		
		String userID, name, password, email, phone, DOB;
			
		try {
			
			BufferedReader patientBr = Files.newBufferedReader(patientFilePath);
			patientBr.readLine();
			
			while((lines = patientBr.readLine()) != null) {
				String[] patientData = lines.split("\t");
				patients.add(new Patient(patientData[0],patientData[1],patientData[2],patientData[3],patientData[4],patientData[5]));
			}
			
			patientBr.close();
			
			
			if(determine == 1) {

				FileWriter patientFw = new FileWriter(patientFileName,true);        
				BufferedWriter patientBw = new BufferedWriter(patientFw);
				
				System.out.print("\n\nUsername: ");
				name = scanner.next();
				
				patientBw.write("\n");
				
				userID = genPatientID(patients);

				patientBw.write(userID + "\t");
				
				patientBw.write(name + "\t");

				System.out.print("\n\nPassword: ");
				password = scanner.next();
				patientBw.write(password + "\t");
				

				System.out.print("\n\nEmail: ");
				email = scanner.next();
				patientBw.write(email + "\t");

				
				System.out.print("\n\nPhone number: ");
				phone = scanner.next();
				patientBw.write(phone + "\t");
				
				
				System.out.print("\n\nDate of Birth (DD/MM/YYYY):	");
				DOB = scanner.next();
				patientBw.write(DOB);
				

				patients.add(new Patient(genPatientID(patients), name, password, email, phone, DOB));
				
				userB = name; 
				passwordB = password;
				idB = userID;
				patientBw.flush();
				patientBw.close();

				String createPatientScheduleFileName = "patientScheduleDatabase/" + userID + ".txt";
				File patientScheduleFile = new File(createPatientScheduleFileName);

				
				try {
					FileWriter patientScheduleFw = new FileWriter(createPatientScheduleFileName,true);
					BufferedWriter patientScheduleBw = new BufferedWriter(patientScheduleFw);
					PrintWriter patientSchedulePw = new PrintWriter(patientScheduleBw);


					patientSchedulePw.print("ID\tHospital\tDoctor\tSpecialty\tDate\tTime\tFees\tDue\tConsult Status");

					patientScheduleBw.close();
					patientSchedulePw.flush();
					patientSchedulePw.close();

					patientScheduleFile.createNewFile();


				} catch(Exception e) {
					System.out.println("ERROR");
				}

				scanner.nextLine();

				System.out.println("\n\n****************************************************************************************************************************************");

			} 
			
			else if(determine == 2) {
				
				
				boolean logInStatus = false;
				
				while(logInStatus != true) {
					
					System.out.print("\n\nEnter User ID: ");
					userID = scanner.next();
					
					
					System.out.print("\n\nEnter Password: ");
					password = scanner.next();
				
				
					for(int i = 0; i < patients.size(); i++) {
					
						if(userID.equals(patients.get(i).getUserID()) && password.equals(patients.get(i).getPass())) {
							idB = userID;
							String pScheduleFileName = "patientScheduleDatabase/" + userID + ".txt";
							Path pFilePath = Paths.get(pScheduleFileName);
							lines = "";
							try {

								BufferedReader pBr = Files.newBufferedReader(pFilePath);
								pBr.readLine();

								while((lines = pBr.readLine()) != null) {
									String[] pData = lines.split("\t");
									double doctorpFees = Double.parseDouble(pData[6]);
									patientSchedules.add(new PatientSchedule(pData[0],pData[1],pData[2],pData[3],pData[4],pData[5],doctorpFees,pData[7], pData[8]));
								}
								pBr.close();

							} catch (Exception e) {
								System.out.println("Error");
							}

							userB = patients.get(i).getName(); 
							passwordB = password;
							
							logInStatus = true;
				
						}
										
					}
					
					System.out.println("\n\n****************************************************************************************************************************************");
				}
					
				scanner.nextLine();
			}
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println("\n");
		
		// Search for hospital file path
		String hospitalFileName = "hospitalDatabase.txt"; 
		Path hospitalFilePath = Paths.get(hospitalFileName);
		lines = "";

		// System.out.println(hospitalFilePath);

		// Hospital Array
		ArrayList<Hospital> hospitals = new ArrayList();
		
		try {

			// Tell the program to read the chosen file path
			BufferedReader hospitalBr = Files.newBufferedReader(hospitalFilePath);
			
			// Read the first line only
			hospitalBr.readLine();
			
			// Read the rest of the line and insert in Hospital Data
			while((lines = hospitalBr.readLine()) != null) {
				String[] hospitalData = lines.split("\t");
				hospitals.add(new Hospital(hospitalData[0],hospitalData[1],hospitalData[2],hospitalData[3],hospitalData[4]));
			}

			hospitalBr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean quitState = false;
		while(quitState != true)
		{
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();

		

			System.out.print("\tHi " + userB + "("+ idB + ") !" + "\t\t\t\t\t\t\t\t\t\tToday's date is " + dateFormat.format(date));
			
			
			System.out.println("\n\n\n****************************************************************************************************************************************");
			
			System.out.println("\n\nMenu Selection:\n\n1 - Book Consultation\n2 - Check My Schedule\n3 - Quit");
			System.out.print("\n\nEnter Menu: ");
			int selectMenu = scanner.nextInt();

			scanner.nextLine();

			if(selectMenu == 1)
			{
				System.out.println("\n\n****************************************************************************************************************************************");

				System.out.println("\nLIST OF HOSPITAL DETAILS\n");
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
				
				System.out.printf("%3s\t %12s\t %22s\t \t\t%15s\t \t\t%36s", "ID", "Name", "Working Hours", "Address", "Rating");
				
				System.out.println();
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
				
				for(int i = 0; i < hospitals.size(); i++){
					
					System.out.format("%s\t %s\t %s\t %s\t \t%s",
							hospitals.get(i).getHospitalID(), hospitals.get(i).getHospitalName(),hospitals.get(i).getHospitalWorkingHours(), hospitals.get(i).getHospitalAddress(),hospitals.get(i).getHospitalRate());
					System.out.println();
					
				}
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
				
				System.out.print("\nEnter Hospital ID: ");
				String hospitalInput = scanner.nextLine();

				
				System.out.println("\n\n****************************************************************************************************************************************");
				
				
				System.out.println("\nLIST OF DOCTOR DETAILS\n");

				
				
				
				Boolean foundState = false;

				int hospitalNumber = 0;
				String hospitalName = "";
				// Hospital Array
				ArrayList<Doctor> doctors = new ArrayList();       

				for(int i = 0; i < hospitals.size(); i++) {
					if (hospitalInput.equals(hospitals.get(i).getHospitalID())) {
						hospitalNumber = i;
						hospitalName = hospitals.get(i).getHospitalName();
						foundState = true;
						String doctorFileName = "doctorDatabase/" + hospitalInput + ".txt"; 
						Path doctorFilePath = Paths.get(doctorFileName);
						lines = "";
							
							try {

								// Tell the program to read the chosen file path
								BufferedReader doctorBr = Files.newBufferedReader(doctorFilePath);
								
								// Read the first line only
								doctorBr.readLine();
								
								// Read the rest of the line and insert in Hospital Data
								while((lines = doctorBr.readLine()) != null) {
									String[] doctorData = lines.split("\t");
									double doctorFees = Double.parseDouble(doctorData[4]);
									doctors.add(new Doctor(doctorData[0],doctorData[1],doctorData[2],doctorData[3],doctorFees));
								}

								doctorBr.close();

							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							break;
					}
				}
				


				if(foundState != true){
					System.out.println("ID does not found");
				}
				else {
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
					
					System.out.printf("%3s\t %8s\t %13s \t%30s \t%20s", "ID", "Name", "Phone", "Specialty", "Fees");
					
					System.out.println();
					
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
					
					for(int i = 0; i < doctors.size(); i++){
						
						System.out.format("%s\t %s\t %s\t\t %20s %20.2f",
								doctors.get(i).getDoctorID(), doctors.get(i).getDoctorName(),doctors.get(i).getPhone(), doctors.get(i).getSpecialty(), doctors.get(i).getFees());
						System.out.println();
						
					}
					
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
				}
				
				System.out.print("\nEnter doctor ID: ");
				String doctorInput = scanner.nextLine();
				System.out.println("\n\n****************************************************************************************************************************************");

				

				System.out.print("\n");
				
				//Schedule Array
				ArrayList<DoctorSchedule> doctorSchedules = new ArrayList();       

				foundState = false;
				int doctorNumber = 0;
				String doctorName = "", doctorSpecialty = "";
				double doctorFees = 0;
				for(int i = 0; i < doctors.size(); i++) {
					if (doctorInput.equals(doctors.get(i).getDoctorID())) {
						doctorNumber = i;
						doctorName = doctors.get(i).getDoctorName();
						doctorSpecialty = doctors.get(i).getSpecialty();
						doctorFees = doctors.get(i).getFees();
						foundState = true;
						String doctorScheduleFileName = "scheduleDatabase/" + doctorInput + ".txt"; 
						Path doctorScheduleFilePath = Paths.get(doctorScheduleFileName);
						lines = "";
							
							try {

								// Tell the program to read the chosen file path
								BufferedReader doctorScheduleBr = Files.newBufferedReader(doctorScheduleFilePath);
								
								// Read the first line only
								doctorScheduleBr.readLine();
								
								// Read the rest of the line and insert in Hospital Data
								while((lines = doctorScheduleBr.readLine()) != null) {
									String[] doctorScheduleData = lines.split("\t");
									doctorSchedules.add(new DoctorSchedule(doctorScheduleData[0],doctorScheduleData[1],doctorScheduleData[2],doctorScheduleData[3]));
								}

								doctorScheduleBr.close();

							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
					}
				}
				if(foundState != true){
					System.out.println("ID does not found");
				}
				
				else {
					System.out.println("\nLIST OF DOCTOR'S SCHEDULES");
					
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
					
					System.out.printf("%3s %15s %15s %15s", "ID", "Time", "Date", "Status");
					
					System.out.println();
					
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
					
					for(int i = 0; i < doctorSchedules.size(); i++){
						
						if (doctorSchedules.get(i).getDoctorStatus().equals("Available")) {
							
							System.out.format("%s\t %s\t %s\t %s",
									doctorSchedules.get(i).getDoctorScheduleID(), doctorSchedules.get(i).getTime(),doctorSchedules.get(i).getDate(), doctorSchedules.get(i).getDoctorStatus());
							System.out.println();
							
					}	
						
				}	

					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
					
		}
				
				System.out.print("\n\nEnter your booking Schedule ID from timeslots available: ");
				String doctorScheduleInput = scanner.nextLine();
				System.out.println("\n\n\n****************************************************************************************************************************************");

				foundState = false;
				int doctorScheduleNumber = 0;
				String doctorDate = "", doctorTime = "";
				String due = "";
				for(int i = 0; i < doctorSchedules.size(); i++) {
					if(doctorScheduleInput.equals(doctorSchedules.get(i).getDoctorScheduleID())) {
						doctorScheduleNumber = i;
						doctorDate = doctorSchedules.get(i).getDate();
						doctorTime = doctorSchedules.get(i).getTime();
						due = dueCondition(doctorDate);
						doctorSchedules.get(i).setStatus("Unavailable");
						foundState = true;
						String doctorFileName = "scheduleDatabase/" + doctorInput + ".txt";
						editRecord(doctorFileName, doctorSchedules.get(i).getDoctorScheduleID());
					}
				}
				
				if(foundState != true){
					System.out.println("ID does not found");
				}

				String scheduleID = genPatientScheduleID(patientSchedules);	
				
				patientSchedules.add(new PatientSchedule(scheduleID,hospitalName,doctorName,doctorSpecialty,doctorDate,doctorTime,doctorFees,"Approved", due));
				

				String patientScheduleFileName = "patientScheduleDatabase/" + idB + ".txt";
				File patientScheduleFile = new File(patientScheduleFileName);

				try {
					FileWriter patientScheduleFw = new FileWriter(patientScheduleFile,true);
					BufferedWriter patientScheduleBw = new BufferedWriter(patientScheduleFw);
					PrintWriter patientSchedulePw = new PrintWriter(patientScheduleBw);
					
					patientSchedulePw.print("\n"+patientSchedules.get(patientSchedules.size()-1).getpID()+"\t"+patientSchedules.get(patientSchedules.size()-1).getpHospital()+"\t"+patientSchedules.get(patientSchedules.size()-1).getpDoctor()+"\t"+patientSchedules.get(patientSchedules.size()-1).getDoctorpSpecialty()+"\t"+patientSchedules.get(patientSchedules.size()-1).getDoctorpDate()+"\t"+patientSchedules.get(patientSchedules.size()-1).getDoctorpTime()+"\t"+patientSchedules.get(patientSchedules.size()-1).getDoctorpFees()+"\t"+ patientSchedules.get(patientSchedules.size()-1).getDue()+"\t"+patientSchedules.get(patientSchedules.size()-1).getConsultStatus());
					
					patientSchedulePw.flush();
					patientSchedulePw.close();

				} catch (Exception e) {
					System.out.println("Error");
				}
				
			} else if (selectMenu == 2) {


				System.out.println("\n\n****************************************************************************************************************************************");

				System.out.println("\nMY SCHEDULE\n");
				
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				
				System.out.printf("%3s\t %12s\t %15s %15s %22s %12s\t %20s %20s %30s", "ID",	"Hospital",	"Doctor",	"Specialty",	"Date",	"Time",	"Fees",	"Due", "Consult Status");
				
				System.out.println();
				
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				
				for(int i = 0; i < patientSchedules.size(); i++){
					
					
					System.out.format("%s\t %s\t %s\t %s\t \t%s %s\t %20.2f\t %20s\t \t%s",
							patientSchedules.get(i).getpID(),patientSchedules.get(i).getpHospital(),patientSchedules.get(i).getpDoctor(),patientSchedules.get(i).getDoctorpSpecialty(),patientSchedules.get(i).getDoctorpDate(),patientSchedules.get(i).getDoctorpTime(),patientSchedules.get(i).getDoctorpFees(),patientSchedules.get(i).getDue(),patientSchedules.get(i).getConsultStatus());
					System.out.println();
					
				}
				
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			} else if (selectMenu == 3) {
				System.out.println("Thank you, see you again!");
				quitState = true;
				System.out.flush();
				System.exit(0);  
			}



		}
	}
}