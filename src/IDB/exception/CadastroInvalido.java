package IDB.exception;

/**
 * Caso o user já tenha sido cadastrado
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class CadastroInvalido extends Exception {

    public CadastroInvalido(String user) {
        super("O User ''" + user + "'' já está em uso!");
    }
}
