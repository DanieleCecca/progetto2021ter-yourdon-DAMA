package it.uniba.main;

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

		help();
	}

	static void help()
	{
		System.out.println("Benvenuto nel gioco di dama, realizzato dal gruppo yourdon.");
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
