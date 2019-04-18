package IDB.model;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Carro {

    private String cor; //cor do carro.
    private String numero; //número de identificação do carro(código da TAG).
    private String equipe; //nome da equipe(nome do carro).

    /**
     * Construtor.
     *
     * @param cor
     * @param equipe
     */
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
