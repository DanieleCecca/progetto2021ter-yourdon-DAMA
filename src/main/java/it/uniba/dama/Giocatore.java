package it.uniba.dama;

import it.uniba.utilita.Cronometro;

public class Giocatore {
    private String colore;
    private  Cronometro cronometro;
    private int tempoPrecedente;

    public Giocatore(String colore) {
        this.colore = colore;
        this.cronometro = new Cronometro(tempoPrecedente);
        tempoPrecedente = 0;
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