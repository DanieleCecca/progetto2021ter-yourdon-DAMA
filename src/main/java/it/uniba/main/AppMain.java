package it.uniba.main;

import it.uniba.dama.damiera;

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
	 * 	 * This is the main entry of the application.
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
		damiera tavolo;
		tavolo = new damiera();

		tavolo.stampaDamieraNumerata();

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
