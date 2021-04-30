package it.uniba.dama;


import it.uniba.main.AppMain;
import it.uniba.utilita.Comandi;
import it.uniba.utilita.Cronometro;
import it.uniba.utilita.Costanti;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Partita {
    private Giocatore bianco;
    private Giocatore nero;
    private Damiera tavolo;
    private boolean inCorso;
    private String turno;
    private Cronometro tempoIniziale;
    private ArrayList<String> cronologiaMosse;

    public Partita() {
        tavolo = new Damiera();
        inCorso = false;
        cronologiaMosse = new ArrayList<>();
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
        tavolo = new Damiera();
        tavolo.popolaDamiera();
        inCorso = true;
        turno = "bianco";

        bianco.getCronometro().start();

        while (inCorso) {

            Scanner inputTastiera = new Scanner(System.in);
            System.out.print("Inserisci comando: ");
            String comando = inputTastiera.nextLine();

            if (controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO)) {
                boolean spostamentoEseguito;
                if (turno.equals("bianco")) {
                    spostamentoEseguito=tavolo.spostamentoSemplice(bianco, comando);
                } else {
                    spostamentoEseguito=tavolo.spostamentoSemplice(nero, comando);
                }
                if(spostamentoEseguito){
                    aggiungiMossa(comando);
                    cambiaTurno();
                }
            }
            else if (controlloSintassi(comando, Costanti.PATTERN_PRESA)) {
                boolean spostamentoEseguito;
                if (turno.equals("bianco")) {
                    spostamentoEseguito=tavolo.presaSemplice(bianco, comando);
                } else {
                    spostamentoEseguito=tavolo.presaSemplice(nero, comando);
                }
                if(spostamentoEseguito) {
                    aggiungiMossa(comando);
                    cambiaTurno();
                }
            }
            else if (controlloSintassi(comando, Costanti.PATTERN_PRESA_MULTIPLA)) {
                boolean spostamentoEseguito;
                if (turno.equals("bianco")) {
                    spostamentoEseguito=tavolo.presaMultipla(bianco, comando);
                } else {
                    spostamentoEseguito=tavolo.presaMultipla(nero, comando);
                }
                if(spostamentoEseguito) {
                    aggiungiMossa(comando);
                    cambiaTurno();
                }
            }
            else {
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

                    case "prese":
                        prese();
                        break;

                    case "mosse":
                        mosse();
                        break;

                    default:
                        System.out.println("Comando inesistente.");
                        break;
                }
            }
        }

    }

    private boolean controlloSintassi(String comando,final String stringa) {
        boolean corretto = false;
        comando = comando.replaceAll("\\s", "");

        try {
            Pattern pattern = Pattern.compile(stringa);

            if (comando.matches(pattern.pattern())) {
                corretto = true;
            }
        } catch (Exception eccezioneSpostamento) {
        }
        return corretto;
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

    private void cambiaTurno() {
        if (turno.equals("bianco")) {
            setTurno("nero");
            bianco.getCronometro().setContinua(false);
            bianco.setTempoPrecedente(bianco.getCronometro().getSecondi());

            nero.resettaCronometro();
            nero.getCronometro().start();
        } else {
            setTurno("bianco");
            nero.getCronometro().setContinua(false);
            nero.setTempoPrecedente(nero.getCronometro().getSecondi());

            bianco.resettaCronometro();
            bianco.getCronometro().start();
        }
        System.out.println("Turno del giocatore: " + turno );
    }

    public void prese() {
        System.out.print("Bianco: ");
        for (int i=0;i<bianco.getPedinePrese().size();i++){
            System.out.print(bianco.getPedinePrese().get(i).getSimbolo());
        }

        System.out.print("\n" +"Nero: ");
        for (int i=0;i<nero.getPedinePrese().size();i++){
            System.out.print(nero.getPedinePrese().get(i).getSimbolo());
        }
        System.out.print("\n");
    }

    public void mosse(){
        System.out.print("Mosse giocate:\n");
        for (int i=0;i<cronologiaMosse.size();i++){
            System.out.println(cronologiaMosse.get(i));
        }
    }

    public void aggiungiMossa(String comando){
        if (this.turno == "bianco"){
            cronologiaMosse.add("B: " + comando);
        }
        else {
            cronologiaMosse.add("N: " + comando);
        }
    }
}
