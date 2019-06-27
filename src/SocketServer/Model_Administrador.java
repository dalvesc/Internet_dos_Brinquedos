package SocketServer;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Model_Administrador {
    
    private String nome; //nome do ADM.
    private String usuario; //nome de usuário do ADM.
    private String senha; //senha do ADM.

    /**
     * Construtor.
     */
    public Model_Administrador() {

    }

    /**
     * Construtor.
     *
     * @param nome
     * @param usuario
     * @param senha
     */
    public Model_Administrador(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
