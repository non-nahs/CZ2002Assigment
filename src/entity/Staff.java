package entity;

public class Staff {

	private int staffID;
	private String staffName;
	private boolean gender;
	private String jobTitle;

	public void viewReservations() {
		// TODO - implement Staff.viewReservations
		
	}

	public void viewSalesRevenue() {
		// TODO - implement Staff.viewSalesRevenue
		
	}

	public String getName() {
		// TODO - implement Staff.getName
		return this.staffName;
	}

	public String getGender() {
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

}