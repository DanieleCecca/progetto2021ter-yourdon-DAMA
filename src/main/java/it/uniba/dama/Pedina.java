package it.uniba.dama;

/**
 * Classe che rappresenta la Pedina del gioco della dama con il relativo simbolo e colore<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * <ul>Knows:
 *     <li>Il colore relativo alla pedina</li>
 *     <li>Il simbolo relativo alla pedina(in UNICODE)</li></ul>
 *
 * <ul>Does:
 *        <li>Istanzia il colore e simbolo della pedina</li>
 *     <li>Ottiene il colore della pedina</li>
 *     <li>Ottiene il simbolo della pedina</li></ul>
 */
public class Pedina {

    /**
     * Rappresenta il colore della pedina.
     */
    private String colore;
    /**
     * Rappresenta il simbolo della pedina.
     */
    private String simbolo;

    /**
     * Costruttore di default della classe Pedina.
     */
    public Pedina() {

    }
    /**
     * Costruttore per la classe Pedina.
     * Inizializza il colore e il simbolo della pedina.
     *
     * @param nuovoColore il colore della pedina
     * @param nuovoSimbolo il simbolo della pedina
     */
    public Pedina(final String nuovoColore, final String nuovoSimbolo) {
        this.colore = nuovoColore;
        this.simbolo = nuovoSimbolo;
    }

    /**
     * Metodo get per colore.
     *
     * @return il colore della pedina
     */
    public final String getColore() {
        return colore;
    }

    /**
     * Metodo set per colore.
     *
     * @param nuovoColore il nuovo colore della pedina
     */
    public final void setColore(final String nuovoColore) {
        this.colore = nuovoColore;
    }

    /**
     * Metodo get per simbolo.
     *
     * @return il simbolo della pedina
     */
    public final String getSimbolo() {
        return simbolo;
    }

    /**
     * Metodo set per simbolo.
     *
     * @param nuovoSimbolo il nuovo simbolo della pedina
     */
    public final void setSimbolo(final String nuovoSimbolo) {
        this.simbolo = nuovoSimbolo;
    }

}
