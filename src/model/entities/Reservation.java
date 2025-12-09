package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	
	public static DateTimeFormatter sdf= DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation() {
		
	}




	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	
	



	public Integer getRoomNumber() {
		return roomNumber;
	}




	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}




	public LocalDate getCheckin() {
		return checkin;
	}





	public LocalDate getCheckout() {
		return checkout;
	}



	public long duration() {
		long d = ChronoUnit.DAYS.between(checkin, checkout);
		
		return d;
		
	}
	
	
	public void updateDates(LocalDate checkin, LocalDate checkout) {
		this.checkin = checkin;
		this.checkout= checkout;
		
		
	}
	
	@Override
	public String toString() {
		return "Reservetion: Room "
				+ roomNumber
				+", check-in: "
				+ checkin.format(sdf)
				+", check-out: "
				+ checkout.format(sdf)
				+", "
				+ duration()
				+" nights";
				
	}
	
	
	

}
