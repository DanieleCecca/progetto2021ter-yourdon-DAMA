package it.uniba.dama;

import it.uniba.utilita.Costanti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe che rappresenta i casi di test della classe Pedina
 */
public class PedinaTest {

    //Test pedina
    @Test
    @DisplayName("1: Test assertNotNull Pedina")
    public void pedinaTest1() {
        Pedina pedina = new Pedina();
        assertNotNull(pedina);
    }

    @Test
    @DisplayName("2: Test assertNotNull Pedina")
    public void pedinaTest2() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(pedina);
    }

    //Test sul campo colore
    @Test
    @DisplayName("3: Test assertNotEquals getColore")
    public void pedinaTest3() {
        Pedina pedina = new Pedina();
        assertNotEquals("bianco", pedina.getColore());
    }

    @Test
    @DisplayName("4: Test assertEquals getColore")
    public void pedinaTest4() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", pedina.getColore());
    }

    @Test
    @DisplayName("5: Test assertNotNull getColore")
    public void pedinaTest5() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(pedina.getColore());
    }

    @Test
    @DisplayName("6: Test assertEquals setColore")
    public void pedinaTest6() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setColore("nero");
        assertEquals("nero", pedina.getColore());
    }

    @Test
    @DisplayName("7: Test assertNotNull setColore")
    public void pedinaTest7() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setColore("nero");
        assertNotNull(pedina.getColore());
    }

    //Test sul campo simbolo
    @Test
    @DisplayName("8: Test assertNotEquals getSimbolo")
    public void pedinaTest8() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo(Costanti.UNICODE_PEDINA_NERA);
        assertNotEquals(Costanti.UNICODE_PEDINA_BIANCA, pedina.getSimbolo());
    }

    @Test
    @DisplayName("9: Test assertEquals getSimbolo")
    public void pedinaTest9() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo(Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", pedina.getColore());
    }

    @Test
    @DisplayName("10: Test assertNotNull getSimbolo")
    public void pedinaTest10() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(pedina.getSimbolo());
    }

    @Test
    @DisplayName("11: Test assertEquals setSimbolo")
    public void pedinaTest11() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo("nero");
        assertEquals("nero", pedina.getSimbolo());
    }

    @Test
    @DisplayName("12: Test assertNotNull setSimbolo")
    public void pedinaTest12() {
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo("nero");
        assertNotNull(pedina.getSimbolo());
    }
}
