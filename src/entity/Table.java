// Jasper
package entity;
import java.util.ArrayList;

import boundary.MainMenuUI;

public class Table {

	Reservation reservation;
	private int tableID;
	private int seatCapacity;
	private boolean occupied;

	public Table(int tID, int seats){
		this.tableID = tID;
		this.seatCapacity = seats;
		this.occupied = false;  //default = false
	}

	public int getTableID(){
		return this.tableID;
	}

	public int getSeatCapacity(){
		return this.seatCapacity;
	}

	public boolean getTableStatus(){
		return this.occupied;
	}

	public void editTableID(int newID){
		this.tableID = newID;
	}

	public void editSeatCapacity(int newCapacity){
		this.seatCapacity = newCapacity;
	}


	public void bookTable() {  // should be no input instead; rmb change vpp also
			this.occupied = true;
		}

	public void releaseTable() { // should be no input instead; rmb change vpp also
			this.occupied = false;
		}


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
			tables.add(new Table(i,12));// 12pax x 2
		}
	}
}