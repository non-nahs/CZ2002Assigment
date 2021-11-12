package controller;

import entity.Reservation;

public class ReservationMgr {

	//public void createReservation() {
		//return new Reservation();
	//}
	public Reservation createReservation(){
		return new Reservation();
	}

	public void viewReservation() {
		clearExpiry();
		// TODO - implement ReservationMgr.viewReservation
		throw new UnsupportedOperationException();
	}

	public void removeReservation() {
		// TODO - implement ReservationMgr.removeReservation
		throw new UnsupportedOperationException();
	}

	private void clearExpiry() {
		// TODO - implement ReservationMgr.timeoutReservation
		throw new UnsupportedOperationException();
	}

	public void checkTableAvail() {
		// TODO - implement ReservationMgr.checkTableAvail
		throw new UnsupportedOperationException();
	}

}