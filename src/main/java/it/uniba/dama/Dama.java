package it.uniba.dama;

/**
 * Sottoclasse di Pedina che rappresenta la Dama<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilita:
 * Knows:
 *   <ul>
 *       <li>Il colore relativo alla dama</li>
 *       <li>Il simbolo relativo alla dama(in UNICODE)</li>
 * </ul>
 *   Does:
 *   <ul>
 *       <li>Istanzia il colore e simbolo della dama utilizzando il costruttore della superclasse</li>
 * </ul>
 */

public class Dama extends Pedina {
    /**
     * Costruttore di default della classe Dama
     */
    public Dama() {
    }

    /**
     * Costruttore per la classe Dama.
     * Inizializza il colore e il simbolo della dama.
     *
     * @param nuovoColore  il colore della dama
     * @param nuovoSimbolo il simbolo della dama
     */
    public Dama(final String nuovoColore, final String nuovoSimbolo) {
        super(nuovoColore, nuovoSimbolo);
    }
}
