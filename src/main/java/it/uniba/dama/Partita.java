package it.uniba.dama;


import it.uniba.main.AppMain;
import it.uniba.utilita.Comandi;
import it.uniba.utilita.Cronometro;


import java.util.Scanner;
import java.util.regex.Pattern;


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

    private void cambiaTurno() {
        if (turno.equals("bianco")) {
            setTurno("nero");
        } else {
            setTurno("bianco");
        }
        System.out.println("Turno del giocatore: " + turno );
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

            if (controlloSintassiCorretta(comando)) {
                boolean spostamentoEseguito;
                if (turno.equals("bianco")) {
                    spostamentoEseguito=tavolo.spostamentoSemplice(bianco, comando);
                } else {
                    spostamentoEseguito=tavolo.spostamentoSemplice(nero, comando);
                }
                if(spostamentoEseguito){
                    cambiaTurno();
                }



            } else {
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

    }

    private boolean controlloSintassiCorretta(String comando) {
        //comando = comando.trim();
        boolean corretto = false;
        comando = comando.replaceAll("\\s", "");

        try {
            String primaParteComando = comando.substring(0, comando.indexOf('-'));
            String secondaParteComando = comando.substring(comando.indexOf('-') + 1);
            Pattern pattern = Pattern.compile("\\b(0?[1-9]|[1-2][0-9]|3[0-2])\\b");

            if (primaParteComando.matches(pattern.pattern()) && secondaParteComando.matches(pattern.pattern())) {
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
