package it.uniba.dama;

import it.uniba.dama.giocatore;
import it.uniba.dama.damiera;

public class partita {
    private giocatore bianco;
    private giocatore nero;
    private damiera tavolo;
    private boolean inCorso;

    public partita() {
        tavolo = new damiera();
        inCorso = false;
    }

    public damiera getDamiera() {
        return tavolo;
    }

    public boolean getinCorso() {
        return inCorso;
    }

    public void gioca() {
        bianco = new giocatore("bianco");
        nero = new giocatore("nero");
        tavolo.popolaDamiera();
        inCorso = true;
    }

}
