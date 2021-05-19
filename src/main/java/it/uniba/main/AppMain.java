package it.uniba.main;

import it.uniba.utilita.Interfaccia;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 *
 * <b>DO NOT RENAME</b>
 */

/**
 * Classe principale del progetto<br>
 * Tipo di classe: <b>Boundary</b> <br>
 * Responsabilità:
 * 		<ul>Knows:
 * 	    </ul>
 * 		<ul>Does:
 * 		    <li>Richiama il metodo dell'Interfaccia Iniziale</li>
 * 		    <li>Effettua il controllo del comando passato in input come flag -h o --help</li>
 * 		</ul>
 */

public final class AppMain {

    public static final Interfaccia SINGLETON = Interfaccia.getSingleton();

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

        SINGLETON.stampaBenvenuto();
        SINGLETON.controlloFlagHelp(args);
        SINGLETON.interfacciaIniziale();
        /*
        Interfaccia.stampaBenvenuto();
        Interfaccia.controlloFlagHelp(args);
        Interfaccia.interfacciaIniziale();*/
    }
}
