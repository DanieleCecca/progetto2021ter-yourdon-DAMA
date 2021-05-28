package it.uniba.dama;

import it.uniba.utilita.Costanti;
import it.uniba.main.AppMain;

/**
 * Classe che rappresenta la Damiera di gioco come una matrice di Caselle <br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilita:
 * Knows:
 * <ul>
 *     <li>Matrice di Caselle</li>
 * </ul>
 * Does:
 * <ul>
 *     <li>Istanzia la matrice di caselle con le coppie di coordinate inserendo
 *         il relativo numero di casella</li>
 *     <li> Ottiene e setta la matrice di caselle</li>
 *     <li>Istanzia la matrice di caselle utilizzando una damiera passata come
 *         parametro(costruttore di copia)</li>
 *     <li>Inserisce nella damiera le pedine del giocatore 1 e del giocatore 2</li>
 *     <li>Stampa la damiera con le pedine di ogni giocatore</li>
 *     <li>Stampa la damiera con i numeri delle caselle</li>
 *     <li>Ricerca la casella all'interno della damiera tramite una posizione passata
 *         come parametro</li>
 *     <li>Permette di effettuare lo spostamento semplice di una pedina all'interno
 *         della damiera, modificandone lo stato</li>
 *     <li>Permette di effettuare una presa semplice di una pedina all'interno
 *         della damiera, modificandone lo stato</li>
 *     <li>Permette di effettuare una presa multipla di piu' pedine all'interno
 *         della damiera, modificandone lo stato</li>
 *     <li>Trasforma la pedina in Dama se arriva nella base avversaria</li></ul>
 */
public final class Damiera {
    /**
     * Rappresenta la damiera ossia il tavolo da gioco.
     */
    private Casella[][] damiera = new Casella[Costanti.DIM][Costanti.DIM];

