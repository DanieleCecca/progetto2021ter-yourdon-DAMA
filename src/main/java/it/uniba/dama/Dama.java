package it.uniba.dama;

/**
 * Sottoclasse di Pedina che rappresenta la Dama<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * <ul>Knows:
 *        <li>Il colore relativo alla dama</li>
 *        <li>Il simbolo relativo alla dama(in UNICODE)</li>
 *    </ul>
 *    <ul>Does:
 *        <li>Istanzia il colore e simbolo della dama utilizzando il costruttore della superclasse</li>
 *    </ul>
 */

public class Dama extends Pedina {
    public Dama() {
    }

    public Dama(final String colore, final String simbolo) {
        super(colore, simbolo);
    }
}
