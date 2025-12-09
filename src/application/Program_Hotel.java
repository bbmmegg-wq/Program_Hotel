package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program_Hotel {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		DateTimeFormatter sdf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		
		System.out.printf("Room number: ");
		int roomNumber= sc.nextInt();
		System.out.printf("Check-in Date (dd/MM/yyyy): ");
		LocalDate checkin= LocalDate.parse(sc.next(), sdf);
		System.out.printf("Check-out Date (dd/MM/yyyy): ");
		LocalDate checkout= LocalDate.parse(sc.next(), sdf);
		
		Reservation reservation= new Reservation(roomNumber, checkin, checkout);
		
		
		System.out.println(reservation);
		System.out.println();
		
		System.out.println("Enter data to update reservation: ");
		
		System.out.printf("Check-in Date (dd/MM/yyyy): ");
		LocalDate checkin1= LocalDate.parse(sc.next(), sdf);
		System.out.printf("Check-out Date (dd/MM/yyyy): ");
		LocalDate checkout1= LocalDate.parse(sc.next(), sdf);
		
		LocalDate now=  LocalDate.now();
		
		
		
		if( ! checkin.isAfter(now) || !checkout1.isAfter(now)) {
			
			System.out.println("Revervation dates for uptade must be future dates ");
		}
		else if ( !checkout.isAfter(checkin1)) {
			System.out.println("Error in reservation: Ckeck-out date must be after check-in date ");
		}
		else {
			reservation.updateDates(checkin1, checkout1);
			System.out.println(reservation);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
