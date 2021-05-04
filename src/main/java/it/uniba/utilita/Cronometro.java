package it.uniba.utilita;

/**
 *  Classe che permette di calcolare il tempo in run-time <br>
 *  Tipo di classe: <b>Entity</b><br>
 *  Responsabilità:
 * 		<ul>Knows:
 * 		     <li>Il tempo calcolato in secondi</li>
 * 		     <li>Un valore che permette di fermare il tempo</li></ul>
 * 		<ul>Does:
 * 		    <li>Istanzia il tempo in secondi</li>
 * 		    <li>Ottiene i secondi</li>
 * 		    <li>Setta il valore che permette di fermare il tempo</li>
 * 		    <li>Calcola il tempo in run-time</li>
 * 		    <li>Stampa il tempo trascorso</li></ul>
 */
public class Cronometro extends Thread {
    private int secondi = 0;
    private boolean continua = true;

    public Cronometro(int tempoPrecedente) {
        secondi = tempoPrecedente;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    public boolean getContinua() {
        return continua;
    }

    public void setContinua(boolean continua) {
        this.continua = continua;
    }

    public void run() {
        try {
            while (continua) {
                Thread.sleep(1000);
                secondi++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stampaTempoTrascorso() {
        int secondi, minuti, ore;

        secondi = this.secondi;
        ore = secondi / 3600;
        minuti = (secondi % 3600) / 60;
        secondi = (secondi % 3600) % 60;
        Interfaccia.stampaMessaggio(ore + " h " + minuti + " min " + secondi + " sec ");
    }
}