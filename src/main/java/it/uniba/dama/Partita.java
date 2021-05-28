package it.uniba.dama;

import it.uniba.utilita.Costanti;
import it.uniba.main.AppMain;
import it.uniba.utilita.Interfaccia;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Classe che rappresenta la partita corrente <br>
 * Tipo di classe: <b>Control</b> <br>
 * Responsabilita:
 * Knows:
 * <ul>
 *     <li>Giocatore nero</li>
 *     <li>Giocatore bianco</li>
 *     <li>La damiera di gioco</li>
 *     <li>Valore che indica se la partita e' in corso</li>
 *     <li>Valore che indica il turno di appartenenza(bianco o nero)</li>
 *     <li>Il tempo di gioco iniziale</li>
 *     <li>Una lista di mosse giocate in ordine cronologico</li></ul>
 * Does:
 * <ul>
 *     <li>Istanzia la damiera da gioco, il valore della partita in corso
 *         a falso e la lista di mosse giocate</li>
 *     <li>Ottiene e setta il giocatore bianco</li>
 *     <li>Ottiene e setta il giocatore nero</li>
 *     <li>Ottiene e setta la damiera da gioco</li>
 *     <li>Ottiene e setta il valore della partita in corso</li>
 *     <li>Ottiene e setta il turno di appartenenza</li>
 *     <li>Ottiene e setta il tempo di gioco iniziale</li>
 *     <li>Permette di avviare la partita (settando come giocatore iniziale il bianco)
 *         e di ricevere i comandi relativi alle mosse di gioco</li>
 *     <li>Verifica che la sintassi del comando inserito, quando
 *         viene effettuata una mossa, sia valido</li>
 *     <li>Permette di abbandonare la partita e dichiarare come vincitore il giocatore avversario</li>
 *     <li>Permette di visualizzare il tempo trascorso per entrambi i giocatori</li>
 *     <li>Permette di cambiare il turno del giocatore</li>
 *     <li>Permette di visualizzare le prese effettuate durante la partita</li>
 *     <li>Permette di visualizzare le mosse effettuate durante la partita</li>
 *     <li>Aggiunge una mossa nella lista di mosse giocate</li></ul>
 */

public final class Partita {
    /**
     * Rappresenta il giocatore bianco della partita.
     */
    private Giocatore bianco;
    /**
     * Rappresenta il giocatore nero della partita.
     */
    private Giocatore nero;
    /**
     * Rappresenta la damiera della partita.
     */
    private Damiera tavolo;
    /**
     * Rappresenta lo stato della partita.
     */
    private boolean inCorso;
    /**
     * Rappresenta il turno della partita(bianco/nero).
     */
    private String turno;
    /**
     * Rappresenta la cronologia delle mosse giocate dai giocatori durante la partita.
     */
    private ArrayList<String> cronologiaMosse;

    /**
     * Costruttore della classe Partita.
     * Inizializza il tavolo da gioco (cioe' Damiera), il valore booleano inCorso e la lista cronologiaMosse.
     */
    public Partita() {
        tavolo = new Damiera();
        inCorso = false;
        cronologiaMosse = new ArrayList<>();
    }

    /**
     * Metodo get per bianco.
     *
     * @return il giocatore bianco
     */
    public Giocatore getBianco() {
        return bianco;
    }

    /**
     * Metodo set per bianco.
     *
     * @param coloreBianco il giocatore bianco
     */
    public void setBianco(final Giocatore coloreBianco) {
        this.bianco = coloreBianco;
    }

    /**
     * Metodo get per bero.
     *
     * @return il giocatore nero
     */
    public Giocatore getNero() {
        return nero;
    }

    /**
     * Metodo set per bero.
     *
     * @param coloreNero il giocatore Nero
     */
    public void setNero(final Giocatore coloreNero) {
        this.nero = coloreNero;
    }

    /**
     * Metodo get per tavolo.
     *
     * @return la damiera di gioco
     */
    public Damiera getTavolo() {
        return tavolo;
    }

    /**
     * Metodo set per tavolo.
     *
     * @param nuovoTavolo la nuova damiera di gioco
     */
    public void setTavolo(final Damiera nuovoTavolo) {
        this.tavolo = nuovoTavolo;
    }

