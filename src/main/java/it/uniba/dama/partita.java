package it.uniba.dama;

import it.uniba.main.AppMain;
import it.uniba.utilita.cronometro;

import java.util.Scanner;


public class partita {
    private giocatore bianco;
    private giocatore nero;
    private damiera tavolo;
    private boolean inCorso;
    private String turno;
    private cronometro tempoIniziale;

    public partita() {
        tavolo = new damiera();
        inCorso = false;
    }

    public giocatore getBianco() {
        return bianco;
    }

    public void setBianco(giocatore bianco) {
        this.bianco = bianco;
    }

    public giocatore getNero() {
        return nero;
    }

    public void setNero(giocatore nero) {
        this.nero = nero;
    }

    public damiera getTavolo() {
        return tavolo;
    }

    public void setTavolo(damiera tavolo) {
        this.tavolo = tavolo;
    }

    public boolean isInCorso() {
        return inCorso;
    }

    public void setInCorso(boolean inCorso) {
        this.inCorso = inCorso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public cronometro getTempoIniziale() {
        return tempoIniziale;
    }

    public void setTempoIniziale(cronometro tempoIniziale) {
        this.tempoIniziale = tempoIniziale;
    }

    public void gioca() {
        bianco = new giocatore("bianco");
        nero = new giocatore("nero");
        tavolo.popolaDamiera();
        inCorso = true;
        turno = "bianco";

        tempoIniziale = new cronometro();

        while (inCorso) {
            Scanner inputTastiera = new Scanner(System.in);
            System.out.print("Inserisci comando: ");
            String comando = inputTastiera.nextLine();

            switch (comando) {

                case "damiera":
                    tavolo.stampaDamieraGioco();
                    break;

                case "numeri":
                    tavolo.stampaDamieraNumerata();
                    break;

                case "abbandona":
                    abbandona();
                    break;

                case "esci":
                    AppMain.esci();
                    break;

                case "tempo":
                    tempo();
                    break;

                default:
                    System.out.println("Comando inesistente.");
                    break;
            }
        }
    }

    public void abbandona() {
        Scanner inputTastiera = new Scanner(System.in);
        String conferma;
        do {
            System.out.print("Sei sicuro di voler abbandonare? (si/no) ");
            conferma = inputTastiera.nextLine();
            if (!conferma.equals("si") && !conferma.equals("no"))
                System.out.println("Comando inesistente.");
        } while (!conferma.equals("si") && !conferma.equals("no"));

        if (conferma.equals("si")) {
            inCorso = false;
            if (turno.equals("bianco"))
                System.out.println("Partita abbandonata: il nero ha vinto.");
            else
                System.out.println("Partita abbandonata: il bianco ha vinto.");
        }
    }

    public void tempo() {
        cronometro tempoCorrente = new cronometro();
        cronometro.stampaTempoTrascorso(tempoIniziale.getTempo(), tempoCorrente.getTempo());
    }
}
