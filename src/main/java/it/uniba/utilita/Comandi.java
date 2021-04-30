package it.uniba.utilita;

public class Comandi {

    public static void helpPartita() {
        System.out.println("Le mosse sono descritte in notazione algebrica\n" +
                "Esempio: \n" +
                "1-5\n" +
                "1x10");
        System.out.println("Ecco la lista dei comandi disponibili:");
        System.out.println("- help\n" +
                "- abbandona\n" +
                "- esci\n" +
                "- numeri\n" +
                "- damiera\n" +
                "- tempo\n" +
                "- prese");
    }


    public static void help() {
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

    public static void controlloFlagHelp(String [] args) {
        int i = 0;
        boolean flagHelp = false;
        while (i < args.length && !flagHelp) {
            if (args[i].equals("--help") || args[i].equals("-h")) {
                Comandi.help();
                flagHelp = true;
            }
            i++;
        }
        if (!flagHelp)
            Comandi.help();
    }
}
