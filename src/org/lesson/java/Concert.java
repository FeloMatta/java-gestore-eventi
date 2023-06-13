package org.lesson.java;

import org.lesson.java.customExeption.InvalidDateException;
import org.lesson.java.customExeption.InvalidNumberOfSeatsException;
import org.lesson.java.customExeption.NullValueException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event {
    private LocalTime hour;
    private BigDecimal price;

    Concert(String title, LocalDate date, int totalSeats, LocalTime hour, BigDecimal price) throws NullValueException, InvalidDateException, InvalidNumberOfSeatsException, IllegalArgumentException {
        super(title, date, totalSeats);
        this.hour = hour;

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        } else {
            this.price = price;
        }
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Concert{" +
                super.toString() +
                ", hour=" + hour +
                ", price=" + getPrice() +
                "€" +
                '}';
    }
}