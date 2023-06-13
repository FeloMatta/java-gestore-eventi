package org.lesson.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Creo l'evento
            LocalDate dataEvento = LocalDate.of(2023, 6, 30);
            Evento evento = new Evento("Concerto", dataEvento, 100);

            // Prenoto alcuni posti
            evento.prenota();
            evento.prenota();
            evento.prenota();

            // Disdico un posto
            evento.disdici();

            // visualizzo le informazioni dell'evento
            System.out.println("Informazioni evento: ");
            System.out.println("Titolo: " + evento.getTitolo());
            System.out.println("Data: " + evento.getData());
            System.out.println("Posti totali: " + evento.getPostiTotali());
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Stringa rappresentante l'evento: " + evento.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Errore nell'inizializzazione dell'evento: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Errore nell'operazione: " + e.getMessage());
        }
    }
}
