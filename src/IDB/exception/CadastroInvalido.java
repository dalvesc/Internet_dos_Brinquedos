package IDB.exception;

/**
 * Caso o user jÃ¡ tenha sido cadastrado
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class CadastroInvalido extends Exception {

    public CadastroInvalido(String user) {
        super("O User ''" + user + "'' jÃ¡ estÃ¡ em uso!");
    }
}
