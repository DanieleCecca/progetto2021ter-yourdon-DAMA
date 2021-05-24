package it.uniba.example.dama;

import it.uniba.dama.Dama;
import it.uniba.dama.Giocatore;
import it.uniba.dama.Partita;
import it.uniba.dama.Pedina;
import it.uniba.utilita.Costanti;
import it.uniba.utilita.Cronometro;
import it.uniba.utilita.Interfaccia;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InterfacciaTest {


    //Test Interfaccia
    @Test
    @DisplayName("1: Test assertNotNull Interfaccia")
    public void InterfacciaTest_1() {
        Interfaccia interfaccia = Interfaccia.getSingleton();
        assertNotNull(interfaccia);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("2: Test assertEquals stampaBenvenuto")
    public void InterfacciaTest_2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.stampaBenvenuto();
        String outputAspettato = "\n       Benvenuto nel gioco della\n\n"
                + "         ___   _   __  __   _   \n"
                + "        |   \\ /_\\ |  \\/  | /_\\  \n"
                + "        | |) / _ \\| |\\/| |/ _ \\ \n"
                + "        |___/_/ \\_\\_|  |_/_/ \\_\\\n"
                + "                               \n      realizzato dal gruppo YOURDON®\n\n";

        assertEquals(outputAspettato, outContent.toString());
    }

    @Test
    @DisplayName("3: Test assertEquals helpPartita")
    public void InterfacciaTest_3() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.helpPartita();
        String outputAspettato = "\nLe mosse sono descritte in notazione algebrica\n"
                + "Esempio: \n"
                + "1-5\n"
                + "1x10\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             | \n"
                + "+---+----------------------------------+\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "| - | prese                            |\n"
                + "| - | mosse                            |\n"
                + "+---+----------------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString());
    }

    @Test
    @DisplayName("4: Test assertEquals help")
    public void InterfacciaTest_4() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.help();
        String outputAspettato = "\n"
                + "+---+----------------------------------+\n"
                + "|   |              COMANDI             |\n"
                + "+---+----------------------------------+\n"
                + "| - | gioca                            |\n"
                + "| - | abbandona                        |\n"
                + "| - | esci                             |\n"
                + "| - | numeri                           |\n"
                + "| - | damiera                          |\n"
                + "| - | tempo                            |\n"
                + "+---+----------------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString());
    }

    @Test
    @DisplayName("6: Test assertEquals stampaMessaggio")
    public void InterfacciaTest_6() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.stampaMessaggio(Costanti.APPLICAZIONE_CHIUSA);
        String outputAspettato = Costanti.APPLICAZIONE_CHIUSA;

        assertEquals(outputAspettato, outContent.toString());
    }

    @Test
    @DisplayName("7: Test assertEquals stampaMessaggioInterfaccia")
    public void InterfacciaTest_7() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.stampaMessaggioInterfaccia(Costanti.TAVOLO_GIOCO);
        String outputAspettato = Costanti.TAVOLO_GIOCO;

        assertEquals(outputAspettato, outContent.toString());
    }

    @Test
    @DisplayName("8: Test assertNotNull acquisireComando")
    public void InterfacciaTest_8() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream gioca = new ByteArrayInputStream("gioca".getBytes());
        System.setIn(gioca);
        Interfaccia interfaccia = Interfaccia.getSingleton();
        String comando = interfaccia.acquisireComando();
        assertNotNull(comando);
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("9: Test assertNotNull acquisireComandoInterfaccia")
    public void InterfacciaTest_9() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream gioca = new ByteArrayInputStream("gioca".getBytes());
        System.setIn(gioca);
        Interfaccia interfaccia = Interfaccia.getSingleton();
        String comando = interfaccia.acquisireComandoInterfaccia();
        assertNotNull(comando);
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("10: Test assertEquals esci")
    public void InterfacciaTest_10() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream c = new ByteArrayInputStream("no".getBytes());
        System.setIn(c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        interfaccia.esci();
        String outputAspettato = Costanti.RICHIESTA_USCITA_APP;
        assertEquals(outputAspettato, outContent.toString());
        System.setIn(sysInBackup);
    }

    @Test
    @DisplayName("11: Test assertEquals controlloFlagHelp")
    public void InterfacciaTest_11() {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        String[] args = new String[1];
        args[0] = "";
        interfaccia.controlloFlagHelp(args);

        String outputAspettato = "\n" +
                "+---+----------------------------------+\n" +
                "|   |              COMANDI             |\n" +
                "+---+----------------------------------+\n" +
                "| - | gioca                            |\n" +
                "| - | abbandona                        |\n" +
                "| - | esci                             |\n" +
                "| - | numeri                           |\n" +
                "| - | damiera                          |\n" +
                "| - | tempo                            |\n" +
                "+---+----------------------------------+\n" +
                "\n";

        assertEquals(outputAspettato, outContent.toString());
    }

    @Test
    @DisplayName("12: Test assertEquals controlloFlagHelp")
    public void InterfacciaTest_12() {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        String[] args = new String[1];
        args[0] = "--help";
        interfaccia.controlloFlagHelp(args);

        String outputAspettato = "\n" +
                "+---+----------------------------------+\n" +
                "|   |              COMANDI             |\n" +
                "+---+----------------------------------+\n" +
                "| - | gioca                            |\n" +
                "| - | abbandona                        |\n" +
                "| - | esci                             |\n" +
                "| - | numeri                           |\n" +
                "| - | damiera                          |\n" +
                "| - | tempo                            |\n" +
                "+---+----------------------------------+\n" +
                "\n";

        assertEquals(outputAspettato, outContent.toString());
    }

    @Test
    @DisplayName("13: Test assertEquals controlloFlagHelp")
    public void InterfacciaTest_13() {

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Interfaccia interfaccia = Interfaccia.getSingleton();
        String[] args = new String[1];
        args[0] = "-h";
        interfaccia.controlloFlagHelp(args);

        String outputAspettato = "\n" +
                "+---+----------------------------------+\n" +
                "|   |              COMANDI             |\n" +
                "+---+----------------------------------+\n" +
                "| - | gioca                            |\n" +
                "| - | abbandona                        |\n" +
                "| - | esci                             |\n" +
                "| - | numeri                           |\n" +
                "| - | damiera                          |\n" +
                "| - | tempo                            |\n" +
                "+---+----------------------------------+\n" +
                "\n";

        assertEquals(outputAspettato, outContent.toString());
    }

}
