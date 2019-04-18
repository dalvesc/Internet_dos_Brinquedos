package IDB.exception;

/**
 * Exceção lançada caso não tenha pilotos na corrida.
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SemPilotos extends Exception {

    public SemPilotos() {
        super("Não possui pilotos");
    }
}