    /**
     * Metodo get per inCorso.
     *
     * @return lo stato della partita (in corso o non)
     */
    public boolean getInCorso() {
        return inCorso;
    }

    /**
     * Metodo set per inCorso.
     *
     * @param nuovoStato nuovo stato della partita(in corso o non)
     */
    public void setInCorso(final boolean nuovoStato) {
        this.inCorso = nuovoStato;
    }

    /**
     * Metodo get per turno.
     *
     * @return il turno di appartenenza
     */
    public String getTurno() {
        return turno;
    }

    /**
     * Metodo set per turno.
     *
     * @param nuovoTurno il nuovo turno di appartenenza
     */
    public void setTurno(final String nuovoTurno) {
        this.turno = nuovoTurno;
    }

    /**
     * Metodo get per cronologiaMosse.
     *
     * @return la lista delle mosse giocate
     */
    public ArrayList<String> getCronologiaMosse() {
        return cronologiaMosse;
    }

    /**
     * Metodo set per cronologiaMosse.
     *
     * @param nuovaCronologiaMosse nuova lista contenente le mosse giocate
     */
    public void setCronologiaMosse(final ArrayList<String> nuovaCronologiaMosse) {
        this.cronologiaMosse = nuovaCronologiaMosse;
    }

    /**
     * Metodo che permette di inizializzare tutti i valori allo stato iniziale.
     * e permette l'input dell'utente.
     */
    public void inizio() {
        bianco = new Giocatore("bianco");
        nero = new Giocatore("nero");
        tavolo = new Damiera();
        tavolo.popolaDamiera();
        cronologiaMosse = new ArrayList<>();
        inCorso = true;
        turno = "bianco";
        bianco.getCronometro().start();

        String comando;
        while (inCorso) {
            AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.INSERIRE_COMANDO);
            comando = AppMain.SINGLETON.acquisireComandoInterfaccia();

            if (comando.equals("esci")) {
                Interfaccia.esci();
            } else {
                gioca(comando);
            }
        }
    }

    /**
     * Metodo che permette di elaborare l'input ricevuto e assiociare il comando(l'azione) corretta.
     *
     * @param comando comando che indica la successiva azione
     */
    public void gioca(final String comando) {
        if (controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO)) {
            try {
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
            } catch (DamieraException e) {
                AppMain.SINGLETON.stampaMessaggioInterfaccia(e.getMessage());
            }
        } else if (controlloSintassi(comando, Costanti.PATTERN_PRESA)) {
            try {
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
            } catch (DamieraException e) {
                AppMain.SINGLETON.stampaMessaggioInterfaccia(e.getMessage());
            }
        } else if (controlloSintassi(comando, Costanti.PATTERN_PRESA_MULTIPLA)) {
            try {
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
            } catch (DamieraException e) {
                AppMain.SINGLETON.stampaMessaggioInterfaccia(e.getMessage());
            }
        } else {
            switch (comando) {
                case "help":
                    AppMain.SINGLETON.helpPartita();
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
                    AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.ERR_PARTITA_GIA_INIZIATA);
                    break;

                case "prese":
                    prese();
                    break;

                case "mosse":
                    mosse();
                    break;

                default:
                    AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.ERR_COMANDO_INESISTENTE);
                    break;
            }
        }
    }

    /**
     * Metodo che permette di controllate la corretta sintassi delle mosse date in input.
     *
     * @param comando la mossa giocata
     * @param pattern il pattern con cui confrontare il comando
     * @return un booleano che indica se la sintassi del comando e' corretta o non corretta
     */
    boolean controlloSintassi(final String comando, final String pattern) {
        boolean corretto = false;
        String comandoTrim = comando.replaceAll("\\s", "");

        try {
            Pattern pat = Pattern.compile(pattern);

            if (comandoTrim.matches(pat.pattern())) {
                corretto = true;
            }
        } catch (Exception eccezioneSpostamento) {
        }
        return corretto;
    }

    /**
     * Metodo che permette al giocatore di abbandonare la partita.
     * <p>
     * Viene assegnata la sconfitta al giocatore che ha
     * abbandonato la partita.
     */
    public void abbandona() {
        String conferma;
        do {
            AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.RICHIESTA_ABBANDONA_PARTITA);
            conferma = AppMain.SINGLETON.acquisireComandoInterfaccia();
            if (!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no")) {
                AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.ERR_RISPOSTA_NON_VALIDA);
            }
        } while (!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"));

        if (conferma.equalsIgnoreCase("si")) {
            inCorso = false;
            if (turno.equals("bianco")) {
                AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.GIOCATORE_NERO_VINCE);
            } else {
                AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.GIOCATORE_BIANCO_VINCE);
            }
        }
    }

    /**
     * Metodo che permette di stampare il tempo di gioco dei giocatori.
     */
    public void tempo() {
        AppMain.SINGLETON.stampaMessaggioInterfaccia("+----------------------------+\n"
                + "|   " + Costanti.TEMPO_GIOCATORE_BIANCO + "   |\n"
                + "+----------------------------+\n"
                + "|     ");
        AppMain.SINGLETON.stampaMessaggioInterfaccia(bianco.getCronometro().tempoTrascorso());
        AppMain.SINGLETON.stampaMessaggioInterfaccia("       |\n"
                + "+----------------------------+\n");

        AppMain.SINGLETON.stampaMessaggioInterfaccia("+----------------------------+\n"
                + "|   " + Costanti.TEMPO_GIOCATORE_NERO + "     |\n"
                + "+----------------------------+\n"
                + "|     ");
        AppMain.SINGLETON.stampaMessaggioInterfaccia(nero.getCronometro().tempoTrascorso());
        AppMain.SINGLETON.stampaMessaggioInterfaccia("       |\n"
                + "+----------------------------+\n\n");
    }

    /**
     * Metodo che permette di cambiare il turno del giocatore.
     * <p>
     * Se il turno e' bianco allora lo cambia in nero
     * altrimenti lo cambia in bianco.
     */
    void cambiaTurno() {
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
        AppMain.SINGLETON.stampaMessaggioInterfaccia("\nTurno del giocatore: " + turno + "\n");
    }

    /**
     * Metodo che permette di stampare  le prese (e quindi le pedine) dei giocatori.
     */
    public void prese() {
        AppMain.SINGLETON.stampaMessaggioInterfaccia("+-------------------------------\n"
                + "|   " + Costanti.BIANCO + " ");
        for (int i = 0; i < bianco.getPedinePrese().size(); i++) {
            AppMain.SINGLETON.stampaMessaggioInterfaccia(bianco.getPedinePrese().get(i).getSimbolo());
        }

        AppMain.SINGLETON.stampaMessaggioInterfaccia("\n+-------------------------------\n"
                + "|   " + Costanti.NERO + "   ");
        for (int i = 0; i < nero.getPedinePrese().size(); i++) {
            AppMain.SINGLETON.stampaMessaggioInterfaccia(nero.getPedinePrese().get(i).getSimbolo());
        }
        AppMain.SINGLETON.stampaMessaggioInterfaccia("\n+-------------------------------\n\n");
    }

    /**
     * Metodo che permette di stampare le mosse effettuate dai giocatori.
     */
    public void mosse() {

        AppMain.SINGLETON.stampaMessaggioInterfaccia("+--------------------------+\n"
                + "|   |     " + Costanti.MOSSE_GIOCATE + "    \n"
                + "+--------------------------+");
        for (int i = 0; i < cronologiaMosse.size(); i++) {
            AppMain.SINGLETON.stampaMessaggioInterfaccia("\n"
                    + "| " + cronologiaMosse.get(i) + "                 ");
        }
        AppMain.SINGLETON.stampaMessaggioInterfaccia("\n+--------------------------+\n\n");
    }

    /**
     * Metodo che permette di aggiungere una mossa alla lista delle mosse del giocatore.
     *
     * @param mossa la mossa effettuata dal giocatore
     */
    public void aggiungiMossa(final String mossa) {
        if (this.turno.equals("bianco")) {
            cronologiaMosse.add("B | " + mossa);
        } else {
            cronologiaMosse.add("N | " + mossa);
        }
    }

}
