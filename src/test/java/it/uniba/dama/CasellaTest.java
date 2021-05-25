package it.uniba.dama;

import it.uniba.utilita.Costanti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CasellaTest {

    //Test casella
    @Test
    @DisplayName("1: Test assertNotNull Casella")
    public void CasellaTest_1() {
        Casella casella = new Casella();
        assertNotNull(casella);
    }

    @Test
    @DisplayName("2: Test assertTrue getNumeroCasella")
    public void CasellaTest_2() {
        Casella casella = new Casella();
        casella.setNumeroCasella(5);
        assertTrue(casella.getNumeroCasella() >= 1 && casella.getNumeroCasella() <= 32);
    }

    @Test
    @DisplayName("3: Test assertEquals setNumeroCasella")
    public void CasellaTest_3() {
        Casella casella = new Casella();
        casella.setNumeroCasella(1);
        assertEquals(1, casella.getNumeroCasella());
    }

    @Test
    @DisplayName("4: Test assertTrue getPedina")
    public void CasellaTest_4() {
        Casella casella = new Casella();
        Pedina pedina = new Pedina("", "");
        casella.setPedina(pedina);
        assertTrue(pedina.equals(casella.getPedina()));
    }

    @Test
    @DisplayName("5: Test assertEquals setPedina")
    public void CasellaTest_5() {
        Casella casella = new Casella();
        casella.setPedina(Costanti.PEDINA_BIANCA);
        assertEquals(Costanti.PEDINA_BIANCA, casella.getPedina());
    }

    @Test
    @DisplayName("6: Test assertFalse getOccupato")
    public void CasellaTest_6() {
        Casella casella = new Casella();
        assertFalse(casella.getOccupato());
    }

    @Test
    @DisplayName("7: Test assertEquals setOccupato")
    public void CasellaTest_7() {
        Casella casella = new Casella();
        casella.setOccupato(true);
        assertTrue(casella.getOccupato());
    }

    @Test
    @DisplayName("8: Test assertEquals getCoordinata")
    public void CasellaTest_8() {
        Casella casella = new Casella();
        assertNotNull(casella.getCoordinata());
    }

    @Test
    @DisplayName("9: Test assertNotNull setCoordinata")
    public void CasellaTest_9() {
        Casella casella = new Casella();
        casella.setCoordinata(casella.getCoordinata());
        assertNotNull(casella.getCoordinata());
    }

    //Test coordinata
    @Test
    @DisplayName("1: Test assertNotNull Coordinata")
    public void CoordinataTest_1() {
        Coordinata coordinata = new Coordinata();
        assertNotNull(coordinata);
    }

    @Test
    @DisplayName("2: Test assertNotNull getX")
    public void CoordinataTest_2() {
        Coordinata coordinata = new Coordinata();
        assertNotNull(coordinata.getX());
    }

    @Test
    @DisplayName("3: Test assertEquals setX")
    public void CoordinataTest_3() {
        Coordinata coordinata = new Coordinata();
        coordinata.setX(4);
        assertEquals(4, coordinata.getX());
    }

    @Test
    @DisplayName("4: Test assertNotNull getY")
    public void CoordinataTest_4() {
        Coordinata coordinata = new Coordinata();
        assertNotNull(coordinata.getY());
    }

    @Test
    @DisplayName("5: Test assertEquals setY")
    public void CoordinataTest_5() {
        Coordinata coordinata = new Coordinata();
        coordinata.setY(6);
        assertEquals(6, coordinata.getY());
    }
}
