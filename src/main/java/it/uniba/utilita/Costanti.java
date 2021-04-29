package it.uniba.utilita;

import it.uniba.dama.Pedina;
import it.uniba.dama.Dama;

public class Costanti {
    public static final Pedina PEDINA_BIANCA = new Pedina("bianco", "\u26C2");
    public static final Pedina PEDINA_NERA = new Pedina("nero", "\u26C0");

    public static final Dama DAMA_BIANCA = new Dama("bianco", "\u26C1");
    public static final Dama DAMA_NERA = new Dama("nero", "\u26C3");

    public static final String UNICODE_PEDINA_BIANCA = "\u26C2";
    public static final String UNICODE_PEDINA_NERA = "\u26C0";
    public static final String UNICODE_DAMA_BIANCA = "\u26C1";
    public static final String UNICODE_DAMA_NERA = "\u26C3";
    public static final String SPAZIO_CORTO = "\u202F";

    public static final String PATTERN_SPOSTAMENTO = "(0?[1-9]|[1-2][0-9]|3[0-2])(-)(0?[1-9]|[1-2][0-9]|3[0-2])";
    public static final String PATTERN_PRESA = "(0?[1-9]|[1-2][0-9]|3[0-2])((x)(0?[1-9]|[1-2][0-9]|3[0-2]))";
    public static final String PATTERN_PRESA_MULTIPLA = "(0?[1-9]|[1-2][0-9]|3[0-2])((x)(0?[1-9]|[1-2][0-9]|3[0-2]))+";
    public static final int DIM = 8;
}
