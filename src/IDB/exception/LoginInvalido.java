package IDB.exception;

/**
 * Caso o email ou a senha do usuário esteja incorreta
 *
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class LoginInvalido extends Exception {

    public LoginInvalido() {
        super("User ou senha inválidos!");
    }
}
