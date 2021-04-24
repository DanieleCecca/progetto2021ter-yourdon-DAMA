package it.uniba.dama;

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
