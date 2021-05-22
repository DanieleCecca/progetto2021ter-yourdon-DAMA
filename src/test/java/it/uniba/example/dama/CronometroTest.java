package it.uniba.example.dama;

import static org.junit.Assume.assumeNotNull;
import static org.junit.jupiter.api.Assertions.*;

import it.uniba.utilita.Costanti;
import it.uniba.utilita.Cronometro;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CronometroTest {
    private int tempoPrecedente = 0;
    //Test Cronometro
    @Test
    @DisplayName("1: Test assertTrue cronometro")
    public void Cronometro_Test1(){
        tempoPrecedente = 2;
        Cronometro cronometro=new Cronometro(tempoPrecedente);
        assertTrue(cronometro.getSecondi()>=0);
    }

    //Test sul campo secondi
    @Test
    @DisplayName("2: Test assertNotNull getSecondi")
    public void Cronometro_Test2(){
        tempoPrecedente = 1;
        Cronometro cronometro=new Cronometro(tempoPrecedente);
        assertEquals(1,cronometro.getSecondi());
    }

    @Test
    @DisplayName("3: Test assertEquals getSecondi")
    public void Cronometro_Test3(){
        Cronometro cronometro = new Cronometro(tempoPrecedente);
        assertEquals(cronometro.getSecondi(),tempoPrecedente);
    }

    @Test
    @DisplayName("4: Test assertEquals setSecondi")
    public void Cronometro_Test4(){
        tempoPrecedente = 1;
        Cronometro cronometro = new Cronometro(tempoPrecedente);
        cronometro.setSecondi(5);
        assertEquals(5,cronometro.getSecondi());
    }

    @Test
    @DisplayName("5: Test assertTrue setSecondi")
    public void Cronometro_Test5(){
        Cronometro cronometro = new Cronometro(tempoPrecedente);
        cronometro.setSecondi(tempoPrecedente);
        assertTrue(cronometro.getSecondi()>=0);
    }
    @Test
    @DisplayName("6: Test assertTrue setSecondi")
    public void Cronometro_Test6(){
        Cronometro cronometro = new Cronometro(tempoPrecedente);
        cronometro.setSecondi(tempoPrecedente);
        assertTrue(cronometro.getSecondi()<Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("7: Test assertTrue getContinua")
    public void Cronometro_Test7(){
        Cronometro cronometro= new Cronometro(tempoPrecedente);
        assertTrue(cronometro.getContinua());
    }

    @Test
    @DisplayName("8: Test assertFalse setContinua")
    public void Cronometro_Test8(){
        Cronometro cronometro= new Cronometro(tempoPrecedente);
        cronometro.setContinua(false);
        assertFalse(cronometro.getContinua());
    }

    @Test
    @DisplayName("9: Test assertTrue run")
    public void Cronometro_Test9(){
        Cronometro cronometro = new Cronometro(tempoPrecedente);
        cronometro.setContinua(true);
        cronometro.start();
        //cronometro.run();
        try {
            Thread.sleep(Costanti.SECONDO);
        } catch (InterruptedException e) {
            cronometro.interrupt();
        }
        cronometro.setContinua(false);
        assertTrue(cronometro.getSecondi()>0);

    }
    @Test
    @DisplayName("10: Test assertEquals run")
    public void Cronometro_Test10() {
        tempoPrecedente = 2;
        Cronometro cronometro = new Cronometro(tempoPrecedente);
        cronometro.setContinua(true);
        cronometro.start();
        try {
            Thread.sleep(Costanti.SECONDO);
        } catch (InterruptedException e) {
            cronometro.interrupt();
        }
        cronometro.setContinua(false);
        assertEquals(3,cronometro.getSecondi());
    }

    @Test
    @DisplayName("11: Test assertEquals tempoTrascorso")
    public void Cronometro_Test11(){
        Cronometro cronometro = new Cronometro(20);
        int sec = 20;
        int min = 0;
        int h = 0;
        sec = (sec % Costanti.ORA_IN_SECONDI) % Costanti.MINUTO_IN_SECONDI;
        String tot = h + " h " + min + " min " + sec + " sec ";
        assertEquals(tot,cronometro.tempoTrascorso());
    }

    @Test
    @DisplayName("12: Test assertTrue setSecondi")
    public void Cronometro_Test12(){
        Cronometro cronometro = new Cronometro(tempoPrecedente);
        cronometro.setSecondi(Integer.MAX_VALUE);
        assertEquals(cronometro.getSecondi(),Integer.MAX_VALUE);
    }
}
