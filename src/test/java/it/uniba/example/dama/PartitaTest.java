package it.uniba.example.dama;

import it.uniba.dama.Damiera;
import it.uniba.dama.Giocatore;
import it.uniba.dama.Partita;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

import it.uniba.utilita.Costanti;
import it.uniba.utilita.Cronometro;
import it.uniba.utilita.Interfaccia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void PartitaTest_20(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Partita partita = new Partita();
        partita.mosse();

        String outputAspettato = "+--------------------------+\n" +
                "|   |     MOSSE GIOCATE    \n" +
                "+--------------------------+\n" +
                "+--------------------------+\n" +
                "\n";

        assertEquals(outputAspettato, outContent.toString());
    }

    //Test metodo prese
    @Test
    @DisplayName("21: Test assertEquals prese")
    public void PartitaTest_21(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

        Partita partita = new Partita();

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");

        partita.setBianco(bianco);
        partita.setNero(bianco);

        partita.prese();

        String outputAspettato = "+-------------------------------\n" +
                "|   Bianco:  \n" +
                "+-------------------------------\n" +
                "|   Nero:    \n" +
                "+-------------------------------\n\n";

        assertEquals(outputAspettato, outContent.toString());
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
    public void PartitaTest_23(){
        Partita partita = new Partita();
        partita.setTurno("bianco");

        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");

        partita.setBianco(bianco);
        partita.setNero(bianco);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

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

        assertEquals(outputAspettato, outContent.toString());
    }

}
