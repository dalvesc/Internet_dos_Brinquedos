package IDB.exception;

/**
 * ExceÃ§Ã£o lanÃ§ada caso nÃ£o esteja acontecendo corrida.
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SemPilotos extends Exception {

    public SemPilotos() {
        super("NÃ£o possui pilotos");
    }
}
