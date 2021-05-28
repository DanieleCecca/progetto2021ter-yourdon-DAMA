package it.uniba.dama;

import it.uniba.utilita.Cronometro;

import java.util.ArrayList;

/**
 * CLasse che rappresenta il Giocatore <br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilita:
 * Knows:
 * <ul>
 *     <li>Il colore relativo al giocatore</li>
 *     <li>Il tempo di gioco totale del giocatore</li>
 *     <li>Il tempo di gioco del giocatore del turno precedente al turno corrente</li>
 *     <li>Una lista di pedine prese dal giocatore</li>
 * </ul>
 * Does:
 *    <ul>
 *     <li>Istanzia il colore del giocatore e il tempo iniziale</li>
 *     <li>Ottiene il tempo di gioco del giocatore</li>
 *     <li>Ottiene il colore del giocatore</li>
 *     <li>Setta il tempo di gioco del turno precedente al turno corrente</li>
 * </ul>
 */


public final class Giocatore {
    /**
     * Rappresenta il colore del giocatore.
     */
    private String colore;
    /**
     * Rappresenta il tempo effettivo di gioco del giocatore.
     */
    private Cronometro cronometro;
    /**
     * Rappresenta il tempo trascorso nel turno precedente a quello effettivo del giocatore.
     */
    private int tempoPrecedente = 0;
    /**
     * Rappresenta le pedine prese dal iocatore durante la partita.
     */
    private ArrayList<Pedina> pedinePrese = new ArrayList<Pedina>();

    /**
     * Costruttore della classe Giocatore
     *
     * @param nuovoColore il colore del giocatore
     */
    public Giocatore(final String nuovoColore) {
        this.colore = nuovoColore;
        this.cronometro = new Cronometro(tempoPrecedente);
        tempoPrecedente = 0;
    }

    /**
     * Metodo che permette di riprendere il calcolo del tempo dal turno precedente.
     */
    public void resettaCronometro() {
        this.cronometro = new Cronometro(tempoPrecedente);
    }

    /**
     * Metodo get per cronometro.
     *
     * @return il tempo efftivo trascorso per il giocatore
     */
    public Cronometro getCronometro() {
        return cronometro;
    }

    /**
     * Metodo set per cronometro.
     *
     * @param nuovoCronometro nuova Cronometro che riprende il tempo del Cronometro precedente.
     */
    public void setCronometro(final Cronometro nuovoCronometro) {
        this.cronometro = nuovoCronometro;
    }

    /**
     * Metodo get per tempoPrecedente.
     *
     * @return il tempo del turno precedente
     */
    public int getTempoPrecedente() {
        return tempoPrecedente;
    }

    /**
     * Metodo set per cronometro.
     *
     * @param nuovoTempoPrecedente nuovo tempo precedente.
     */
    public void setTempoPrecedente(final int nuovoTempoPrecedente) {
        this.tempoPrecedente = nuovoTempoPrecedente;
    }

    /**
     * Metodo get per colore.
     *
     * @return il colore del giocatore
     */
    public String getColore() {
        return colore;
    }

    /**
     * Metodo set per colore.
     *
     * @param nuovoColore nuova colore del giocatore.
     */
    public void setColore(final String nuovoColore) {
        this.colore = nuovoColore;
    }

    /**
     * Metodo get per le pedinePrese.
     *
     * @return la lista con le pedine prese dal giocatore.
     */
    public ArrayList<Pedina> getPedinePrese() {
        return pedinePrese;
    }

    /**
     * Metodo set per le pedinePrese che aggiunge una pedina alla lista ogni volta che viene richiamto.
     *
     * @param pedinaPresa la pedina presa
     */
    public void setPedinePrese(final Pedina pedinaPresa) {
        this.pedinePrese.add(pedinaPresa);
    }

}
