package it.uniba.dama;

/**
 * Classe che rappresenta la Pedina del gioco della dama con il relativo simbolo e colore<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * 		<ul>Knows:
 * 		    <li>Il colore relativo alla pedina</li>
 * 		    <li>Il simbolo relativo alla pedina(in UNICODE)</li></ul>
 *
 * 		<ul>Does:
 * 	        <li>Istanzia il colore e simbolo della pedina</li>
 * 		    <li>Ottiene il colore della pedina</li>
 * 		    <li>Ottiene il simbolo della pedina</li></ul>
 */
public class Pedina {

    private String colore;
    private String simbolo;

    public Pedina() {

    }

    public Pedina(String colore, String simbolo) {
        this.colore = colore;
        this.simbolo = simbolo;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

}
