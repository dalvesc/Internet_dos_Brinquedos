package IDB.model;

import java.util.LinkedList;

public class Piloto {
    private String urlImagem;
    private String nome;
    private Carro carro;
    private String equipe;
    private String usuario;
    private String senha;
    private LinkedList<Volta> voltas;
    
    public Piloto(String nome, String usuario, String senha, String urlImagem) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.urlImagem = urlImagem;
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
