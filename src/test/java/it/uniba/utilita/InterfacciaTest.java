package it.uniba.utilita;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Classe che rappresenta i casi di test della classe Interfaccia
 */
public final class InterfacciaTest {

    //Test Interfaccia
    @Test
    @DisplayName("1: Test assertNotNull Interfaccia")
    public void interfacciaTest1() {
        Interfaccia interfaccia = Interfaccia.getSingleton();
        assertNotNull(interfaccia);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("2: Test assertEquals stampaBenvenuto")
    public void interfacciaTest2() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.stampaBenvenuto();
        String outputAspettato = "\n       Benvenuto nel gioco della\n\n"
                + "         ___   _   __  __   _   \n"
                + "        |   \\ /_\\ |  \\/  | /_\\  \n"
                + "        | |) / _ \\| |\\/| |/ _ \\ \n"
                + "        |___/_/ \\_\\_|  |_/_/ \\_\\\n"
                + "                               \n      realizzato dal gruppo YOURDON®\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("3: Test assertEquals helpPartita")
    public void interfacciaTest3() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.helpPartita();
        String outputAspettato = "\nLe mosse sono descritte in notazione algebrica\n"
                + "Esempio: \n"
                + "1-5\n"
                + "1x10\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             | \n"
                + "+---+----------------------------------+\n"
                + "| - | help                             |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "| - | prese                            |\n"
                + "| - | mosse                            |\n"
                + "+---+----------------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("4: Test assertEquals help")
    public void interfacciaTest4() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.help();
        String outputAspettato = "\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             |\n"
                + "+---+----------------------------------+\n"
                + "| - | help                             |\n"
                + "| - | gioca                            |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "+---+----------------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("6: Test assertEquals stampaMessaggio")
    public void interfacciaTest6() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.stampaMessaggio(Costanti.APPLICAZIONE_CHIUSA);
        String outputAspettato = Costanti.APPLICAZIONE_CHIUSA;

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("7: Test assertEquals stampaMessaggioInterfaccia")
    public void interfacciaTest7() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.stampaMessaggioInterfaccia(Costanti.TAVOLO_GIOCO);
        String outputAspettato = Costanti.TAVOLO_GIOCO;

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("8: Test assertNotNull acquisireComando")
    public void interfacciaTest8() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream gioca = new ByteArrayInputStream("gioca".getBytes("UTF-8"));
        System.setIn(gioca);
        Interfaccia interfaccia = Interfaccia.getSingleton();
        String comando = interfaccia.acquisireComando();
        assertNotNull(comando);
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("9: Test assertNotNull acquisireComandoInterfaccia")
    public void interfacciaTest9() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream gioca = new ByteArrayInputStream("gioca".getBytes("UTF-8"));
        System.setIn(gioca);
        Interfaccia interfaccia = Interfaccia.getSingleton();
        String comando = interfaccia.acquisireComandoInterfaccia();
        assertNotNull(comando);
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("10: Test assertEquals esci")
    public void interfacciaTest0() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream c = new ByteArrayInputStream("no".getBytes("UTF-8"));
        System.setIn(c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.esci();
        String outputAspettato = Costanti.RICHIESTA_USCITA_APP;
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("11: Test assertEquals controlloFlagHelp")
    public void interfacciaTest11() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        String[] args = new String[1];
        args[0] = "";
        interfaccia.controlloFlagHelp(args);

        String outputAspettato = "\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             |\n"
                + "+---+----------------------------------+\n"
                + "| - | help                             |\n"
                + "| - | gioca                            |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "+---+----------------------------------+\n"
                + "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));


    }

    @Test
    @DisplayName("12: Test assertEquals controlloFlagHelp")
    public void interfacciaTest12() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        String[] args = new String[1];
        args[0] = "--help";
        interfaccia.controlloFlagHelp(args);

        String outputAspettato = "\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             |\n"
                + "+---+----------------------------------+\n"
                + "| - | help                             |\n"
                + "| - | gioca                            |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "+---+----------------------------------+\n"
                + "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("13: Test assertEquals controlloFlagHelp")
    public void interfacciaTest13() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        String[] args = new String[1];
        args[0] = "-h";
        interfaccia.controlloFlagHelp(args);

        String outputAspettato = "\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             |\n"
                + "+---+----------------------------------+\n"
                + "| - | help                             |\n"
                + "| - | gioca                            |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "+---+----------------------------------+\n"
                + "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("14: Test assertEquals interfacciaComando")
    public void interfacciaTest14() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.interfacciaComando("damiera");

        String outputAspettato = Costanti.ERR_PARTITA_NON_INIZIATA;

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("15: Test assertEquals interfacciaComando")
    public void interfacciaTest15() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.interfacciaComando("numeri");

        String outputAspettato = "Tavolo da gioco:\n"
                + "\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|  1 |    |  2 |    |  3 |    |  4 |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    |  5 |    |  6 |    |  7 |    |  8 |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|  9 |    | 10 |    | 11 |    | 12 |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    | 13 |    | 14 |    | 15 |    | 16 |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "| 17 |    | 18 |    | 19 |    | 20 |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    | 21 |    | 22 |    | 23 |    | 24 |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "| 25 |    | 26 |    | 27 |    | 28 |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    | 29 |    | 30 |    | 31 |    | 32 |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("16: Test assertEquals interfacciaComando")
    public void interfacciaTest16() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.interfacciaComando("tempo");

        String outputAspettato = Costanti.ERR_PARTITA_NON_INIZIATA;

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("17: Test assertEquals interfacciaComando")
    public void interfacciaTest17() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.interfacciaComando("help");

        String outputAspettato = "\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             |\n"
                + "+---+----------------------------------+\n"
                + "| - | help                             |\n"
                + "| - | gioca                            |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "+---+----------------------------------+\n"
                + "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("18: Test assertEquals interfacciaComando")
    public void interfacciaTest18() throws UnsupportedEncodingException {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.interfacciaComando("");

        String outputAspettato = Costanti.ERR_COMANDO_INESISTENTE;

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("19: Test assertEquals interfacciaComando")
    public void interfacciaTest19() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream c = new ByteArrayInputStream("no".getBytes("UTF-8"));
        System.setIn(c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.interfacciaComando("abbandona");
        String outputAspettato = Costanti.ERR_PARTITA_NON_INIZIATA;
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("20: Test assertEquals interfacciaComando")
    public void interfacciaTest20() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream c = new ByteArrayInputStream("no".getBytes("UTF-8"));
        System.setIn(c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.interfacciaComando("esci");
        String outputAspettato = Costanti.RICHIESTA_USCITA_APP;
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("21: Test assertEquals interfacciaComando")
    public void interfacciaTest21() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream c = new ByteArrayInputStream("no".getBytes("UTF-8"));
        System.setIn(c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.getPartita().setInCorso(true);
        interfaccia.getPartita().getTavolo().popolaDamiera();
        interfaccia.interfacciaComando("damiera");

        String outputAspettato = "Tavolo da gioco:\n"
                + "\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "| ⛀  |    | ⛀  |    | ⛀  |    | ⛀  |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    | ⛀  |    | ⛀  |    | ⛀  |    | ⛀  |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "| ⛀  |    | ⛀  |    | ⛀  |    | ⛀  |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    |    |    |    |    |    |    |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    |    |    |    |    |    |    |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    | ⛂  |    | ⛂  |    | ⛂  |    | ⛂  |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "| ⛂  |    | ⛂  |    | ⛂  |    | ⛂  |    |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "|    | ⛂  |    | ⛂  |    | ⛂  |    | ⛂  |\n"
                + "-----+----+----+----+----+----+----+-----\n"
                + "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("22: Test assertEquals interfacciaComando")
    public void interfacciaTest22() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream c = new ByteArrayInputStream("no".getBytes("UTF-8"));
        System.setIn(c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.getPartita().setInCorso(true);
        interfaccia.getPartita().getTavolo().popolaDamiera();
        interfaccia.interfacciaComando("tempo");

        String outputAspettato = "";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("23: Test assertEquals interfacciaComando")
    public void interfacciaTest23() throws UnsupportedEncodingException {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream c = new ByteArrayInputStream("no".getBytes("UTF-8"));
        System.setIn(c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.getPartita().setInCorso(true);
        interfaccia.getPartita().getTavolo().popolaDamiera();
        interfaccia.interfacciaComando("abbandona");

        String outputAspettato = "";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
        System.setIn(sysInBackup);
    }

}
