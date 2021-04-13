package it.uniba.dama;

import it.uniba.dama.giocatore;
import it.uniba.dama.damiera;
import it.uniba.main.AppMain;
import java.util.Scanner;


public class partita {
    private giocatore bianco;
    private giocatore nero;
    private damiera tavolo;
    private boolean inCorso;
    private String turno;

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
        turno = "bianco";

        while (inCorso) {
            Scanner inputTastiera = new Scanner(System.in);
            System.out.print("Inserisci comando: ");
            String comando = inputTastiera.nextLine();

            switch (comando) {

                case "damiera":
                    tavolo.stampaDamieraGioco();
                    break;

                case "numeri":
                    tavolo.stampaDamieraNumerata();
                    break;

                case "abbandona":
                    abbandona();
                    break;

                case "esci":
                    AppMain.esci();
                    break;

                default:
                    System.out.println("Comando inesistente.");
                    break;
            }
        }
    }

    public void abbandona() {
        Scanner inputTastiera = new Scanner(System.in);
        String conferma;
        do {
            System.out.print("Sei sicuro di voler abbandonare? (si/no) ");
            conferma = inputTastiera.nextLine();
            if (!conferma.equals("si") && !conferma.equals("no"))
                System.out.println("Comando inesistente.");
        } while (!conferma.equals("si") && !conferma.equals("no"));

        if (conferma.equals("si")) {
            inCorso = false;
            if (turno.equals("bianco"))
                System.out.println("Partita abbandonata: il nero ha vinto.");
            else
                System.out.println("Partita abbandonata: il bianco ha vinto.");
        }
    }

}
