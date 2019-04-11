package IDB.model;

import java.util.LinkedList;

public class Piloto {
    private String urlImagem;
    private final String nome;
    private Carro carro;
    private String equipe;
    private final String usuario;
    private final String senha;
    private LinkedList<Volta> voltas;

    public Piloto(String urlImagem, String nome, String equipe, String usuario, String senha) {
        this.urlImagem = urlImagem;
        this.nome = nome;
        this.equipe = equipe;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public void novaVolta(Volta volta){
        voltas.add(volta);
    }
    
    public int getNumVoltas(){
        return voltas.size();
    }
    
    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getNome() {
        return nome;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
