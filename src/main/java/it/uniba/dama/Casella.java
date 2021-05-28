package it.uniba.dama;

/**
 * Classe che rappresenta una Casella della damiera<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilita:
 * Knows:
 * <ul>
 *     <li>La pedina, se presente, posizionata all'interno della casella corrente</li>
 *     <li>Un valore che indica se la Casella e' occupata o meno</li>
 *     <li>Il numero della casella</li>
 *     <li>Delle coordinate (x,y) che indicano la posizione della Casella nella Damiera</li></ul>
 * Does:
 * <ul>
 *     <li>Istanzia la casella con al suo interno una coppia di coordinate (x,y) e una pedina vuota</li>
 *     <li>Ottiene e setta il numero della casella</li>
 *     <li>Ottiene e setta il valore occupato della Casella</li></ul>
 */
public final class Casella {
    /**
     * Rappresenta la pedina inserita nella casella.
     */
    private Pedina pedina;
    /**
     * Booleano che e' vero se la casella e' occupata da un pezzo, falso altrimenti.
     */
    private boolean occupato;
    /**
     * Numero che caratterizza la casella.
     */
    private int numeroCasella;
    /**
     * Coordinate della dama in cui si trova la casella.
     */
    private Coordinata coordinata;

    /**
     * Costruttore della classe Casella.
     * Inizializza gli attributi della casella.
     */
    public Casella() {
        pedina = new Pedina("", "");
        coordinata = new Coordinata();
    }

    /**
     * Metodo get per coordinata.
     *
     * @return la coordinata della casella
     */
    public Coordinata getCoordinata() {
        return coordinata;
    }

    /**
     * Metodo set per coordinata.
     *
     * @param nuovaCoordinata la nuova coordinata
     */
    public void setCoordinata(final Coordinata nuovaCoordinata) {
        this.coordinata = nuovaCoordinata;
    }

    /**
     * Metodo get per il numeroCasella.
     *
     * @return il numero della casella
     */
    public int getNumeroCasella() {
        return numeroCasella;
    }

    /**
     * Metodo set per numeroCasella.
     *
     * @param nuovoNumeroCasella il nuovo numero della casella
     */
    public void setNumeroCasella(final int nuovoNumeroCasella) {
        this.numeroCasella = nuovoNumeroCasella;
    }

    /**
     * Metodo get per Pedina.
     *
     * @return la pedina
     */
    public Pedina getPedina() {
        return pedina;
    }

    /**
     * Metodo set per Pedina.
     *
     * @param nuovaPedina la nuova pedina
     */
    public void setPedina(final Pedina nuovaPedina) {
        this.pedina = nuovaPedina;
    }

    /**
     * Metodo get per occupato.
     *
     * @return l'attributo occupato della casella
     */
    public boolean getOccupato() {
        return occupato;
    }

    /**
     * Metodo set per occupato.
     *
     * @param nuovoStato il nuovo stato di occupato della casella
     */
    public void setOccupato(final boolean nuovoStato) {
        this.occupato = nuovoStato;
    }
}

/**
 * Classe che rappresenta una coppia di coordinate<br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilita:
 * Knows:
 * <ul>
 *     <li>Valori (x,y) che indicano le coordinate di una matrice</li></ul>
 * Does:
 * <ul>
 *     <li>Ottiene e setta la coordinata X</li>
 *     <li>Ottiene e setta la coordinata Y</li></ul>
 */
class Coordinata {
    /**
     * Rappresenta l'ascissa della coordinata.
     */
    private int x;
    /**
     * Rappresenta l'ordinata della coordinata.
     */
    private int y;

    /**
     * Costruttore di default della classe Coordinata
     */
    Coordinata() {
    }

    /**
     * Metodo get per l'ascissa x.
     *
     * @return l'ascissa corrispondente
     */
    public int getX() {
        return x;
    }

    /**
     * Metodo set per l'ascissa x.
     *
     * @param ascissa la nuova ascissa
     */
    public void setX(final int ascissa) {
        this.x = ascissa;
    }

    /**
     * Metodo get per l'ordinata y.
     *
     * @return l'ordinata corrispondente
     */
    public int getY() {
        return y;
    }

    /**
     * Metodo set per l'ordinata y.
     *
     * @param ordinata la nuova ordinata
     */
    public void setY(final int ordinata) {
        this.y = ordinata;
    }

}
