package it.uniba.dama;

import it.uniba.dama.Giocatore;
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

import static org.junit.jupiter.api.Assertions.*;

public class PedinaTest {

    //Test pedina
    @Test
    @DisplayName("1: Test assertNotNull Pedina")
    public void PedinaTest_1(){
        Pedina pedina = new Pedina();
        assertNotNull(pedina);
    }

    @Test
    @DisplayName("2: Test assertNotNull Pedina")
    public void PedinaTest_2(){
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(pedina);
    }

    //Test sul campo colore
    @Test
    @DisplayName("3: Test assertNotEquals getColore")
    public void PedinaTest_3(){
        Pedina pedina = new Pedina();
        assertNotEquals("bianco", pedina.getColore());
    }

    @Test
    @DisplayName("4: Test assertEquals getColore")
    public void PedinaTest_4(){
        Pedina pedina = new Pedina("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", pedina.getColore());
    }

    @Test
    @DisplayName("5: Test assertNotNull getColore")
    public void PedinaTest_5(){
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(pedina.getColore());
    }

    @Test
    @DisplayName("6: Test assertEquals setColore")
    public void PedinaTest_6(){
        Pedina pedina = new Pedina("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setColore("nero");
        assertEquals("nero", pedina.getColore());
    }

    @Test
    @DisplayName("7: Test assertNotNull setColore")
    public void PedinaTest_7(){
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setColore("nero");
        assertNotNull(pedina.getColore());
    }

    //Test sul campo simbolo
    @Test
    @DisplayName("8: Test assertNotEquals getSimbolo")
    public void PedinaTest_8(){
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo(Costanti.UNICODE_PEDINA_NERA);
        assertNotEquals(Costanti.UNICODE_PEDINA_BIANCA, pedina.getSimbolo());
    }

    @Test
    @DisplayName("9: Test assertEquals getSimbolo")
    public void PedinaTest_9(){
        Pedina pedina = new Pedina("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo(Costanti.UNICODE_PEDINA_BIANCA);
        assertEquals("bianco", pedina.getColore());
    }

    @Test
    @DisplayName("10: Test assertNotNull getSimbolo")
    public void PedinaTest_10(){
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        assertNotNull(pedina.getSimbolo());
    }

    @Test
    @DisplayName("11: Test assertEquals setSimbolo")
    public void PedinaTest_11(){
        Pedina pedina = new Pedina("bianco",Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo("nero");
        assertEquals("nero", pedina.getSimbolo());
    }

    @Test
    @DisplayName("12: Test assertNotNull setSimbolo")
    public void PedinaTest_12(){
        Pedina pedina = new Pedina("bianco", Costanti.UNICODE_PEDINA_BIANCA);
        pedina.setSimbolo("nero");
        assertNotNull(pedina.getSimbolo());
    }
}
