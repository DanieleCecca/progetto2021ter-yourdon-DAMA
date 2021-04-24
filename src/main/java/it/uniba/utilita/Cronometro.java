package it.uniba.utilita;

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
        System.out.println(ore + " h " + minuti + " min " + secondi + " sec ");
    }
}