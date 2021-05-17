package it.uniba.dama;

import it.uniba.utilita.Cronometro;
import it.uniba.utilita.Costanti;
import it.uniba.utilita.Interfaccia;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Classe che rappresenta la partita corrente <br>
 * Tipo di classe: <b>Control</b> <br>
 * Responsabilità:
 * <ul>Knows:
 *      <li>Giocatore nero</li>
 *      <li>Giocatore bianco</li>
 *      <li>La damiera di gioco</li>
 *      <li>Valore che indica se la partita è in corso</li>
 *      <li>Valore che indica il turno di appartenenza(bianco o nero)</li>
 *      <li>Il tempo di gioco iniziale</li>
 *      <li>Una lista di mosse giocate in ordine cronologico</li></ul>
 * <ul>Does:
 *      <li>Istanzia la damiera da gioco, il valore della partita in corso
 *      a falso e la lista di mosse giocate</li>
 *      <li>Ottiene e setta il giocatore bianco</li>
 *      <li>Ottiene e setta il giocatore nero</li>
 *      <li>Ottiene e setta la damiera da gioco</li>
 *      <li>Ottiene e setta il valore della partita in corso</li>
 *      <li>Ottiene e setta il turno di appartenenza</li>
 *      <li>Ottiene e setta il tempo di gioco iniziale</li>
 *      <li>Permette di avviare la partita (settando come giocatore iniziale il bianco)
 *      e di ricevere i comandi relativi alle mosse di gioco</li>
 *      <li>Verifica che la sintassi del comando inserito, quando
 *      viene effettuata una mossa, sia valido</li>
 *      <li>Permette di abbandonare la partita e dichiarare come vincitore il giocatore avversario</li>
 *      <li>Permette di visualizzare il tempo trascorso per entrambi i giocatori</li>
 *      <li>Permette di cambiare il turno del giocatore</li>
 *      <li>Permette di visualizzare le prese effettuate durante la partita</li>
 *      <li>Permette di visualizzare le mosse effettuate durante la partita</li>
 *      <li>Aggiunge una mossa nella lista di mosse giocate</li></ul>
 */

public final class Partita {
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

    public void setBianco(final Giocatore coloreBianco) {
        this.bianco = coloreBianco;
    }

    public Giocatore getNero() {
        return nero;
    }

    public void setNero(final Giocatore coloreNero) {
        this.nero = coloreNero;
    }

    public Damiera getTavolo() {
        return tavolo;
    }

    public void setTavolo(final Damiera nuovoTavolo) {
        this.tavolo = nuovoTavolo;
    }

    public boolean getInCorso() {
        return inCorso;
    }

    public void setInCorso(final boolean nuovoStato) {
        this.inCorso = nuovoStato;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(final String nuovoTurno) {
        this.turno = nuovoTurno;
    }

    public Cronometro getTempoIniziale() {
        return tempoIniziale;
    }

    public void setTempoIniziale(final Cronometro nuovoTempoIniziale) {
        this.tempoIniziale = nuovoTempoIniziale;
    }

    public void gioca() {
        bianco = new Giocatore("bianco");
        nero = new Giocatore("nero");
        tavolo = new Damiera();
        tavolo.popolaDamiera();
        cronologiaMosse = new ArrayList<>();
        inCorso = true;
        turno = "bianco";

        bianco.getCronometro().start();

        while (inCorso) {

            Interfaccia.stampaMessaggio(Costanti.INSERIRE_COMANDO);
            String comando = Interfaccia.acquisireComando();

            if (controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO)) {
                boolean spostamentoEseguito;
                if (turno.equals("bianco")) {
                    spostamentoEseguito = tavolo.spostamentoSemplice(bianco, comando);
                } else {
                    spostamentoEseguito = tavolo.spostamentoSemplice(nero, comando);
                }
                if (spostamentoEseguito) {
                    aggiungiMossa(comando);
                    cambiaTurno();
                }
            } else if (controlloSintassi(comando, Costanti.PATTERN_PRESA)) {
                boolean spostamentoEseguito;
                if (turno.equals("bianco")) {
                    spostamentoEseguito = tavolo.presaSemplice(bianco, comando);
                } else {
                    spostamentoEseguito = tavolo.presaSemplice(nero, comando);
                }
                if (spostamentoEseguito) {
                    aggiungiMossa(comando);
                    cambiaTurno();
                }
            } else if (controlloSintassi(comando, Costanti.PATTERN_PRESA_MULTIPLA)) {
                boolean spostamentoEseguito;
                if (turno.equals("bianco")) {
                    spostamentoEseguito = tavolo.presaMultipla(bianco, comando);
                } else {
                    spostamentoEseguito = tavolo.presaMultipla(nero, comando);
                }
                if (spostamentoEseguito) {
                    aggiungiMossa(comando);
                    cambiaTurno();
                }
            } else {
                switch (comando) {
                    case "help":
                        Interfaccia.helpPartita();
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
                        Interfaccia.esci();
                        break;

                    case "tempo":
                        tempo();
                        break;

                    case "gioca":
                        Interfaccia.stampaMessaggio(Costanti.ERR_PARTITA_GIA_INIZIATA);
                        break;

                    case "prese":
                        prese();
                        break;

                    case "mosse":
                        mosse();
                        break;

                    default:
                        Interfaccia.stampaMessaggio(Costanti.ERR_COMANDO_INESISTENTE);
                        break;
                }
            }
        }

    }

