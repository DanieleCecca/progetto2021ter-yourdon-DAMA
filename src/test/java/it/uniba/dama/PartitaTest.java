package it.uniba.dama;

import it.uniba.utilita.Costanti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Classe che rappresenta i casi di test riguardanti la classe Partita
 */
public final class PartitaTest {
    //Test Partita
    @Test
    @DisplayName("1: Test assertNotNull partita")
    public void partitaTest1() {
        Partita partita = new Partita();
        assertNotNull(partita);
    }

    //Test sul campo bianco
    @Test
    @DisplayName("2: Test assertNull getBianco")
    public void partitaTest2() {
        Partita partita = new Partita();
        assertNull(partita.getBianco());
    }

    @Test
    @DisplayName("3: Test assertNotNull setBianco")
    public void partitaTest3() {
        Partita partita = new Partita();
        Giocatore bianco = new Giocatore("bianco");
        partita.setBianco(bianco);
        assertNotNull(partita.getBianco());
    }

    @Test
    @DisplayName("4: Test assertEquals setBianco")
    public void partitaTest4() {
        Partita partita = new Partita();
        Giocatore bianco = new Giocatore("bianco");
        partita.setBianco(bianco);
        assertEquals(bianco, partita.getBianco());
    }

    //Test sul campo nero
    @Test
    @DisplayName("5: Test assertNull getNero")
    public void partitaTest5() {
        Partita partita = new Partita();
        assertNull(partita.getNero());
    }

    @Test
    @DisplayName("6: Test assertNotNull setNero")
    public void partitaTest6() {
        Partita partita = new Partita();
        Giocatore nero = new Giocatore("nero");
        partita.setNero(nero);
        assertNotNull(partita.getNero());
    }

    @Test
    @DisplayName("7: Test assertEquals setNero")
    public void partitaTest7() {
        Partita partita = new Partita();
        Giocatore nero = new Giocatore("nero");
        partita.setNero(nero);
        assertEquals(nero, partita.getNero());
    }

    //Test sul campo tavolo
    @Test
    @DisplayName("8: Test assertNotNull getTavolo")
    public void partitaTest8() {
        Partita partita = new Partita();
        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("9: Test assertNotNull setTavolo")
    public void partitaTest9() {
        Partita partita = new Partita();
        Damiera tavolo = new Damiera();
        partita.setTavolo(tavolo);
        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("10: Test assertEquals setTavolo")
    public void partitaTest10() {
        Partita partita = new Partita();
        Damiera tavolo = new Damiera();
        partita.setTavolo(tavolo);
        assertEquals(tavolo, partita.getTavolo());
    }

    //Test sul campo inCorso
    @Test
    @DisplayName("11: Test assertFalse getInCorso")
    public void partitaTest11() {
        Partita partita = new Partita();
        assertFalse(partita.getInCorso());
    }

    @Test
    @DisplayName("12: Test assertTrue setInCorso")
    public void partitaTest12() {
        Partita partita = new Partita();
        partita.setInCorso(true);
        assertTrue(partita.getInCorso());
    }

    //Test sul campo turno
    @Test
    @DisplayName("13: Test assertNull getTurno")
    public void partitaTest13() {
        Partita partita = new Partita();
        assertNull(partita.getTurno());
    }

    @Test
    @DisplayName("14: Test assertEquals setTurno")
    public void partitaTest14() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        assertEquals("bianco", partita.getTurno());
    }

    @Test
    @DisplayName("15: Test assertNotNull setTurno")
    public void partitaTest15() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        assertNotNull(partita.getTurno());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    //Test metodo mosse
    @Test
    @DisplayName("16: Test assertEquals mosse")
    public void partitaTest16() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Partita partita = new Partita();
        partita.mosse();

        String outputAspettato = "+--------------------------+\n"
                + "|   |     MOSSE GIOCATE    \n"
                + "+--------------------------+\n"
                + "+--------------------------+\n"
                + "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    //Test metodo prese
    @Test
    @DisplayName("17: Test assertEquals prese")
    public void partitaTest17() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Partita partita = new Partita();

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");

        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.prese();

        String outputAspettato = "+-------------------------------\n"
                + "|   Bianco:  \n"
                + "+-------------------------------\n"
                + "|   Nero:    \n"
                + "+-------------------------------\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    //Test metodo aggiungiMossa
    @Test
    @DisplayName("18: Test assertEquals aggiungiMossa")
    public void partitaTest18() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        partita.aggiungiMossa("1-1");

        ArrayList<String> mosse = new ArrayList<String>();
        mosse.add("B | 1-1");

        assertEquals(mosse, partita.getCronologiaMosse());
    }

    //Test metodo tempo
    @Test
    @DisplayName("19: Test assertEquals tempo")
    public void partitaTest19() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");

        partita.setBianco(bianco);
        partita.setNero(nero);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        partita.tempo();

