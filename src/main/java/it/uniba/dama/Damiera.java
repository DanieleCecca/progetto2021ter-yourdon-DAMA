package it.uniba.dama;

import it.uniba.utilita.Costanti;
import it.uniba.utilita.Interfaccia;

/**
 * Classe che rappresenta la Damiera di gioco come una matrice di Caselle <br>
 * Tipo di classe: <b>Entity</b><br>
 * Responsabilità:
 * <ul>Knows:
 *       <li>Matrice di Caselle</li></ul>
 *  <ul>Does:
 *       <li>Istanzia la matrice di caselle con le coppie di coordinate inserendo
 *       il relativo numero di casella</li>
 *       <li> Ottiene e setta la matrice di caselle</li>
 *       <li>Istanzia la matrice di caselle utilizzando una damiera passata come
 *       parametro(costruttore di copia)</li>
 *       <li>Inserisce nella damiera le pedine del giocatore 1 e del giocatore 2</li>
 *       <li>Stampa la damiera con le pedine di ogni giocatore</li>
 *       <li>Stampa la damiera con i numeri delle caselle</li>
 *       <li>Ricerca la casella all'interno della damiera tramite una posizione passata
 *       come parametro</li>
 *       <li>Permette di effettuare lo spostamento semplice di una pedina all'interno
 *       della damiera, modificandone lo stato</li>
 *       <li>Permette di effettuare una presa semplice di una pedina all'interno
 *       della damiera, modificandone lo stato</li>
 *       <li>Permette di effettuare una presa multipla di più pedine all'interno
 *       della damiera, modificandone lo stato</li>
 *       <li>Trasforma la pedina in Dama se arriva nella base avversaria</li></ul>
 */
public final class Damiera {

    private Casella[][] damiera = new Casella[Costanti.DIM][Costanti.DIM];

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

    private Casella[][] getDamiera() {
        return damiera;
    }

    private void setDamiera(final Casella[][] nuovaDamiera) {
        this.damiera = nuovaDamiera;
    }

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

    public void stampaDamieraGioco() {
        Interfaccia.stampaMessaggio(Costanti.TAVOLO_GIOCO);
        for (int i = 0; i < Costanti.DIM; i++) {
            Interfaccia.stampaMessaggio("\n-----+----+----+----+----+----+----+-----\n");
            for (int j = 0; j < Costanti.DIM; j++) {
                Interfaccia.stampaMessaggio("|");
                if (!damiera[i][j].getOccupato()) {
                    Interfaccia.stampaMessaggio("    ");
                } else {
                    if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_PEDINA_NERA)) {
                        Interfaccia.stampaMessaggio(" " + Costanti.UNICODE_PEDINA_NERA + Costanti.SPAZIO_CORTO + " ");
                    } else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_PEDINA_BIANCA)) {
                        Interfaccia.stampaMessaggio(" " + Costanti.UNICODE_PEDINA_BIANCA + Costanti.SPAZIO_CORTO + " ");
                    } else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_DAMA_NERA)) {
                        Interfaccia.stampaMessaggio(" " + Costanti.UNICODE_DAMA_NERA + Costanti.SPAZIO_CORTO + " ");
                    } else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_DAMA_BIANCA)) {
                        Interfaccia.stampaMessaggio(" " + Costanti.UNICODE_DAMA_BIANCA + Costanti.SPAZIO_CORTO + " ");
                    }
                }
            }
            Interfaccia.stampaMessaggio("|");
        }
        Interfaccia.stampaMessaggio("\n-----+----+----+----+----+----+----+-----\n");
        Interfaccia.stampaMessaggio("\n");
    }

    public void stampaDamieraNumerata() {
        int numero = 1;
        Interfaccia.stampaMessaggio(Costanti.TAVOLO_GIOCO);
        for (int i = 0; i < Costanti.DIM; i++) {
            Interfaccia.stampaMessaggio("\n-----+----+----+----+----+----+----+-----\n");
            for (int j = 0; j < Costanti.DIM; j++) {
                Interfaccia.stampaMessaggio("|");
                //Se la riga è pari allora il primo pezzo è posto sulla prima colonna con numero pari
                if (i % Costanti.NUM_PARI == 0) {
                    if (j % Costanti.NUM_PARI == 0) {
                        if (numero < Costanti.NUM_10) {
                            Interfaccia.stampaMessaggio("  " + numero + " ");
                        } else {
                            Interfaccia.stampaMessaggio(" " + numero + " ");
                        }
                        numero++;
                    } else {
                        Interfaccia.stampaMessaggio("    ");
                    }
                    //Se la riga è dispari allora il primo pezzo è posto sulla prima posizione con numero dispari
                } else if (i % Costanti.NUM_PARI != 0) {
                    if (j % Costanti.NUM_PARI != 0) {
                        if (numero < Costanti.NUM_10) {
                            Interfaccia.stampaMessaggio("  " + numero + " ");
                        } else {
                            Interfaccia.stampaMessaggio(" " + numero + " ");
                        }
                        numero++;
                    } else {
                        Interfaccia.stampaMessaggio("    ");
                    }
                }
            }
            Interfaccia.stampaMessaggio("|");
        }
        Interfaccia.stampaMessaggio("\n-----+----+----+----+----+----+----+-----\n");
        Interfaccia.stampaMessaggio("\n");
    }

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


    public boolean spostamentoSemplice(final Giocatore giocatore, final String spostamento) {
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
                        Interfaccia.stampaMessaggio(Costanti.ERR_CASELLA_OCCUPATA);
                    }
                } else {
                    Interfaccia.stampaMessaggio(Costanti.ERR_MOSSA_NON_VALIDA);
                }
            } else {
                Interfaccia.stampaMessaggio(Costanti.ERR_APPERTENENZA_PEDINA);
            }
        } else {
            Interfaccia.stampaMessaggio(Costanti.ERR_CASELLA_VUOTA);
        }
        return spostamentoEseguito;
    }

    public boolean presaSemplice(final Giocatore giocatore, final String spostamento) {
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
                                Interfaccia.stampaMessaggio(Costanti.ERR_MOSSA_NON_VALIDA);
                            }
                        } else {
                            Interfaccia.stampaMessaggio(Costanti.ERR_MOSSA_NON_VALIDA);
                        }
                    } else {
                        Interfaccia.stampaMessaggio(Costanti.ERR_CASELLA_OCCUPATA);
                    }
                } else {
                    Interfaccia.stampaMessaggio(Costanti.ERR_MOSSA_NON_VALIDA);
                }

            } else {
                Interfaccia.stampaMessaggio(Costanti.ERR_APPERTENENZA_PEDINA);
            }
        } else {
            Interfaccia.stampaMessaggio(Costanti.ERR_CASELLA_VUOTA);
        }
        return spostamentoEseguito;
    }

    public boolean presaMultipla(final Giocatore giocatore, final String spostamento) {
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
