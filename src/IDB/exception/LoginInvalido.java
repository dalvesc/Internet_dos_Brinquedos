package IDB.exception;

/**
 * Caso o email ou a senha do usuÃ¡rio esteja incorreta
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class LoginInvalido extends Exception {

    public LoginInvalido() {
        super("User ou senha invÃ¡lidos!");
    }
}