    /**
     * Costruttore della classe Damiera.
     * Inizializza la damira inizializzando ogni casella della matrice ossia della damiera.
     */
    public Damiera() {
        int numeroCasella = 1;
        for (int i = 0; i < Costanti.DIM; i++) {
            for (int j = 0; j < Costanti.DIM; j++) {
                damiera[i][j] = new Casella();
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    damiera[i][j].setNumeroCasella(numeroCasella);
                    numeroCasella++;
                }
                damiera[i][j].getCoordinata().setX(i);
                damiera[i][j].getCoordinata().setY(j);
            }
        }
    }

    /**
     * Costruttore di copia della classe Damiera.
     * Inizializza la damiera a partire dalla damiera passata in input
     *
     * @param copia damiera da copiare
     */
    public Damiera(final Damiera copia) {
        for (int i = 0; i < Costanti.DIM; i++) {
            for (int j = 0; j < Costanti.DIM; j++) {
                damiera[i][j] = new Casella();
                damiera[i][j].setNumeroCasella(copia.getDamiera()[i][j].getNumeroCasella());
                damiera[i][j].setPedina(copia.getDamiera()[i][j].getPedina());
                damiera[i][j].setOccupato(copia.getDamiera()[i][j].getOccupato());

                damiera[i][j].getCoordinata().setX(i);
                damiera[i][j].getCoordinata().setY(j);
            }
        }
    }

    /**
     * Metodo get per Damiera
     *
     * @return la damiera di gioco
     */
    protected Casella[][] getDamiera() {
        return damiera;
    }

    /**
     * Metodo che permette di inserire le pedine nelle caselle della damiera.
     * <p>
     * Scorre nella matrice della damiera e inserisce opportunamente le pedine dei giocatori
     * e setta lo stato ad occupato nelle caselle in cui e' stata inserita la pedina.
     */
    public void popolaDamiera() {
        //inserisce pedine giocatore 1
        for (int i = 0; i < Costanti.ULTIMA_RIGA_INIZIALE_BIANCO; i++) {
            for (int j = 0; j < Costanti.DIM; j++) {
                if (i % Costanti.NUM_PARI == 0 && j % Costanti.NUM_PARI == 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_NERA);
                    damiera[i][j].setOccupato(true);
                } else if (i % Costanti.NUM_PARI != 0 && j % Costanti.NUM_PARI != 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_NERA);
                    damiera[i][j].setOccupato(true);
                }
            }
        }
        //inserisce pedine giocatore 2
        for (int i = Costanti.ULTIMA_RIGA_INIZIALE_NERO; i < Costanti.DIM; i++) {
            for (int j = 0; j < Costanti.DIM; j++) {
                if (i % Costanti.NUM_PARI == 0 && j % Costanti.NUM_PARI == 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_BIANCA);
                    damiera[i][j].setOccupato(true);
                } else if (i % Costanti.NUM_PARI != 0 && j % Costanti.NUM_PARI != 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_BIANCA);
                    damiera[i][j].setOccupato(true);
                }
            }
        }
    }

    /**
     * Metodo che permette di stampare a video lo stato della damiera della partita in corso.
     */
    public void stampaDamieraGioco() {
        AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.TAVOLO_GIOCO);
        for (int i = 0; i < Costanti.DIM; i++) {
            AppMain.SINGLETON.stampaMessaggioInterfaccia("\n-----+----+----+----+----+----+----+-----\n");
            for (int j = 0; j < Costanti.DIM; j++) {
                AppMain.SINGLETON.stampaMessaggioInterfaccia("|");
                if (!damiera[i][j].getOccupato()) {
                    AppMain.SINGLETON.stampaMessaggioInterfaccia("    ");
                } else {
                    if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_PEDINA_NERA)) {
                        AppMain.SINGLETON.stampaMessaggioInterfaccia(
                                " " + Costanti.UNICODE_PEDINA_NERA + Costanti.SPAZIO_CORTO + " ");
                    } else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_PEDINA_BIANCA)) {
                        AppMain.SINGLETON.stampaMessaggioInterfaccia(
                                " " + Costanti.UNICODE_PEDINA_BIANCA + Costanti.SPAZIO_CORTO + " ");
                    } else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_DAMA_NERA)) {
                        AppMain.SINGLETON.stampaMessaggioInterfaccia(
                                " " + Costanti.UNICODE_DAMA_NERA + Costanti.SPAZIO_CORTO + " ");
                    } else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_DAMA_BIANCA)) {
                        AppMain.SINGLETON.stampaMessaggioInterfaccia(
                                " " + Costanti.UNICODE_DAMA_BIANCA + Costanti.SPAZIO_CORTO + " ");
                    }
                }
            }
            AppMain.SINGLETON.stampaMessaggioInterfaccia("|");
        }
        AppMain.SINGLETON.stampaMessaggioInterfaccia("\n-----+----+----+----+----+----+----+-----\n");
        AppMain.SINGLETON.stampaMessaggioInterfaccia("\n");
    }

    /**
     * Metodo che permette di stampare a video una rappresentazione della damiera nella quale sono
     * rappresentati i numeri corrispondenti alle posizioni delle caselle.
     */

    public void stampaDamieraNumerata() {
        int numero = 1;
        AppMain.SINGLETON.stampaMessaggioInterfaccia(Costanti.TAVOLO_GIOCO);
        for (int i = 0; i < Costanti.DIM; i++) {
            AppMain.SINGLETON.stampaMessaggioInterfaccia("\n-----+----+----+----+----+----+----+-----\n");
            for (int j = 0; j < Costanti.DIM; j++) {
                AppMain.SINGLETON.stampaMessaggioInterfaccia("|");
                //Se la riga è pari allora il primo pezzo è posto sulla prima colonna con numero pari
                if (i % Costanti.NUM_PARI == 0) {
                    if (j % Costanti.NUM_PARI == 0) {
                        if (numero < Costanti.NUM_10) {
                            AppMain.SINGLETON.stampaMessaggioInterfaccia("  " + numero + " ");
                        } else {
                            AppMain.SINGLETON.stampaMessaggioInterfaccia(" " + numero + " ");
                        }
                        numero++;
                    } else {
                        AppMain.SINGLETON.stampaMessaggioInterfaccia("    ");
                    }
                    //Se la riga è dispari allora il primo pezzo è posto sulla prima posizione con numero dispari
                } else if (i % Costanti.NUM_PARI != 0) {
                    if (j % Costanti.NUM_PARI != 0) {
                        if (numero < Costanti.NUM_10) {
                            AppMain.SINGLETON.stampaMessaggioInterfaccia("  " + numero + " ");
                        } else {
                            AppMain.SINGLETON.stampaMessaggioInterfaccia(" " + numero + " ");
                        }
                        numero++;
                    } else {
                        AppMain.SINGLETON.stampaMessaggioInterfaccia("    ");
                    }
                }
            }
            AppMain.SINGLETON.stampaMessaggioInterfaccia("|");
        }
        AppMain.SINGLETON.stampaMessaggioInterfaccia("\n-----+----+----+----+----+----+----+-----\n");
        AppMain.SINGLETON.stampaMessaggioInterfaccia("\n");
    }

    /**
     * Metodo che permette di cercare una determinata casella nella damiera.
     *
     * @param posizione indica la posizione della casella da cercare
     * @return la casella cercata o nel caso non venga trovata restituisce null
     */
    public Casella ricercaCasella(final int posizione) {
        for (int i = 0; i < Costanti.DIM; i++) {
            for (int j = 0; j < Costanti.DIM; j++) {
                if (damiera[i][j].getNumeroCasella() == posizione) {
                    return damiera[i][j];
                }
            }
        }
        return null;
    }

    /**
     * Metodo che permette di effettuare uno spostamento semplice di una pedina.
     *
     * @param giocatore   il giocatore che effettua la mossa
     * @param spostamento il comando che indica la mossa da compiere
     * @throws DamieraException la mossa che si sta cercando di fare non e' valida
     * @return un boolenao che indica lo stato della mossa(se e' andata a buon fino o meno)
     */
    public boolean spostamentoSemplice(final Giocatore giocatore, final String spostamento) throws DamieraException {
        boolean spostamentoEseguito = false;

        String spostamentoTrim = spostamento.replaceAll("\\s", "");

        int primaPosizione = Integer.parseInt(spostamentoTrim.substring((0), spostamentoTrim.indexOf('-')));
        int secondaPosizione = Integer.parseInt(spostamentoTrim.substring(spostamentoTrim.indexOf('-') + 1));


        Casella primaCasella = ricercaCasella(primaPosizione);
        Casella secondaCasella = ricercaCasella(secondaPosizione);
        if (primaCasella.getOccupato()) {
            if (primaCasella.getPedina().getColore() == giocatore.getColore()) {
                if (((secondaCasella.getCoordinata().getX() == (primaCasella.getCoordinata().getX() + 1)
                        && giocatore.getColore().equals("nero"))
                        || (secondaCasella.getCoordinata().getX() == (primaCasella.getCoordinata().getX() - 1))
                        && giocatore.getColore().equals("bianco"))
                        && (secondaCasella.getCoordinata().getY() == (primaCasella.getCoordinata().getY() + 1)
                        || secondaCasella.getCoordinata().getY() == (primaCasella.getCoordinata().getY() - 1))) {
                    if (!secondaCasella.getOccupato()) {
                        primaCasella.setOccupato(secondaCasella.getOccupato());
                        secondaCasella.setPedina(primaCasella.getPedina());
                        secondaCasella.setOccupato(true);
                        spostamentoEseguito = true;
                        controlloDamatura(giocatore, secondaCasella);
                    } else {
                        throw new DamieraException(Costanti.ERR_CASELLA_OCCUPATA);
                    }
                } else {
                    throw new DamieraException(Costanti.ERR_MOSSA_NON_VALIDA);
                }
            } else {
                throw new DamieraException(Costanti.ERR_APPERTENENZA_PEDINA);
            }
        } else {
            throw new DamieraException(Costanti.ERR_CASELLA_VUOTA);
        }
        return spostamentoEseguito;
    }

    /**
     * Metodo che permette di effettuare una presa semplice di una pedina.
     *
     * @param giocatore   il giocatore che effettua la presa
     * @param spostamento il comando che indica la mossa da compiere
     * @throws DamieraException la mossa che si sta cercando di fare non e' valida
     * @return un boolenao che indica lo stato della mossa(se e' andata a buon fino o meno)
     */
    public boolean presaSemplice(final Giocatore giocatore, final String spostamento) throws DamieraException {
        boolean spostamentoEseguito = false;

        String spostamentoTrim = spostamento.replaceAll("\\s", "");

        int primaPosizione = Integer.parseInt(spostamentoTrim.substring((0), spostamentoTrim.indexOf('x')));
        int terzaPosizione = Integer.parseInt(spostamentoTrim.substring(spostamentoTrim.indexOf('x') + 1));

        Casella casellaUno = ricercaCasella(primaPosizione);
        Casella casellaDue = new Casella();
        Casella casellaTre = ricercaCasella(terzaPosizione);

        //Il giocatore nero effettua la presa verso destra o sinistra
        if (giocatore.getColore().equals("nero")
                && casellaUno.getPedina().getColore().equals(giocatore.getColore())) {
            if (casellaTre.getCoordinata().getY() == (casellaUno.getCoordinata().getY() + 2)) {
                casellaDue = damiera[casellaUno.getCoordinata().getX() + 1][casellaUno.getCoordinata().getY() + 1];
            } else if (casellaTre.getCoordinata().getY() == (casellaUno.getCoordinata().getY() - 2)) {
                casellaDue = damiera[casellaUno.getCoordinata().getX() + 1][casellaUno.getCoordinata().getY() - 1];
            }
        }
        //Il giocatore bianco effettua la presa verso sinistra o destra
        if (giocatore.getColore().equals("bianco")
                && casellaUno.getPedina().getColore().equals(giocatore.getColore())) {
            if (casellaTre.getCoordinata().getY() == (casellaUno.getCoordinata().getY() - 2)) {
                casellaDue = damiera[casellaUno.getCoordinata().getX() - 1][casellaUno.getCoordinata().getY() - 1];
            } else if (casellaTre.getCoordinata().getY() == (casellaUno.getCoordinata().getY() + 2)) {
                casellaDue = damiera[casellaUno.getCoordinata().getX() - 1][casellaUno.getCoordinata().getY() + 1];
            }
        }

        if (casellaUno.getOccupato()) {
            if (casellaUno.getPedina().getColore().equals(giocatore.getColore())) {
                if (((casellaTre.getCoordinata().getX() == (casellaUno.getCoordinata().getX() + 2)
                        && giocatore.getColore().equals("nero"))
                        || (casellaTre.getCoordinata().getX() == (casellaUno.getCoordinata().getX() - 2))
                        && giocatore.getColore().equals("bianco"))
                        && (casellaTre.getCoordinata().getY() == (casellaUno.getCoordinata().getY() + 2)
                        || casellaTre.getCoordinata().getY() == (casellaUno.getCoordinata().getY() - 2))) {
                    if (!casellaTre.getOccupato()) {
                        if (casellaDue.getOccupato()) {
                            if (!casellaDue.getPedina().getColore().equals(giocatore.getColore())) {
                                casellaDue.setOccupato(false);
                                //Cancellare anche simbolo e colore?
                                //Da inserire funzione che aggiorna il numero di pedine prese
                                casellaUno.setOccupato(false);
                                casellaTre.setPedina(casellaUno.getPedina());
                                casellaTre.setOccupato(true);
                                spostamentoEseguito = true;
                                controlloDamatura(giocatore, casellaTre);
                                giocatore.setPedinePrese(casellaDue.getPedina());
                            } else {
                                throw new DamieraException(Costanti.ERR_MOSSA_NON_VALIDA);

                            }
                        } else {
                            throw new DamieraException(Costanti.ERR_MOSSA_NON_VALIDA);
                        }
                    } else {
                        throw new DamieraException(Costanti.ERR_CASELLA_OCCUPATA);
                    }
                } else {
                    throw new DamieraException(Costanti.ERR_MOSSA_NON_VALIDA);
                }

            } else {
                throw new DamieraException(Costanti.ERR_APPERTENENZA_PEDINA);
            }
        } else {
            throw new DamieraException(Costanti.ERR_CASELLA_VUOTA);
        }
        return spostamentoEseguito;
    }

    /**
     * Metodo che permette di effettuare una presa multipla.
     *
     * @param giocatore   il giocatore che effettua la presa
     * @param spostamento il comando che indica la mossa da compiere
     * @throws DamieraException la mossa che si sta cercando di fare non e' valida
     * @return un boolenao che indica lo stato della mossa(se e' andata a buon fino o meno)
     */
    public boolean presaMultipla(final Giocatore giocatore, final String spostamento) throws DamieraException {
        Damiera provaDamiera = new Damiera(this);
        Giocatore provaGiocatore = new Giocatore(giocatore.getColore());
        boolean esito = true;
        int occorrenze = 0;
        int posizioneCorrente = 0;
        int posizioneSuccessiva = spostamento.indexOf("x");
        String sottoComando = "";

        for (int i = 0; i < spostamento.length(); i++) {
            if (spostamento.charAt(i) == 'x') {
                occorrenze++;
            }
        }

        for (int i = 0; i < occorrenze; i++) {
            if (i < occorrenze - 1) {
                posizioneSuccessiva = spostamento.indexOf("x", posizioneSuccessiva + 1);
                sottoComando = spostamento.substring(posizioneCorrente, posizioneSuccessiva);
                posizioneCorrente = spostamento.indexOf("x", posizioneCorrente + 1) + 1;
            } else {
                sottoComando = spostamento.substring(posizioneCorrente);
            }

            if (!provaDamiera.presaSemplice(provaGiocatore, sottoComando)) {
                esito = false;
                break;
            }
        }

        if (esito) {
            posizioneCorrente = 0;
            posizioneSuccessiva = spostamento.indexOf("x");
            for (int i = 0; i < occorrenze; i++) {
                if (i < occorrenze - 1) {
                    posizioneSuccessiva = spostamento.indexOf("x", posizioneSuccessiva + 1);
                    sottoComando = spostamento.substring(posizioneCorrente, posizioneSuccessiva);
                    posizioneCorrente = spostamento.indexOf("x", posizioneCorrente + 1) + 1;
                } else {
                    sottoComando = spostamento.substring(posizioneCorrente);
                }
                presaSemplice(giocatore, sottoComando);
            }
        }
        return esito;
    }

    /**
     * Metodo che permette di controllare le condizioni necessarie per trasformare la pedina in dama e
     * in caso di esito positivo effettua le modifiche sulla pedina trasformandola in dama.
     *
     * @param giocatore giocatore che effettua un qualsiasi tipo di mossa
     * @param casella   casella da controllare, che e' indicata dal termine a destra della mossa.
     */
    private void controlloDamatura(final Giocatore giocatore, final Casella casella) {
        if (giocatore.getColore().equals("bianco")) {
            if (casella.getNumeroCasella() >= 1 && casella.getNumeroCasella() <= Costanti.NUM_4
                    && !(casella.getPedina() instanceof Dama)) {
                casella.setPedina(Costanti.DAMA_BIANCA);
            }
        } else {
            if (casella.getNumeroCasella() >= Costanti.NUM_29 && casella.getNumeroCasella() <= Costanti.NUM_32
                    && !(casella.getPedina() instanceof Dama)) {
                casella.setPedina(Costanti.DAMA_NERA);
            }
        }
    }
}
