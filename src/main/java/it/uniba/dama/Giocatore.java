package it.uniba.dama;

import it.uniba.utilita.Cronometro;
import java.util.ArrayList;

/**
 * CLasse che rappresenta il Giocatore <br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * 		<ul>Knows:
 * 		    <li>Il colore relativo al giocatore</li>
 * 		    <li>Il tempo di gioco totale del giocatore</li>
 * 		    <li>Il tempo di gioco del giocatore del turno precedente al turno corrente</li>
 * 		    <li>Una lista di pedine prese dal giocatore</li>
 * 		</ul>
 * 		<ul>Does:
 * 		    <li>Istanzia il colore del giocatore e il tempo iniziale</li>
 * 		    <li>Ottiene il tempo di gioco del giocatore</li>
 * 		    <li>Ottiene il colore del giocatore</li>
 * 		    <li>Setta il tempo di gioco del turno precedente al turno corrente</li>
 * 		</ul>
 */

public class Giocatore {
    private String colore;
    private  Cronometro cronometro;
    private int tempoPrecedente;
    private ArrayList<Pedina> pedinePrese = new ArrayList<Pedina>();

    public ArrayList<Pedina> getPedinePrese() {
        return pedinePrese;
    }

    public void setPedinePrese(Pedina pedinaPresa) {
        this.pedinePrese.add(pedinaPresa);
    }

    public Giocatore(String colore) {
        this.colore = colore;
        this.cronometro = new Cronometro(tempoPrecedente);
        tempoPrecedente = 0;
    }

    public void resettaCronometro()  {
        this.cronometro = new Cronometro(tempoPrecedente);
    }

    public Cronometro getCronometro() {
        return cronometro;
    }

    public void setCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
    }

    public int getTempoPrecedente() {
        return tempoPrecedente;
    }

    public void setTempoPrecedente(int tempoPrecedente) {
        this.tempoPrecedente = tempoPrecedente;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

}