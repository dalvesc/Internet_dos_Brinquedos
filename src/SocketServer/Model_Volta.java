package SocketServer;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Model_Volta {
    
    private int numeroVolta; //número da volta atual na corrida.
    private final double tempo; //tempo total da volta completa.
    private int pits; //quantos PITS do piloto durante está volta.

    /**
     * Construtor.
     *
     * @param tempo
     */
    public Model_Volta(double tempo) {
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
    public double getTempo() {
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
