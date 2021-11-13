// Eugene
package entity;

import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class Staff {

	private int staffID;
	private String staffName;
	private boolean gender;  // false = female // true = male
	private String jobTitle;

	// constructor here
	public Staff(int sId, String n, boolean g, String jd){
		this.staffID = sId;
		this.staffName = n;
		this.gender = g;
		this.jobTitle = jd;

	}
	// end of consructor

	public void viewReservations() {
		// TODO - implement Staff.viewReservations
		// https://java-programming.mooc.fi/part-4/3-files-and-reading-data
		// we create a scanner for reading the file
		try (Scanner scanner = new Scanner(Paths.get("reservations.txt"))) {
			// we read the file until all lines have been read
			while (scanner.hasNextLine()) {
				// we read one line
				String row = scanner.nextLine();
				// we print the line that we read
				System.out.println(row);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void viewSalesRevenue() {
		// TODO - implement Staff.viewSalesRevenue
		// https://java-programming.mooc.fi/part-4/3-files-and-reading-data
		try (Scanner scanner = new Scanner(Paths.get("revenue.txt"))) {
			// we read the file until all lines have been read
			while (scanner.hasNextLine()) {
				// we read one line
				String row = scanner.nextLine();
				// we print the line that we read
				System.out.println(row);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public String getName() {
		// TODO - implement Staff.getName
		return this.staffName;
	}

	public boolean getGender() {
		// TODO - implement Staff.getGender
		return this.gender;
	}

	public int getStaffId() {
		// TODO - implement Staff.getStaffId
		return this.staffID;
	}

	public String getJobTitle() {
		// TODO - implement Staff.getJobTitle
		return this.jobTitle;
	}

	/**
	 * 
	 * @param title
	 */
	public void setJobTitle(String title) {
		// TODO - implement Staff.setJobTitle
		this.jobTitle = title;
	}

	public static void initStaff(){ // initialise Staffs
		ArrayList<Staff> staffs  = new ArrayList<Staff>();
		staffs.add(new Staff(1,"Johnathan",true,"Manager"));
		staffs.add(new Staff(2,"Joeseph",true,"Supervisor"));
		staffs.add(new Staff(3,"Jotarou",true,"Waiter"));
		staffs.add(new Staff(4,"Josuke",true,"Waiter"));
		staffs.add(new Staff(5,"Jolyne",false,"Waiter"));
	}
}