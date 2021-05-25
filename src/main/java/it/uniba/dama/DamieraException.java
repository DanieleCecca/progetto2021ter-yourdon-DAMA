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
    /**
     * Costruttore per la classe DamieraException.
     * Inizializza il messaggio dell'eccezione.
     *
     * @param messaggio il messaggio d'errore dell'eccezione
     */
    public DamieraException(final String messaggio) {
        super(messaggio);
    }

    /**
     * Metodo get per messaggio.
     *
     * @return il messaggio dell'eccezione DamieraException
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
