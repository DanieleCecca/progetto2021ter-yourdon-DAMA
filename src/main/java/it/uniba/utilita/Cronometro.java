package it.uniba.utilita;

import java.util.Date;
import java.sql.Timestamp;

public class cronometro {
    private Date date;
    private Timestamp tempo;

    public cronometro() {
        date = new Date();
        tempo = new Timestamp(date.getTime());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTempo() {
        return tempo;
    }

    public void setTempo(Timestamp tempo) {
        this.tempo = tempo;
    }

    public static void stampaTempoTrascorso(Timestamp tempoIniziale, Timestamp tempoAttuale) {
        long millisecondi = tempoAttuale.getTime() - tempoIniziale.getTime();
        int secondi = (int) millisecondi / 1000;

        int ore = secondi / 3600;
        int minuti = (secondi % 3600) / 60;
        secondi = (secondi % 3600) % 60;

        System.out.println("Sono passate " + ore + " h " + minuti + " min " + secondi + " sec ");
    }
}