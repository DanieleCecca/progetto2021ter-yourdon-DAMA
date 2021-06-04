package it.uniba.dama;

import it.uniba.utilita.Costanti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Classe che rappresenta i casi di test della classe Damiera
 */
public final class DamieraTest {

    @Test
    @DisplayName("1: Test assertNull Damiera")
    public void damieraTest1() {
        Damiera damiera = new Damiera();

        assertNotNull(damiera);
    }

    @Test
    @DisplayName("2: Test assertNull Damiera")
    public void damieraTest2() {
        Damiera copia = new Damiera();
        Damiera damiera = new Damiera(copia);
        assertNotNull(damiera);
    }


    @Test
    @DisplayName("3: Test assertNotNull popolaDamiera")
    public void damieraTest3() {
        Damiera damiera = new Damiera();
        damiera.popolaDamiera();
        assertAll(
                () -> {
                    //controllo sulle pedine del giocatore 1
                    for (int i = 0; i < Costanti.ULTIMA_RIGA_INIZIALE_BIANCO; i++) {
                        for (int j = 0; j < Costanti.DIM; j++) {
                            if (i % Costanti.NUM_PARI == 0 && j % Costanti.NUM_PARI == 0) {
                                assertEquals(Costanti.PEDINA_NERA, damiera.getDamiera()[i][j].getPedina());
                                assertEquals(true, damiera.getDamiera()[i][j].getOccupato());
                            } else if (i % Costanti.NUM_PARI != 0 && j % Costanti.NUM_PARI != 0) {
                                assertEquals(Costanti.PEDINA_NERA, damiera.getDamiera()[i][j].getPedina());
                                assertEquals(true, damiera.getDamiera()[i][j].getOccupato());
                            }
                        }
                    }
                },
                () -> {
                    //controllo sulle pedine del giocatore 2
                    for (int i = Costanti.ULTIMA_RIGA_INIZIALE_NERO; i < Costanti.DIM; i++) {
                        for (int j = 0; j < Costanti.DIM; j++) {
                            if (i % Costanti.NUM_PARI == 0 && j % Costanti.NUM_PARI == 0) {
                                assertEquals(Costanti.PEDINA_BIANCA, damiera.getDamiera()[i][j].getPedina());
                                assertEquals(true, damiera.getDamiera()[i][j].getOccupato());
                            } else if (i % Costanti.NUM_PARI != 0 && j % Costanti.NUM_PARI != 0) {
                                assertEquals(Costanti.PEDINA_BIANCA, damiera.getDamiera()[i][j].getPedina());
                                assertEquals(true, damiera.getDamiera()[i][j].getOccupato());
                            }
                        }
                    }
                }
        );
    }

    @Test
    @DisplayName("4: Test assertEquals stampaDamieraGioco")
    public void damieraTest4() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Damiera damiera = new Damiera();
        damiera.popolaDamiera();

        damiera.stampaDamieraGioco();

        String outputAspettato = "Tavolo da gioco:\n"
                + "\n-----+----+----+----+----+----+----+-----\n"
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
    @DisplayName("5: Test assertEquals stampaDamieraNumerata")
    public void damieraTest5() throws UnsupportedEncodingException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        outContent.reset();
        System.setOut(new PrintStream(outContent, true, "UTF-8"));

        Damiera damiera = new Damiera();
        damiera.popolaDamiera();

        damiera.stampaDamieraNumerata();

        String outputAspettato = Costanti.TAVOLO_GIOCO
                + "\n-----+----+----+----+----+----+----+-----\n"
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
                + "-----+----+----+----+----+----+----+-----\n\n";

