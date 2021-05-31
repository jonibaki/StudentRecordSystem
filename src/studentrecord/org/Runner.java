package studentrecord.org;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JDialog;
import javax.swing.JFrame;

public class Runner {
	public static Student[] students = new Student[30];
	public static int currentStudent = -1;
	
	public static JFrame frameDataEntry;
	public static JFrame frameRunnerScreen;
	public static JFrame frameSearchRecord;
	public static JDialog frameAuthenticate;
	public static JFrame frameStudentProfile;
	public static JFrame frameAdvanceSearch;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					readFile();
					WindowDataEntry windowDataEntry = new WindowDataEntry();
					Runner.frameDataEntry = windowDataEntry.frame;
					Runner.frameDataEntry.setVisible(false);
					
					
					WindowMainScreen windowMainScreen = new WindowMainScreen();
					Runner.frameRunnerScreen = windowMainScreen.frame;
					Runner.frameRunnerScreen.setVisible(true);
					
					WindowSearchRecord windowSearchRecord = new WindowSearchRecord();
					Runner.frameSearchRecord = windowSearchRecord.frame;
					Runner.frameSearchRecord.setVisible(false);
					
					Runner.frameAuthenticate = new WindowAuthenticate();
					Runner.frameAuthenticate.setVisible(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void readFile (){
		
		try(BufferedReader br = new BufferedReader(new FileReader("studentrecord.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line= null;// = br.readLine();
		    

		    while ((line = br.readLine()) != null) {
		    	Student record = new Student();
		    	
		    	
		    	
		        //sb.append(line);
		        //sb.append(System.lineSeparator());
		        //line = br.readLine();
		        String[] parts = line.split(" ");
		        record.name = parts[0].replaceAll("#space#", " ");
		        record.gender = parts[1];
		        record.address = parts[2].replaceAll("#space#", " ");
		        record.mark =Integer.parseInt(parts[3]);
		        
		        currentStudent++;
		        students[currentStudent] = record;
		              		
		    }
		   
		    //String everything = sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(currentStudent);
	}

	public static Student getStudent(int index){
		return students[index];
	}
	public static void setStudent(int index, Student student){
		 students[index] = student;
	}
}
