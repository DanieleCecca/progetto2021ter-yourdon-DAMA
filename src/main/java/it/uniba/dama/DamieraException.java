package it.uniba.dama;

/**
 * Classe che si occupa di lanciare un messaggio di errore ogni volta che
 * la mossa in input effettuata dall'utente sulla damiera risulta non valida
 * Tipo di classe: <b>noECB</b><br>;
 * Responsabilità:
 * <ul>Does:
 *      <li>Richiama il costruttore della classe Exception per poter lanciare il messaggio</li>
 * </ul>
 */
public final class DamieraException extends Exception {
    public DamieraException(final String messaggio) {
        super(messaggio);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
