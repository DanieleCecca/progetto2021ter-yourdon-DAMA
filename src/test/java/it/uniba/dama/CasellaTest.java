package it.uniba.dama;

import it.uniba.utilita.Costanti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe che rappresenta i casi di test della classe Casella
 */
public final class CasellaTest {

    //Test casella
    @Test
    @DisplayName("1: Test assertNotNull Casella")
    public void casellaTest1() {
        Casella casella = new Casella();
        assertNotNull(casella);
    }

    @Test
    @DisplayName("2: Test assertTrue getNumeroCasella")
    public void casellaTest2() {
        Casella casella = new Casella();
        final int numero = 5;
        casella.setNumeroCasella(numero);
        final int secondoNumero = 32;
        assertTrue(casella.getNumeroCasella() >= 1 && casella.getNumeroCasella() <= secondoNumero);
    }

    @Test
    @DisplayName("3: Test assertEquals setNumeroCasella")
    public void casellaTest3() {
        Casella casella = new Casella();
        casella.setNumeroCasella(1);
        assertEquals(1, casella.getNumeroCasella());
    }

    @Test
    @DisplayName("4: Test assertTrue getPedina")
    public void casellaTest4() {
        Casella casella = new Casella();
        Pedina pedina = new Pedina("", "");
        casella.setPedina(pedina);
        assertTrue(pedina.equals(casella.getPedina()));
    }

    @Test
    @DisplayName("5: Test assertEquals setPedina")
    public void casellaTest5() {
        Casella casella = new Casella();
        casella.setPedina(Costanti.PEDINA_BIANCA);
        assertEquals(Costanti.PEDINA_BIANCA, casella.getPedina());
    }

    @Test
    @DisplayName("6: Test assertFalse getOccupato")
    public void casellaTest6() {
        Casella casella = new Casella();
        assertFalse(casella.getOccupato());
    }

    @Test
    @DisplayName("7: Test assertEquals setOccupato")
    public void casellaTest7() {
        Casella casella = new Casella();
        casella.setOccupato(true);
        assertTrue(casella.getOccupato());
    }

    @Test
    @DisplayName("8: Test assertEquals getCoordinata")
    public void casellaTest8() {
        Casella casella = new Casella();
        assertNotNull(casella.getCoordinata());
    }

    @Test
    @DisplayName("9: Test assertNotNull setCoordinata")
    public void casellaTest9() {
        Casella casella = new Casella();
        casella.setCoordinata(casella.getCoordinata());
        assertNotNull(casella.getCoordinata());
    }

    //Test coordinata
    @Test
    @DisplayName("1: Test assertNotNull Coordinata")
    public void coordinataTest1() {
        Coordinata coordinata = new Coordinata();
        assertNotNull(coordinata);
    }

    @Test
    @DisplayName("2: Test assertNotNull getX")
    public void coordinataTest2() {
        Coordinata coordinata = new Coordinata();
        assertNotNull(coordinata.getX());
    }

    @Test
    @DisplayName("3: Test assertEquals setX")
    public void coordinataTest3() {
        Coordinata coordinata = new Coordinata();
        final int numero = 4;
        coordinata.setX(numero);
        assertEquals(numero, coordinata.getX());
    }

    @Test
    @DisplayName("4: Test assertNotNull getY")
    public void coordinataTest4() {
        Coordinata coordinata = new Coordinata();
        assertNotNull(coordinata.getY());
    }

    @Test
    @DisplayName("5: Test assertEquals setY")
    public void coordinataTest5() {
        Coordinata coordinata = new Coordinata();
        final int numero = 6;
        coordinata.setY(numero);
        assertEquals(numero, coordinata.getY());
    }
}
