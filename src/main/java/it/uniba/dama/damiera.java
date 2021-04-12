package it.uniba.dama;

public class damiera {

    static final int DIM = 8;

    private int[][] damiera = new int[DIM][DIM];


    public damiera() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++)
                damiera[i][j] = 0;
        }
    }

    public void popolaDamiera() {
        //inserisce pedine giocatore 1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < DIM; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        damiera[i][j] = 1;
                } else if (i % 2 != 0) {
                    if (j % 2 != 0)
                        damiera[i][j] = 1;
                }
            }
        }
        //inserisce pedine giocatore 2
        for (int i = 5; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        damiera[i][j] = 2;
                } else if (i % 2 != 0) {
                    if (j % 2 != 0)
                        damiera[i][j] = 2;
                }
            }
        }
    }

    public void stampaDamieraGioco() {
        System.out.println("Tavolo da gioco: ");
        for (int i = 0; i < DIM; i++) {
            System.out.println("");
            System.out.println("-----+----+----+----+----+----+----+-----");
            for (int j = 0; j < DIM; j++) {
                System.out.print("|");
                if (damiera[i][j] == 1)
                    System.out.print(" " + "\u26C0" + "\u202F ");
                else if (damiera[i][j] == 2)
                    System.out.print(" " + "\u26C2" + "\u202F ");
                else {
                    System.out.print("    ");
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
        for (int i = 0; i < DIM; i++) {
            System.out.println("");
            System.out.println("-----+----+----+----+----+----+----+-----");
            for (int j = 0; j < DIM; j++) {
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
}