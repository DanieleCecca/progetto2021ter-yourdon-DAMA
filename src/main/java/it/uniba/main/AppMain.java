package it.uniba.main;

import it.uniba.dama.damiera;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import it.uniba.sotorrent.GoogleDocsUtils;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 *
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

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

        //Prova stampa di carattere Unicode
        char d = '\u26C0';
        System.out.println("Dama: " + d);

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

        damiera tavolo;
        tavolo = new damiera();
        //Questa parte permette l'inserimento di un comando valido da parte dell'utente
        boolean esci = false;
        Scanner inputTastiera = new Scanner(System.in);
        while (!esci) {
            System.out.println("Inserisci comando: ");
            String comando = inputTastiera.nextLine();

            switch (comando) {

                case "damiera":
                    tavolo.popolaDamiera();
                    tavolo.stampaDamieraGioco();
                    break;

                case "numeri":
                    tavolo.stampaDamieraNumerata();
                    break;

                case "esci":
                    System.out.println("Applicazione chiusa.");
                    esci = true;
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

}
