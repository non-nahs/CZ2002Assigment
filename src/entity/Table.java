package entity;

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

}