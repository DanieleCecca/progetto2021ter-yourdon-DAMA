package it.uniba.example.dama;

import it.uniba.dama.Giocatore;
import static org.junit.Assume.assumeNotNull;
import static org.junit.jupiter.api.Assertions.*;

import it.uniba.dama.Pedina;
import it.uniba.utilita.Costanti;
import it.uniba.utilita.Cronometro;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class GiocatoreTest {

    //Test giocatore
    @Test
    @DisplayName("1: Test assertNotNull giocatore")
    public void GiocatoreTest_1(){
        Giocatore giocatore = new Giocatore("bianco");
        assertNotNull(giocatore);
    }

    //Test sul campo colore
    @Test
    @DisplayName("2: Test assertEquals getColore")
    public void GiocatoreTest_2(){
        Giocatore giocatore = new Giocatore("bianco");
        assertEquals("bianco", giocatore.getColore());
    }

    @Test
    @DisplayName("3: Test assertNotNull getColore")
    public void GiocatoreTest_3(){
        Giocatore giocatore = new Giocatore("bianco");
        assertNotNull(giocatore.getColore());
    }

    @Test
    @DisplayName("4: Test assertTrue lunghezza getColore")
    public void GiocatoreTest_4(){
        Giocatore giocatore = new Giocatore("bianco");
        assertTrue(giocatore.getColore().length() > 0);
    }

    @Test
    @DisplayName("5: Test assertEquals setColore")
    public void GiocatoreTest_5(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setColore("nero");
        assertEquals("nero", giocatore.getColore());
    }

    @Test
    @DisplayName("6: Test assertNotNull setColore")
    public void GiocatoreTest_6(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setColore("nero");
        assertNotNull(giocatore.getColore());
    }

    @Test
    @DisplayName("7: Test assertTrue setColore")
    public void GiocatoreTest_7(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setColore("nero");
        assertTrue(giocatore.getColore().length() > 0);
    }

    //Test sul campo tempoPrecedente
    @Test
    @DisplayName("8: Test assertTrue getTempoPrecedente")
    public void GiocatoreTest_8(){
        Giocatore giocatore = new Giocatore("bianco");
        assertTrue(giocatore.getTempoPrecedente() >= 0);
    }

    @Test
    @DisplayName("9: Test assertTrue getTempoPrecedente")
    public void GiocatoreTest_9(){
        Giocatore giocatore = new Giocatore("bianco");
        assertTrue(giocatore.getTempoPrecedente() < Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("10: Test assertEquals setTempoPrecedente")
    public void GiocatoreTest_10(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setTempoPrecedente(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, giocatore.getTempoPrecedente());
    }

    @Test
    @DisplayName("11: Test assertTrue setTempoPrecedente")
    public void GiocatoreTest_11(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setTempoPrecedente(10);
        assertTrue(giocatore.getTempoPrecedente() >= 0);
    }

    @Test
    @DisplayName("12: Test assertTrue setTempoPrecedente")
    public void GiocatoreTest_12(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setTempoPrecedente(10);
        assertTrue(giocatore.getTempoPrecedente() < Integer.MAX_VALUE);
    }

    //Test sul campo pedinePrese
    @Test
    @DisplayName("13: Test assertEquals getPedinePrese")
    public void GiocatoreTest_13(){
        Giocatore giocatore = new Giocatore("bianco");
        assertEquals(0, giocatore.getPedinePrese().size());
    }

    @Test
    @DisplayName("14: Test assertNotEquals getPedinePrese")
    public void GiocatoreTest_14(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setPedinePrese(Costanti.PEDINA_BIANCA);
        assertNotEquals(0, giocatore.getPedinePrese().size());
    }

    @Test
    @DisplayName("15: Test assertEquals getPedinePrese")
    public void GiocatoreTest_15(){
        Giocatore giocatore = new Giocatore("bianco");
        assertEquals(0, giocatore.getPedinePrese().size());
    }

    @Test
    @DisplayName("16: Test assertTrue setPedinePrese")
    public void GiocatoreTest_16(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.setPedinePrese(Costanti.PEDINA_BIANCA);
        assertTrue(giocatore.getPedinePrese().size() >= 1);
    }

    @Test
    @DisplayName("17: Test assertEquals setPedinePrese")
    public void GiocatoreTest_17(){
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
    public void GiocatoreTest_18(){
        Giocatore giocatore = new Giocatore("bianco");
        assertNotNull(giocatore.getCronometro());
    }

    @Test
    @DisplayName("19: Test assertNotNull setCronometro")
    public void GiocatoreTest_19(){
        Giocatore giocatore = new Giocatore("bianco");
        Cronometro cronometro = new Cronometro(0);
        giocatore.setCronometro(cronometro);
        assertNotNull(giocatore.getCronometro());
    }

    @Test
    @DisplayName("20: Test assertNotNull resettaCronometro")
    public void GiocatoreTest_20(){
        Giocatore giocatore = new Giocatore("bianco");
        giocatore.resettaCronometro();
        assertNotNull(giocatore.getCronometro());
    }

}
