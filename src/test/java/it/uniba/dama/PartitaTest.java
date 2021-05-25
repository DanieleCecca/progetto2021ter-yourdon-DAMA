package it.uniba.dama;

import it.uniba.utilita.Costanti;
import it.uniba.utilita.Cronometro;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;

public class PartitaTest {
    //Test Partita
    @Test
    @DisplayName("1: Test assertNotNull partita")
    public void PartitaTest_1(){
        Partita partita = new Partita();
        assertNotNull(partita);
    }

    //Test sul campo bianco
    @Test
    @DisplayName("2: Test assertNull getBianco")
    public void PartitaTest_2(){
        Partita partita = new Partita();
        assertNull(partita.getBianco());
    }

    @Test
    @DisplayName("3: Test assertNotNull setBianco")
    public void PartitaTest_3(){
        Partita partita = new Partita();
        Giocatore bianco = new Giocatore("bianco");
        partita.setBianco(bianco);
        assertNotNull(partita.getBianco());
    }

    @Test
    @DisplayName("4: Test assertEquals setBianco")
    public void PartitaTest_4(){
        Partita partita = new Partita();
        Giocatore bianco = new Giocatore("bianco");
        partita.setBianco(bianco);
        assertEquals(bianco, partita.getBianco());
    }

    //Test sul campo nero
    @Test
    @DisplayName("5: Test assertNull getNero")
    public void PartitaTest_5(){
        Partita partita = new Partita();
        assertNull(partita.getNero());
    }

    @Test
    @DisplayName("6: Test assertNotNull setNero")
    public void PartitaTest_6(){
        Partita partita = new Partita();
        Giocatore nero = new Giocatore("nero");
        partita.setNero(nero);
        assertNotNull(partita.getNero());
    }

    @Test
    @DisplayName("7: Test assertEquals setNero")
    public void PartitaTest_7(){
        Partita partita = new Partita();
        Giocatore nero = new Giocatore("nero");
        partita.setNero(nero);
        assertEquals(nero, partita.getNero());
    }

