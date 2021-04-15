package it.uniba.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import it.uniba.sotorrent.GoogleDocsUtils;

import java.util.Scanner;
import it.uniba.dama.Partita;
import it.uniba.dama.Damiera;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 *
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

    public static boolean esci = false;
    /**
     * Private constructor. Change if needed.
     */
    private AppMain() {

    }

    /**
     * * This is the main entry of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {

        System.out.println("Current working dir: " + System.getProperty("user.dir"));

        if (args.length > 0) {
            switch (args[0]) {
                case "it":
                    System.out.println("Applicazione avviata.");
                    break;

                case "en":
                    System.out.println("Application started.");
                    break;

                default:
                    System.out.println("Specify the language. "
                            + "Languages supported: 'it' or 'en'");
                    break;
            }
        } else {
            System.out.println("Using default language 'en'");
            System.out.println("Application started.");
        }


		/* Questa parte di codice fà in modo che non vengano mostrati due help
		nel caso l'applicazione venga avviata con i flag --help o -h */
        int i = 0;
        boolean flagHelp = false;
        while (i < args.length && !flagHelp) {
            if (args[i].equals("--help") || args[i].equals("-h")) {
                help();
                flagHelp = true;
            }
            i++;
        }
        if (!flagHelp)
            help();


        //Questa parte permette l'inserimento di un comando valido da parte dell'utente
        Scanner inputTastiera = new Scanner(System.in);
        Partita incontro = new Partita();

        while (!esci) {
            System.out.print("Inserisci comando: ");
            String comando = inputTastiera.nextLine();

            switch (comando) {
                case "gioca":
                    System.out.println("La partita è iniziata.");
                    incontro.gioca();
                    break;

                case "damiera":
                    if (incontro.getInCorso() == true)
                        incontro.getTavolo().stampaDamieraGioco();
                    else
                        System.out.println("La partita non è ancora iniziata. Inserisci il comando 'gioca' per iniziare una nuova partita.");
                    break;

                case "numeri":
                    incontro.getTavolo().stampaDamieraNumerata();
                    break;

                case "tempo":
                    if (incontro.getInCorso() == false)
                        System.out.println("La partita non è ancora iniziata. Inserisci il comando 'gioca' per iniziare una nuova partita.");
                    break;

                case "esci":
                    esci();
                    break;

                case "help":
                    help();
                    break;

                default:
                    System.out.println("Comando inesistente.");
                    break;
            }
        }
    }

    //Metodo che mostra una lista dei comandi disponibili
    static void help() {
        System.out.println("\nBenvenuto nel gioco di dama, realizzato dal gruppo yourdon.");
        System.out.println("Ecco la lista dei comandi disponibili:");
        System.out.println("- help\n" +
                "- gioca\n" +
                "- abbandona\n" +
                "- esci\n" +
                "- numeri\n" +
                "- damiera\n" +
                "- tempo");
    }

    public static void esci(){
        Scanner inputTastiera = new Scanner(System.in);
        String conferma;
        do {
            System.out.print("Sei sicuro di voler uscire dall'applicazione? (si/no) ");
            conferma = inputTastiera.nextLine();
            if (!conferma.equals("si") && !conferma.equals("no"))
                System.out.println("Comando inesistente.");
        } while (!conferma.equals("si") && !conferma.equals("no"));

        if (conferma.equals("si")) {
            System.out.println("Applicazione chiusa.");
            esci = true;
            System.exit(0);
        }
        else
            esci = false;
    }
}
