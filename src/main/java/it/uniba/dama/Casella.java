package it.uniba.dama;

public class Casella {
    private Pedina pedina;
    private boolean occupato;
    private int numeroCasella;
    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;

    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Casella (){
        pedina = new Pedina("", "");
        coordinate = new Coordinate();
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

 class
 Coordinate {
    private int x;
    private int y;

    Coordinate(){
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}