        assertEquals(outputAspettato, outContent.toString("UTF-8"));
    }

    @Test
    @DisplayName("6: Test assertEquals ricercaCasella")
    public void damieraTest6() {
        Damiera damiera = new Damiera();

        assertAll(
                () -> {
                    assertEquals(0, damiera.ricercaCasella(1).getCoordinata().getX());
                    assertEquals(0, damiera.ricercaCasella(1).getCoordinata().getY());
                }
        );
    }

    @Test
    @DisplayName("7: Test assertEquals ricercaCasella")
    public void damieraTest7() {
        Damiera damiera = new Damiera();
        final int numero = 200;
        assertNull(damiera.ricercaCasella(numero));

    }

    @ParameterizedTest(name = "{index}: {0} assertTrue spostamentoSemplice")
    @ValueSource(strings = {"25-21", "21-22", "21-18", "10-19", "9-13", "18-13"})
    public void damieraTest8(final String comando) {
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        Damiera damiera = new Damiera();
        damiera.popolaDamiera();
        try {
            assertTrue(damiera.spostamentoSemplice(bianco, comando));
            assertTrue(damiera.spostamentoSemplice(nero, comando));
        } catch (DamieraException e) {
            System.out.print(e.getMessage());
        }

    }

    @ParameterizedTest(name = "{index}: {0} assertTrue presaSemplice")
    @ValueSource(strings = {"30x21", "26x17", "10x30", "23x1", "25-21", "10x30", "21-22", "21-18", "10-19", "9-13",
            "18-13", "18x9", "10-14", "25-21", "5-10", "4x11", "11-14", "22-19", "12-16", "19x10", "19x14", "23-20",
            "14x23"})
    public void damieraTest9(final String comando) {
        Partita partita = new Partita();
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        Damiera damiera = new Damiera();
        damiera.popolaDamiera();
        if (partita.controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO)) {
            try {
                damiera.spostamentoSemplice(bianco, comando);
                damiera.spostamentoSemplice(nero, comando);
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        } else if (partita.controlloSintassi(comando, Costanti.PATTERN_PRESA)) {
            try {
                assertTrue(damiera.presaSemplice(bianco, comando));
                assertTrue(damiera.presaSemplice(nero, comando));
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    @ParameterizedTest(name = "{index}: {0} assertTrue presaMultipla")
    @ValueSource(strings = {"21-22", "21-18", "10-19", "9-13", "18-13", "18x9", "10-14", "25-21",
            "5-10", "21-17", "14-19", "23x14x7", "23x14x5"})
    public void damieraTest10(final String comando) {
        Partita partita = new Partita();
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        Damiera damiera = new Damiera();
        damiera.popolaDamiera();
        if (partita.controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO)) {
            try {
                damiera.spostamentoSemplice(bianco, comando);
                damiera.spostamentoSemplice(nero, comando);
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        } else if (partita.controlloSintassi(comando, Costanti.PATTERN_PRESA)) {
            try {
                damiera.presaSemplice(bianco, comando);
                damiera.presaSemplice(nero, comando);
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        } else if (partita.controlloSintassi(comando, Costanti.PATTERN_PRESA_MULTIPLA)) {
            try {
                assertTrue(damiera.presaMultipla(bianco, comando));
                assertTrue(damiera.presaMultipla(nero, comando));
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    @ParameterizedTest(name = "{index}: {0} assertTrue presaMultipla con damatura")
    @ValueSource(strings = {"23-19", "10-14", "28-23", "9-13", "23-20", "13-17", "32-28", "14x23x32"})
    public void damieraTest11(final String comando) {
        Partita partita = new Partita();
        Giocatore bianco = new Giocatore("bianco");
        Giocatore nero = new Giocatore("nero");
        Damiera damiera = new Damiera();
        damiera.popolaDamiera();
        if (partita.controlloSintassi(comando, Costanti.PATTERN_SPOSTAMENTO)) {
            try {
                damiera.spostamentoSemplice(bianco, comando);
                damiera.spostamentoSemplice(nero, comando);
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        } else if (partita.controlloSintassi(comando, Costanti.PATTERN_PRESA)) {
            try {
                damiera.presaSemplice(bianco, comando);
                damiera.presaSemplice(nero, comando);
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        } else if (partita.controlloSintassi(comando, Costanti.PATTERN_PRESA_MULTIPLA)) {
            try {
                assertTrue(damiera.presaMultipla(bianco, comando));
                assertTrue(damiera.presaMultipla(nero, comando));
            } catch (DamieraException e) {
                System.out.print(e.getMessage());
            }
        }
    }

}
