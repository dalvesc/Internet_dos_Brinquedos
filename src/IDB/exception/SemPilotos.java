package IDB.exception;

/**
 * Exceção lançada caso não esteja acontecendo corrida.
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SemPilotos extends Exception {

    public SemPilotos() {
        super("Não possui pilotos");
    }
}
