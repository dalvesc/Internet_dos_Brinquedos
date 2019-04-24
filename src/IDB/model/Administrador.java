/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDB.model;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Administrador {
    private String nome; //nome do ADM.
    private String usuario; //nome de usuário do ADM.
    private String senha; //senha do ADM.
    
    /**
     * Construtor.
     */
    public Administrador(){
        
    }
    
    /**
     * Construtor.
     * @param nome
     * @param usuario
     * @param senha 
     */
    public Administrador(String nome, String usuario, String senha){
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