        String outputAspettato = "+----------------------------+\n"
                + "|   Tempo giocatore bianco   |\n"
                + "+----------------------------+\n"
                + "|     0 h 0 min 0 sec        |\n"
                + "+----------------------------+\n"
                + "+----------------------------+\n"
                + "|   Tempo giocatore nero     |\n"
                + "+----------------------------+\n"
                + "|     0 h 0 min 0 sec        |\n"
                + "+----------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("20: Test assertEquals abbandona")
    public void partitaTest20() throws UnsupportedEncodingException {
        //input automatico
        ByteArrayInputStream in = new ByteArrayInputStream("no".getBytes("UTF-8"));
        System.setIn(in);

        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        //cattura stampe
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        partita.abbandona();

        String outputAspettato = "Sei sicuro di voler abbandonare? (si/no): ";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    //mettendo cambio turno pubblico
    @Test
    @DisplayName("21: Test assertEquals cambioTurno")
    public void partitaTest21() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);


        partita.cambiaTurno();

        assertEquals("nero", partita.getTurno());
    }

    //mettendo controllo sintassi pubblico
    @Test
    @DisplayName("22: Test assertTrue controlloSintassi")
    public void partitaTest22() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        String comando = "21-18";

        assertTrue(partita.controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO));
    }

    //mettendo controllo sintassi pubblico
    @Test
    @DisplayName("23: Test assertFalse controlloSintassi")
    public void partitaTest23() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        String comando = "falso";

        assertFalse(partita.controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO));
    }

    //mettendo controllo sintassi pubblico
    @Test
    @DisplayName("24: Test assertTrue controlloSintassi")
    public void partitaTest24() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        String comando = "21x18";

        assertTrue(partita.controlloSintassi(comando, Costanti.PATTERN_PRESA));
    }

    //mettendo controllo sintassi pubblico
    @Test
    @DisplayName("25: Test assertFalse controlloSintassi")
    public void partitaTest25() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        String comando = "falso";

        assertFalse(partita.controlloSintassi(comando, Costanti.PATTERN_PRESA));
    }

    //mettendo controllo sintassi pubblico
    @Test
    @DisplayName("26: Test assertTrue controlloSintassi")
    public void partitaTest26() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        String comando = "21x18x16";

        assertTrue(partita.controlloSintassi(comando, Costanti.PATTERN_PRESA_MULTIPLA));
    }

    //mettendo controllo sintassi pubblico
    @Test
    @DisplayName("27: Test assertFalse controlloSintassi")
    public void partitaTest27() {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        String comando = "falso";

        assertFalse(partita.controlloSintassi(comando, Costanti.PATTERN_PRESA_MULTIPLA));
    }

    @Test
    @DisplayName("28: Test assertEquals gioca")
    public void partitaTest28() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        String comando = "comando inesistente";
        partita.gioca(comando);
        String outputAspettato = "Comando inesistente.\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("29: Test assertEquals gioca")
    public void partitaTest29() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);
        partita.getTavolo().popolaDamiera();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        String comando = "damiera";
        partita.gioca(comando);
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
    }

    @Test
    @DisplayName("30: Test assertEquals gioca")
    public void partitaTest30() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);
        partita.getTavolo().popolaDamiera();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));


        String comando = "numeri";
        partita.gioca(comando);
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

    //mettere system.out.print in interfaccia.helppartita
    @Test
    @DisplayName("31: Test assertEquals gioca")
    public void partitaTest31() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);
        partita.getTavolo().popolaDamiera();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));


        String comando = "help";
        partita.gioca(comando);
        String outputAspettato = "\n"
                + "Le mosse sono descritte in notazione algebrica\n"
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
    @DisplayName("32: Test assertEquals gioca")
    public void partitaTest32() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);
        partita.getTavolo().popolaDamiera();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));


        String comando = "tempo";
        partita.gioca(comando);
        String outputAspettato = "+----------------------------+\n"
                + "|   Tempo giocatore bianco   |\n"
                + "+----------------------------+\n"
                + "|     0 h 0 min 0 sec        |\n"
                + "+----------------------------+\n"
                + "+----------------------------+\n"
                + "|   Tempo giocatore nero     |\n"
                + "+----------------------------+\n"
                + "|     0 h 0 min 0 sec        |\n"
                + "+----------------------------+\n"
                + "\n";
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("33: Test assertEquals gioca")
    public void partitaTest33() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);
        partita.getTavolo().popolaDamiera();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));


        String comando = "mosse";
        partita.gioca(comando);
        String outputAspettato = "+--------------------------+\n"
                + "|   |     MOSSE GIOCATE    \n"
                + "+--------------------------+\n"
                + "+--------------------------+\n"
                + "\n";
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("34: Test assertEquals gioca")
    public void partitaTest35() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);
        partita.getTavolo().popolaDamiera();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));


        String comando = "prese";
        partita.gioca(comando);
        String outputAspettato = "+-------------------------------\n"
                + "|   Bianco:  \n"
                + "+-------------------------------\n"
                + "|   Nero:    \n"
                + "+-------------------------------\n"
                + "\n";
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("36: Test assertEquals gioca")
    public void partitaTest36() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);
        partita.getTavolo().popolaDamiera();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));


        String comando = "gioca";
        partita.gioca(comando);
        String outputAspettato = Costanti.ERR_PARTITA_GIA_INIZIATA;
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("37: Test assertEquals setCronologiaMosse")
    public void partitaTest37() {
        Partita partita = new Partita();

        ArrayList<String> cronologia = new ArrayList<String>();
        cronologia.add("mossa");

        partita.setCronologiaMosse(cronologia);
        assertEquals(cronologia, partita.getCronologiaMosse());
    }

    @Test
    @DisplayName("38: Test assertNotNull gioca")
    public void partitaTest38() {
        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.gioca("21-18");
        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("39: Test assertNotNull gioca")
    public void partitaTest39() {
        Partita partita = new Partita();
        partita.setTurno("nero");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.getTavolo().popolaDamiera();

        partita.gioca("11-14");

        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("40: Test assertNotNull gioca")
    public void partitaTest40() {
        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.getTavolo().popolaDamiera();

        String[] mosse = new String[]{
                "21-18",
                "11-14",
                "18x11"
        };

        final int numero = 3;
        for (int i = 0; i < numero; i++) {
            partita.gioca(mosse[i]);
        }

        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("41: Test assertNotNull gioca")
    public void partitaTest41() {
        Partita partita = new Partita();
        partita.setTurno("nero");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.getTavolo().popolaDamiera();

        String[] mosse = new String[]{
                "11-14",
                "21-18",
                "14x21"
        };

        final int numero = 3;
        for (int i = 0; i < numero; i++) {
            System.out.println(mosse[i]);
            partita.gioca(mosse[i]);
        }

        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("42: Test assertNotNull gioca")
    public void partitaTest42() {
        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.getTavolo().popolaDamiera();

        String[] mosse = new String[]{
                "21-18",
                "11-14",
                "23-20",
                "12-16",
                "27-23",
                "7-12",
                "30-27",
                "14x21x30"
        };

        final int numero = 8;
        for (int i = 0; i < numero; i++) {
            partita.gioca(mosse[i]);
        }

        partita.getTavolo().stampaDamieraGioco();
        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("43: Test assertNotNull gioca")
    public void partitaTest43() {
        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.getTavolo().popolaDamiera();

        String[] mosse = new String[]{
                "21-18",
                "11-14",
                "23-20",
                "12-16",
                "27-23",
                "7-12",
                "30-27",
                "14x21x30",
                "23-19",
                "12-15",
                "25-21",
                "3-7",
                "19x12x3"
        };

        final int numero = 13;
        for (int i = 0; i < numero; i++) {
            partita.gioca(mosse[i]);
        }

        assertNotNull(partita.getTavolo());
    }

    //Test metodo prese
    @Test
    @DisplayName("44: Test assertEquals prese")
    public void partitaTest44() throws UnsupportedEncodingException {
        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);


        partita.getTavolo().popolaDamiera();

        String[] mosse = new String[]{
                "23-19",
                "10-14",
                "28-23",
                "9-13",
                "23-20",
                "13-17",
                "32-28",
                "14x23x32",
                "20-15",
                "14x23x32",
                "20-15",
                "11x20",
                "24x15"
        };

        final int numero = 13;
        for (int i = 0; i < numero; i++) {
            partita.gioca(mosse[i]);
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        partita.prese();

        String outputAspettato = "+-------------------------------\n"
                + "|   Bianco:  ⛀\n"
                + "+-------------------------------\n"
                + "|   Nero:    ⛂⛂⛂\n"
                + "+-------------------------------\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    //Test metodo mosse
    @Test
    @DisplayName("45: Test assertEquals prese")
    public void partitaTest45() throws UnsupportedEncodingException {


        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        partita.setBianco(bianco);
        partita.setNero(nero);


        partita.getTavolo().popolaDamiera();

        String[] mosse = new String[]{
                "23-19",
                "10-14",
                "28-23",
                "9-13",
                "23-20",
                "13-17",
                "32-28",
                "14x23x32",
                "20-15",
                "14x23x32",
                "20-15",
                "11x20",
                "24x15"
        };

        final int numero = 13;
        for (int i = 0; i < numero; i++) {
            partita.gioca(mosse[i]);
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        partita.mosse();

        String outputAspettato = "+--------------------------+\n"
                + "|   |     MOSSE GIOCATE    \n"
                + "+--------------------------+\n"
                + "| B | 23-19                 \n"
                + "| N | 10-14                 \n"
                + "| B | 28-23                 \n"
                + "| N | 9-13                 \n"
                + "| B | 23-20                 \n"
                + "| N | 13-17                 \n"
                + "| B | 32-28                 \n"
                + "| N | 14x23x32                 \n"
                + "| B | 20-15                 \n"
                + "| N | 11x20                 \n"
                + "| B | 24x15                 \n"
                + "+--------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }


}
