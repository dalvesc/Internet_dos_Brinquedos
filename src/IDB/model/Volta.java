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
public class Volta {
    private int numeroVolta;
    private float tempo;
    private int pits;

    public Volta(int numeroVolta, float tempo) {
        this.numeroVolta = numeroVolta;
        this.tempo = tempo;
        this.pits = 0;
    }
    
    public int getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(int numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }
    
    public void pitStop(){
        pits++;
    }
    
    public int getPitsTotais(){
        return pits;
    }
}
