/*
 * Classe que contém o número da volta, o tempo total dessa volta em uma corrida e quantos PITS o piloto usou
 * durante essa volta.
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

    public Volta(float tempo) {
        this.tempo = tempo;
        this.pits = 0;
    }

    /**
     * Método que retorna o número da volta.
     *
     * @return int com o número da volta
     */
    public int getNumeroVolta() {
        return numeroVolta;
    }

    /**
     * Método que informa qual o número da volta.
     *
     * @param numeroVolta - número da volta que o piloto estar.
     */
    public void setNumeroVolta(int numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    /**
     * Método que retorna o tempo que essa volta foi feita.
     *
     * @return int com o tempo da volta
     */
    public float getTempo() {
        return tempo;
    }

    /**
     * Método que retorna se o piloto utilizou pitstop na volta.
     *
     * @return int da quantidade de pits que utilizou na volta
     */
    public int getPits() {
        return pits;
    }

    /**
     * Método que adiciona um novo pitstop.
     */
    public void pitStop() {
        pits++;
    }
}