    private boolean controlloSintassi(final String comando, final String stringa) {
        boolean corretto = false;
        String comandoTrim = comando.replaceAll("\\s", "");

        try {
            Pattern pattern = Pattern.compile(stringa);

            if (comandoTrim.matches(pattern.pattern())) {
                corretto = true;
            }
        } catch (Exception eccezioneSpostamento) {
        }
        return corretto;
    }


    public void abbandona() {
        String conferma;
        do {
            Interfaccia.stampaMessaggio(Costanti.RICHIESTA_ABBANDONA_PARTITA);
            conferma = Interfaccia.acquisireComando();
            if (!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no")) {
                Interfaccia.stampaMessaggio(Costanti.ERR_RISPOSTA_NON_VALIDA);
            }
        } while (!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"));

        if (conferma.equalsIgnoreCase("si")) {
            inCorso = false;
            if (turno.equals("bianco")) {
                Interfaccia.stampaMessaggio(Costanti.GIOCATORE_NERO_VINCE);
            } else {
                Interfaccia.stampaMessaggio(Costanti.GIOCATORE_BIANCO_VINCE);
            }
        }
    }

    public void tempo() {
        Interfaccia.stampaMessaggio("+----------------------------+\n"
                + "|   " + Costanti.TEMPO_GIOCATORE_BIANCO + "   |\n"
                + "+----------------------------+\n"
                + "|     ");
        Interfaccia.stampaMessaggio(bianco.getCronometro().tempoTrascorso());
        Interfaccia.stampaMessaggio("       |\n"
                + "+----------------------------+\n");

        Interfaccia.stampaMessaggio("+----------------------------+\n"
                + "|   " + Costanti.TEMPO_GIOCATORE_NERO + "     |\n"
                + "+----------------------------+\n"
                + "|     ");
        Interfaccia.stampaMessaggio(nero.getCronometro().tempoTrascorso());
        Interfaccia.stampaMessaggio("       |\n"
                + "+----------------------------+\n\n");
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
        Interfaccia.stampaMessaggio("\nTurno del giocatore: " + turno + "\n");
    }

    public void prese() {
        Interfaccia.stampaMessaggio("+-------------------------------\n"
                + "|   " + Costanti.BIANCO + " ");
        for (int i = 0; i < bianco.getPedinePrese().size(); i++) {
            Interfaccia.stampaMessaggio(bianco.getPedinePrese().get(i).getSimbolo());
        }

        Interfaccia.stampaMessaggio("\n+-------------------------------\n"
                + "|   " + Costanti.NERO + "   ");
        for (int i = 0; i < nero.getPedinePrese().size(); i++) {
            Interfaccia.stampaMessaggio(nero.getPedinePrese().get(i).getSimbolo());
        }
        Interfaccia.stampaMessaggio("\n+-------------------------------\n\n");
    }


    public void mosse() {

        Interfaccia.stampaMessaggio("+--------------------------+\n"
                + "|   |     " + Costanti.MOSSE_GIOCATE + "    \n"
                + "+--------------------------+");
        for (int i = 0; i < cronologiaMosse.size(); i++) {
            Interfaccia.stampaMessaggio("\n"
                    + "| " + cronologiaMosse.get(i) + "                 ");
        }
        Interfaccia.stampaMessaggio("\n+--------------------------+\n\n");
    }

    public void aggiungiMossa(final String comando) {
        if (this.turno.equals("bianco")) {
            cronologiaMosse.add("B | " + comando);
        } else {
            cronologiaMosse.add("N | " + comando);
        }
    }

}
