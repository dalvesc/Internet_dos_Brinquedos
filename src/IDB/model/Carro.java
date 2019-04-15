package IDB.model;

public class Carro {
    
    private String cor;
    private String numero; 
    private String equipe;
    private boolean disponivel;

    public Carro(String cor, String equipe) {
        this.cor = cor;
        this.numero = numero;
        this.equipe = equipe;
        this.disponivel = disponivel;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
 
    
}
