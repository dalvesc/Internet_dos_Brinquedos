package IDB.model;

public class Administrador {

    private final String nome;
    private final String usuario;
    private final String senha;

    public Administrador(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
