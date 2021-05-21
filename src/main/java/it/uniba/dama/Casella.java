package it.uniba.dama;

/**
 * Classe che rappresenta una Casella della damiera<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * <ul>Knows:
 *      <li>La pedina, se presente, posizionata all'interno della casella corrente</li>
 *      <li>Un valore che indica se la Casella è occupata o meno</li>
 *      <li>Il numero della casella</li>
 *      <li>Delle coordinate (x,y) che indicano la posizione della Casella nella Damiera</li></ul>
 * <ul>Does:
 *      <li>Istanzia la casella con al suo interno una coppia di coordinate (x,y) e una pedina vuota</li>
 *      <li>Ottiene e setta il numero della casella</li>
 *      <li>Ottiene e setta il valore occupato della Casella</li></ul>
 */
public final class Casella {
    private Pedina pedina;
    private boolean occupato;
    private int numeroCasella;
    private Coordinata coordinata;

    public Coordinata getCoordinata() {
        return coordinata;

    }

    public void setCoordinata(final Coordinata nuovaCoordinata) {
        this.coordinata = nuovaCoordinata;
    }

    public Casella() {
        pedina = new Pedina("", "");
        coordinata = new Coordinata();
    }

    public int getNumeroCasella() {
        return numeroCasella;
    }

    public void setNumeroCasella(final int nuovoNumeroCasella) {
        this.numeroCasella = nuovoNumeroCasella;
    }

    public Pedina getPedina() {
        return pedina;
    }

    public void setPedina(final Pedina nuovaPedina) {
        this.pedina = nuovaPedina;
    }

    public boolean getOccupato() {
        return occupato;
    }

    public void setOccupato(final boolean nuovoStato) {
        this.occupato = nuovoStato;
    }
}

/**
 * Classe che rappresenta una coppia di coordinate<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * <ul>Knows:
 *      <li>Valori (x,y) che indicano le coordinate di una matrice</li></ul>
 * <ul>Does:
 *      <li>Ottiene e setta la coordinata X</li>
 *      <li>Ottiene e setta la coordinata Y</li></ul>
 */
class Coordinata {
    private int x;
    private int y;

    Coordinata() {
    }

    public int getX() {
        return x;
    }

    public void setX(final int ascissa) {
        this.x = ascissa;
    }

    public int getY() {
        return y;
    }

    public void setY(final int ordinata) {
        this.y = ordinata;
    }
}
