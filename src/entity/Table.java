package entity;
import java.util.ArrayList;

import boundary.MainMenuUI;


/**
 * Represents a table in the Restaurant
 * A table can be reserved or occupied by 1 customer.
 * @author Yeo Kai Liang, Jasper
 * @version 1.0
 * @since 2021-10-15
 */


public class Table {

	/**
	 * The identification number for this table
	 */
	private int tableID;
	/**
	 * The maximum number of people able to sit in this table
	 */
	private int seatCapacity;
	/**
	 * This table's occupied status
	 */
	private boolean occupied;

	/**
	 * Creates a new Table with the given table identification number and seat capacity
	 * @param tID	This table's ID
	 * @param seats This table's seat capacity
	 */
	public Table(int tID, int seats){
		this.tableID = tID;
		this.seatCapacity = seats;
		this.occupied = false; 
	}

	/**
	 * Gets ID of this table.
	 * @return this table's name
	 */
	public int getTableID(){
		return this.tableID;
	}
	/**
	 * Get seat capacity of this table.
	 * @return this table's seating capacity
	 */
	public int getSeatCapacity(){
		return this.seatCapacity;
	}

	/**
	 * Get occupied status of this table.
	 * @return this table's occupied status
	 */
	public boolean getTableStatus(){
		return this.occupied;
	}


	/**
	 * Set this table's occupied by customer status to TRUE
	 */
	public void bookTable() {  // should be no input instead; rmb change vpp also
			this.occupied = true;
		}

	/**
	 * Set this table's occupied by customer status to FALSE
	 */
	public void releaseTable() { // should be no input instead; rmb change vpp also
			this.occupied = false;
		}


	/**
	 * Initialise the tables in the restaurant
	 * 
	 * This table set up contains the following:
	 * 5 tables that have 2 seat capacity
	 * 5 tables that have 4 seat capacity
	 * 5 tables that have 8 seat capacity
	 * 3 tables that have 12 seat capcity
	 */
	public static void initTable(){
		int i = 0;
		ArrayList<Table> tables = MainMenuUI.table;
		for (i=1; i<=5;i++){
			tables.add(new Table(i,2));	// 2pax x 5
		}
		for(i=6;i<=10;i++){
			tables.add(new Table(i,4)); // 4pax x 5
		}
		for(i=11;i<=15;i++){ 
			tables.add(new Table(i,8)); // 8pax x 5
		}
		for(i=16;i<=18;i++){
			tables.add(new Table(i,12));// 12pax x 3
		}
	}
}