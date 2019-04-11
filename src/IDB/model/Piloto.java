/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDB.model;

import java.util.LinkedList;

/**
 *
 * @author danco
 */
public class Piloto {
    private String urlImagem;
    private String nome;
    private Carro carro;
    private LinkedList<Volta> voltas;

    public Piloto(String urlImagem, String nome, Carro carro, LinkedList voltas) {
        this.urlImagem = urlImagem;
        this.nome = nome;
        this.carro = carro;
        this.voltas = voltas;
    }
    
    public void novaVolta(Volta volta){
        voltas.add(volta);
    }
    
    public int getNumVoltas(){
        return voltas.size();
    }
}
