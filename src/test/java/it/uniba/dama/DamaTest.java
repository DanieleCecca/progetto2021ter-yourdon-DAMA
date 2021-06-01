package it.uniba.dama;

import it.uniba.utilita.Costanti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe che rappresenta i casi di test della classe Dama
 */
public final class DamaTest {

    //Test dama
    @Test
    @DisplayName("1: Test assertNotNull Dama")
    public void damaTest1() {
        Dama dama = new Dama();
        assertNotNull(dama);
    }

    @Test
    @DisplayName("2: Test assertNotNull Dama")
    public void damaTest2() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(dama);
    }

    //Test sul campo colore
    @Test
    @DisplayName("3: Test assertNotEquals getColore")
    public void damaTest3() {
        Dama dama = new Dama();
        assertNotEquals("bianco", dama.getColore());
    }

    @Test
    @DisplayName("4: Test assertEquals getColore")
    public void damaTest4() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", dama.getColore());
    }

    @Test
    @DisplayName("5: Test assertNotNull getColore")
    public void damaTest5() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(dama.getColore());
    }

    @Test
    @DisplayName("6: Test assertEquals setColore")
    public void damaTest6() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setColore("nero");
        assertEquals("nero", dama.getColore());
    }

    @Test
    @DisplayName("7: Test assertNotNull setColore")
    public void damaTest7() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setColore("nero");
        assertNotNull(dama.getColore());
    }

    //Test sul campo simbolo
    @Test
    @DisplayName("8: Test assertNotEquals getSimbolo")
    public void damaTest8() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo(Costanti.UNICODE_PEDINA_NERA);
        assertNotEquals(Costanti.UNICODE_PEDINA_BIANCA, dama.getSimbolo());
    }

    @Test
    @DisplayName("9: Test assertEquals getSimbolo")
    public void damaTest9() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo(Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", dama.getColore());
    }

    @Test
    @DisplayName("10: Test assertNotNull getSimbolo")
    public void damaTest10() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(dama.getSimbolo());
    }

    @Test
    @DisplayName("11: Test assertEquals setSimbolo")
    public void damaTest11() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo("nero");
        assertEquals("nero", dama.getSimbolo());
    }

    @Test
    @DisplayName("12: Test assertNotNull setSimbolo")
    public void damaTest12() {
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo("nero");
        assertNotNull(dama.getSimbolo());
    }
}
