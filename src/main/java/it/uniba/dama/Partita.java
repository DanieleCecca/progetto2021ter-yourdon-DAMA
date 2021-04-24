package it.uniba.dama;


import it.uniba.main.AppMain;
import it.uniba.utilita.Comandi;
import it.uniba.utilita.Cronometro;
import jdk.tools.jlink.internal.plugins.SystemModulesPlugin;

import java.util.Scanner;


public class Partita {
    private Giocatore bianco;
    private Giocatore nero;
    private Damiera tavolo;
    private boolean inCorso;
    private String turno;
    private Cronometro tempoIniziale;

    public Partita() {
        tavolo = new Damiera();
        inCorso = false;
    }

    public Giocatore getBianco() {
        return bianco;
    }

    public void setBianco(Giocatore bianco) {
        this.bianco = bianco;
    }

    public Giocatore getNero() {
        return nero;
    }

    public void setNero(Giocatore nero) {
        this.nero = nero;
    }

    public Damiera getTavolo() {
        return tavolo;
    }

    public void setTavolo(Damiera tavolo) {
        this.tavolo = tavolo;
    }

    public boolean getInCorso() {
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

    public Cronometro getTempoIniziale() {
        return tempoIniziale;
    }

    public void setTempoIniziale(Cronometro tempoIniziale) {
        this.tempoIniziale = tempoIniziale;
    }

    public void gioca() {
        bianco = new Giocatore("bianco");
        nero = new Giocatore("nero");
        tavolo.popolaDamiera();
        inCorso = true;
        turno = "bianco";

        bianco.getCronometro().start();

        while (inCorso) {
            Scanner inputTastiera = new Scanner(System.in);
            System.out.print("Inserisci comando: ");
            String comando = inputTastiera.nextLine();

            switch (comando) {
                case "help":
                    Comandi.helpPartita();
                    break;

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

                case "gioca":
                    System.out.println("La partita e' gia iniziata.");
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
        System.out.println("\nTempo giocatore bianco: ");
        bianco.getCronometro().stampaTempoTrascorso();

        System.out.println("Tempo giocatore nero: ");
        nero.getCronometro().stampaTempoTrascorso();

    }

    /*if(turno.equals("bianco")){
        turno = "nero";

        bianco.cronometro.continua = false;
        bianco.tempoPrecedente = bianco.cronometro.secondi;

        nero.cronometro = new Cronometro(nero.tempoPrecedente);
        nero.cronometro.start();

    }
    else {
        turno = "bianco";

        nero.cronometro.continua = false;
        nero.tempoPrecedente = nero.cronometro.secondi;

        bianco.cronometro = new Cronometro(bianco.tempoPrecedente);
        bianco.cronometro.start();
    }*/
}
