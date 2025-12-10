package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program_Hotel {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		DateTimeFormatter sdf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		try {
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
		checkin= LocalDate.parse(sc.next(), sdf);
		System.out.printf("Check-out Date (dd/MM/yyyy): ");
		checkout= LocalDate.parse(sc.next(), sdf);
		
		LocalDate now=  LocalDate.now();
		
		reservation.updateDates(checkin, checkout, now);
		
				
				
				
		System.out.println(reservation);
			
		}
		catch (DomainExceptions d) {
			System.out.println( d.getMessage());
		}
		catch (RuntimeException d) {
			System.out.println("Unexpected error");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
