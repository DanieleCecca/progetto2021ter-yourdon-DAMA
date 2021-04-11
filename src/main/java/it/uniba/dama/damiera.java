package it.uniba.dama;

public class damiera {

    static final int DIM = 8;

    public damiera() {
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