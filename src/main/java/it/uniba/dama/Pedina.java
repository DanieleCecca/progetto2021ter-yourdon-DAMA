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

    private String colore;
    private String simbolo;

    public Pedina() {

    }

    public Pedina(final String nuovoColore, final String nuovoSimbolo) {
        this.colore = nuovoColore;
        this.simbolo = nuovoSimbolo;
    }

    public final String getColore() {
        return colore;
    }

    public final void setColore(final String nuovoColore) {
        this.colore = nuovoColore;
    }

    public final String getSimbolo() {
        return simbolo;
    }

    public final void setSimbolo(final String nuovoSimbolo) {
        this.simbolo = nuovoSimbolo;
    }

}
