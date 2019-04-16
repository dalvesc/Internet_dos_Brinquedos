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
public class Carro {
    
    private String cor;
    private String numero; 
    private String equipe;

    public Carro(String cor, String equipe) {
        this.cor = cor;
        this.equipe = equipe;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
}
