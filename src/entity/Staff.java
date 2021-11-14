package entity;

import java.util.ArrayList;
//import java.util.Scanner;
//import java.nio.file.Paths;

/**
 * Represents a Staff working in the restaurant
 * @author Yap Eugene
 * @version 1.0
 * @since 2021-10-15
 */

public class Staff {

	/**
	 * Identification number of this staff.
	 */
	private int staffID;
	
	/**
	 * Name of this staff.
	 */
	private String staffName;
	
	/**
	 * Gender of this staff.
	 * false = female, true = male
	 */
	private boolean gender; 
	
	/**
	 * Job title of this staff.
	 */
	private String jobTitle;
	
	/**
	 * List of all staffs working in the restaurant. 
	 */
	private static ArrayList<Staff> staffs  = new ArrayList<Staff>();
	
	/**
	 * Creates a new Staff with staffId, name, gender and job. 
	 * @param sId This Staff's ID
	 * @param n This Staff's name
	 * @param g This Staff's gender
	 * @param jd This Staff's job
	 */
	public Staff(int sId, String n, boolean g, String jd){
		this.staffID = sId;
		this.staffName = n;
		this.gender = g;
		this.jobTitle = jd;
	}
	
	/**
	 * Get the Name of this Staff
	 * @return this Staff's name
	 */
	public String getName() {
		return this.staffName;
	}

	/**
	 * Get the Gender of this Staff.
	 * Male = True, Female = False.
	 * @return this Staff's gender
	 */
	public boolean getGender() {
		return this.gender;
	}


	/**
	 * Get the StaffID of this Staff
	 * @return this Staff's ID
	 */
	public int getStaffId() {
		return this.staffID;
	}

	/**
	 * Get the Job Title of this Staff
	 * @return this Staff's Job Title
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Changes the Job of this Staff
	 * @param title This Staff's new Job. 
	 */
	public void setJobTitle(String title) {
		this.jobTitle = title;
	}

	/**
	 * Create 5 new Staffs.
	 * Add each Staff to the ArrayList<Staff> staffs.
	 */
	public static void initStaff(){ // initialise Staffs
		staffs.add(new Staff(1,"Johnathan",true,"Manager"));
		staffs.add(new Staff(2,"Joeseph",true,"Supervisor"));
		staffs.add(new Staff(3,"Jotarou",true,"Waiter"));
		staffs.add(new Staff(4,"Josuke",true,"Waiter"));
		staffs.add(new Staff(5,"Jolyne",false,"Waiter"));
	}

	/**
	 * Prints each Staff's ID, Name, Gender and Job. 
	 */
	public void printStaff() {
		System.out.println("ID  Name  Gender  Job");
		for(Staff s : staffs)
			System.out.println(s);
	}

	/**
	 * Returns each Staff's ID, Name, Gender and Job. 
	 */
	@Override
	public String toString() {
		return this.staffID + " " + this.staffName + " " + this.gender + " " + this.jobTitle;
	}
}