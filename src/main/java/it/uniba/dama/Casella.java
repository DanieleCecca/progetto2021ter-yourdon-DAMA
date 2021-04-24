package it.uniba.dama;

public class Casella {
    private Pedina pedina;
    private boolean occupato;
    private int numeroCasella;

    public Casella (){
        pedina = new Pedina("", "");
    }

    public int getNumeroCasella() {
        return numeroCasella;
    }

    public void setNumeroCasella(int numeroCasella) {
        this.numeroCasella = numeroCasella;
    }

    public Casella (Pedina pedinaDaPosizionare){
        pedina = pedinaDaPosizionare;
    }

    public Pedina getPedina() {
        return pedina;
    }

    public void setPedina(Pedina pedina) {
        this.pedina = pedina;
    }

    public boolean getOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
}
