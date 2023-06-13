package org.lesson.java;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati = 0;

    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void prenota() throws IllegalStateException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Impossibile effettuare la prenotazione. L'evento è già passato.");
        }
        if (postiPrenotati >= postiTotali) {
            throw new IllegalStateException("Impossibile effettuare la prenotazione. Posti esauriti.");
        }
        postiPrenotati++;
    }

    public void disdici() throws IllegalStateException {
        if (!data.isBefore(LocalDate.now())) {
            if (postiPrenotati <= 0) {
                throw new IllegalStateException("Impossibile disdire la prenotazione. Nessuna prenotazione effettuata.");
            }

            postiPrenotati--;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormattata = formatter.format(data);
        return dataFormattata + " - " + titolo;
    }
}
