package it.uniba.utilita;

//import it.uniba.dama.Partita;

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

public class Interfaccia {
    public static boolean esci = false;

    public Interfaccia() {
    }

    public static void interfacciaIniziale() {
        //Questa parte permette l'inserimento di un comando valido da parte dell'utente
        Partita incontro = new Partita();

        while (!esci) {
            stampaMessaggio(Costanti.INSERIRE_COMANDO);
            String comando = acquisireComando();

            switch (comando) {
                case "gioca":
                    stampaMessaggio(Costanti.PARTITA_INIZIATA);
                    incontro.gioca();
                    break;

                case "damiera":
                    if (incontro.getInCorso())
                        incontro.getTavolo().stampaDamieraGioco();
                    else
                        stampaMessaggio(Costanti.ERR_PARTITA_NON_INIZIATA);
                    break;

                case "numeri":
                    incontro.getTavolo().stampaDamieraNumerata();
                    break;

                case "tempo":
                    if (!incontro.getInCorso())
                        stampaMessaggio(Costanti.ERR_PARTITA_NON_INIZIATA);
                    break;

                case "esci":
                    esci();
                    break;

                case "help":
                    Interfaccia.help();
                    break;

                case "abbandona":
                    if (!incontro.getInCorso())
                        stampaMessaggio(Costanti.ERR_PARTITA_NON_INIZIATA);
                    break;

                default:
                    stampaMessaggio(Costanti.ERR_COMANDO_INESISTENTE);
                    break;
            }
        }
    }

    public static void controlloFlagHelp(String[] args) {
        int i = 0;
        boolean flagHelp = false;
        while (i < args.length && !flagHelp) {
            if (args[i].equals("--help") || args[i].equals("-h")) {
                Interfaccia.help();
                flagHelp = true;
            }
            i++;
        }
        if (!flagHelp)
            Interfaccia.help();
    }

    public static void esci() {
        String conferma;
        do {
            stampaMessaggio(Costanti.RICHIESTA_USCITA_APP);
            conferma = acquisireComando();
            if (!conferma.equals("si") && !conferma.equals("no"))
                stampaMessaggio(Costanti.ERR_RISPOSTA_NON_VALIDA);
        } while (!conferma.equals("si") && !conferma.equals("no"));

        if (conferma.equals("si")) {
            stampaMessaggio(Costanti.APPLICAZIONE_CHIUSA);
            esci = true;
            System.exit(0);
        } else
            esci = false;
    }

    public static void helpPartita() {
        System.out.println("Le mosse sono descritte in notazione algebrica\n"
                + "Esempio: \n"
                + "1-5\n"
                + "1x10");
        System.out.println("Ecco la lista dei comandi disponibili:");
        System.out.println("- help\n"
                + "- abbandona\n"
                + "- esci\n"
                + "- numeri\n"
                + "- damiera\n"
                + "- tempo\n"
                + "- prese\n"
                + "- mosse");
    }

    public static void help() {
        System.out.println("\nBenvenuto nel gioco di dama, realizzato dal gruppo yourdon.");
        System.out.println("Ecco la lista dei comandi disponibili:");
        System.out.println("- help\n"
                + "- gioca\n"
                + "- abbandona\n"
                + "- esci\n"
                + "- numeri\n"
                + "- damiera\n"
                + "- tempo");
    }

    public static void stampaMessaggio(String messaggio) {
        System.out.print(messaggio);
    }

    public static String acquisireComando() {
        Scanner inputTastiera = new Scanner(System.in);
        String comando = inputTastiera.nextLine();
        return comando;
    }
}
