package it.uniba.utilita;

import it.uniba.dama.Partita;

import java.util.Scanner;

/**
 * Classe che rappresenta l'Interfaccia Utente<br>
 * Tipo di classe: <b>Boundary</b><br>
 * Responsabilità:
 * <ul>Knows:
 *     <li>Un valore che indica se l'utente vuole uscire dall'applicazione</li></ul>
 * <ul>Does:
 *     <li>Stampa l'interfaccia iniziale l'applicazione si predispone a ricevere i comandi iniziali</li>
 *     <li>Stampa i comandi validi all'avvio dell'applicazione se viene passato un flag -h o --help</li>
 *     <li>Stampa i comandi validi durante il corso della partita</li>
 *     <li>Stampa un messaggio qualsiasi passato come parametro</li>
 *     <li>Acquisisce da tastiera un comando</li>
 *     <li>Permette di uscire dall'applicazione</li></ul>
 */

public final class Interfaccia {
    private static boolean esci = false;
    private static Interfaccia singleton = null;

    /**
     * Costruttore di default privato necessario per
     * realizzare la classe Singleton come suggerisce
     * il design pattern.
     */
    private Interfaccia() {
    }

    /**
     * Metodo get per ritornare l'unica istanza della classe Singleton.
     *
     * @return il singleton
     */
    public static Interfaccia getSingleton() {
        if (singleton == null) {
            singleton = new Interfaccia();
        }
        return singleton;
    }

    /**
     * Metodo che permette l'inserimento di un comando valido da parte dell'utente.
     */
    public void interfacciaIniziale() {
        Partita incontro = new Partita();

        while (!esci) {
            stampaMessaggio(Costanti.INSERIRE_COMANDO);
            String comando = acquisireComando();

            switch (comando) {
                case "gioca":
                    stampaMessaggio(Costanti.PARTITA_INIZIATA);
                    incontro.inizio();
                    break;

                case "damiera":
                    if (incontro.getInCorso()) {
                        incontro.getTavolo().stampaDamieraGioco();
                    } else {
                        stampaMessaggio(Costanti.ERR_PARTITA_NON_INIZIATA);
                    }
                    break;

                case "numeri":
                    incontro.getTavolo().stampaDamieraNumerata();
                    break;

                case "tempo":
                    if (!incontro.getInCorso()) {
                        stampaMessaggio(Costanti.ERR_PARTITA_NON_INIZIATA);
                    }
                    break;

                case "esci":
                    esci();
                    break;

                case "help":
                    help();
                    break;

                case "abbandona":
                    if (!incontro.getInCorso()) {
                        stampaMessaggio(Costanti.ERR_PARTITA_NON_INIZIATA);
                    }
                    break;

                default:
                    stampaMessaggio(Costanti.ERR_COMANDO_INESISTENTE);
                    break;
            }
        }
    }

    /**
     * Metodo che controlla i flag inseriti.
     * Se i flag inseriti corrispondono a --help e -h viene richiamato il metodo help(), che stampa i possibili comandi.
     *
     * @param args i flag inseriti
     */
    public void controlloFlagHelp(final String[] args) {
        int i = 0;
        boolean flagHelp = false;
        while (i < args.length && !flagHelp) {
            if (args[i].equals("--help") || args[i].equals("-h")) {
                help();
                flagHelp = true;
            }
            i++;
        }
        if (!flagHelp) {
            help();
        }
    }

    /**
     * Metodo che permette di uscire dall'applicazione chiedendo conferma all'utente.
     */
    public static void esci() {
        String conferma;
        do {
            stampaMessaggio(Costanti.RICHIESTA_USCITA_APP);
            conferma = acquisireComando();
            if (!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no")) {
                stampaMessaggio(Costanti.ERR_RISPOSTA_NON_VALIDA);
            }
        } while (!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"));

        if (conferma.equalsIgnoreCase("si")) {
            stampaMessaggio(Costanti.APPLICAZIONE_CHIUSA);
            esci = true;
            System.exit(0);
        } else {
            esci = false;
        }
    }

    /**
     * Metodo che permette di stampare una grafica di benvenuto all'avvio dell'applicazione.
     */
    public void stampaBenvenuto() {
        System.out.print("\n       Benvenuto nel gioco della\n\n"
                + "         ___   _   __  __   _   \n"
                + "        |   \\ /_\\ |  \\/  | /_\\  \n"
                + "        | |) / _ \\| |\\/| |/ _ \\ \n"
                + "        |___/_/ \\_\\_|  |_/_/ \\_\\\n"
                + "                               \n      realizzato dal gruppo YOURDON®\n\n");
    }

    /**
     * Metodo che stampa una lista dei comandi eseguibili dall'applicazione durante una partita (quindi in corso).
     */
    public void helpPartita() {
        System.out.print("\nLe mosse sono descritte in notazione algebrica\n"
                + "Esempio: \n"
                + "1-5\n"
                + "1x10\n");
        System.out.print(
                "+---+----------------------------------+\n"
                        + "|   |              COMANDI             | \n"
                        + "+---+----------------------------------+\n"
                        + "| - | abbandona                        |\n"
                        + "| - | esci                             |\n"
                        + "| - | numeri                           |\n"
                        + "| - | damiera                          |\n"
                        + "| - | tempo                            |\n"
                        + "| - | prese                            |\n"
                        + "| - | mosse                            |\n"
                        + "+---+----------------------------------+\n\n");

    }

    /**
     * Metodo che permette di stampare una lista di comandi eseguibili dall'applicazione
     * a partita non iniziata (quindi non in corso).
     */
    public void help() {
        System.out.print("\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             |\n"
                + "+---+----------------------------------+\n"
                + "| - | gioca                            |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "+---+----------------------------------+\n\n");
    }

    /**
     * Metodo che permette di stampare un messaggio nella classe interfaccia.
     *
     * @param messaggio stringa da stampare
     */
    public static void stampaMessaggio(final String messaggio) {
        System.out.print(messaggio);
    }

    /**
     * Metodo che permette di acquisire il comando dato in input dall'utente nella classe interfaccia.
     *
     * @return il comando acquisito
     */
    public static String acquisireComando() {
        Scanner inputTastiera = new Scanner(System.in, "UTF-8");
        String comando = inputTastiera.nextLine();
        return comando;
    }

    /**
     * Metodo che permette di stampare un messaggio.
     *
     * @param messaggio stringa da stampare
     */
    public void stampaMessaggioInterfaccia(final String messaggio) {
        System.out.print(messaggio);
    }

    /**
     * Metodo che permette di acquisire il comando dato in input dall'utente.
     *
     * @return il comando acquisito
     */
    public String acquisireComandoInterfaccia() {
        Scanner inputTastiera = new Scanner(System.in, "UTF-8");
        String comando = inputTastiera.nextLine();
        return comando;
    }

    //per risolvere il fatto che si accede ad un metodo statico da una istanza bisogna ricopiare
    //stampamessaggio e acquisirecomando e renderli non statici
}
