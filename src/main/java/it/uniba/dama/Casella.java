package it.uniba.dama;

/**
 * Classe che rappresenta una Casella della damiera<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * 		<ul>Knows:
 * 		     <li>La pedina, se presente, posizionata all'interno della casella corrente</li>
 * 		     <li>Un valore che indica se la Casella è occupata o meno</li>
 * 		     <li>Il numero della casella</li>
 * 		     <li>Delle coordinate (x,y) che indicano la posizione della Casella nella Damiera</li></ul>
 * 		<ul>Does:
 * 		     <li>Istanzia la casella con al suo interno una coppia di coordinate (x,y) e una pedina vuota</li>
 * 		     <li>Ottiene e setta il numero della casella</li>
 * 		     <li>Ottiene e setta il valore occupato della Casella</li></ul>
 */
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

/**
 * Classe che rappresenta una coppia di coordinate<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * 		<ul>Knows:
 * 		     <li>Valori (x,y) che indicano le coordinate di una matrice</li></ul>
 * 		<ul>Does:
 * 		     <li>Ottiene e setta la coordinata X</li>
 * 		     <li>Ottiene e setta la coordinata Y</li></ul>
 */
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