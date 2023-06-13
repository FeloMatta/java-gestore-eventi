package org.lesson.java;

import org.lesson.java.customExeption.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Event myEvent = null;

        do {
            try {
                System.out.println("Inserisci il nome dell'evento: ");
                String title = scan.nextLine();
                // omitted code to speed up testing, LocalDate.parse("2023-10-10") at line 26 momentarily replace this lines
//                System.out.println("Inserisci la data dell'vento in formato ISO: ");
//                LocalDate date = LocalDate.parse(scan.nextLine());
                System.out.println("Inserisci il numero di posti totali: ");
                int totalSeats = scan.nextInt();
                scan.nextLine();

                myEvent = new Event(title, LocalDate.parse("2023-10-10"), totalSeats);

            } catch (NullValueException e) {
                System.out.println("L'evento deve avere un titolo \n");
            } catch (InvalidDateException e) {
                System.out.println("L'evento deve avere una data valida \n");
            } catch (InvalidNumberOfSeatsException e) {
                System.out.println("L'evento deve avere un numero di posti positivo e maggiore di 0 \n");
            } catch (DateTimeParseException e) {
                System.out.println("Il formato fornito nella data non è di tipo ISO \n");
            }
        } while (myEvent == null);

        System.out.println(myEvent + "\n");

        System.out.println("Vuoi effettuare prenotazioni? S/N");
        String bookYesOrNo = scan.nextLine();

        if (Objects.equals(bookYesOrNo, "S") || Objects.equals(bookYesOrNo, "s")) {

            boolean validBookedSeat = false;
            int seatLeft = myEvent.getTotalSeats() - myEvent.getBookedSeats();

            do {
                try {
                    System.out.println("Quanti posti vorresti prenotare: ");

                    int numberOfBookedSeats = scan.nextInt();
                    scan.nextLine();

                    if (numberOfBookedSeats > 0) {

                        for (int i = 0; i < numberOfBookedSeats; i++) {
                            myEvent.bookSeat();
                        }

                    } else {
                        throw new InvalidBookedSeatException();
                    }

                    seatLeft = seatLeft - numberOfBookedSeats;
                    validBookedSeat = true;

                } catch (InvalidBookedSeatException e) {
                    System.out.println("Input non valido, posti disponibili: " + seatLeft);
                }
            } while (!validBookedSeat);


            System.out.println("Posti totali: " + myEvent.getTotalSeats() + " Posti diponibili: " + seatLeft);
        }

        System.out.println("\n");

        System.out.println("Vuoi effettuare una disdetta? S/N");
        String cancelBookYesOrNo = scan.nextLine();

        if (Objects.equals(cancelBookYesOrNo, "S") || Objects.equals(cancelBookYesOrNo, "s")) {

            boolean validCancelBookedSeat = false;
            int seatLeft = myEvent.getTotalSeats() - myEvent.getBookedSeats();

            do {
                try {
                    System.out.println("Quanti posti vorresti disdire: ");

                    int numberOfCancelBookedSeats = scan.nextInt();
                    scan.nextLine();

                    myEvent.cancelBooking(numberOfCancelBookedSeats);

                    seatLeft = seatLeft + numberOfCancelBookedSeats;
                    validCancelBookedSeat = true;

                } catch (InvalidCancelBookingException e) {
                    System.out.println("Input non valido, posti prenotati cancellabili: " + myEvent.getBookedSeats());
                }
            } while (!validCancelBookedSeat);


            System.out.println("Posti totali: " + myEvent.getTotalSeats() + " Posti diponibili: " + seatLeft);
        }

    }
}
