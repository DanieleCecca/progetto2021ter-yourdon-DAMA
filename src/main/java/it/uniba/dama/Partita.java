package it.uniba.dama;

import it.uniba.utilita.Cronometro;
import it.uniba.utilita.Costanti;
import it.uniba.main.AppMain;
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

    /**
     * Costruttore di default della classe Partita.
     * Inizializza il tavolo da gioco (cioè Damiera), il valore booleano inCorso e la lista cronologiaMosse.
     */
    public Partita() {
        tavolo = new Damiera();
        inCorso = false;
        cronologiaMosse = new ArrayList<>();
    }

    /**
     * Metodo get per Bianco.
     *
     * @return il giocatore bianco
     */
    public Giocatore getBianco() {
        return bianco;
    }

    /**
     * Metodo set per Bianco.
     *
     * @param coloreBianco il giocatore bianco
     */
    public void setBianco(final Giocatore coloreBianco) {
        this.bianco = coloreBianco;
    }

    /**
     * Metodo get per Nero.
     *
     * @return il giocatore nero
     */
    public Giocatore getNero() {
        return nero;
    }

    /**
     * Metodo set per Nero.
     *
     * @param coloreNero il giocatore Nero
     */
    public void setNero(final Giocatore coloreNero) {
        this.nero = coloreNero;
    }

    /**
     * Metodo get per Tavolo.
     *
     * @return la damiera di gioco
     */
    public Damiera getTavolo() {
        return tavolo;
    }

    /**
     * Metodo set per Tavolo.
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
     *
     */
    public void setInCorso(final boolean nuovoStato) {
        this.inCorso = nuovoStato;
    }

    /**
     * Metodo get per Turno.
     *
     * @return il turno di appartenenza
     */
    public String getTurno() {
        return turno;
    }

    /**
     * Metodo set per Turno.
     *
     * @param nuovoTurno il nuovo turno di appartenenza
     */
    public void setTurno(final String nuovoTurno) {
        this.turno = nuovoTurno;
    }

    /**
     * Metodo get per tempoIniziale.
     *
     * @return il tempo di gioco iniziale
     */
    public Cronometro getTempoIniziale() {
        return tempoIniziale;
    }

    /**
     * Metodo set per tempoIniziale.
     *
     * @param nuovoTempoIniziale nuovo tempo di gioco iniziale
     */
    public void setTempoIniziale(final Cronometro nuovoTempoIniziale) {
        this.tempoIniziale = nuovoTempoIniziale;
    }

    /**
     * Metodo get per cronologiaMosse.
     *
     * @return la lista cronologiaMosse
     */
    public ArrayList<String> getCronologiaMosse() {
        return cronologiaMosse;
    }

    /**
     * Metodo set per cronologiaMosse.
     *
     * @param nuovaCronologiaMosse nuova lista di cronologiaMosse
     */
    public void setCronologiaMosse(final ArrayList<String> nuovaCronologiaMosse) {
        this.cronologiaMosse = nuovaCronologiaMosse;
    }

    /**
     * Inizializza tutti i valori allo stato iniziale
     * e avvia la partita di dama classica.
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
     * Effettua controlli sulla sintassi per i comandi di spostamenti e prese
     * e rende disponibili i comandi per la partita in corso.
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
                System.out.print(e.getMessage());
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
                System.out.print(e.getMessage());
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
                System.out.print(e.getMessage());
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
     * Controlla la corretta sintassi del comando dato in input.
     *
     * @param comando il comando esistente
     * @param stringa il comando dato in input dall'utente
     * @return la sintassi (corretta o non corretta)
     */
     boolean controlloSintassi(final String comando, final String stringa) {
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

    /**
     * Permette al giocatore di abbandonare la partita.
     *
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
     * Stampa il tempo di gioco dei giocatori.
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
     * Cambia il turno di gioco.
     *
     * Se turno è bianco allora lo cambia in nero
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
     * Stampa le prese (e quindi le pedine) dei giocatori.
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
     * Stampa le mosse effettuate dai giocatori.
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
     * Aggiunge una mossa alla lista delle mosse del giocatore.
     *
     * @param comando la mossa effettuata dal giocatore
     */
    public void aggiungiMossa(final String comando) {
        if (this.turno.equals("bianco")) {
            cronologiaMosse.add("B | " + comando);
        } else {
            cronologiaMosse.add("N | " + comando);
        }
    }

}
