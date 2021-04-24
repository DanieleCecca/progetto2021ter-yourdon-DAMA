package it.uniba.dama;

import it.uniba.utilita.Costanti;

public class Damiera {

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
            }
        }
    }

    public Casella[][] getDamiera() {
        return damiera;
    }

    public void setDamiera(Casella[][] damiera) {
        this.damiera = damiera;
    }

    public void popolaDamiera() {
        //inserisce pedine giocatore 1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Costanti.DIM; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_NERA);
                    damiera[i][j].setOccupato(true);
                }

                else if (i % 2 != 0 && j % 2 != 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_NERA);
                    damiera[i][j].setOccupato(true);
                }
            }
        }
        //inserisce pedine giocatore 2
        for (int i = 5; i < Costanti.DIM; i++) {
            for (int j = 0; j < Costanti.DIM; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_BIANCA);
                    damiera[i][j].setOccupato(true);
                }

                else if (i % 2 != 0 && j % 2 != 0) {
                    damiera[i][j].setPedina(Costanti.PEDINA_BIANCA);
                    damiera[i][j].setOccupato(true);
                }
            }
        }
    }

    public void stampaDamieraGioco() {
        System.out.println("Tavolo da gioco: ");
        for (int i = 0; i < Costanti.DIM; i++) {
            System.out.println("");
            System.out.println("-----+----+----+----+----+----+----+-----");
            for (int j = 0; j < Costanti.DIM; j++) {
                System.out.print("|");
                if (!damiera[i][j].getOccupato())
                    System.out.print("    ");
                else {
                    if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_PEDINA_NERA))
                        System.out.print(" " + Costanti.UNICODE_PEDINA_NERA + Costanti.SPAZIO_CORTO + " ");

                    else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_PEDINA_BIANCA))
                        System.out.print(" " + Costanti.UNICODE_PEDINA_BIANCA + Costanti.SPAZIO_CORTO + " ");

                    else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_DAMA_NERA))
                        System.out.print(" " + Costanti.UNICODE_DAMA_NERA + Costanti.SPAZIO_CORTO + " ");

                    else if (damiera[i][j].getPedina().getSimbolo().equals(Costanti.UNICODE_DAMA_BIANCA))
                        System.out.print(" " + Costanti.UNICODE_DAMA_BIANCA + Costanti.SPAZIO_CORTO + " ");
                }
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("-----+----+----+----+----+----+----+-----");
        System.out.print("\n");
    }

    public void stampaDamieraNumerata() {
        int numero = 1;
        System.out.println("Tavolo da gioco: ");
        for (int i = 0; i < Costanti.DIM; i++) {
            System.out.println("");
            System.out.println("-----+----+----+----+----+----+----+-----");
            for (int j = 0; j < Costanti.DIM; j++) {
                System.out.print("|");
                //Se la riga è pari allora il primo pezzo è posto sulla prima colonna con numero pari
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (numero < 10)
                            System.out.print("  " + numero + " ");
                        else
                            System.out.print(" " + numero + " ");

                        numero++;
                    } else
                        System.out.print("    ");
                }
                //Se la riga è dispari allora il primo pezzo è posto sulla prima posizione con numero dispari
                else if (i % 2 != 0) {
                    if (j % 2 != 0) {
                        if (numero < 10)
                            System.out.print("  " + numero + " ");
                        else
                            System.out.print(" " + numero + " ");

                        numero++;
                    } else
                        System.out.print("    ");
                }
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("-----+----+----+----+----+----+----+-----");
    }

    /*public void mossa(Damiera tavolo, Giocatore giocatore, String spostamento) {

        return tavolo;
    }*/
}