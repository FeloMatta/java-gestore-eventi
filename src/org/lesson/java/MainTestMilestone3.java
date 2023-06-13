package org.lesson.java;

import org.lesson.java.customExeption.InvalidDateException;
import org.lesson.java.customExeption.InvalidNumberOfSeatsException;
import org.lesson.java.customExeption.NullValueException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainTestMilestone3 {
    public static <InputMismatchException extends Throwable> void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Concert myConcert = null;

        do {
            try {
                System.out.println("Inserisci il nome del concerto: ");
                String title = scan.nextLine();
                System.out.println("Inserisci la data dell'vento in formato ISO: ");
                LocalDate date = LocalDate.parse(scan.nextLine());
                System.out.println("Inserisci il numero di posti totali: ");
                int totalSeats = scan.nextInt();
                scan.nextLine();
                System.out.println("Inserisci l'ora dell'evento: ");
                LocalTime hour = LocalTime.parse(scan.nextLine());
                System.out.println("Inserisci il prezzo: ");
                BigDecimal price = scan.nextBigDecimal();

                myConcert = new Concert(title, LocalDate.parse("2023-10-10"), totalSeats, hour, price);

            } catch (NullValueException e) {
                System.out.println("L'evento deve avere un titolo \n");
            } catch (InvalidDateException e) {
                System.out.println("L'evento deve avere una data valida \n");
            } catch (InvalidNumberOfSeatsException e) {
                System.out.println("L'evento deve avere un numero di posti positivo e maggiore di 0 \n");
            } catch (DateTimeParseException e) {
                System.out.println("Il formato fornito nella data non è di tipo ISO \n");
            } catch (IllegalArgumentException e) {
                System.out.println("Il prezzo non è valido \n");
            }
        } while (myConcert == null);

        System.out.println(myConcert + "\n");

    }
}