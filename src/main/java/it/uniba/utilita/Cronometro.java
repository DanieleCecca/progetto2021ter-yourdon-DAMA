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
public final class Cronometro extends Thread {
    private int secondi = 0;
    private boolean continua = true;

    public Cronometro(final int tempoPrecedente) {
        secondi = tempoPrecedente;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setSecondi(final int sec) {
        this.secondi = sec;
    }

    public boolean getContinua() {
        return continua;
    }

    public void setContinua(final boolean cont) {
        this.continua = cont;
    }

    public void run() {
        try {
            while (continua) {
                Thread.sleep(Costanti.SECONDO);
                secondi++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String tempoTrascorso() {
        int sec, minuti, ore;

        sec = this.secondi;
        ore = sec / Costanti.ORA_IN_SECONDI;
        minuti = (sec % Costanti.ORA_IN_SECONDI) / Costanti.MINUTO_IN_SECONDI;
        sec = (sec % Costanti.ORA_IN_SECONDI) % Costanti.MINUTO_IN_SECONDI;
        return (ore + " h " + minuti + " min " + sec + " sec ");
    }
}
