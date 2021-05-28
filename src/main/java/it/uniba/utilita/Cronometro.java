package it.uniba.utilita;

/**
 * Classe che permette di calcolare il tempo in run-time <br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilita:
 * Knows:
 *    <ul>
 *      <li>Il tempo calcolato in secondi</li>
 *      <li>Un valore che permette di fermare il tempo</li></ul>
 * Does:
 *    <ul>
 *     <li>Istanzia il tempo in secondi</li>
 *     <li>Ottiene i secondi</li>
 *     <li>Setta il valore che permette di fermare il tempo</li>
 *     <li>Calcola il tempo in run-time</li>
 *     <li>Stampa il tempo trascorso</li></ul>
 */
public final class Cronometro extends Thread {

    /**
     * Rappresenta i secondi passati.
     */
    private int secondi = 0;
    /**
     * Rappresenta un'entità di tipo booleana che serve a stabilire quando riprendere il calcolo del tempo.
     */
    private boolean continua = true;

    /**
     * Costruttore della classe Cronometro.
     * Inizializza i secondi con i secondi trascorsi nel turno precdente.
     *
     * @param tempoPrecedente i secondi trascorsi nel turno precdente
     */
    public Cronometro(final int tempoPrecedente) {
        secondi = tempoPrecedente;
    }

    /**
     * Metodo get per secondi.
     *
     * @return i secondi di cronometro ossia il tempo trascorso in sec
     */
    public int getSecondi() {
        return secondi;
    }

    /**
     * Metodo set per secondi.
     *
     * @param nuoviSecondi i nuovi secondi ossia il nuovo tempo trascorso in sec
     */
    public void setSecondi(final int nuoviSecondi) {
        this.secondi = nuoviSecondi;
    }

    /**
     * Metodo get per continua.
     *
     * @return lo stato di continua
     */
    public boolean getContinua() {
        return continua;
    }

    /**
     * Metodo set per continua.
     *
     * @param nuovoStato il nuovo stato
     */
    public void setContinua(final boolean nuovoStato) {
        this.continua = nuovoStato;
    }

    /**
     * Metodo che permette di iniziare a calcolare il tempo trascorso.
     */
    public void run() {
        try {
            while (continua) {
                Thread.sleep(Costanti.SECONDO);
                secondi++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo che permette di ottenere il tempo trascorso in h min sec
     *
     * @return la stringa che indica il tempo trascorso nel formato : h min sec
     */
    public String tempoTrascorso() {
        int sec, minuti, ore;

        sec = this.secondi;
        ore = sec / Costanti.ORA_IN_SECONDI;
        minuti = (sec % Costanti.ORA_IN_SECONDI) / Costanti.MINUTO_IN_SECONDI;
        sec = (sec % Costanti.ORA_IN_SECONDI) % Costanti.MINUTO_IN_SECONDI;
        return (ore + " h " + minuti + " min " + sec + " sec ");
    }
}
