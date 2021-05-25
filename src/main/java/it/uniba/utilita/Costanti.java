package it.uniba.utilita;

import it.uniba.dama.Pedina;
import it.uniba.dama.Dama;

/**
 * Classe che contiene le costante usate in questa applicazione
 * Tipo di classe: <b>noECB</b><br>;
 * Responsabilità:
 * <ul>Knows:
 *      <li>I valori delle variabili costanti usate in questa applicazione</li>
 * </ul>
 */

public final class Costanti {
    /**
     * Costruttore privato di default della classe Costanti.
     */
    private Costanti() {
    }

    public static final Pedina PEDINA_BIANCA = new Pedina("bianco", "\u26C2");
    public static final Pedina PEDINA_NERA = new Pedina("nero", "\u26C0");

    public static final Dama DAMA_BIANCA = new Dama("bianco", "\u26C3");
    public static final Dama DAMA_NERA = new Dama("nero", "\u26C1");

    public static final String UNICODE_PEDINA_BIANCA = "\u26C2";
    public static final String UNICODE_PEDINA_NERA = "\u26C0";
    public static final String UNICODE_DAMA_BIANCA = "\u26C1";
    public static final String UNICODE_DAMA_NERA = "\u26C3";
    public static final String SPAZIO_CORTO = "\u202F";

    /**
     * Stringhe costanti che indicano i Pattern validi per le mosse.
     */
    public static final String PATTERN_SPOSTAMENTO = "(0?[1-9]|[1-2][0-9]|3[0-2])(-)(0?[1-9]|[1-2][0-9]|3[0-2])";
    public static final String PATTERN_PRESA = "(0?[1-9]|[1-2][0-9]|3[0-2])((x)(0?[1-9]|[1-2][0-9]|3[0-2]))";
    public static final String PATTERN_PRESA_MULTIPLA = "(0?[1-9]|[1-2][0-9]|3[0-2])((x)(0?[1-9]|[1-2][0-9]|3[0-2]))+";

    public static final int DIM = 8;
    public static final int ORA_IN_SECONDI = 3600;
    public static final int MINUTO_IN_SECONDI = 60;
    public static final int SECONDO = 1000;

    public static final int ULTIMA_RIGA_INIZIALE_BIANCO = 3;
    public static final int ULTIMA_RIGA_INIZIALE_NERO = 5;
    public static final int NUM_PARI = 2;
    public static final int NUM_10 = 10;

    public static final int NUM_4 = 4;
    public static final int NUM_29 = 29;
    public static final int NUM_32 = 32;

    /**
     * Messaggi di interfaccia con l'utente.
     */
    public static final String INSERIRE_COMANDO = "Inserisci un comando: ";
    public static final String PARTITA_INIZIATA = "La partita è iniziata.\n";
    public static final String RICHIESTA_USCITA_APP = "Sei sicuro di voler uscire dall'applicazione? (si/no): ";
    public static final String RICHIESTA_ABBANDONA_PARTITA = "Sei sicuro di voler abbandonare? (si/no): ";
    public static final String APPLICAZIONE_CHIUSA = "Applicazione chiusa.\n";
    public static final String TAVOLO_GIOCO = "Tavolo da gioco:\n";
    public static final String GIOCATORE_BIANCO_VINCE = "Partita abbandonata: il bianco ha vinto.\n";
    public static final String GIOCATORE_NERO_VINCE = "Partita abbandonata: il nero ha vinto.\n";
    public static final String TEMPO_GIOCATORE_BIANCO = "Tempo giocatore bianco";
    public static final String TEMPO_GIOCATORE_NERO = "Tempo giocatore nero";
    public static final String BIANCO = "Bianco: ";
    public static final String NERO = "Nero: ";
    public static final String MOSSE_GIOCATE = "MOSSE GIOCATE";

    /**
     * Messaggi di errore.
     */
    public static final String ERR_PARTITA_NON_INIZIATA = "La partita non è ancora iniziata. Inserisci il comando"
            + " 'gioca' per iniziare una nuova partita.\n";
    public static final String ERR_PARTITA_GIA_INIZIATA = "La partita e' gia iniziata.\n";
    public static final String ERR_COMANDO_INESISTENTE = "Comando inesistente.\n";
    public static final String ERR_RISPOSTA_NON_VALIDA = "Risposta non valida.\n";
    public static final String ERR_CASELLA_OCCUPATA = "La casella è già occupata.\n";
    public static final String ERR_CASELLA_VUOTA = "La casella è vuota.\n";
    public static final String ERR_MOSSA_NON_VALIDA = "Mossa non valida.\n";
    public static final String ERR_APPERTENENZA_PEDINA = "La pedina appartiene all'altro giocatore.\n";
}
