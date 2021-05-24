package it.uniba.dama;

import it.uniba.dama.Giocatore;
import it.uniba.dama.Pedina;
import it.uniba.utilita.Costanti;
import it.uniba.dama.Dama;
import it.uniba.utilita.Cronometro;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DamaTest {

    //Test dama
    @Test
    @DisplayName("1: Test assertNotNull Dama")
    public void DamaTest_1(){
        Dama dama = new Dama();
        assertNotNull(dama);
    }

    @Test
    @DisplayName("2: Test assertNotNull Dama")
    public void DamaTest_2(){
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(dama);
    }

    //Test sul campo colore
    @Test
    @DisplayName("3: Test assertNotEquals getColore")
    public void DamaTest_3(){
        Dama dama = new Dama();
        assertNotEquals("bianco", dama.getColore());
    }

    @Test
    @DisplayName("4: Test assertEquals getColore")
    public void DamaTest_4(){
        Dama dama = new Dama("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", dama.getColore());
    }

    @Test
    @DisplayName("5: Test assertNotNull getColore")
    public void DamaTest_5(){
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(dama.getColore());
    }

    @Test
    @DisplayName("6: Test assertEquals setColore")
    public void DamaTest_6(){
        Dama dama = new Dama("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        dama.setColore("nero");
        assertEquals("nero", dama.getColore());
    }

    @Test
    @DisplayName("7: Test assertNotNull setColore")
    public void DamaTest_7(){
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setColore("nero");
        assertNotNull(dama.getColore());
    }

    //Test sul campo simbolo
    @Test
    @DisplayName("8: Test assertNotEquals getSimbolo")
    public void DamaTest_8(){
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo(Costanti.UNICODE_PEDINA_NERA);
        assertNotEquals(Costanti.UNICODE_PEDINA_BIANCA, dama.getSimbolo());
    }

    @Test
    @DisplayName("9: Test assertEquals getSimbolo")
    public void DamaTest_9(){
        Dama dama = new Dama("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo(Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", dama.getColore());
    }

    @Test
    @DisplayName("10: Test assertNotNull getSimbolo")
    public void DamaTest_10(){
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(dama.getSimbolo());
    }

    @Test
    @DisplayName("11: Test assertEquals setSimbolo")
    public void DamaTest_11(){
        Dama dama = new Dama("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo("nero");
        assertEquals("nero", dama.getSimbolo());
    }

    @Test
    @DisplayName("12: Test assertNotNull setSimbolo")
    public void DamaTest_12(){
        Dama dama = new Dama("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        dama.setSimbolo("nero");
        assertNotNull(dama.getSimbolo());
    }
}
