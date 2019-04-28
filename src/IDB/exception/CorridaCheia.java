package IDB.exception;

/**
 * Caso a corrida já tenha todos seus pilotos cadastrados
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class CorridaCheia extends Exception {

    public CorridaCheia() {
        super("Corrida cheia!");
    }
}
