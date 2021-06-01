package it.uniba.dama;

import it.uniba.utilita.Costanti;
import it.uniba.utilita.Cronometro;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Classe che rappresenta i casi di test della classe Giocatore
 */
public final class GiocatoreTest {

    //Test giocatore
    @Test
    @DisplayName("1: Test assertNotNull giocatore")
    public void giocatoreTest1() {
        Giocatore giocatore = new Giocatore("bianco");
        assertNotNull(giocatore);
    }

    //Test sul campo colore
    @Test
    @DisplayName("2: Test assertEquals getColore")
    public void giocatoreTest2() {
        Giocatore giocatore = new Giocatore("bianco");
        assertEquals("bianco", giocatore.getColore());
    }

    @Test
    @DisplayName("3: Test assertNotNull getColore")
    public void giocatoreTest3() {
        Giocatore giocatore = new Giocatore("bianco");
        assertNotNull(giocatore.getColore());
    }

    @Test
    @DisplayName("4: Test assertTrue lunghezza getColore")
    public void giocatoreTest4() {
        Giocatore giocatore = new Giocatore("bianco");
        assertTrue(giocatore.getColore().length() > 0);
    }

    @Test
    @DisplayName("5: Test assertEquals setColore")
    public void giocatoreTest5() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setColore("nero");
        assertEquals("nero", giocatore.getColore());
    }

    @Test
    @DisplayName("6: Test assertNotNull setColore")
    public void giocatoreTest6() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setColore("nero");
        assertNotNull(giocatore.getColore());
    }

    @Test
    @DisplayName("7: Test assertTrue setColore")
    public void giocatoreTest7() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setColore("nero");
        assertTrue(giocatore.getColore().length() > 0);
    }

    //Test sul campo tempoPrecedente
    @Test
    @DisplayName("8: Test assertTrue getTempoPrecedente")
    public void giocatoreTest8() {
        Giocatore giocatore = new Giocatore("bianco");
        assertTrue(giocatore.getTempoPrecedente() >= 0);
    }

    @Test
    @DisplayName("9: Test assertTrue getTempoPrecedente")
    public void giocatoreTest9() {
        Giocatore giocatore = new Giocatore("bianco");
        assertTrue(giocatore.getTempoPrecedente() < Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("10: Test assertEquals setTempoPrecedente")
    public void giocatoreTest10() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setTempoPrecedente(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, giocatore.getTempoPrecedente());
    }

    @Test
    @DisplayName("11: Test assertTrue setTempoPrecedente")
    public void giocatoreTest11() {
        Giocatore giocatore = new Giocatore("bianco");
        final int numero = 10;
        giocatore.setTempoPrecedente(numero);
        assertTrue(giocatore.getTempoPrecedente() >= 0);
    }

    @Test
    @DisplayName("12: Test assertTrue setTempoPrecedente")
    public void giocatoreTest12() {
        Giocatore giocatore = new Giocatore("bianco");
        final int numero = 10;
        giocatore.setTempoPrecedente(numero);
        assertTrue(giocatore.getTempoPrecedente() < Integer.MAX_VALUE);
    }

    //Test sul campo pedinePrese
    @Test
    @DisplayName("13: Test assertEquals getPedinePrese")
    public void giocatoreTest13() {
        Giocatore giocatore = new Giocatore("bianco");
        assertEquals(0, giocatore.getPedinePrese().size());
    }

    @Test
    @DisplayName("14: Test assertNotEquals getPedinePrese")
    public void giocatoreTest14() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setPedinePrese(Costanti.PEDINA_BIANCA);
        assertNotEquals(0, giocatore.getPedinePrese().size());
    }

    @Test
    @DisplayName("15: Test assertEquals getPedinePrese")
    public void giocatoreTest15() {
        Giocatore giocatore = new Giocatore("bianco");
        assertEquals(0, giocatore.getPedinePrese().size());
    }

    @Test
    @DisplayName("16: Test assertTrue setPedinePrese")
    public void giocatoreTest16() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setPedinePrese(Costanti.PEDINA_BIANCA);
        assertTrue(giocatore.getPedinePrese().size() >= 1);
    }

    @Test
    @DisplayName("17: Test assertEquals setPedinePrese")
    public void giocatoreTest17() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setPedinePrese(Costanti.PEDINA_BIANCA);
        giocatore.setPedinePrese(Costanti.PEDINA_NERA);
        giocatore.setPedinePrese(Costanti.PEDINA_BIANCA);

        ArrayList<Pedina> pedine = new ArrayList<Pedina>();
        pedine.add(Costanti.PEDINA_BIANCA);
        pedine.add(Costanti.PEDINA_NERA);
        pedine.add(Costanti.PEDINA_BIANCA);
        assertEquals(pedine, giocatore.getPedinePrese());
    }

    //Test sul campo cronometro
    @Test
    @DisplayName("18: Test assertNotNull getCronometro")
    public void giocatoreTest18() {
        Giocatore giocatore = new Giocatore("bianco");
        assertNotNull(giocatore.getCronometro());
    }

    @Test
    @DisplayName("19: Test assertNotNull setCronometro")
    public void giocatoreTest19() {
        Giocatore giocatore = new Giocatore("bianco");
        Cronometro cronometro = new Cronometro(0);
        giocatore.setCronometro(cronometro);
        assertNotNull(giocatore.getCronometro());
    }

    @Test
    @DisplayName("20: Test assertNotNull resettaCronometro")
    public void giocatoreTest20() {
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.resettaCronometro();
        assertNotNull(giocatore.getCronometro());
    }

}
