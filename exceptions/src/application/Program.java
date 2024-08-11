package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.print("Check-in Date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out Date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: checkout date must be after checkin date");
        }else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in Date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
    
            System.out.print("Check-out Date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: reservation dates for update must be future dates!");
            }
            else if (!checkOut.after(checkIn)){
                System.out.println("Error in reservation: checkout date must be after checkin date");
            }
            else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();
    }
}
