package org.lesson.java;

import org.lesson.java.customExeption.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int bookedSeats = 0;

    Event(String title, LocalDate date, int totalSeats) throws NullValueException, InvalidDateException, InvalidNumberOfSeatsException {

        if (title.isEmpty()) {
            throw new NullValueException();
        } else {
            this.title = title;
        }

        if (date.isBefore(LocalDate.now())) {
            throw new InvalidDateException();
        } else {
            this.date = date;
        }

        if (totalSeats <= 0) {
            throw new InvalidNumberOfSeatsException();
        } else {
            this.totalSeats = totalSeats;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new NullPointerException();
        } else {
            this.title = title;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new InvalidDateException();
        } else {
            this.date = date;
        }
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void bookSeat() throws InvalidBookedSeatException {
        if (this.bookedSeats > this.totalSeats || date.isBefore(LocalDate.now())) {
            throw new InvalidBookedSeatException();
        } else {
            this.bookedSeats = this.bookedSeats + 1;
        }
    }

    public void cancelBooking(int numberOfCancelBookSeats) throws InvalidCancelBookingException {
        if (this.bookedSeats <= numberOfCancelBookSeats || date.isBefore(LocalDate.now()) || numberOfCancelBookSeats < 0) {
            throw new InvalidCancelBookingException();
        } else {
            for (int i = 0; i < numberOfCancelBookSeats; i++) {
                this.bookedSeats = this.bookedSeats - 1;
            }
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
    }
}