    //Test sul campo tavolo
    @Test
    @DisplayName("8: Test assertNotNull getTavolo")
    public void PartitaTest_8(){
        Partita partita = new Partita();
        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("9: Test assertNotNull setTavolo")
    public void PartitaTest_9(){
        Partita partita = new Partita();
        Damiera tavolo = new Damiera();
        partita.setTavolo(tavolo);
        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("10: Test assertEquals setTavolo")
    public void PartitaTest_10(){
        Partita partita = new Partita();
        Damiera tavolo = new Damiera();
        partita.setTavolo(tavolo);
        assertEquals(tavolo, partita.getTavolo());
    }

    //Test sul campo inCorso
    @Test
    @DisplayName("11: Test assertFalse getInCorso")
    public void PartitaTest_11(){
        Partita partita = new Partita();
        assertFalse(partita.getInCorso());
    }

    @Test
    @DisplayName("12: Test assertTrue setInCorso")
    public void PartitaTest_12(){
        Partita partita = new Partita();
        partita.setInCorso(true);
        assertTrue(partita.getInCorso());
    }

    //Test sul campo turno
    @Test
    @DisplayName("13: Test assertNull getTurno")
    public void PartitaTest_13(){
        Partita partita = new Partita();
        assertNull(partita.getTurno());
    }

    @Test
    @DisplayName("14: Test assertEquals setTurno")
    public void PartitaTest_14(){
        Partita partita = new Partita();
        partita.setTurno("bianco");
        assertEquals("bianco", partita.getTurno());
    }

    @Test
    @DisplayName("15: Test assertNotNull setTurno")
    public void PartitaTest_15(){
        Partita partita = new Partita();
        partita.setTurno("bianco");
        assertNotNull(partita.getTurno());
    }

    //Test sul campo cronometro
    @Test
    @DisplayName("16: Test assertNull getTempoIniziale")
    public void PartitaTest_16(){
        Partita partita = new Partita();
        assertNull(partita.getTempoIniziale());
    }

    @Test
    @DisplayName("17: Test assertNotNull setTempoIniziale")
    public void PartitaTest_17(){
        Partita partita = new Partita();
        Cronometro cronometro = new Cronometro(0);
        partita.setTempoIniziale(cronometro);
        assertNotNull(partita.getTempoIniziale());
    }

    @Test
    @DisplayName("18: Test assertEquals setTempoIniziale")
    public void PartitaTest_18(){
        Partita partita = new Partita();
        Cronometro cronometro = new Cronometro(0);
        partita.setTempoIniziale(cronometro);
        assertEquals(cronometro, partita.getTempoIniziale());
    }

    @Test
    @DisplayName("19: Test assertEquals setTempoIniziale")
    public void PartitaTest_19(){
        Partita partita = new Partita();
        Cronometro cronometro = new Cronometro(Integer.MAX_VALUE);
        partita.setTempoIniziale(cronometro);
        assertEquals(cronometro, partita.getTempoIniziale());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    //Test metodo mosse
    @Test
    @DisplayName("20: Test assertEquals mosse")
    public void PartitaTest_20() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Partita partita = new Partita();
        partita.mosse();

        String outputAspettato = "+--------------------------+\n" +
                "|   |     MOSSE GIOCATE    \n" +
                "+--------------------------+\n" +
                "+--------------------------+\n" +
                "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    //Test metodo prese
    @Test
    @DisplayName("21: Test assertEquals prese")
    public void PartitaTest_21() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Partita partita = new Partita();

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");

        partita.setBianco(bianco);
        partita.setNero(nero);

        partita.prese();

        String outputAspettato = "+-------------------------------\n" +
                "|   Bianco:  \n" +
                "+-------------------------------\n" +
                "|   Nero:    \n" +
                "+-------------------------------\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    //Test metodo aggiungiMossa
    @Test
    @DisplayName("22: Test assertEquals aggiungiMossa")
    public void PartitaTest_22(){
        Partita partita = new Partita();
        partita.setTurno("bianco");
        partita.aggiungiMossa("1-1");

        ArrayList<String> mosse = new ArrayList<String>();
        mosse.add("B | 1-1");

        assertEquals(mosse, partita.getCronologiaMosse());
    }

    //Test metodo tempo
    @Test
    @DisplayName("23: Test assertEquals tempo")
    public void PartitaTest_23() throws UnsupportedEncodingException {
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

        String outputAspettato = "+----------------------------+\n" +
                "|   Tempo giocatore bianco   |\n" +
                "+----------------------------+\n" +
                "|     0 h 0 min 0 sec        |\n" +
                "+----------------------------+\n" +
                "+----------------------------+\n" +
                "|   Tempo giocatore nero     |\n" +
                "+----------------------------+\n" +
                "|     0 h 0 min 0 sec        |\n" +
                "+----------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("24: Test assertEquals abbandona")
    public void PartitaTest_24() throws UnsupportedEncodingException {
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
    @DisplayName("25: Test assertEquals cambioTurno")
    public void PartitaTest_25(){
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
    @DisplayName("26: Test assertTrue controlloSintassi")
    public void PartitaTest_26(){
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
    @DisplayName("27: Test assertFalse controlloSintassi")
    public void PartitaTest_27(){
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
    @DisplayName("28: Test assertTrue controlloSintassi")
    public void PartitaTest_28(){
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
    @DisplayName("29: Test assertFalse controlloSintassi")
    public void PartitaTest_29(){
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
    @DisplayName("30: Test assertTrue controlloSintassi")
    public void PartitaTest_30(){
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
    @DisplayName("31: Test assertFalse controlloSintassi")
    public void PartitaTest_31(){
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
    @DisplayName("32: Test assertEquals gioca")
    public void PartitaTest_32() throws UnsupportedEncodingException {
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
    @DisplayName("33: Test assertEquals gioca")
    public void PartitaTest_33() throws UnsupportedEncodingException {
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
        String outputAspettato = "Tavolo da gioco:\n" +
                "\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "| ⛀  |    | ⛀  |    | ⛀  |    | ⛀  |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    | ⛀  |    | ⛀  |    | ⛀  |    | ⛀  |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "| ⛀  |    | ⛀  |    | ⛀  |    | ⛀  |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    |    |    |    |    |    |    |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    |    |    |    |    |    |    |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    | ⛂  |    | ⛂  |    | ⛂  |    | ⛂  |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "| ⛂  |    | ⛂  |    | ⛂  |    | ⛂  |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    | ⛂  |    | ⛂  |    | ⛂  |    | ⛂  |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("34: Test assertEquals gioca")
    public void PartitaTest_34() throws UnsupportedEncodingException {
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
        String outputAspettato = "Tavolo da gioco:\n" +
                "\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|  1 |    |  2 |    |  3 |    |  4 |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    |  5 |    |  6 |    |  7 |    |  8 |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|  9 |    | 10 |    | 11 |    | 12 |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    | 13 |    | 14 |    | 15 |    | 16 |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "| 17 |    | 18 |    | 19 |    | 20 |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    | 21 |    | 22 |    | 23 |    | 24 |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "| 25 |    | 26 |    | 27 |    | 28 |    |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "|    | 29 |    | 30 |    | 31 |    | 32 |\n" +
                "-----+----+----+----+----+----+----+-----\n" +
                "\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    //mettere system.out.print in interfaccia.helppartita
    @Test
    @DisplayName("35: Test assertEquals gioca")
    public void PartitaTest_35() throws UnsupportedEncodingException {
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
        String outputAspettato = "\n" +
                "Le mosse sono descritte in notazione algebrica\n" +
                "Esempio: \n" +
                "1-5\n" +
                "1x10\n" +
                "+---+----------------------------------+\n" +
                "|   |              COMANDI             | \n" +
                "+---+----------------------------------+\n" +
                "| - | abbandona                        |\n" +
                "| - | esci                             |\n" +
                "| - | numeri                           |\n" +
                "| - | damiera                          |\n" +
                "| - | tempo                            |\n" +
                "| - | prese                            |\n" +
                "| - | mosse                            |\n" +
                "+---+----------------------------------+\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("36: Test assertEquals gioca")
    public void PartitaTest_36() throws UnsupportedEncodingException {
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
        String outputAspettato = "+----------------------------+\n" +
                "|   Tempo giocatore bianco   |\n" +
                "+----------------------------+\n" +
                "|     0 h 0 min 0 sec        |\n" +
                "+----------------------------+\n" +
                "+----------------------------+\n" +
                "|   Tempo giocatore nero     |\n" +
                "+----------------------------+\n" +
                "|     0 h 0 min 0 sec        |\n" +
                "+----------------------------+\n" +
                "\n";
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("37: Test assertEquals gioca")
    public void PartitaTest_37() throws UnsupportedEncodingException {
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
        String outputAspettato = "+--------------------------+\n" +
                "|   |     MOSSE GIOCATE    \n" +
                "+--------------------------+\n" +
                "+--------------------------+\n" +
                "\n";
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("38: Test assertEquals gioca")
    public void PartitaTest_38() throws UnsupportedEncodingException {
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
        String outputAspettato = "+-------------------------------\n" +
                "|   Bianco:  \n" +
                "+-------------------------------\n" +
                "|   Nero:    \n" +
                "+-------------------------------\n" +
                "\n";
        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("39: Test assertEquals gioca")
    public void PartitaTest_39() throws UnsupportedEncodingException {
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
    @DisplayName("41: Test assertEquals setCronologiaMosse")
    public void PartitaTest_41(){
        Partita partita = new Partita();

        ArrayList<String> cronologia = new ArrayList<String>();
        cronologia.add("mossa");

        partita.setCronologiaMosse(cronologia);
        assertEquals(cronologia, partita.getCronologiaMosse());
    }

    @Test
    @DisplayName("42: Test assertNotNull gioca")
    public void PartitaTest_42(){
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
    @DisplayName("43: Test assertNotNull gioca")
    public void PartitaTest_43(){
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
    @DisplayName("44: Test assertNotNull gioca")
    public void PartitaTest_44(){
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
        for(int i = 0; i < 3; i++){
            partita.gioca(mosse[i]);
        }

        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("45: Test assertNotNull gioca")
    public void PartitaTest_45(){
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

        for(int i = 0; i < 3; i++){
            System.out.println(mosse[i]);
            partita.gioca(mosse[i]);
        }

        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("46: Test assertNotNull gioca")
    public void PartitaTest_46(){
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
        for(int i = 0; i < 8; i++){
            partita.gioca(mosse[i]);
        }

        partita.getTavolo().stampaDamieraGioco();
        assertNotNull(partita.getTavolo());
    }

    @Test
    @DisplayName("47: Test assertNotNull gioca")
    public void PartitaTest_47(){
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
        for(int i = 0; i < 13; i++){
            partita.gioca(mosse[i]);
        }

        assertNotNull(partita.getTavolo());
    }




}
