package IDB.exception;

/**
 * Caso a corrida ainda não tenha sido iniciada
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class SemCorrida extends Exception {

    public SemCorrida() {
        super("Corrida ainda não iniciada!");
    }
}
